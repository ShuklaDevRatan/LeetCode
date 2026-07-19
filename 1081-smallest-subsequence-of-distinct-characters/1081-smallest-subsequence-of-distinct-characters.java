class Solution {
    public String smallestSubsequence(String s) {
        int count[] = new int[26];
        boolean inStack[] = new boolean [26];
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            count[ch - 'a']++;
        }
        for(char ch : s.toCharArray()){
            count[ch - 'a']--;
            if(inStack[ch-'a']) continue;
            while(!st.isEmpty() && ch < st.peek() && count[st.peek()-'a'] > 0){
                char remove = st.pop();
                inStack[remove-'a'] = false;
            }
            st.push(ch);
            inStack[ch - 'a'] = true;
        }
        StringBuilder result = new StringBuilder();
        for (char ch : st) {
            result.append(ch);
        }
        return result.toString();
    }
}