package com.example.WordCount;

import com.example.main.WordAnalyzer;
import com.example.main.WordFrequency;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public final class CalculateResourceTest{


    @Test
    void testWordAnalyzer() {

        final String text = "er er er ger ger ver ver zzz ergerg  ver er";
        WordAnalyzer wordAnalyzer = new WordAnalyzer();
        int result = wordAnalyzer.calculateHighestFrequency(text);
        assertEquals(4,result);
        String word = "ger";
        int resultger = wordAnalyzer.calculateFrequencyForWord(text,word);
        assertEquals(2,resultger);
        List<WordFrequency> resultList = wordAnalyzer.calculateMostFrequentNWords(text,5);
        assertEquals("er",resultList.get(0).getWords());
        assertEquals("ver",resultList.get(1).getWords());
        assertEquals("ger",resultList.get(2).getWords());
        assertEquals("ergerg",resultList.get(3).getWords());
        assertEquals("zzz",resultList.get(4).getWords());
        assertEquals(result,resultList.get(0).getFrequency());
        assertEquals(4,resultList.get(0).getFrequency());
    }
    /*
    Via Postman (GET & SENT)
    http://localhost:8080/WordCount-1.0-SNAPSHOT/calculateHighestFrequency/General/hoi dit mag alles zijn en dit werkt
    http://localhost:8080/WordCount-1.0-SNAPSHOT/calculateHighestFrequency/ForWord/hoi/with/hoi hoi hoi hoi hoi hoi hi
    http://localhost:8080/WordCount-1.0-SNAPSHOT/calculateMostFrequentNWords/hoi dit mag alles zijn en dit werkt/4
   Wilde Jersey testen maken maar die maven repo downloade niet.
     */
}