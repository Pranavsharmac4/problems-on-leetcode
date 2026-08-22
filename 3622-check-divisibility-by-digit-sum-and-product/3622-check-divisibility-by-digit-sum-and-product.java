class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int product=1;
        int digit=n;
        while(n!=0){
            int temp=n%10;
            sum+=temp;
            product*=temp;
            n=n/10;
        }

        int div=sum+product;
       return digit%div==0;
    }
}