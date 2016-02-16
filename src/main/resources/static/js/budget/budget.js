angular.module('budget', [])

.controller('budget', function($scope, $http, $filter, $uibModal, $timeout, $window, $translate, modalService) {
	$scope.dirtyBudgetItems =[];
	$scope.newBudgetItems = [];
	$scope.savedBudgetItems = [];
	$scope.allDisabled = true;
	$scope.budgetTopics = ['Braut', 'Bräutigam', 'Trauung', 'Hochzeitsfeier', 'Gebühren', 'Hochzeitspapeterie', 'Flitterwochen', 'Sonstiges'];
	$scope.hideError = true;
	$scope.hideSuccess = true;
	
	function getItems() {
		  $http.get('/userDetails/').success(function(data) {
				$scope.id = data.id;
				$scope.translationData = {
					    firstName: data.firstName,
					    marriagePartner: data.marriagePartner
					  };
				
				var params = {
						
						id : $scope.id
				};
					
				$http.get('/budget/search/findByUserId', {params : params}).success(
						function(data) {
							if (data._embedded != undefined) {
								
								angular.forEach(angular.fromJson(data._embedded.budget), function(obj){
									var string = obj._links.self.href;
									$scope.helpArray = string.split('/');
									$scope.itemId = $scope.helpArray[$scope.helpArray.length-1]
											$scope.savedBudgetItems.push({
												name : obj.name,
												plannedValue: obj.plannedValue,
												realValue: obj.realValue,
												paid: obj.paid,
												topic : obj.topic,
												id: $scope.itemId,
												isDisabled : true,
												showDetails : false})  
								})
							} 
						});
			})
			};
	getItems();
	
	$scope.addItem = function(topic){
				$scope.newBudgetItems.push({
					topic: topic,
					id : 'new',
					name : '',
					plannedValue: 0,
					realValue: 0,
					paid: false}); 
				} 
	
	
	$scope.saveBudgetItems = function() {
			$scope.newBudgetItems.forEach(function(item){
				$http.post(
						'/save/newBudgetItem',
						{
							topic: item.topic,
							name: item.name,
							plannedValue: item.plannedValue,
							realValue: item.realValue,
							paid: item.paid
						}
				).success(function(data, status, headers) {
					$scope.newBudgetItems.forEach(function(item){
						$scope.savedBudgetItems.push(item)
					})
					$scope.newBudgetItems = []
					$scope.hideSuccess = false;
					$timeout(function() {
						$scope.hideSuccess = true;
					}, 3000);
				}).error(function(data, status, headers) {
					alert("error");
				});
			})
			
		
		$scope.dirtyBudgetItems.forEach(function(item){
			$http.put('/update/budget/' +item.id,{
				name: item.name,
				plannedValue: item.plannedValue,
				realValue: item.realValue,
				paid: item.paid
			}).success(function(data, status, headers) {
				$scope.dirtyBudgetItems = []
				$window.scrollTo(0, 0);
				$scope.hideSuccess = false;
				$timeout(function() {
					$scope.hideSuccess = true;
				}, 3000);
			}).error(function(data, status, headers) {
				alert("error");
			});
		})
	}
				
	
	
	$scope.delete = function (index, item) {
		modalService.showModal({}).then(function (result){
			if(item.id === 'new'){
					$scope.newBudgetItems.splice(index,1)
			}
			else{
				 $http.delete('delete/budget/' + item.id).success(function(data, status){
			        	console.log("gelöscht")
			        	$scope.savedBudgetItems.splice(index,1)
			        })
			}
       
		})
		
    }
	
	
	$scope.saveDirty = function (topic, item) {
		item.isDisabled=!item.isDisabled
		var a = 0;
		var b;
		var i;
	    for (i = 0; i < $scope.dirtyBudgetItems.length; i++) {
        	
	        if ($scope.dirtyBudgetItems[i].id == item.id) {
	        	b=i;
	        	a=1;
	        }
	        
	    }
	    if(a==0 && item.id != 'new'){
	    	$scope.dirtyBudgetItems.push(item)
	    }
	    if(a==1){
	    	$scope.dirtyBudgetItems[b].name = item.name;
	    	$scope.dirtyBudgetItems[b].plannedValue = item.plannedValue;
	    	$scope.dirtyBudgetItems[b].realValue = item.realValue;
	    	$scope.dirtyBudgetItems[b].paid = item.paid;
	    	
	    }
	    console.log($scope.dirtyBudgetItems)
	}
	
	$scope.saveAllDirty = function (topic){
		//TODO
		if($scope.allDisabled){
			$scope.savedBudgetItems.forEach(function(item){
				if(item.topic === topic){
					item.isDisabled = false;
					$scope.saveDirty(topic, item)
				}
				
			})
		}
		if(!$scope.allDisabled){
			$scope.savedBudgetItems.forEach(function(item){
				if(item.topic === topic){
					item.isDisabled = true;
					$scope.saveDirty(topic, item)
				}
			})
		}
		
		$scope.allDisabled = !$scope.allDisabled;
	}
	
	$scope.openDialog = function(item, number) {

		if(number === 0){
			var uibModalInstance = $uibModal.open({
	            templateUrl: 'js/dialog/provider.html',
	            controller: 'provider',
	            resolve: {
	                item: function () {
	                    return item;
	                }
	            }
	        });
		}
		if(number === 1){
			var uibModalInstance = $uibModal.open({
	            templateUrl: 'js/dialog/details.html',
	            controller: 'details',
	            resolve: {
	                item: function () {
	                    return item;
	                }
	            }
	        });
		}
		
	}
	}).filter('sumOfValue',	function() {
				return function(data, key) {
					if (typeof (data) === 'undefined'
							&& typeof (key) === 'undefined'
							| typeof (data) === 'undefined') {
						return 0;
					}
					var sum = 0;
					for (var i = 0; i < data.length; i++) {
						sum = sum + parseFloat(data[i][key]);
					}
					return sum;
				}
			})