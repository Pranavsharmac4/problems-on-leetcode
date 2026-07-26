class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
int n = series1.length;
        int m = series2.length;
        List<List<Integer>> rs = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        
        while (i < n || j < m) {
            int t1 = (i < n) ? series1[i][0] : Integer.MAX_VALUE;
            int t2 = (j < m) ? series2[j][0] : Integer.MAX_VALUE;
            
            int curr = Math.min(t1, t2);
            
            int val1 = (i < n) ? series1[i][1] : 0;
            int val2 = (j < m) ? series2[j][1] : 0;
            List<Integer> pair = new ArrayList<>();
            pair.add(curr);
            pair.add(val1 + val2);
            rs.add(pair);
            
            if (t1 < t2) {
                i++;
            } else if (t2 < t1) {
                j++;
            } else {
                i++;
                j++;
            }
        }
        
        return rs;
    }
}