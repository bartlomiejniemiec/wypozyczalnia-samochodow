package controller;

import spark.template.freemarker.FreeMarkerEngine;

import static spark.SparkBase.staticFileLocation;
import static spark.Spark.get;

public class Dispatcher {

    public void setRoutes() {
        staticFileLocation("/public");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
        get("/", new IndexResource(), freeMarkerEngine);
      //  get("/", new , freeMarkerEngine);

    }
}
