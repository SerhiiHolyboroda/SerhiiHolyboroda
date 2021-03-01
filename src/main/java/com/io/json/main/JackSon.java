package com.io.json.main;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.io.json.classes.DataJson;
import com.io.json.classes.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class JackSon {
    public static void main(String[] args) throws IOException {


//        ObjectMapper mapper = new ObjectMapper();
//
//      Driver d = mapper.readValue(new File("standing.json"), Driver.class);
//
//        System.out.println(d);
        ObjectMapper mapper = new ObjectMapper();

        try {

            // JSON file to Java object
            DataJson staff = mapper.readValue(new File("standing.json"), DataJson.class);

            // JSON string to Java object
            String jsonInString = "{\"name\":\"mkyong\",\"age\":37,\"skills\":[\"java\",\"python\"]}";
            DataJson staff2 = mapper.readValue(jsonInString, DataJson.class);

            // compact print
            System.out.println(staff2);

            // pretty print
            String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff2);

            System.out.println(prettyStaff1);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
