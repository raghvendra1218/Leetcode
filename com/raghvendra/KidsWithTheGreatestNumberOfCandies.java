package com.raghvendra;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();

        int maxCandies = 0;
        for (int j : candies) {
            maxCandies = Math.max(j, maxCandies);
        }

        for (int candy : candies) {
            if (maxCandies - candy <= extraCandies) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}
