package com.burrsutter;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class MyRESTController {
   final String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");
   private int count = 0; // simple counter to see lifecycle

   @RequestMapping("/")
   public String sayHello() {
       return "Bonjour from Spring Boot! " + count++ + " on " + hostname + "\n";
   }

   @RequestMapping("/sysresources") 
   public String getSystemResources() {
        long memory = Runtime.getRuntime().maxMemory();
        int cores = Runtime.getRuntime().availableProcessors();
        return 
            " Memory: " + (memory / 1024 / 1024) +
            " Cores: " + cores;
   }

   @RequestMapping("/consume") 
   public String consumeSome() {
       return "";
   }
}