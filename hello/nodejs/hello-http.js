const os = require('os');
const http = require('http');
let cnt = 0;

http.createServer((req, res) =>
    res.end(`Hello from Node.js! ${cnt++} on ${os.hostname()}\n`)
).listen(8000);

console.log(`Server running at http://localhost:8000/`);

