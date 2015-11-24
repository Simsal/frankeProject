angular
		.module('hello', [ 'ngRoute', 'ui.bootstrap', 'mwl.calendar', 'auth', 'home', 'navigation', 'start', 'budget', 'tablePlan', 'guestList', 'register' ])
		.config(

				function($routeProvider, $httpProvider, $locationProvider) {

					$locationProvider.html5Mode(true);

					$routeProvider.when('/', {
						templateUrl : 'js/home/home.html',
						controller : 'home'
					}).when('/login', {
						templateUrl : 'js/navigation/login.html',
						controller : 'navigation'
					}).when('/ubersicht', {
						templateUrl : 'js/start/start.html',
						controller : 'start'
					}).when('/budgetplanung', {
						templateUrl : 'js/budget/budget.html',
						controller : 'budget'
					}).when('/guestlist', {
						templateUrl : 'js/guestList/guestList.html',
						controller : 'guestList'
					}).when('/tischplan', {
						templateUrl : 'js/tablePlan/tablePlan.html',
						controller : 'tablePlan'
					}).when('/register', {
						templateUrl : 'js/register/register.html',
						controller : 'register'
					}).otherwise('/');

					$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

				}).run(function(auth) {

			// Initialize auth module with the home page and login/logout path
			// respectively
			auth.init('/home', '/login', '/logout');

		})
.config(function(calendarConfigProvider) {

			calendarConfigProvider.setDateFormatter('moment'); // use moment to
																// format dates
			moment.locale('de')
			calendarConfigProvider.setDateFormats({
				hour : 'HH:mm'
			});
		})

.directive('username', function($q, $timeout, $http) {
	  return {
	    require: 'ngModel',
	    link: function(scope, elm, attrs, ctrl) {
	    	
	    	$scope.usernames ;
	    	function findAllUserNames() {
	  		  
	  					
	  				$http.get('get/allUserNames').success(
	  						function(data) {
	  							if (data != undefined) {
	  								$scope.usernames = data;
	  							} else {
	  								$scope.usernames = [];
	  							}
	  						});
	  			
	  			};

	      ctrl.$asyncValidators.username = function(modelValue, viewValue) {

	        if (ctrl.$isEmpty(modelValue)) {
	          // consider empty model valid
	          return $q.when();
	        }

	        var def = $q.defer();

	        $timeout(function() {
	          // Mock a delayed response
	          if (usernames.indexOf(modelValue) === -1) {
	            // The username is available
	            def.resolve();
	          } else {
	            def.reject();
	          }

	        }, 2000);

	        return def.promise;
	      };
	    }
	  };
});