class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26]; 
        String vowels = "aeiou";
    
         
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        int maxVowel = 0;
        int maxConsonant = 0;
        
      
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            if (freq[i] > 0) {
                if (vowels.indexOf(ch) != -1) {
                    maxVowel = Math.max(maxVowel, freq[i]);   
                } else {
                    maxConsonant = Math.max(maxConsonant, freq[i]); 
                }
            }
        }
        
        return maxVowel + maxConsonant;
    }
}
