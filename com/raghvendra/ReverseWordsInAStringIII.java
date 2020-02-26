package com.raghvendra;

//public class ReverseWordsInAStringIII {
//    public String reverseWords(String s) {
//        StringBuilder sb = new StringBuilder();
//        char[] wordsString = s.toCharArray();
//        Stack<Character> myStack  = new Stack<>();
//        for(int i = 0; i < wordsString.length;i++){
//            if(wordsString[i]== ' '){
//                while(!myStack.empty()){
//                    sb.append(myStack.pop());
//                }
//                sb.append(' ');
//            } else {
//                myStack.push(wordsString[i]);
//            }
//        }
//        while(!myStack.empty()){
//            sb.append(myStack.pop());
//        }
//        return new String(sb);
//    }
//}


//Using reverse() method

//public class ReverseWordsInAStringIII {
//    public String reverseWords(String s) {
//        String [] words = s.split(" ");
//        StringBuilder sb = new StringBuilder();
//        for(String word : words){
//            sb.append(new StringBuilder(word).reverse()+" ");
//        }
//        return sb.toString().trim();
//    }
//}

////Using two pointer
//public class ReverseWordsInAStringIII {
//    public String reverseWords(String s) {
//        StringBuilder sb = new StringBuilder();
//        char [] wordsChar = s.toCharArray();
//        System.out.println("Length "+ wordsChar.length);
//         for(int index = 0, k = 0; k < wordsChar.length; k++){
//             if(wordsChar[k] == ' '){
////                int j = k-1;
//                 while(j>=index){
//                     System.out.print("chars: "+ wordsChar[j]);
//                     System.out.println();
//                     sb.append(wordsChar[j]);
//                     j--;
//                }
//                 sb.append(' ');
////                 index = k+1;
//            }
//        }
//         return sb.toString().trim();
//    }
//}

import java.util.Stack;

//Using Stack
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        Stack<Character> word = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                while (!word.isEmpty()){
                    sb.append(word.pop());
                }
                sb.append(' ');
            }else {
                word.push(s.charAt(i));
            }
        }
        while (!word.isEmpty()){
            sb.append(word.pop());
        }
        return sb.toString();
    }
}
