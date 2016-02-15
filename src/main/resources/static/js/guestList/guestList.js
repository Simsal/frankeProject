angular.module('guestList', []).controller('guestList', function($scope, $http, $filter, $uibModal, modalService) {
	$scope.guests = [];
	$scope.newGuest = [];
	$scope.newGuests = [];
	$scope.dirtyGuests = [];
	
	function findAllGuests() {
		  $http.get('/userDetails/').success(function(data) {
				$scope.id = data.id;
				$scope.firstName = data.firstName;
				$scope.marriagePartner = data.marriagePartner;
				
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
         console.log($scope.guestListForm.$error);
	});
	
	$scope.saveDirty = function (index, guest) {
		guest.isDisabled=!guest.isDisabled
		
		if($scope.containsGuest(index, $scope.dirtyGuests)){
			$scope.dirtyGuests.push($scope.guests[index]);
		}
	}
	
	$scope.containsGuest = function(index, list) {
		var i;
	    for (i = 0; i < list.length; i++) {
	        if (angular.equals(list[i], $scope.guests[index])) {
	            return false;
	        }
	    }

	    return true;
		}
	
	
	$scope.saveGuests = function(){
//		if($scope.newGuests.)
		
		$scope.dirtyGuests.forEach(function(guest){
			var string = guest._links.self.href;
			$scope.helpArray = string.split('/');
			$scope.itemId = $scope.helpArray[$scope.helpArray.length-1]
			$http.put('/update/guests/' +$scope.itemId,{
				firstName: guest.firstName,
				lastName: guest.lastName,
				street: guest.street,
				postalCode: guest.postalCode,
				town: guest.town,
				email: guest.email,
				marriageSide: guest.marriageSide,
				invited: guest.invited
			}).success(function(data, status, headers) {
				alert("passt")
			}).error(function(data, status, headers) {
				alert("error");
			});
		})
		
		$scope.newGuests.forEach(function(guest) {
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
		$scope.newGuest.isDisabled = true;
		$scope.newGuests.push($scope.newGuest);
		$scope.newGuest = [];
	}
	
	$scope.delete = function (index, item) {
		modalService.showModal({}).then(function (result){
		var string = item._links.self.href;
		$scope.helpArray = string.split('/');
		$scope.itemId = $scope.helpArray[$scope.helpArray.length-1]
        $http.delete('delete/guest/' + $scope.itemId).success(function(data, status){
        	$scope.guests.splice(index, 1);
        })
		})
		
    }
	
})
