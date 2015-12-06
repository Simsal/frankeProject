angular.module('guestList', []).controller('guestList', function($scope, $http) {
	$scope.guests = [];
	$scope.newGuest = {};
	
	function findAllGuests() {
		  $http.get('/userDetails/').success(function(data) {
				$scope.id = data.id;
				
				var params = {
						
						id : $scope.id
				};
					
				$http.get('/guests/search/findByUserId', {params : params}).success(
						function(data) {
							if (data._embedded != undefined) {
								$scope.guests = angular.fromJson(data._embedded.guests);
								console.log(data._embedded.guests)
								console.log($scope.guests)
							} else {
								$scope.guests = [];
							}
						});
			})
			};
	findAllGuests();
	
	
	$scope.saveGuests = function(){
		
		$http.post(
				'/save/newUser',
				{
					
					
				}
				
		)
	}
	
	$scope.delete = function (index, item) {
//		modalService.showModal({}).then(function (result){
//		var string = item._links.self.href;
//		$scope.helpArray = string.split('/');
//		var helpstring = $scope.helpArray[$scope.helpArray.length-1]
//		$scope.array = helpstring.split('{')
//        $http.delete('delete/' + $scope.array[0]).success(function(data, status){
//        })
//		
//		
//		})
		$scope.guests.splice(index, 1);
    }
	
});