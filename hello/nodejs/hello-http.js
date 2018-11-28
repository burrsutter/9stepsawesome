const os = require('os');
const http = require('http');
let cnt = 0;

http.createServer((req, res) =>
    res.end(`Node Hello on ${os.hostname()} ${cnt++} \n`)
).listen(8000);

console.log(`Server running at http://localhost:8000/`);

