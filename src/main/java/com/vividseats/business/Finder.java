package com.vividseats.business;

import com.vividseats.business.model.Person;

import java.util.List;
import java.util.Optional;

public interface Finder {

    Optional<Person> find(List<Person> personList);
}
