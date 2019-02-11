package com.raghvendra;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        // First Thought process was through maps (So I am not deleting it)
//        Map<Character,Integer> myMap = new HashMap<>();
//        int index = 0, count = 0;
//        for(int i = 0; i< toString().length();++i){
//            if(myMap.containsKey(S.charAt(i))){
//                myMap.put(S.charAt(i),myMap.get(S.charAt(i)+1));
//            } else {
//                myMap.put(S.charAt(i),1);
//            }
//        }
//        while(index)
//        for(Map.Entry<Character,Integer> entry : myMap.entrySet()){
//            if(entry.getKey() == J.charAt(i)){
//                count+=entry.getValue();
//            }
//        }

        int count = 0;
        int[] letters = new int[255];
        for(int i = 0; i < S.length(); i++){
            letters[(int)S.charAt(i)]++;
        }
        for(int j = 0; j <J.length();j++){
            count+=letters[(int)J.charAt(j)];
        }
        return count;
    }
}
