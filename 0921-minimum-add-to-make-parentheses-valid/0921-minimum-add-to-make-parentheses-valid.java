class Solution {
    public int minAddToMakeValid(String s) {
        int openNeeded = 0; 
        int closeNeeded = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                closeNeeded++; 
            } else {
                if (closeNeeded > 0) {
                    closeNeeded--; 
                } else {
                    openNeeded++; 
                }
            }
        }
        
        return openNeeded + closeNeeded;
    }
}