class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character>st1=new Stack<>();
        Stack<Character>st2=new Stack<>();
        for(int i=0;i< s.length();i++){
            char c= s.charAt(i);
            if(c=='#'){
                if(!st1.empty()){
                    st1.pop();
                }
            }
             else st1.push(c);
        }
         for(int i=0;i< t.length();i++){
            char c= t.charAt(i);
            if(c=='#'){
                if(!st2.empty()){
                    st2.pop();
                }
            }
             else st2.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!st1.isEmpty()) {
            sb.append(st1.pop());
        }
        StringBuilder sb1 = new StringBuilder();
        while (!st2.isEmpty()) {
            sb1.append(st2.pop());
        }

        return sb.reverse().toString().equals(sb1.reverse().toString());
    }
}