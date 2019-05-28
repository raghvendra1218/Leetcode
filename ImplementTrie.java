package com.raghvendra;

public class ImplementTrie {
    private class TrieNode{
        char val;
        boolean isWord;
        TrieNode[] branches = new TrieNode[26];
        TrieNode(){ };
        TrieNode(char c, boolean isWord){
            val = c;
            this.isWord = isWord;
            TrieNode node = new TrieNode();
        }
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public ImplementTrie() {
        root = new TrieNode();
        root.val = ' ';
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.branches[c - 'a'] == null){
                curr.branches[c - 'a'] = new TrieNode(c, false);
            }
            curr = curr.branches[c - 'a'];
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.branches[c - 'a'] == null){
                return false;
            }
            curr = curr.branches[c - 'a'];
        }
        return curr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c : prefix.toCharArray()){
            if(curr.branches[c - 'a'] == null){
                return false;
            }
            curr = curr.branches[c - 'a'];
        }
        return true;
    }
}
