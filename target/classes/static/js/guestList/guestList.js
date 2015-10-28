angular.module('guestList', []).controller('guestList', function($scope) {
	$scope.guests = [{ name : 'simon',
						postalCode : '78954'}]
	$scope.isDisabled = true;
});