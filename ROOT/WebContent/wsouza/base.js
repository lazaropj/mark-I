	var geocoder = new google.maps.Geocoder();
	var map = null;
	var ultimoDesenho=null;
	var ultimoMarcador=null;
	
	var deLocation = null, ateLocation=null;
	var dirService = null;
	var dirRenderer = null;
	
	var siglaEstados = {
    		
    		"AC":"Acre",
    		"AL":"Alagoas",
    		"AM":"Amazonas",
    		"AP":"Amapa",
    		"BA":"Bahia",
    		"CE":"Ceará",
    		"DF":"Distrito Federal",
    		"ES":"Espírito Santo",
    		"GO":"Goiás",
    		"MA":"Maranhão",
    		"MG":"Minas Gerais",
    		"MS":"Mato Grosso do Sul",
    		"MT":"Mato Grosso",
    		"PA":"Pará",
    		"PB":"Paraíba",
    		"PE":"Pernambuco",
    		"PI":"Piauí",
    		"PR":"Paraná",
    		"RJ":"Rio de Janeiro",
    		"RN":"Rio Grande do Norte",
    		"RO":"Rondônia",
    		"RR":"Roraima",
    		"RS":"Rio Grande do Sul",
    		"SC":"Santa Catarina",
    		"SE":"Sergipe",
    		"SP":"São Paulo",
    		"TO":"Tocantins"
    };
    
    var mapOptions = {
            center: new google.maps.LatLng(-15.826691, -47.9218204),
            zoom: 6,
            mapTypeId: google.maps.MapTypeId.ROADMAP,
            streetViewControl: false
          };
    
    function initialize() {
    	  //cwb lat -25.42    Lon: -49.27
          // df lat -15.826691 -47.9218204
        map = new google.maps.Map(document.getElementById("map_canvas"),   mapOptions);
        geolocateUser();
    
        /*$('#anosOcorrenciaLink').tooltip({
            position: "top"
        });*/
        
        $('#anosOcorrenciaLink').tooltip({
        	position: "top",
            content: $("#anoCheckedDiv").html(),
            showEvent: 'click',
            /*onUpdate: function(content){
                content.panel({
                    width: 200,
                    border: false,
                    title: 'Login',
                    href: '_dialog.html'
                });
            },*/
            onShow: function(){
                var t = $(this);
                t.tooltip('tip').unbind().bind('mouseenter', function(){
                    t.tooltip('show');
                }).bind('mouseleave', function(){
                    t.tooltip('hide');
                });
            }
        });
        
      }
    
    function checkAno(check){
    	
    	if($(check).is(":checked")){
    		$(check).parent().css("background-color","#ecd084");
    	}else{
    		$(check).parent().css("background-color","white");
    	}
    	
    }
    
    function geolocationError(positionError) {
       // document.getElementById("error").innerHTML += "Error: " + positionError.message + "<br />";
       //alert(positionError.message);
      }
    
    function geolocateUser() {
        // If the browser supports the Geolocation API
        if (navigator.geolocation)
        {
          var positionOptions = {
            enableHighAccuracy: true,
            timeout: 10 * 1000 // 10 seconds
          };
          navigator.geolocation.getCurrentPosition(geolocationSuccess, geolocationError, positionOptions);
        }
        else{
          //document.getElementById("error").innerHTML += "Your browser doesn't support the Geolocation API";
         //alert("Your browser doesn't support the Geolocation API");
      }
        
    }
    
    function geolocationSuccess(position) {
        var userLatLng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
        //console.log(userLatLng);
        
        map.setCenter(userLatLng);
        
        // Write the formatted address
        //writeAddressName(userLatLng);
 
      /*   var myOptions = {
          zoom : 16,
          center : userLatLng,
          mapTypeId : google.maps.MapTypeId.ROADMAP
        }; */
        // Draw the map
       // var mapObject = new google.maps.Map(document.getElementById("map"), myOptions);
        // Place the marker
        
        /* new google.maps.Marker({
          map: map,
          position: userLatLng
        }); */
        
        // Draw a circle around the user position to have an idea of the current localization accuracy
        /* var circle = new google.maps.Circle({
          center: userLatLng,
          radius: position.coords.accuracy,
          map: map,
          fillColor: '#0000FF',
          fillOpacity: 0.5,
          strokeColor: '#0000FF',
          strokeOpacity: 1.0
        });
        mapObject.fitBounds(circle.getBounds()); */
      }
    
    function accioEstado(sigla){
    	
    	if(dirRenderer!=null) {dirRenderer.setMap(null); dirRenderer=null;}
    	
    	//if(estado || estado.trim().length==0) return;
    	if(ultimoDesenho) ultimoDesenho.setMap(null);
    	
    	var coordsArray = polygonEstadosGeom[sigla].split('|');
    	var desenho = new Array();
    	
    	for (var i = 0; i < coordsArray.length; i++) { 
	    	XY = coordsArray[i].split(','); 
	    	//points.push( new GLatLng(parseFloat(XY[1]),parseFloat(XY[0]))) ;
	    	desenho.push(new google.maps.LatLng(parseFloat(XY[1]), parseFloat(XY[0])));
    	} 
    	
    	bermudaTriangle = new google.maps.Polygon({
    	    paths: desenho,
    	    strokeColor: "#000001",
    	    strokeOpacity: 0.8,
    	    strokeWeight: 1,
    	    //fillColor: "#FF0000",
    	    fillOpacity: 0.15
    	  });
    	 bermudaTriangle.setMap(map);
    	 ultimoDesenho = bermudaTriangle;
    	 
    	 //console.log(siglaEstados[sigla]);
    	 
    	geocoder.geocode( { 'address': siglaEstados[sigla]}, function(results, status) {
	    	      if (status == google.maps.GeocoderStatus.OK) {
	    	        map.setCenter(results[0].geometry.location);
	    	        console.log(results[0].geometry.location);
	    	        
	    	        if(ultimoMarcador)ultimoMarcador.setMap(null);
	    	        
	    	        var marker = new google.maps.Marker({
	    	            map: map,
	    	            animation: google.maps.Animation.DROP,
	    	            position: results[0].geometry.location
	    	        });
	    	        google.maps.event.addListener(marker, 'click', function(){
	    	        	ultimoDesenho.setOptions({fillOpacity:0});
	    	        	
	    	        });
	    	        
	    	        ultimoMarcador=marker;
	    	      } else {
	    	        alert('Geocode was not successful for the following reason: ' + status);
	    	      }
	    });
    	
    	map.setZoom(mapOptions.zoom);
    }
    
    
    function accioRota(){
    	//buscando cidade "de"

    	geocoder.geocode( { 'address': $("#de").val()}, function(results, status) {
    		console.log(status);
    		if (status == google.maps.GeocoderStatus.OK) {
    			deLocation = results[0].geometry.location;
    		
    			geocoder.geocode( { 'address': $("#ate").val()}, function(results, status) {
    	    		console.log(status);
    	    		if (status == google.maps.GeocoderStatus.OK) {
    	    			ateLocation = results[0].geometry.location;
    	    			
    	    			drawRoute();
    	    			
    	    		}
    	    		else {
    	    	        alert('Geocode was not successful for the following reason: ' + status);
    	  	      }
    	    	});
    		
    		
    		
    		
    		}else {
    	        alert('Geocode was not successful for the following reason: ' + status);
  	      }
    	});
    	
    }
    
    function drawRoute(){
    	
    	// init directions service
    	if(dirService==null)
    		dirService = new google.maps.DirectionsService();
    	
    	if(dirRenderer!=null) {dirRenderer.setMap(null); dirRenderer=null;}
    	dirRenderer = new google.maps.DirectionsRenderer({suppressMarkers: true});
    	dirRenderer.setMap(map);
    	
    	var request = {
    			origin: deLocation.lat()+","+deLocation.lng(), //"48.1252,11.5407",
    			destination: ateLocation.lat()+","+ateLocation.lng(),//"48.13376,11.5535",
    			//waypoints: [{location:"48.12449,11.5536"}, {location:"48.12515,11.5569"}],
    			travelMode: google.maps.TravelMode.DRIVING
    	};
    	
    	dirService.route(request, function(result, status) {
    		if (status == google.maps.DirectionsStatus.OK) {
    			dirRenderer.setDirections(result);
    		}
    	});
    }
	
    	
    	
