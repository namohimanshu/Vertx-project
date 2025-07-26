package com.techpass;

import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.json.JsonObject;

public class BootStrapVerticle extends AbstractVerticle {
    public void start() throws Exception{
        //ways to deploy the verticles
        //vertx.deployVerticle("com.techpass.FirstVerticle");


      //  vertx.deployVerticle(FirstVerticle.class.getName());
        System.out.println("deployed the bootstarp article with first article");
       // vertx.deployVerticle(new FirstVerticle());



        ConfigStoreOptions fileStore = new ConfigStoreOptions()
                .setType("file")
                .setOptional(true)
                .setConfig(new JsonObject().put("path","my-config.hocon"));
        ConfigStoreOptions sysPropStore= new ConfigStoreOptions().setType("sys");
        ConfigRetrieverOptions options= new ConfigRetrieverOptions().addStore(fileStore)
                .addStore(sysPropStore);
        ConfigRetriever retriever= ConfigRetriever.create(vertx,options);
      retriever.getConfig().onComplete(
              json -> {
                  JsonObject configs=  json.result();
                  int instances = configs.getInteger("verticle-instance");
                  DeploymentOptions dOptions= new DeploymentOptions();
                  dOptions.setInstances(instances);
                  dOptions.setWorkerPoolSize(5);
                  vertx.deployVerticle(FirstVerticle.class.getName(),dOptions);
              }
      );
    }
}
