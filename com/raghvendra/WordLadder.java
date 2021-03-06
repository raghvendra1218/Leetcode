package com.raghvendra;

/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest
transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //Initialise a set to keep track of visited words, we will remove words from it as we will find them while visiting
        Set<String> unvisited =  new HashSet<>(wordList);
        //Create a Queue for BFS traversal
        Queue<String> myQueue = new LinkedList<>();
        //A check to remove the beginWord from the wordList, if present, however not required
        unvisited.remove(beginWord);
        //Boundary condition, check if the endWord is there in the wordList or not, if not then return 0
        if(!unvisited.contains(endWord)) return 0;
        myQueue.offer(beginWord);
        //initialise a counter for keeping track of the distance for each level, initially we are at level 1,
        //because beginWord is already added in the queue, we need to count that as level 1
        int distance = 1;
        //Start the traversal
        while (!myQueue.isEmpty()){
            //Let's initialise the size variable because that will mark the level for traversal, and increment distance by 1
            int size = myQueue.size();
            for(int i = 0; i < size; ++i){
                //Convert the popped word to char array
                char[] word = myQueue.poll().toCharArray();
                //We need to plant each alphabet at each places in the word, so traverse through the char array to exploit every possibility
                for(int j = 0; j < word.length; ++j){
                    //Try alphabets for each word placing
                    char temp = word[j];
                    for(int k = 0; k < 26; ++k){
                        word[j] = (char)('a' + k);
                        //create the new word in form of a string
                        String nextWord = new String(word);
                        //check the newWord in the unvisited set
                        if(unvisited.contains(nextWord)){
                            //check if this word is equal to the endWord, if yes then return distance
                            if(nextWord.equals(endWord)){
                                distance++;
                                return distance;
                            } else {
                                //Add the nextWord in the Queue
                                myQueue.offer(nextWord);
                                //Remove this newWord from the Set, so that it is not checked again
                                unvisited.remove(nextWord);
                            }
                        }
                    }
                    word[j] = temp;
                }
            }
            distance++;
        }
        return 0;
    }
}
