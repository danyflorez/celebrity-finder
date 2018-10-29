package com.vividseats.application;

import com.vividseats.business.Finder;
import com.vividseats.business.Processor;
import com.vividseats.business.Reader;
import com.vividseats.business.Writer;
import com.vividseats.business.impl.CelebrityFinder;
import com.vividseats.business.impl.CelebrityProcessor;
import com.vividseats.business.impl.ConsoleWriter;
import com.vividseats.business.impl.JsonReader;

public class CelebrityApplication {

    public static void main(String ...args){
        Reader reader = new JsonReader(args[0]);
        Finder finder = new CelebrityFinder();
        Writer writer = new ConsoleWriter();
        Processor processor = new CelebrityProcessor(reader, finder, writer);
        processor.process();
    }
}
