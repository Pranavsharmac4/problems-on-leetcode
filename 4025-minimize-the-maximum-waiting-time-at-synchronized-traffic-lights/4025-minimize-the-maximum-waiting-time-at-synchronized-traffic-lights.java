class Solution {
    public int minPenalty(int p, int[] lights, int[] arr) {
        int maxl=0;
        for(int l:lights){
            maxl=Math.max(maxl,l);
        }
        int ans=0;
        for(int t:arr){
            int r=t%p;
            if(r>=maxl){
                ans=Math.max(ans,p-r);
            }
        }
        return ans;
    }
}