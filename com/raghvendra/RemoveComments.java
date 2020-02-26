package com.raghvendra;

import java.util.ArrayList;
import java.util.List;
//
//We only need to check for two things:
//
//   If we see '//' we stop reading the current line, and add whatever characters we have seen to the result.
//   If we see '/*' then we start the multiline comment mode and we keep on ignoring characters until we see '*/'.
//   If the current character is neither of the above two and the multiline comment mode is off, then we add that character to the current line.
//   Once we parse one line (source[i]), then if the mode is off, we add the currently generated line (StringBuilder) to the result and repeat for source[i + 1].
//   We need to be careful not to insert empty lines in the result.

public class RemoveComments {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean mode = false;

        //traverse through each Strings passed in source
        for(String s : source){
            //traverse through each Character in each source line i.e. s
            for(int i = 0; i < s.length(); ++i){

                //If mode is set true skip the lines until we find the set of characters like this : '*/' in the following lines
                if(mode){
                    if(i < s.length() - 1 && s.charAt(i) == '*' && s.charAt(i + 1) == '/'){
                        mode = false;
                        i++;  //skip the '/' in the next iteration of  i
                    }
                } else {
                    //Check for // comments in such case we can safely break from the current line further reading because we simply have to move
                    //to the next line without adding it into the result, so it's okay to read the next line from input source
                    if(i < s.length() - 1 && s.charAt(i) == '/' && s.charAt(i + 1) == '/'){
                        break;  //ignore remaining characters on line s
                    } else if(i < s.length() - 1 && s.charAt(i) == '/' && s.charAt(i + 1) == '*'){
                        //multiLine comment found, set the mode as true
                        mode = true;
                        i++; //we can skip the '*' in the next iteration of i, as it's already been checked in the else if condition above
                    } else {
                        //Found the legit code and we can add in the sb
                        sb.append(s.charAt(i));
                    }
                }
            }
            //After each line, it's time to add the sb in the ArrayList result, and reset the StringBuilder
            //Also we have to make sure mode is not set, because if it is, we do not have to add the sb in result
            if(!mode && sb.length() > 0){
                result.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return result;
    }
}
