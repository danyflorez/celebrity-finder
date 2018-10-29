package com.vividseats.business.impl;

import com.vividseats.business.Finder;
import com.vividseats.business.Processor;
import com.vividseats.business.Reader;
import com.vividseats.business.Writer;
import com.vividseats.business.model.Person;
import org.junit.Test;
import org.mockito.Mockito;
import static com.vividseats.business.impl.PeopleGeneratorUtil.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CelebrityProcessorTest {

    @Test
    public void shouldWriteTheCelebrityWhenIsFound(){
        List<Person> people = Arrays.asList(CELEBRITY, NO_CELEBRITY1);
        Reader reader = Mockito.mock(Reader.class);
        Mockito.when(reader.getPeople()).thenReturn(people);
        Writer writer = Mockito.mock(Writer.class);
        Finder finder = Mockito.mock(Finder.class);
        Mockito.when(finder.find(people)).thenReturn(Optional.of(CELEBRITY));
        Processor processor = new CelebrityProcessor(reader, finder, writer);

        processor.process();

        Mockito.verify(writer).write("The celebrity is 11");
    }

    @Test
    public void shouldWriteCelebrityNotFoundWhenIsNoFound(){

        List<Person> people = Arrays.asList(NO_CELEBRITY0, NO_CELEBRITY1);
        Reader reader = Mockito.mock(Reader.class);
        Mockito.when(reader.getPeople()).thenReturn(people);
        Writer writer = Mockito.mock(Writer.class);
        Finder finder = Mockito.mock(Finder.class);
        Mockito.when(finder.find(people)).thenReturn(Optional.empty());
        Processor processor = new CelebrityProcessor(reader, finder, writer);

        processor.process();

        Mockito.verify(writer).write("Celebrity not found");
    }

    @Test(expected=NullPointerException.class)
    public void shouldThrowsExceptionWhenReaderIsNull(){
        Writer writer = Mockito.mock(Writer.class);
        Finder finder = Mockito.mock(Finder.class);
        new CelebrityProcessor(null, finder, writer);
    }

    @Test(expected=NullPointerException.class)
    public void shouldThrowsExceptionWhenWriterIsNull(){
        Reader reader = Mockito.mock(Reader.class);
        Finder finder = Mockito.mock(Finder.class);
        new CelebrityProcessor(reader, finder, null);
    }

    @Test(expected=NullPointerException.class)
    public void shouldThrowsExceptionWhenFinderIsNull(){
        Reader reader = Mockito.mock(Reader.class);
        Writer writer = Mockito.mock(Writer.class);
        new CelebrityProcessor(reader, null, writer);
    }
}
