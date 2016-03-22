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
			$scope.provider = {
					name		:	"",
					street		:	"",
					postalCode	:	"",
					town		:	"",
					email		:	"",
					telephone	:	"",
					mobilephone	:	"",
					comment		:	""
					
			};
			//TODO Provider finden
			if($scope.item.provider != undefined){
			function findProvider() {
						console.log($scope.item)
						var params = {
								
								id : $scope.item.provider
						};
							
						$http.get('/provider/search/findById', {params : params}).success(
								function(data) {
									if (data._embedded != undefined) {
										$scope.provider = angular.fromJson(data._embedded.guests);
										
									} else {
										$scope.provider = [];
									}
								});
					
					};
			findProvider();
			}
			
			$scope.ok = function ok() {
				console.log($scope.provider)
				$http.post("/save/newProvider", {
					name		:	$scope.provider.name,
					street		:	$scope.provider.street,
					postalCode	:	$scope.provider.postalCode,
					town		:	$scope.provider.town,
					email		:	$scope.provider.email,
					telephone	:	$scope.provider.telephone,
					mobilephone	:	$scope.provider.mobilephone,
					comment		:	$scope.provider.comment
				}).success(function(data, status, headers) {
					alert("passt")
				}).error(function(data, status, headers) {
					alert("error");
				});
			    $uibModalInstance.close($scope.item);
			  };

			  $scope.cancel = function () {
			    $uibModalInstance.dismiss('cancel');
			  };
			
		}])