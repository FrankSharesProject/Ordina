package com.example.main;

public class MainClass {

    public static void main(String[] args)
    {
        String text="Er was eens een konijn die geen zin had in een wortel Omdat dit konijn Mr Konijn heette was het niet handig";
        System.out.println(text);

        WordAnalyzer wordAnalyzer = new WordAnalyzer();
        System.out.println(wordAnalyzer.calculateFrequencyForWord(text,"KoniJn"));
        System.out.println(wordAnalyzer.calculateHighestFrequency(text));
        wordAnalyzer.calculateMostFrequentNWords(text, 22).forEach(s-> System.out.println(s.getWords() + s.getFrequency()));

        String text2="er er er Deze ze tekst is ER voOR om er er ver draai ze voor aai G>R E.r Rtg tekst eh ergo ze DezE test teksten er";
        System.out.println(text2);
        System.out.println(wordAnalyzer.calculateFrequencyForWord(text2,"er"));
        System.out.println(wordAnalyzer.calculateHighestFrequency(text2));
        wordAnalyzer.calculateMostFrequentNWords(text2, 22).forEach(s-> System.out.println(s.getWords() + s.getFrequency()));
    }
}
