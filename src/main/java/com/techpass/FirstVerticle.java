package com.techpass;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class FirstVerticle extends AbstractVerticle {
    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        System.out.println("first verticle started");
    }
}
