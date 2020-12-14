package com.example.WordCount;

import com.example.main.WordFrequency;
import com.example.main.WordsElement;

import java.util.List;
import java.util.stream.Collectors;

public class CalculateService {

    com.example.main.WordAnalyzer wordAnalyzer = new com.example.main.WordAnalyzer();

    public String getCalculateHighestFrequency(String text){
        int value =  wordAnalyzer.calculateHighestFrequency(text);
        return value+"";
    }

    public String getCalculateFrequencyForWord(String text, String word){
        int value = wordAnalyzer.calculateFrequencyForWord(text, word);
        return value+"";
    }

    public String getCalculateMostFrequentNWords(String text, int topNWords){
        List<WordFrequency> wordFrequencyList = wordAnalyzer.calculateMostFrequentNWords(text,topNWords);
        List<WordsElement> wordsElementList = wordFrequencyList.stream().map( s -> {return (WordsElement) s;}).collect(Collectors.toList());
        return wordsElementList.stream().map(WordsElement::toString).reduce("", String::concat);
    }


}
