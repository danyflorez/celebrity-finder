package com.vividseats.business.impl;

import com.vividseats.business.Finder;
import com.vividseats.business.Processor;
import com.vividseats.business.Reader;
import com.vividseats.business.Writer;
import com.vividseats.business.model.Person;
import com.vividseats.constant.ErrorMessage;
import com.vividseats.constant.General;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CelebrityProcessor implements Processor {

    private final Reader reader;
    private final Finder finder;
    private final  Writer writer;

    public CelebrityProcessor(Reader reader, Finder finder, Writer writer) {
        this.reader = Objects.requireNonNull(reader, ErrorMessage.READER_SHOULD_NOT_BE_NULL);
        this.finder = Objects.requireNonNull(finder, ErrorMessage.FINDER_SHOULD_NOT_BE_NULL);
        this.writer = Objects.requireNonNull(writer, ErrorMessage.WRITER_SHOULD_NOT_BE_NULL);
    }

    @Override
    public void process() {
        List<Person> people = reader.getPeople();
        Optional<Person> person = finder.find(people);
        String content = person.map(p -> String.format(General.CELEBRITY_FOUND, p.getIdentification()))
                                .orElse(General.CELEBRITY_NOT_FOUND);
        writer.write(content);
    }
}
