package com.vividseats.business.impl;

import com.vividseats.business.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void write(String content) {
        System.out.println(content);
    }
}
