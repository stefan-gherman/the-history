package com.codecool.thehistory;




import java.util.*;


public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        String[] splitText = text.split("\\s+");
        List<String> lst = new ArrayList<String>();
        Collections.addAll(lst, wordsArray);
        for (String word : splitText
        ) {
           lst.add(word);
        }
        wordsArray = new String[lst.size()];
        wordsArray = lst.toArray(wordsArray);
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
//        int idx = 0;
//        for (int i=0; i< wordsArray.length; i++) {
//            if (!wordToBeRemoved.equals(wordsArray[i])){
//                wordsArray[idx++] = wordsArray[i];
//            }
//        }
//        wordsArray = Arrays.copyOf(wordsArray,idx);

        List<String> lst = new ArrayList<String>();
        Collections.addAll(lst, wordsArray);
        lst.removeAll(Collections.singleton(wordToBeRemoved));
        wordsArray = new String[lst.size()];
        wordsArray = lst.toArray(wordsArray);

    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArray.length;
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        List<String> lst = new ArrayList<String>();
        Collections.addAll(lst, wordsArray);
        lst.clear();
        wordsArray = new String[lst.size()];
        wordsArray = lst.toArray(wordsArray);
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        List<String> lst = new ArrayList<String>();
        Collections.addAll(lst, wordsArray);
        Collections.replaceAll(lst, from ,to);
        wordsArray = new String [lst.size()];
        wordsArray = lst.toArray(wordsArray);
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        List<String> lst = new ArrayList<String>();
        Collections.addAll(lst, wordsArray);

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
        wordsArray = new String [lst.size()];
        wordsArray = lst.toArray(wordsArray);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
