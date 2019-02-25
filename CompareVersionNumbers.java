package com.raghvendra;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int v1Length = v1.length;
        int v2Length = v2.length;
        int index = 0;
        while ((index < v1Length) && (index < v2Length)) {
            if (Integer.parseInt(v1[index]) > Integer.parseInt(v2[index])) {
                return 1;
            } else if (Integer.parseInt(v1[index]) < Integer.parseInt(v2[index])) {
                return -1;
            }
            index++;
        }

        while (index < v1Length) {
            if (Integer.parseInt(v1[index]) > 0) return 1;
            index++;
        }

        while (index < v2Length) {
            if (Integer.parseInt(v2[index]) > 0) return -1;
            index++;
        }
        return 0;
    }
}
