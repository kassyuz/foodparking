var FPMaps = FP.defaultClass.extend({
	map: null,
	joinville: null,
	browserSupportFlag: new Boolean(),
	styles: [{"featureType":"landscape.natural","elementType":"geometry.fill","stylers":[{"visibility":"on"},{"color":"#e0efef"}]},{"featureType":"poi","elementType":"geometry.fill","stylers":[{"visibility":"on"},{"hue":"#1900ff"},{"color":"#c0e8e8"}]},{"featureType":"road","elementType":"geometry","stylers":[{"lightness":100},{"visibility":"simplified"}]},{"featureType":"road","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"transit.line","elementType":"geometry","stylers":[{"visibility":"on"},{"lightness":700}]},{"featureType":"water","elementType":"all","stylers":[{"color":"#7dcdcd"}]}],

	init: function(){
		this.joinville = new google.maps.LatLng(-26.299196, -48.850555);
		this.map = new google.maps.Map(this.DOM[0], {
			zoom: 14
		});
		this.map.setOptions({styles: this.styles});

		this.currentLocation();
		this.map.setZoom(15);

		this.getAlTrucks();
	},		
	
	getAlTrucks: function(){
		var _this = this;
		FP.get({
			url: "rest/truck/all", 
			success: function( trucks ) {
				$.each(trucks, function( index, truck ) {
					var pos = new google.maps.LatLng(truck.latitude, truck.longitude);
					var marker = new google.maps.Marker({
						position: pos,
						map: _this.map,
						title: truck.description,
						icon: 'resources/images/markers/Cargo32x32.png',
						animation: google.maps.Animation.DROP
					});	

					var infowindow = new google.maps.InfoWindow({
						content: "<b>"+truck.title+"</b>"
					});

					marker.addListener('click', function() {
						infowindow.open(_this.map, marker);
						_this.map.setZoom(_this.map.getZoom()+1);
						_this.map.setCenter(marker.getPosition());							
					});

					marker.addListener('dblclick', function() {
						infowindow.open(_this.map, marker);
						_this.map.setZoom(19);							
						_this.map.setCenter(marker.getPosition());		
					});			
				});	
			}
		});	
	},
	currentLocation:function(){
		var _this = this;
		// Try W3C Geolocation (Preferred)
		  if(navigator.geolocation) {
			this.browserSupportFlag = true;
			navigator.geolocation.getCurrentPosition(function(position) {
			  _this.initialLocation = new google.maps.LatLng(position.coords.latitude,position.coords.longitude);
			  _this.map.setCenter(_this.initialLocation);

			  var currentLocation = new google.maps.Marker({
				position: _this.initialLocation,
				map: _this.map,				
				icon: {
					url: 'resources/images/markers/bluecircle.png',
					anchor: new google.maps.Point(7,7)
				}
			  });

				var circle = new google.maps.Circle({
					map: _this.map,
					clickable: false,
					// metres
					radius: 150,
					fillColor: '#c0e8e8',
					fillOpacity: .6,
					strokeColor: '#7dcdcd',
					strokeOpacity: .4,
					strokeWeight: .8
				});

				// attach circle to marker
				circle.bindTo('center', currentLocation, 'position');

			}, function() {
			  _this.handleNoGeolocation(_this.browserSupportFlag);
			});
		  }else {
			_this.browserSupportFlag = false;
			_this.handleNoGeolocation(_this.browserSupportFlag);
		  }
	},
	handleNoGeolocation:function(errorFlag) {
		this.initialLocation = this.joinville;
		if (errorFlag == true) {
		  console.warn("Geolocation service failed.");			  
		} else {
		  console.warn("Your browser doesn't support geolocation. We've placed you in Siberia.");
		}
		this.map.setCenter(this.initialLocation);
	}
});

