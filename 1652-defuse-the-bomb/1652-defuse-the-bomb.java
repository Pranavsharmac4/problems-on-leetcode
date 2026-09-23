class Solution {
    public int[] decrypt(int[] code, int k) {
     int sum = 0;
     int n= code.length;
     int r[]=new int [n];
     if(k==0)return r;
     
     for(int i=0; i<n;i++){
          if(k>0){
                for(int j=i+1;j<i+1+k;j++){
                    r[i] += code[j%n];
                }
            }
            else if(k<0){
                for(int j =i-1;j>i-1-Math.abs(k);j--){
                    r[i] += code[((j % n) + n) % n];
                }
            }
        }
        return r;

     }
    }