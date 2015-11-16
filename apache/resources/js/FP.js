FP = {

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
						alert("Recurso não encontrado. Verifique o caminho e tente novamente.");
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
}


}


