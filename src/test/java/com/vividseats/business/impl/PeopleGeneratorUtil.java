package com.vividseats.business.impl;

import com.vividseats.business.model.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toMap;

public final class PeopleGeneratorUtil {


    static final Person CELEBRITY = createPerson("11", Collections.emptyList());
    static final Person NO_CELEBRITY3 = createPerson("12", Arrays.asList(CELEBRITY));
    static final Person NO_CELEBRITY2 = createPerson("13", Arrays.asList(CELEBRITY, NO_CELEBRITY3));
    static final Person NO_CELEBRITY1 = createPerson("14", Arrays.asList(CELEBRITY, NO_CELEBRITY2, NO_CELEBRITY3));
    static final Person NO_CELEBRITY0 = createPerson("14", Arrays.asList(NO_CELEBRITY1, NO_CELEBRITY2));


    private PeopleGeneratorUtil(){

    }

    private static Person createPerson(String identification, List<Person> people) {
        Person person = new Person();
        person.setIdentification(identification);
        person.setKnown(people.stream().collect(toMap(Person::getIdentification, p -> p)));
        return person;
    }
}
