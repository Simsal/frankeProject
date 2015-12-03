angular.module('guestList', []).controller('guestList', function($scope) {
	$scope.guests = [{ firstName : 'simon',
						postalCode : '78954',
						isDisabled : true},
					{firstName : 'sarah',
						postalCode : '78953',
						isDisabled : true}]
	$scope.newGuest = {};
	
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