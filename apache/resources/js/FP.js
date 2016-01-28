FP = {

	initMap: function() {
		var mapDom = $("#map");
		this.maps = FPMaps.instance({DOM:mapDom});
		this.bindCheckIn();
	},

	bindCheckIn: function(){
		$("[data-bt-checkin]").bind( "click", function() {
			history.pushState(null, null, "checkin");
			var checkIn = FP.modal({
				title:"CHECK-IN",
				url:"listview.html",
				buttons:[{
					title: "CHECK-IN",
					action: function(){
						alert("ok");
						checkIn.hide();
						history.back();
					}
				}]
			});
		});
	},

	failHandler: function(args){
		if(!args.getResponseHeader=== undefined && !args.status=== undefined && !args.responseText=== undefined){
			if($.isFunction(args.getResponseHeader)){
				var contentType = args.getResponseHeader('Content-Type');
			}else{
				var contentType = args.getResponseHeader["Content-Type"];
			}

			if(contentType.match(/application\/json/i) == null){
				alert( args.responseText);
			}else {
				var response = jQuery.parseJSON(args.responseText);
				if(args.status){
					switch(args.status){
						case 500:
							alert(response.message);
							break;
						case 404:
							alert("Recurso n�o encontrado. Verifique o caminho e tente novamente.");
							break;
						default:
							alert("Erro inesperado.");
							break;
					}
				}
			}
		}
		else {
			alert(args.responseText);
		}
	},

	ajaxOpt: function(){
		var opts = { 
			url: null,
			dataType: 'json',
			cache: false,
			processData: false,
			contentType: "application/json; charset=UTF-8",
			type: 'POST',
			success: function(){},
			error: FP.failHandler
		};
		return opts;
	},

	post: function(options){
		var opt = FP.ajaxOpt();
		opt.type = 'POST';
		if(options.data){					
			options.data = JSON.stringify(options.data);
		}
		var config = $.extend(opt, options);
		$.ajax(config);
	},
	get: function(options){
		var opt = FP.ajaxOpt();
		opt.type = 'GET';
		if(options.data){					
			options.data = JSON.stringify(options.data);
		}
		var config = $.extend(opt, options);
		$.ajax(config);
	},
	defaultClass: {
		templateClass: {
			teste: function(){
				alert(123);
			},
			instance: function(parans){
				if (parans === undefined) {
					parans = {};
				} 
				var obj = Object.create(this);
				var template = $.extend(this,parans);
				for (var k in template) {
					obj[k] = template[k]
	            }
				obj.init();
				return obj;
			}
		},
		extend: function(obj){
			return $.extend({}, this.templateClass, obj);
		}
	},
	lastId:0,
	id:function(){
		this.lastId++;
		return "FP"+this.lastId;
	},
	modal: function(obj){ 
		var modal = this.defaultClass.extend({
			DOM:null,
			title:"",
			content:"",
			buttons:[{
				title: "111",
				action: function(){}
			}],
			url: null,
			tmplModal: $('#tmpl-modal').html(),
			tmplModalButtons: $('#tmpl-modal-button').html(),
				

			init:function(){
				Mustache.parse(this.tmplModal);
				Mustache.parse(this.tmplModalButtons);

				if(this.url == null){
					this.create();
				}else{
					this.get();
				}				
			},
			get:function(){
				var _this = this;
				FP.get({
					url: _this.url, 
					dataType: 'html',
					success: function( content ) {
						_this.content+=content;
						_this.create();
					}
				});
			},

			create: function(){
				var _this = this;
				
				this.DOM = Mustache.render(this.tmplModal, {
					id: FP.id(),
					title:_this.title
				});
				this.DOM = $(this.DOM);
				$(this.DOM.find(".modal-body")[0]).append(_this.content);
				$('body').append(this.DOM);
				this.addbuttons();
				this.addBinds();
				this.show();
			},

			show:function(){
				this.DOM.modal('show');
			},
			hide:function(){
				this.DOM.modal('hide');
			},	
			addBinds:function(){
				var _this = this;
				this.DOM.on('hidden.bs.modal', function () {
					_this.DOM.data('bs.modal', null);
					$(this).remove();
				});
			},
			addbuttons:function(){
				var _this = this;
				var divButtons = $(this.DOM.find(".modal-footer")[0]);
				$.each(this.buttons, function( index, button ) {
					var style = "btn-default";
					if(_this.buttons.length == (index+1)){
						style = "btn-primary";
					}		
					var btId = FP.id();
					var bt = Mustache.render(_this.tmplModalButtons, {
						id: btId,
						title:button.title,
						style: style
					});
						
					divButtons.append(bt);			

					_this.DOM.on('click', "#"+btId, button.action);
				});
			}
		});
		return modal.instance(obj);
	}
}

