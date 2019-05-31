package com.raghvendra;
/*
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language.
Derive the order of letters in this language.

Example 1:

Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

Output: "wertf"
Example 2:

Input:
[
  "z",
  "x"
]

Output: "zx"
Example 3:

Input:
[
  "z",
  "x",
  "z"
]

Output: ""

Explanation: The order is invalid, so return "".
Note:

You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
 */


public class AlienDictionary {
    public String alienOrder(String[] words) {
        boolean[][] adj = new boolean[26][26];
        int[] visited = new int[26];
        buildGraph(words, adj, visited);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; ++i){
            if(visited[i] == 0){
                if(!dfs(adj, visited, sb, i)){
                    return "";
                }
            }
        }
        return sb.reverse().toString();
    }

    private boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i){
        visited[i]  = 1; //visiting
        for(int j = 0; j < 26; ++j){
            if(adj[i][j]){
                if(visited[j] == 1) return false; //means there is a cycle
                if(visited[j] == 0) {
                    if(!dfs(adj, visited, sb, j)){
                        return false;
                    }
                }
            }
        }
        visited[i] = 2;
        sb.append((char)(i + 'a'));
        return true;
    }

    private void buildGraph(String[] words, boolean[][] adj, int[] visited){
        for(int i = 0; i < visited.length; ++i){
            visited[i] = -1; //initialize with -1 , means not existed yet
        }

        for(int i = 0; i < words.length; ++i){
            for(char c : words[i].toCharArray()){
                visited[c - 'a'] = 0;  //letter exists
            }
            if(i > 0){
                String w1 = words[i - 1];
                String w2 = words[i];
                int len = Math.min(w1.length(), w2.length());
                for(int j = 0; j < len; ++j){
                    char c1 = w1.charAt(j);
                    char c2 = w2.charAt(j);
                    if(c1 != c2){
                        adj[c1 - 'a'][c2 - 'a'] = true;
                        break;
                    }
                }
            }
        }
    }
}
