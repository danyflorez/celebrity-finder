package com.vividseats.business.impl;

import com.vividseats.business.model.Person;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import java.util.List;

public class JsonReaderTest {

    @Test
    public void shouldReadJsonSuccessfullyWhenJsonIsValid(){
        JsonReader jsonReader = new JsonReader("src/test/resources/valid.json");

        List<Person> people = jsonReader.getPeople();

        Assertions.assertThat(people.get(0).getIdentification()).isEqualTo("6545");
        Assertions.assertThat(people.get(0).getKnown().get("43").getIdentification()).isEqualTo("43");
        Assertions.assertThat(people.get(1).getIdentification()).isEqualTo("43");
        Assertions.assertThat(people.get(1).getKnown().get("33456").getIdentification()).isEqualTo("33456");
    }

    @Test
    public void shouldReadJsonSuccessfullyWhenHasEmptyKnown(){
        JsonReader jsonReader = new JsonReader("src/test/resources/empty-known.json");

        List<Person> people = jsonReader.getPeople();

        Assertions.assertThat(people.get(0).getIdentification()).isEqualTo("97");
        Assertions.assertThat(people.get(0).getKnown()).isEmpty();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowsAndExceptionWhenJsonIsInvalid(){
        JsonReader jsonReader = new JsonReader("src/test/resources/invalid.json");
        jsonReader.getPeople();
    }


    @Test(expected = NullPointerException.class)
    public void shouldThrowsAndExceptionWhenPathIsInvalid(){
        new JsonReader(null);
    }


}
