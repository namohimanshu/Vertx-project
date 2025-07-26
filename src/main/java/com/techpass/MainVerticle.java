package com.techpass;

import io.vertx.core.AbstractVerticle;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

public class MainVerticle extends AbstractVerticle {

    public static void main(String[] args) {
        Vertx vertx1= Vertx.vertx();
   //     vertx1.deployVerticle(new FirstVerticle());


        DeploymentOptions options= new DeploymentOptions();
        options.setInstances(5);
        options.setWorkerPoolSize(2);
        vertx1.deployVerticle(BootStrapVerticle.class.getName(),options);
    }
}
