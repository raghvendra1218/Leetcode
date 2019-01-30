package com.raghvendra;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
//        if(s == null) return s;
//        s= s.trim();
//        String [] wordsString = s.split(" ");
//        System.out.println("WordsString: " + Arrays.toString(wordsString));
//        List<String> words =  new ArrayList<>();
//        for(String a: wordsString) {
//            //Logic to check if the string contains white space, if present do not add in the List
//            if(a.trim().length() != 0) {
//                words.add(a);
//            }
//        }
//        int wordsStringLength = words.size();
//        String resultantString = "";
//        for(int i = wordsStringLength-1; i >= 0; i --){
//            resultantString += words.get(i)+" ";
//            // below logic can be replaced by using .trim() in the string before returning the string.
//            if(i != 0){
//                resultantString += " ";
//            }
//        }
//        return resultantString;

    //leetcode solution
    if(s == null) return null;
    StringBuilder sb = new StringBuilder();
    int i = s.length()-1;
        while (i>=0){
            if(s.charAt(i) == ' '){
                i--;
                continue;
            }
        int index = s.lastIndexOf(' ',i);
        sb.append(s.substring(index+1,i+1));
        sb.append(' ');
        i = index;
    }
        return sb.toString().trim();
    }
}
