var http = require('http');
var cnt = 0;

http.createServer(function (req, res) {
    var now = new Date();
    res.end('Hello from Node.js! ' + cnt++ + ' on ' + process.env.HOSTNAME  + '\n');
    
}).listen(8000, '0.0.0.0');
console.log('Server running at http://:8000/');
