package com.raghvendra;

import java.util.ArrayList;
import java.util.List;

/**
 * You have an array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 *
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier,
 * with the identifier used in case of ties.  The digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 *
 * Example 1:
 *
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 *
 *
 * Constraints:
 *
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */

public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digitLogs = new ArrayList<>();
        List<String> letterLogs =new ArrayList<>();

        //Step 1: Separate Letter logs and Digit Logs
        for (String log : logs) {
            //Check if the last character of the current log is a letter or a digit
            //Checking last character is intuitive way rather than checking the first character
            if(Character.isDigit(log.charAt(log.length()-1))) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }

        //Step2: Sort Letter Logs
        letterLogs.sort((o1, o2) -> {
            //Strings s1 and s2 are strings, excluding the identifiers
            String s1 = o1.substring(o1.indexOf(" ") + 1);
            String s2 = o2.substring(o2.indexOf(" ") + 1);

            //If strings(s1 and s2) comes out to be same, then we have to sort including identifier(i.e - o1 and o2),
            //else apply sorting on excluding the identifiers
            return s1.equals(s2) ? o1.compareTo(o2) : s1.compareTo(s2);
        });

        //Step3: Generate the final output
        String[] result = new String[digitLogs.size() + letterLogs.size()];
        int idx = 0;
        for (String log : letterLogs) {
            result[idx] = log;
            idx++;
        }
        for (String log : digitLogs) {
            result[idx] = log;
            idx++;
        }
        return result;
    }
}
