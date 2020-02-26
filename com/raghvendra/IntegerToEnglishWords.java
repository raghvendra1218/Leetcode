package com.raghvendra;

public class IntegerToEnglishWords {
    private String [] bigUnits = {"", " Thousand", " Million", " Billion"};
    private String [] digits = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"};
    private String [] tens = {"", "", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
    private String [] tenToNineTeen = {" Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen",
                                        " Eighteen", " Nineteen"};

    public String numberToWords(int num) {
        StringBuilder sb = new StringBuilder();
        int bigUnitIndex = 0 ;
        while(num != 0){
            //Do not append the BigUnit if num is completely divisible by 1000
            if(num % 1000 != 0){
                sb.insert(0,  parseIntoThreeDigits(num % 1000) + bigUnits[bigUnitIndex]);
            }
            bigUnitIndex++;
            num = num / 1000;
        }
        return (sb.toString().equals("")) ? "Zero" : sb.substring(1);
    }

    private String parseIntoThreeDigits(int num){
        StringBuilder sb = new StringBuilder();
        if(num > 99){
            sb.append(digits[num / 100] + " Hundred");
            num = num % 100;
        }
        if(num > 19){
            sb.append(tens[num / 10]);
            num = num % 10;
        }
        if(num > 9){
            sb.append(tenToNineTeen[num % 10]);
            return sb.toString();
        }
        return sb.append(digits[num]).toString();
    }
}
