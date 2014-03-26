package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.StringContains.containsString;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutProgramming() throws Exception {
        assertThat(queryProcessor.process("programming"), containsString("computing"));
    }

    @Test
    public void knowsAboutFootball() throws Exception {
        assertThat(queryProcessor.process("football"), containsString("neymar"));
    }    

    @Test
    public void knowsAboutCheese() throws Exception {
        assertThat(queryProcessor.process("cheese"), containsString("good"));
    }    

    @Test
    public void processPlus() throws Exception {
    	String test = "dh3h43s1: what is 16 plus 1";
    	
        assertThat(queryProcessor.process(test), containsString("17"));
    }    

    @Test
    public void processLargest() throws Exception {
    	String test = "dh3h43s1: numbers largest: 100, 20, 70";
        assertThat(queryProcessor.process(test), containsString("100"));
    }    

    
}
