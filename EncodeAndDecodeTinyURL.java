package com.raghvendra;

/*
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl
 and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work.
You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Approach 1: Using a global counter and then storing the values in the HashMap
 * Limitation : The range of URLs that can be decoded is limited by the range of int.
 *              If excessively large number of URLs have to be encoded, after the range of int is exceeded,
 *              integer overflow could lead to overwriting the previous URLs' encodings, leading to the performance degradation.
 */

/*public class EncodeAndDecodeTinyURL {
    Map<Integer, String> map = new HashMap<>();
    int i = 0;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(i, longUrl);
        return "http://tinyurl.com/" + i++;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/","")));
    }
}*/

/**
 * Approach 2 : Using Hashcode - inbuilt function of Map
 *              We can also think of using concurrent HashMap to make thread safe
 */
/*public class EncodeAndDecodeTinyURL {

    Map<Integer, String> map = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(longUrl.hashCode(), longUrl);
        return "http://tinyurl.com/"+ longUrl.hashCode();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
}*/

/**
 * Approach 3 : Using HashMap + Random Generator - Advantages very less collision and the URL will be sortened to just 6 bits
 * Intuition : We will use possible valid alphanumeric chars and they sum up to 64 in total (0-9 + a-z + A-Z)
 * Advantages : The number of URLs that can be encoded is quite large in this case, nearly of the order (10+26*2)^6.
 *              The length of the encoded URLs is fixed to 6 units, which is a significant reduction for very large URLs.
 *              The performance of this scheme is quite good, due to a very less probability of repeated same codes generated.
 *              Predicting the encoding isn't possible in this scheme since random numbers are used.
 */
public class EncodeAndDecodeTinyURL {

    private String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Map<String, String> map = new HashMap<>();
    private Random rand = new Random();
    private String key = getRand();

    private String getRand(){
        StringBuilder sb = new StringBuilder();
        //six bits are used to represent a 64 characters
        for(int i = 0; i < 6; ++i){
            sb.append(alphabet.charAt(rand.nextInt(62)));
        }
        return new String(sb);
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while (map.containsKey(key)){
            key = getRand();
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
}
