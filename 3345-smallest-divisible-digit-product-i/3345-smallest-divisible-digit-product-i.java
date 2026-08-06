class Solution {
    public int smallestNumber(int n, int t) {
        int smallest=n;
      for(int i=n;i<=(n+10);i++){
        int product=1;
        int current =i;
            while(current!=0){
                int temp=current%10;
                product*=temp;
                current/=10;
            }
         if(product%t==0){
            smallest=product;
          return i;
         }
         
      }
      return n;
    }
}