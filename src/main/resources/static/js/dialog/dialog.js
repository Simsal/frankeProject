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
			
			$scope.close = function(){
				$uibMmodalInstance.close();
			}
			
		}])