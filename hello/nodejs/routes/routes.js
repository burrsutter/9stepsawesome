var os = require('os');
var request = require('request');

var appRouter = function (app) {
    app.get("/", function(req,res) {
        res.status(200).send("Hello from Node.js on " + os.hostname());
    });

    app.get("/callinganother", function() {
        var anotherURL = "http://mynode.yourspace.svc.cluster.local/";
        var request = require('request');
        request(anotherURL, function (error, response, body) {
            if (!error && response.statusCode == 200) {
                res.status(200).send(response.body);
             }
        })
    });

    app.get("/configure", function(req,res) {
        var hostname = os.hostname();
        var databaseConn = (process.env.DBCONN || "Default");
        var msgBroker = (process.env.MSGBROKER || "Default");
        var hello = (process.env.GREETING || "Default");
        var love = (process.env.LOVE || "Default");
        var config = "Configuration for: " + hostname + "\ndatabaseConn=" + databaseConn + "\nmsgBroker=" + msgBroker + "\nhello=" + hello + "\nlove=" + love;
        res.status(200).send(config);
    })
    
    app.get("/health", function(req,res) {
        res.status(200).send("I am fine, thank you");
    })
    
    app.get("/sysresources", function(req,res) { 
        var gb = Number.parseFloat(os.totalmem()/1000000000).toPrecision(4);
        var cpuCount = os.cpus().length.toString();
        res.status(200).send("Memory: " + gb + "GB Cores: " + cpuCount);
    });
}

module.exports = appRouter;