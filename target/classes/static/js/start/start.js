angular.module('start', [])

.controller('start', function($scope) {
	$scope.topics = [ {
		title : 'Dynamic Group Header - 1',
		content : 'Dynamic Group Body - 1'
	}, {
		title : 'Dynamic Group Header - 2',
		content : 'Dynamic Group Body - 2'
	} ];
})