package com.burrsutter;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyRESTController {
    @Autowired
    private Environment environment;

   final String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");
   String greeting;
   
   private int count = 0; // simple counter to see lifecycle

   RestTemplate restTemplate = new RestTemplate();

   @RequestMapping("/")
   public String sayHello() {
       greeting = environment.getProperty("GREETING","Hej");
       count++;
       System.out.println(greeting + " from " + hostname + " " + count);
       return greeting + " from Spring Boot! " + count + " on " + hostname + "\n";
   }

   @RequestMapping("/sysresources") 
   public String getSystemResources() {
        long memory = Runtime.getRuntime().maxMemory();
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("/sysresources " + hostname);
        return 
            " Memory: " + (memory / 1024 / 1024) +
            " Cores: " + cores + "\n";
   }

   @RequestMapping("/consume") 
   public String consumeSome() {
        System.out.println("/consume " + hostname);

        Runtime rt = Runtime.getRuntime();
        StringBuilder sb = new StringBuilder();
        long maxMemory = rt.maxMemory();
        long usedMemory = 0;
        // while usedMemory is less than 80% of Max
        while (((float) usedMemory / maxMemory) < 0.80) {
            sb.append(System.nanoTime() + sb.toString());
            usedMemory = rt.totalMemory();
        }
        String msg = "Allocated about 80% (" + humanReadableByteCount(usedMemory, false) + ") of the max allowed JVM memory size ("
            + humanReadableByteCount(maxMemory, false) + ")";
        System.out.println(msg);
        return msg + "\n";
   }

   @RequestMapping(method = RequestMethod.GET, value = "/health")   
   public ResponseEntity<String> health() {               
        // if (count++ < 5) {
        //    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Bad");
        // } else {             
            return ResponseEntity.status(HttpStatus.OK)
                .body("I am fine, thank you\n");
        // }
   }

   @RequestMapping("/configure")
   public String configure() {
        String databaseConn = environment.getProperty("DBCONN","Default");
        String msgBroker = environment.getProperty("MSGBROKER","Default");
        greeting = environment.getProperty("GREETING","Default");
        String love = environment.getProperty("LOVE","Default");
        return "Configuration for : " + hostname + "\n" 
            + "databaseConn=" + databaseConn + "\n"
            + "msgBroker=" + msgBroker + "\n"
            + "greeting=" + greeting + "\n"
            + "love=" + love + "\n";
   }

   @RequestMapping("/callinganother")
   public String callinganother() {
        
        // <servicename>.<namespace>.svc.cluster.local
        String url = "http://mynode.yourspace.svc.cluster.local:8000/";

        ResponseEntity<String> response
        = restTemplate.getForEntity(url, String.class);
    
        String responseBody =  response.getBody();
        System.out.println(responseBody);

        return responseBody;
   }

   public static String humanReadableByteCount(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < unit)
            return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }

}