class Solution {
    public int totalNumbers(int[] digits) {
        int[] f = new int[10];
        int res = 0;

        for (int d : digits) f[d]++;

        for (int i = 1; i < 10; i++) 
            for (int j = 0; j < 10; j++) 
                for (int k = 0; k < 9; k += 2) {
                    f[i]--; f[j]--; f[k]--;

                    if (f[i] >= 0 && f[j] >= 0 && f[k] >= 0) res++;

                    f[i]++; f[j]++; f[k]++;
                }           
        

        return res;
    }
}
