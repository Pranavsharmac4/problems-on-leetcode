class Solution {
    public int minimumPushes(String word) {
        int c=0;
       for(int i=0;i<word.length();i++){
        c+=(i/8)+1;
       }
       return c;
        
   
    }
}