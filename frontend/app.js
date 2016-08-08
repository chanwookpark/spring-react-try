var bodyParser = require('body-parser');
var express = require('express');
var app = express();
/**
 * Express 설정
 */
app.set('port', (process.env.PORT || 3000));
app.use(bodyParser.urlencoded({extended: true}));
app.use(express.static(__dirname + '/public'));

app.use(function (req, res, next) {
    // CORS header
    res.setHeader('Access-Control-Allow-Origin', '*');

    // disable caching
    res.setHeader('Cache-Control', 'no-cache');
    next();
});

app.listen(app.get('port'), function () {
    console.log('Server started (port: ' + app.get('port') + ')');
});