package com.codecool.thehistory;

import java.util.*;

public class TheHistoryLinkedList implements TheHistory {
    /**
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        String[] splitText = text.split("\\s+");
        for (String word : splitText
        ) {
            wordsLinkedList.add(word);
        }
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        wordsLinkedList.removeAll(Collections.singleton(wordToBeRemoved));
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsLinkedList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsLinkedList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        Collections.replaceAll(wordsLinkedList,from,to);
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

        List<String> lst = new ArrayList<>(wordsLinkedList);
        while(currentEnd <= lst.size()) {
//           List<String> plm = new ArrayList<>(lst.subList(begin, currentEnd));
            if(lst.subList(begin, currentEnd).equals(from)){
                lst.subList(begin, currentEnd).clear();
                lst.addAll(begin, to);
                begin += adder;
                currentEnd += adder;
            } else {
                begin += 1;
                currentEnd += 1;
            }

        }
        wordsLinkedList = new LinkedList<>(lst);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsLinkedList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
