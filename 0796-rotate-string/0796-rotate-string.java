class Solution {
    public boolean rotateString(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        int i = 0;

        while (i < s.length()) {

            if (s.charAt(i) == goal.charAt(0)) {

                int j = i;
                int k = 0;

                while (k < goal.length()) {

                    if (s.charAt(j) != goal.charAt(k)) {
                        break;
                    }

                    j++;
                    k++;

                    if (j == s.length()) {
                        j = 0;
                    }
                }

                if (k == goal.length()) {
                    return true;
                }
            }

            i++;
        }

        return false;
    }
}



// class Solution {
//     public boolean rotateString(String s, String goal) {
//         if (s.length() != goal.length()) {
//             return false;
//         }
//         String doubled = s + s;
//         return doubled.contains(goal);
//     }
// }
// yeh optimal apprch h lekin isme contain ka use kiya h isslye upar wali logic wise zyada achhi h