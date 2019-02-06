//package com.raghvendra;
//
//public class AddBinary {
//    public String addBinary(String a, String b) {
//        char[] strA = a.toCharArray();
//        char[] strB = b.toCharArray();
//
//        int lengthStringA = strA.length;
//        int lengthStringB = strB.length;
//        if(lengthStringA > lengthStringB){
//            strB = new char[lengthStringA];
//            int diff = lengthStringA - lengthStringB;
//            for(int i = 0; i < lengthStringA; i++){
//                if(diff >= 0){
//                    strB[i] = '0';
//                    diff--;
//                } else {
//                    strB[i] = strB[i];
//                }
//            }
//        } else if(lengthStringA == lengthStringB){
//
//        }
//        else {
//            int [] strANew = new int[lengthStringB];
//            int diff = lengthStringB - lengthStringA;
//            for(int i = 0; i < lengthStringA; i++){
//                if(diff >=0){
//                    strANew[i] = 0;
//                    diff--;
//                } else {
//                    strANew[i] = strA[i];
//                }
//        }
//
//        for(int i = 0; i <=lengthStringA; i++){
//            if((strANew[i] == 0 && strB[i] == 1) || (strANew[i] == 1 && strB[i] == 0)){
//
//            }
//        }
//    }
//}
