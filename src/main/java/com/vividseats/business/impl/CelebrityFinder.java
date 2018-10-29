package com.vividseats.business.impl;

import com.vividseats.business.Finder;
import com.vividseats.business.model.Person;
import com.vividseats.constant.ErrorMessage;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class CelebrityFinder implements Finder {

    @Override
    public Optional<Person> find(List<Person> people) {
        Objects.requireNonNull(people, ErrorMessage.THE_PERSON_LIST_SHOULD_NOT_BE_NULL);
        if(people.size() <= 1)
            return Optional.empty();

        Person celebrityCandidate = findCelebrityCandidate(people);
        return validateCelebrity(celebrityCandidate, people);
    }

    private Person findCelebrityCandidate(List<Person> people) {
        int personIndex = 0;
        int celebrityCandidate = people.size() - 1;

        while(personIndex < celebrityCandidate){
            if(people.get(personIndex).knows(people.get(celebrityCandidate))){
                personIndex++;
            }else{
                celebrityCandidate--;
            }
        }
        return people.get(celebrityCandidate);
    }

    private Optional<Person> validateCelebrity(Person celebrity, List<Person> people) {
        boolean invalid = people.stream()
                .filter(isNotCelebrity(celebrity))
                .anyMatch(p -> celebrity.knows(p) || !p.knows(celebrity));

        if(invalid){
            return Optional.empty();
        }
        return Optional.of(celebrity);
    }

    private Predicate<Person> isNotCelebrity(Person celebrity) {
        return i -> !i.equals(celebrity);
    }

}
