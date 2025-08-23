class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] ch = s.toCharArray();
        char[] dh = t.toCharArray();
        Arrays.sort(ch);
        Arrays.sort(dh);
        for(int i=0; i<ch.length; i++){
           if(ch[i] != dh[i]) return false;
        }

         return true;
    }
}