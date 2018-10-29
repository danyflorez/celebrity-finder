package com.vividseats.business.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vividseats.business.Reader;
import com.vividseats.business.model.Person;
import com.vividseats.constant.ErrorMessage;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import static java.nio.file.Files.readAllLines;
import static java.util.stream.Collectors.joining;

public class JsonReader implements Reader {

    private final String path;
    private final ObjectMapper mapper;

    public JsonReader(String path) {
        this.path = Objects.requireNonNull(path, ErrorMessage.NULL_PATH);
        this.mapper = new ObjectMapper();
    }

    @Override
    public List<Person> getPeople() {
        try {
            return mapper.readValue(getContent(), new TypeReference<List<Person>>() {});
        } catch (IOException e) {
            throw new IllegalArgumentException(ErrorMessage.COULD_NOT_READ_JSON, e);
        }
    }

    private String getContent() throws IOException {
        return readAllLines(Paths.get(path))
                .stream()
                .collect(joining());
    }
}
