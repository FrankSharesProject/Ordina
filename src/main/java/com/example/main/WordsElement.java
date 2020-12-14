package com.example.main;

public class WordsElement implements com.example.main.WordFrequency, Comparable
{
    public WordsElement(String word, int frequency)
    {
        this.word = word;
        this.frequency = frequency;
    }

    private String word;
    private int frequency;

    @Override
    public String getWords()
    {
        return word;
    }

    @Override
    public int getFrequency()
    {
        return frequency;
    }


    public int compareTo(WordsElement w)
    {
        if(w.frequency > frequency){return 1;}
        if(w.frequency == frequency && w.word.equals(word)){return 0;}
        if(w.frequency == frequency && !(w.word.equals(word))){return word.compareTo(w.word);}
        else return -1;
    }

    @Override
    public int compareTo(Object o)
    {
        if (o instanceof WordsElement)
        {
            return compareTo((WordsElement) o);
        }
        else{
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordsElement comparingTo = (WordsElement) o;

        if (!word.equals(comparingTo.word)) return false;

        return true;

    }
    @Override
    public String toString(){
        return " word: "+this.word +"has frequency: "+this.frequency;
    }


}