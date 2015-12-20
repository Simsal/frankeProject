angular.module('guestList', []).controller('guestList', function($scope, $http, $filter) {
	$scope.guests = [];
	$scope.newGuest = [];
	$scope.newGuests = [];
	
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
								$scope.guests.forEach(function(guest) {
								    guest.isDisabled = true;
								})
								
							} else {
								$scope.guests = [];
							}
						});
			})
			};
	findAllGuests();
	
	$scope.$watch("guestListForm.$dirty", function(newValue) {
         console.log($scope.guestListForm.$dirty);
	});
	
	
	$scope.saveGuests = function(){
		$scope.newGuests.forEach(function(guest) {
			console.log(guest)
			$http.post(
					'/save/newGuest',
					{
						firstName: guest.firstName,
						lastName: guest.lastName,
						street: guest.street,
						postalCode: guest.postalCode,
						town: guest.town,
						email: guest.email,
						marriageSide: guest.marriageSide,
						invited: guest.invited
					}
			).success(function(data, status, headers) {
				alert("passt")
			}).error(function(data, status, headers) {
				alert("error");
			});
		})
		
	}
	
	$scope.nextUser = function (){
		$scope.newGuests.push($scope.newGuest);
		$scope.newGuest = [];
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
	
})
