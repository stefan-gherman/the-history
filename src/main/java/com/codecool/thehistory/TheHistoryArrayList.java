package com.codecool.thehistory;

import java.util.*;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        String[] splitText = text.split("\\s+");
        for (String word : splitText
        ) {
            wordsArrayList.add(word);
        }
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        wordsArrayList.removeAll(Collections.singleton(wordToBeRemoved));
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        Collections.replaceAll(wordsArrayList,from,to);
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        List<String> from = new ArrayList<>();
        Collections.addAll(from, fromWords);

        List<String> to = new ArrayList<>();
        Collections.addAll(to, toWords);


        int begin = 0;
        int currentEnd = from.size();
        int checked = 0;
        int adder;

//        LinkedList<String> lst = new LinkedList<>(wordsArrayList);
//        Iterator it = lst.iterator();

        if (from.size() <= to.size() && !(to.containsAll(from))) {
            adder = from.size();
        } else {
            adder = to.size();
        }

        while(currentEnd <= wordsArrayList.size()) {
//           List<String> plm = new ArrayList<>(lst.subList(begin, currentEnd));
            if(wordsArrayList.subList(begin, currentEnd).equals(from)){
              wordsArrayList.subList(begin, currentEnd).clear();
                wordsArrayList.addAll(begin, to);
                begin += adder;
                currentEnd += adder;
            } else {
                begin += 1;
                currentEnd += 1;
            }

        }



    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
