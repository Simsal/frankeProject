angular.module('dialog', []).controller(
		'details',
		[ '$scope', '$uibModalInstance', 'item',
				function($scope, $uibModalInstance, item) {
			
			$scope.item = item;
			
			$scope.close = function(){
				$uibModalInstance.close();
			}
			
		}])
.controller(
		'provider',
		[ '$scope', '$uibModalInstance', 'item',
				function($scope, $uibModalInstance, item, $http) {
			
			$scope.item = item;
			//TODO Provider finden
			function findProvider() {
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
			findProvider();
			
			$scope.ok = function () {
			    $uibModalInstance.close($scope.item);
			  };

			  $scope.cancel = function () {
			    $uibModalInstance.dismiss('cancel');
			  };
			
		}])