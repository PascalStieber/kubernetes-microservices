var express = require('express');
var app = express();

app.get('/', function (req, res) {
  res.send('New Hello From Kubernetes Cluster! Second Version!!!');
});

app.get('/demov1', function (req, res) {
  res.send('Hello From Kubernetes Cluster Demo! V1');
});

app.get('/demov2', function (req, res) {
  res.send('Hello From Kubernetes Cluster Demo! V2');
});

app.listen(8080, function () {
  console.log('Example app listening on port 8080!');
});