package org.javaspark;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Run {
    public static void main(String[] args) {
//        get("/hello", (req, res) -> "Hello world");
        get("/hello", (request, response) -> {
            Map<String, String> dataMap = new HashMap();
            dataMap.put("name", "sandiso");

            return new ModelAndView(dataMap, "hello.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
