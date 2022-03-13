package by.rakovets.course.java.spring.webmvc.rest.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setFirstName("Dmitry");
        user.setLastName("Rakovets");

        // Object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String userAsJson = null;
        try {
            userAsJson = objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(userAsJson);

        // JSON to Object
        User userFromJson = null;
        try {
            userFromJson = objectMapper.readValue(userAsJson, User.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(userFromJson);
    }
}
