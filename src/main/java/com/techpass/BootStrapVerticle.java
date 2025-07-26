package com.techpass;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;

public class BootStrapVerticle extends AbstractVerticle {
    public void start() throws Exception{
        //ways to deploy the verticles
        //vertx.deployVerticle("com.techpass.FirstVerticle");


        vertx.deployVerticle(FirstVerticle.class.getName());
        System.out.println("deployed the bootstarp article with first article");
       // vertx.deployVerticle(new FirstVerticle());
    }
}
