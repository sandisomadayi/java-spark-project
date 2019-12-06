package org.javaspark;

import java.util.HashMap;
import java.util.Map;

public class Greet {


    Map<String, Integer> greeted = new HashMap<>();

    public String greet(String name, String language) {
        String greeting = "Invalid language";
        if (language.equalsIgnoreCase("Zulu")) {
            greeting = "Sawubona, " + name;
        }
        else if (language.equalsIgnoreCase("Xhosa")) {
            greeting = "Molo, " + name;
        }
        else if (language.equalsIgnoreCase("Afrikaans")) {
            greeting = "Goeie dag, " + name;
        }

        if (!greeting.equalsIgnoreCase("Invalid language")) {
            updateCount(name);
        }
        return greeting;
    }

    public Integer getGreetedCount() {
        return greeted.keySet().size();
    }

    public void updateCount(String name) {
        if (!greeted.containsKey(name)) {
            greeted.put(name, 1);
        }
        else {
            greeted.put(name, greeted.get(name)+1);
        }
    }
}
