angular.module('budget', [])

.controller('budget', function($scope, $http) {
	$scope.topics = [ {
		title : 'Dynamic Group Header - 1',
		content : 'Dynamic Group Body - 1'
	}, {
		title : 'Dynamic Group Header - 2',
		content : 'Dynamic Group Body - 2'
	} ];
	
	$scope.standardCategories = function(){
		$scope.topics.push({title : 'hallo',
							content : '1'})
	}
})