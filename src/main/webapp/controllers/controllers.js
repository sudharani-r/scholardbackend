var controllersModule = angular.module('controllers', []);
 
controllersModule.controller('SampleController', function($scope) {
    console.log('Sample Load done !');
});
 
controllersModule.controller('ajaxController', function($scope, $http) {
    $http.get('/Elearning/rest/customer/').success(function(data) {
        console.log(data);
    });
});