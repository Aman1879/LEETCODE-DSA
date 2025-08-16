class Solution {
    public int maximum69Number (int num) {
        // char[] digits = String.valueOf(num).toCharArray();

        // for (int i = 0; i < digits.length; i++) {
        //     if (digits[i] == '6') {
        //         digits[i] = '9'; // change the first '6' to '9'
        //         break;           // only one change allowed
        //     }
        // }

        // return Integer.parseInt(new String(digits));
        int temp=num;
        int add=0;
        int p=1;
        while(temp>0){
         int t = temp % 10;
         if(t==6){
            add=3*p;
         }   
         temp/=10;
         p*=10;
        }
        return num+add;
    }
}
