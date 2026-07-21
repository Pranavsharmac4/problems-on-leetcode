class Solution {
    public int minAddToMakeValid(String s) {
        int openNeeded = 0;  // Equivalant to your 'c'
        int closeNeeded = 0; // Equivalent to your Stack size
        
        // s.toCharArray() is cleaner in Java than iterating through a string directly, 
        // though s.charAt(i) inside a standard for-loop avoids allocating a new array.
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                closeNeeded++; 
            } else {
                if (closeNeeded > 0) {
                    // We have an unmatched '(', so this ')' matches it
                    closeNeeded--; 
                } else {
                    // No unmatched '(' available, so we need to add one
                    openNeeded++; 
                }
            }
        }
        
        return openNeeded + closeNeeded;
    }
}