import java.util.*;

class Solution {
    public String sortVowels(String s) {
        String vowels = "aeiouAEIOU";
        int n = s.length();
        
        char[] chars = s.toCharArray();
        StringBuilder vowelBuilder = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            if (vowels.indexOf(chars[i]) != -1) {
                vowelBuilder.append(chars[i]);
            }
        }
        
        char[] vowelArray = vowelBuilder.toString().toCharArray();
        Arrays.sort(vowelArray);
        
        StringBuilder result = new StringBuilder();
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            if (vowels.indexOf(chars[i]) != -1) {
                result.append(vowelArray[idx++]);
            } else {
                result.append(chars[i]);
            }
        }
        
        return result.toString();
    }
}
