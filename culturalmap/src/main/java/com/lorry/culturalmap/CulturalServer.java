package com.lorry.culturalmap;

import static spark.Spark.*;
import spark.Request;
import spark.Response;
import spark.Route;

public class CulturalServer {
    public static void main(String[] args) {
    	System.out.println("Starting Cultural Server...");

        port(8080);
        staticFiles.externalLocation("static"); 

        get("/getStateInfo", new Route() {
            @Override
            public Object handle(Request request, Response response) {
                String state = request.queryParams("state");
                response.type("application/json");
                return DBUtil.getCultureInfo(state);
            }
        });
        System.out.println("Cultural Server is ready at http://localhost:8080");

    }
}

