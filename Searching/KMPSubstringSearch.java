package Searching; 
public class KMPSubstringSearch {
    
    // Function to build the LPS (Longest Prefix Suffix) array
    private static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;  // Length of the previous longest prefix suffix
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];  // Go back in the LPS array
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // KMP algorithm for substring search
    public static void KMPSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        // Compute the LPS array
        int[] lps = computeLPSArray(pattern);
        int i = 0; // Index for text
        int j = 0; // Index for pattern

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1];  // Move to the last matched position
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];  // Use LPS array to skip comparisons
                } else {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "abxabcabcaby";
        String pattern = "abcaby";
        KMPSearch(text, pattern);
    }
}