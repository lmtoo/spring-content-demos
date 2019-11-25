angular.module('filesApp', [])
    .controller('FilesListController', function ($http) {
        var filesList = this;
        filesList.files = [];

        let basePath = "./api/v1/";

        filesList.getFilesList = function () {
            $http.get(basePath+'documents/').success(function (data, status, headers, config) {
                if (data._embedded != undefined) {
                    filesList.files = [];
                    angular.forEach(data._embedded.documents, function (file) {
                        filesList.files.push(file);
                    });
                }
            });
        };
        filesList.getFilesList();

        filesList.getHref = function (file) {
            return file._links["self"].href
        };

        filesList.upload = function () {
            var f = document.getElementById('file').files[0];
            var file = { originalFilename: f.originalFilename };

                $http.post(basePath+'documents/', file, {
                    headers: {
                        "Authorization":"Basic bGlsZUA5MDAwMTAwMDoxMTExMTE="
                    }
                })
                .then(function (response) {
                    var fd = new FormData();
                    fd.append('file', f);
                    return $http.put(response.data._links["content"].href, fd, {
                        transformRequest: angular.identity,
                        headers: {
                            'Content-Type': undefined,
                            "Authorization":"Basic bGlsZUA5MDAwMTAwMDoxMTExMTE="
                        }
                    });
                })
                .then(function (response) {
                    filesList.title = "";
                    filesList.keywords = "";
                    filesList.getFilesList();
                    document.getElementById('file').files[0] = undefined;
                });
        }
    });