package com.burrsutter;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class MyRESTController {
   final String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");

   @RequestMapping("/hello")
   public String sayHello() {
       return "Hello from Spring Boot! " + new java.util.Date() + " on " + hostname + "\n";
   }

}