class Solution {

    public boolean isVowel(char c){

        if(c == 'a' || c == 'e' || c == 'i' ||c == 'o' || c == 'u'){
            return true;
        }

        return false;

    }

    public int maxVowels(String s, int k) {
        
        int n = s.length();
        int max = 0;
        int low =0 , high = 0;
        int count = 0;
        while(high<n){

            char c = s.charAt(high);
          if(isVowel(c)){
                count++;
          }

          while(high-low+1 > k){
            if(isVowel(s.charAt(low))){
                count--;
            }
            low++;
          }

          if(high - low + 1 == k){
            max = Math.max(count, max);

          }

          high++;

        }
        return max;
        }


   
        
    }