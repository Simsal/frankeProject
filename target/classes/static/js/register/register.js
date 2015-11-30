angular.module('register',[]).controller('register', function($scope, $http){
	
	$scope.register = function register(){
		$http.post(
				'/save/newUser',
				{
					firstName: $scope.user.firstName,
					lastName: $scope.user.lastName,
					futureLastName: $scope.user.futureLastName,
					marriagePartner: $scope.user.spouseFirstName,
					userName: $scope.user.userName,
					password: $scope.user.password
				}).success(function(data, status, headers) {
					alert("passt")
		}).error(function(data, status, headers) {
			alert("error");
		});
	}
})

.directive('usernameAvailableValidator', function($timeout, $http) {
  return {
    restrict: 'AE',
    require: 'ngModel',
    link: function(scope, elm, attr, model) { 
      model.$asyncValidators.usernameAvailable = function(username) { 
        return $http.get('/api/username-exists?u='+ username).then(function(res){+
          $timeout(function(){
            model.$setValidity('usernameAvailable', !!res.data); 
          }, 1000);
        })
      }
    }
  } 
});
