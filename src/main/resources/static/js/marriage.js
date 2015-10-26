angular
		.module('hello', [ 'ngRoute', 'ui.bootstrap', 'mwl.calendar', 'auth', 'home', 'navigation', 'start', 'budget' ])
		.config(

				function($routeProvider, $httpProvider, $locationProvider) {

					$locationProvider.html5Mode(true);

					$routeProvider.when('/', {
						templateUrl : 'js/home/home.html',
						controller : 'home'
					}).when('/login', {
						templateUrl : 'js/navigation/login.html',
						controller : 'navigation'
					}).when('/start', {
						templateUrl : 'js/start/start.html',
						controller : 'start'
					}).when('/input', {
						templateUrl : 'js/budget/budget.html',
						controller : 'budget'
					}).otherwise('/');

					$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

				}).run(function(auth) {

			// Initialize auth module with the home page and login/logout path
			// respectively
			auth.init('/', '/login', '/logout');

		})
.config(function(calendarConfigProvider) {

			calendarConfigProvider.setDateFormatter('moment'); // use moment to
																// format dates
			moment.locale('de')
			calendarConfigProvider.setDateFormats({
				hour : 'HH:mm'
			});
		});