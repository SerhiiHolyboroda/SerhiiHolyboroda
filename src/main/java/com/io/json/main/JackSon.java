package com.io.json.main;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.io.json.classes.Example;


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class JackSon {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Example> test = mapper.readValue(new File("standing.json"), new TypeReference<List<Example>>() {
        });
        System.out.println(test);

    }
}
