class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int totalResult = 0;
        for (int i = 0; i < operations.length; i++) {
            if (!operations[i].equals("C") && !operations[i].equals("D") && !operations[i].equals("+")) {
                stack.push(Integer.parseInt(operations[i]));
            } else if (operations[i].equals("C")) {
                if (stack.size() > 0) stack.pop();
            } else if (operations[i].equals("D")) {
                if (stack.size() > 0) stack.push(stack.peek() * 2);
            } else {
                if (stack.size() > 0) {
                    int prevFirstScore = stack.peek();
                    stack.pop();
                    if (stack.size() > 0) {
                        int prevSecondScore = stack.peek();
                        stack.push(prevFirstScore);
                        stack.push(prevFirstScore + prevSecondScore);
                    } else stack.push(prevFirstScore);
                }
            }
        }
        while (stack.size() > 0) {
            totalResult += stack.peek();
            stack.pop();
        }
        return totalResult;
    }
}