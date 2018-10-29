package com.vividseats.business.model;

import java.util.Map;
import java.util.Objects;

public class Person {

    private String identification;
    private Map<String, Person> known;

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public Map<String, Person> getKnown() {
        return known;
    }

    public void setKnown(Map<String, Person> known) {
        this.known = known;
    }

    public boolean knows(Person p){
        Objects.requireNonNull(p, "Person should not be null");
        return known.containsKey(p.getIdentification());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(identification, person.identification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identification);
    }
}
