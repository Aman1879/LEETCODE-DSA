class Solution {
    public int findClosest(int x, int y, int z) {
        int countx = Math.abs(x-z);
        int county = Math.abs(y-z);

     
        if(countx < county){
            return 1;
        }else if( countx > county){
            return 2;
        }else {
            return 0;
        }


    }
}