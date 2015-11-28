angular.module('home', []).controller('home', function($scope, $http) {
	$http.get('/userDetails/').success(function(data) {
		$scope.user = data.firstName;
	});
});