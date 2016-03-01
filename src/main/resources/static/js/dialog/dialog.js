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
				function($scope, $uibModalInstance, item) {
			
			$scope.item = item;
			
			$scope.ok = function () {
			    $uibModalInstance.close($scope.item);
			  };

			  $scope.cancel = function () {
			    $uibModalInstance.dismiss('cancel');
			  };
			
		}])