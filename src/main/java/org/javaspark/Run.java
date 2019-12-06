package org.javaspark;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Run {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {
        Greet greet = new Greet();

        staticFiles.location("/public"); // Static files

        port(getHerokuAssignedPort());

        get("/", (req, res) -> new ModelAndView(new HashMap<>(), "hello.hbs"), new HandlebarsTemplateEngine());

        post("/greet", (request, response) -> {
            Map<String, String> dataMap = new HashMap();
            String userName = request.queryParams("userName");
            String language = request.queryParams("greetingLanguage");

            String greeting = greet.greet(userName, language);

            dataMap.put("counter", greet.getGreetedCount().toString());
            dataMap.put("greeting", greeting);

            return new ModelAndView(dataMap, "hello.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
