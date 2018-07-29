package com.burrsutter;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
public class MainVerticle extends AbstractVerticle {
    final String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");
    @Override
    public void start() {
        Router router = Router.router(vertx);
        router.get("/hello").handler(request -> {
            request.response().end("Hello from Vert.x! " + new java.util.Date() + " on " + hostname);
        });

        vertx.createHttpServer().requestHandler(router::accept)
            .listen(8080);
    }
}
