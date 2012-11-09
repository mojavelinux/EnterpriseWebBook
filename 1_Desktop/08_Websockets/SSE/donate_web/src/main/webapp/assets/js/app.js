require.config({
	paths: {
		'login':'modules/login',
		'donation':'modules/donation',
		'svg-pie-chart':'modules/svg-pie-chart',
		'campaigns-map':'modules/campaigns-map',
	},
	shim: {
		'campaigns-map': {
            deps: ['async!http://maps.google.com/maps/api/js?sensor=false!callback']
        }
	}
});

require([
	'order!login',
	'order!donation',
	'order!svg-pie-chart',
	'order!campaigns-map'
]/*, function () {}*/
);

// using order.js plugin - open console to check order of loading

// Google Maps API loading issue
// Using async.js plugin
// Google Maps loads many JS files asynchronously, so listening just to the first script load
// isn't enough to check if it is ready to be used, another problem is that the regular gmaps script 
// uses document.write, so we need to pass a `callback` parameter to make it not use `document.write` 
// and wait for the callback call.
// <http://code.google.com/apis/maps/documentation/javascript/basics.html#Async>
//
//
// comments was copied from here - https://gist.github.com/882682


