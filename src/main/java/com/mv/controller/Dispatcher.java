package com.mv.controller;

import com.mv.dao.CarDao;
import com.mv.dao.DBConnectionManager;
import com.mv.dao.ReservationDao;
import com.mv.model.Car;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.List;

import static spark.Spark.post;
import static spark.SparkBase.staticFileLocation;
import static spark.Spark.get;

public class Dispatcher {

    public void setRoutes() {
        DBConnectionManager connectionManager = new DBConnectionManager();
        CarDao carDao = new CarDao(connectionManager);
        ReservationDao reservationDao = new ReservationDao(connectionManager);
        staticFileLocation("/public");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();

        get("/", new BasicResource("index.ftl"), freeMarkerEngine);
        get("/cars", new CarsResource(carDao), freeMarkerEngine);
        get("/cars/:id/reservation", new ReservationResource(carDao, reservationDao), freeMarkerEngine);
    }
}
