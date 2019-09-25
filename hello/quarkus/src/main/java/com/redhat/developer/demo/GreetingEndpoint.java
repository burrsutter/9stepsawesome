package com.redhat.developer.demo;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/") 
public class GreetingEndpoint {
    
    private String prefix = "Supersonic Subatomic Java with Quarkus";
    
    private String HOSTNAME =
       System.getenv().getOrDefault("HOSTNAME", "unknown");

    private int count = 0;

    @GET    
    @Produces(MediaType.TEXT_PLAIN)
    public String greet() {
        count++;
        return prefix + " " + HOSTNAME + ":" + count + "\n";
    }

    @GET
    @Path("/healthz")
    @Produces(MediaType.TEXT_PLAIN)
    public String health() {
        return "OK";
    }
    
    @GET
    @Path("/myresources") 
    public String getSystemResources() {
         long memory = Runtime.getRuntime().maxMemory();
         int cores = Runtime.getRuntime().availableProcessors();
         System.out.println("/myresources " + HOSTNAME);
         return 
             " Memory: " + (memory / 1024 / 1024) +
             " Cores: " + cores + "\n";
    }
    
    @GET
    @Path("/consume") 
    public String consumeSome() {
        System.out.println("/consume " + HOSTNAME);

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

   public static String humanReadableByteCount(long bytes, boolean si) {
      int unit = si ? 1000 : 1024;
      if (bytes < unit)
        return bytes + " B";
      int exp = (int) (Math.log(bytes) / Math.log(unit));
      String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
      return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);  
   }

}