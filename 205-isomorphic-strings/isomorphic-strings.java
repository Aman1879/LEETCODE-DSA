class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] arr = new char[128];
       

        for(int i=0 ;i <s.length(); i++){
            char ch = s.charAt(i);
            char dh = t.charAt(i);
            int idx = (int)ch;
            if(arr[idx] =='\0') arr[idx] = dh;
else{
            if(arr[idx] != dh) return false;
}
        } 


        for(int i=0; i<128; i++){
            arr[i] = '\0';
        }

         for(int i=0 ;i <s.length(); i++){
            char ch = t.charAt(i);
            char dh = s.charAt(i);
            int idx = (int)ch;
            if(arr[idx] =='\0') arr[idx] = dh;
else{
            if(arr[idx] != dh) return false;
}
        } 




        return true;
        


    }
}