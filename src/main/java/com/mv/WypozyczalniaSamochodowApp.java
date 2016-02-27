package com.mv;

import com.mv.controller.Dispatcher;

import static spark.SparkBase.port;


public class WypozyczalniaSamochodowApp {
    public static void main(String[] args) {
        port(getPort());
        new Dispatcher().setRoutes();
    }

    private static Integer getPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        Integer port;
        if (processBuilder.environment().get("PORT") != null) {
            port = Integer.parseInt(processBuilder.environment().get("PORT"));
        } else {
            port = 4567;
        }
        return port;
    }
}
