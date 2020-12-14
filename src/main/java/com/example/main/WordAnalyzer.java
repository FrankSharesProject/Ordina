package com.example.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordAnalyzer implements WordFrequencyAnalyzer
{
    //Singleton of com.example.main.WordAnalyzer.
    //In java 11 zou ik dit met een final var hebben opgelost.
    //Kan glasfish 5.1 niet mee om gaan.
    static String wordAnalyzer;
    public static String getWordAnalyzer() {
        return wordAnalyzer;
    }

    public void setWord(String word) {
        WordAnalyzer.wordAnalyzer = word;
    }

    @Override
    public int calculateHighestFrequency(String text)
    {
        String[] trimmedLowerCaseSplitedText = text.trim().toLowerCase().split("\\s+");
        //Counters and Indices
         AtomicInteger maxCountingValue = new AtomicInteger();
        AtomicInteger currentCountingValue = new AtomicInteger();
        setWord(trimmedLowerCaseSplitedText[0]);
        //Run the counting
        Arrays.stream(trimmedLowerCaseSplitedText).sorted().forEach(sortedWord ->
        {
            if (sortedWord.equals(getWordAnalyzer()))
            {
                currentCountingValue.getAndIncrement();
            }
            else
            {
                setWord(sortedWord);
                SetNewMaximumValueIfNeeded(maxCountingValue, currentCountingValue);
                currentCountingValue.set(1);
            }
        //If the last multiple words are on a streak, this shouldn't be missed.
            SetNewMaximumValueIfNeeded(maxCountingValue, currentCountingValue);
        });
        return maxCountingValue.get();
    }

    @Override
    public int calculateFrequencyForWord(String text, String word)
    {
        String[] trimmedLowerCaseSplitedText = text.trim().toLowerCase().split("\\s+");
        AtomicInteger currentCountingValue = new AtomicInteger();
        Arrays.stream(trimmedLowerCaseSplitedText).sorted().forEach(sortedWord ->
        {
            if (sortedWord.equals(word.toLowerCase())) {
                currentCountingValue.getAndIncrement();
            }
        });
        return currentCountingValue.get();
    }


    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int amount)
    {
        String[] trimmedLowerCaseSplitedTextStringArray = text.trim().toLowerCase().split("\\s+");
        ArrayList<WordsElement> arrayOfWordFrequency =
                (ArrayList<WordsElement>) Arrays.stream(trimmedLowerCaseSplitedTextStringArray)
                        .map( word-> giveWordElementForGivenWordLambda(text,word.toLowerCase()))
                        .collect(Collectors.toList());
        return arrayOfWordFrequency.stream().sorted().distinct().limit(amount).collect(Collectors.toList());
    }

    private static WordsElement giveWordElementForGivenWordLambda(String text, String word){
        String[] trimmedLowerCaseSplitedText = text.trim().toLowerCase().split("\\s+");
        AtomicInteger currentCountingValue = new AtomicInteger();
        Arrays.stream(trimmedLowerCaseSplitedText).sorted().forEach(sortedWord ->
        {
            if (sortedWord.equals(word.toLowerCase())) {
                currentCountingValue.getAndIncrement();
            }
        });
        return new WordsElement(word, currentCountingValue.get());
    }

    private void SetNewMaximumValueIfNeeded(AtomicInteger maxCountingValue, AtomicInteger currentCountingValue)
    {
        if (maxCountingValue.get() < currentCountingValue.get())
        {
            maxCountingValue.set(currentCountingValue.get());
        }
    }
}

      /* Dit werkt helaas niet omdat er geen goede pattern is.
      De pattern heeft altijd moeite met juiste woorden achter elkaar met bijv: er er er erg ger ger erg er ver.
      private static WordsElement giveWordElementForGivenWordLambda(String text, String word)
    {
        Pattern pattern = Pattern.compile("(\\s+" + word +"\\s+)| (\\s+"+word+"$)|(^"+word+"\\s+)");
        Matcher matcher = pattern.matcher(text.toLowerCase().trim());
        int count = 0;
        while (matcher.find())
        {
            count++;
        }
        return new WordsElement(word, count);
    }*/
