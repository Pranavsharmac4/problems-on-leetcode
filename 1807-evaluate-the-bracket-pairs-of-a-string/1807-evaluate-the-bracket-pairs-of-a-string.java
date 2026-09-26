class Solution {
    public String evaluate(String s, List<List<String>> K) {
        Map<String, String> d = new HashMap<>();
        for (var k : K)
            d.put(k.get(0), k.get(1));
        
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                int j = s.indexOf(")", i + 1);
                str.append(d.getOrDefault(s.substring(i + 1, j), "?"));
                i = j;
            } else
                str.append(s.charAt(i));
        }

        return str.toString();
    }
}