package com.vividseats.business.impl;

import com.vividseats.business.model.Person;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import static com.vividseats.business.impl.PeopleGeneratorUtil.*;

import java.util.*;

public class CelebrityFinderTest {

    @Test
    public void shouldFindCelebrityWhenEveryoneKnowsTheCelebrity(){
        CelebrityFinder celebrityFinder = new CelebrityFinder();
        Optional<Person> person = celebrityFinder.find(Arrays.asList(CELEBRITY, NO_CELEBRITY1, NO_CELEBRITY2, NO_CELEBRITY3));
        Assertions.assertThat(person).isPresent();
        Assertions.assertThat(person.get()).isEqualTo(CELEBRITY);
    }

    @Test
    public void shouldNotFindCelebrityWhenAtLeastOnePersonDoesNotKnowTheCelebrity(){
        CelebrityFinder celebrityFinder = new CelebrityFinder();
        Optional<Person> person = celebrityFinder.find(Arrays.asList(NO_CELEBRITY0, NO_CELEBRITY1, NO_CELEBRITY2, NO_CELEBRITY3));
        Assertions.assertThat(person).isEmpty();
    }

    @Test
    public void shouldNotFindCelebrityWhenThereIsOnlyOnePerson(){
        CelebrityFinder celebrityFinder = new CelebrityFinder();
        Optional<Person> person = celebrityFinder.find(Arrays.asList(NO_CELEBRITY3));
        Assertions.assertThat(person).isEmpty();
    }

    @Test(expected = NullPointerException.class)
    public void shouldReturnExceptionWhenTheListIsNull(){
        CelebrityFinder celebrityFinder = new CelebrityFinder();
        celebrityFinder.find(null);
    }



}
