angular
		.module(
				'hello',
				[ 'ngRoute', 'ui.bootstrap', 'mwl.calendar', 'pascalprecht.translate', 'ng-currency', 'auth', 'home',
						'navigation', 'start', 'budget', 'tablePlan',
						'guestList', 'register', 'dialog' ])
		.config(

				function($routeProvider, $httpProvider, $locationProvider) {

					$locationProvider.html5Mode(true);

					$routeProvider.when('/', {
						templateUrl : 'js/home/home.html',
						controller : 'home'
					}).when('/login', {
						templateUrl : 'js/navigation/login.html',
						controller : 'navigation'
					}).when('/ubersicht', {
						templateUrl : 'js/start/start.html',
						controller : 'start'
					}).when('/budgetplanung', {
						templateUrl : 'js/budget/budget.html',
						controller : 'budget'
					}).when('/guestlist', {
						templateUrl : 'js/guestList/guestList.html',
						controller : 'guestList'
					}).when('/tischplan', {
						templateUrl : 'js/tablePlan/tablePlan.html',
						controller : 'tablePlan'
					}).when('/register', {
						templateUrl : 'js/register/register.html',
						controller : 'register'
					}).otherwise('/');

					$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

				})
		.run(function(auth) {

			// Initialize auth module with the home page and login/logout path
			// respectively
			auth.init('/home', '/login', '/register', '/logout', '/home');

		})
		.config(function(calendarConfig) {

			calendarConfig.dateFormatter = 'moment';; // use moment to
			// format dates
			moment.locale('de')
			calendarConfig.allDateFormats.moment.date.hour = 'HH:mm';
		}).config(
				function($translateProvider) {
					// deutsche Sprache
					$translateProvider
							.translations(
									'de_DE',
									{
										BUDGET_HEADING : 'Hallo {{firstName}} und {{marriagePartner}}',
										BUDGET_TAB1 : 'Details',
										BUDGET_TAB2 : 'Zusammenfassung',
										BUDGET_COL1 : 'Name',
										BUDGET_COL2 : 'Planpreis',
										BUDGET_COL3 : 'Preis',
										BUDGET_COL4 : 'Erledigt',
										BUDGET_PROVIDER : 'Dienstleister',
										BUDGET_DETAILS : 'Weitere Informationen',
										BUDGET_ADDITEM : 'Neuer Posten',
										BUDGET_SAVE : 'Speichern',
										BUDGET_COL5_1 : 'Alle',
										BUDGET_COL5_2 : 'Alle'
										
										
										
									});

					// englische Sprache
					$translateProvider
							.translations(
									'en_US',
									{
										BUDGET_HEADING : '',
										BUDGET_TAB1 : 'Details',
										BUDGET_TAB2 : 'Summary',
										BUDGET_COL1 : 'Name',
										BUDGET_COL2 : 'Planned Value',
										BUDGET_COL3 : 'Real Value',
										BUDGET_COL4 : 'Done',
										BUDGET_PROVIDER : 'Service provider',
										BUDGET_DETAILS : 'Additional Information',
										BUDGET_ADDITEM : 'New Item',
										BUDGET_SAVE : 'Save',
										BUDGET_COL5_1 : 'All',
										BUDGET_COL5_2 : 'All'
										
									});
					$translateProvider.preferredLanguage('de_DE');
				})
		.service(
				'modalService',
				[
						'$uibModal',
						function($uibModal) {

							var modalDefaults = {
								backdrop : true,
								keyboard : true,
								modalFade : true,
								templateUrl : '/js/confirmModal/confirmModal.html'
							};

							var modalOptions = {
								closeButtonText : 'Close',
								actionButtonText : 'OK',
								headerText : 'Proceed?',
								bodyText : 'Perform this action?'
							};

							this.showModal = function(customModalDefaults,
									customModalOptions) {
								if (!customModalDefaults)
									customModalDefaults = {};
								customModalDefaults.backdrop = 'static';
								return this.show(customModalDefaults,
										customModalOptions);
							};

							this.show = function(customModalDefaults,
									customModalOptions) {
								var tempModalDefaults = {};
								var tempModalOptions = {};

								angular.extend(tempModalDefaults,
										modalDefaults, customModalDefaults);

								angular.extend(tempModalOptions, modalOptions,
										customModalOptions);

								if (!tempModalDefaults.controller) {
									tempModalDefaults.controller = function(
											$scope, $uibModalInstance) {
										$scope.modalOptions = tempModalOptions;
										$scope.modalOptions.ok = function(
												result) {
											$uibModalInstance.close(result);
										};
										$scope.modalOptions.close = function(
												result) {
											$uibModalInstance.dismiss('cancel');
										};
									}
								}

								return $uibModal.open(tempModalDefaults).result;
							};

						} ])