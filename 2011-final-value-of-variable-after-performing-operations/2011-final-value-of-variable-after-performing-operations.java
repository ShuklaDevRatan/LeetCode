class Solution {
public int finalValueAfterOperations(String[] operations) {
    int X = 0;

    for (String operation : operations) {

        if (operation.charAt(1) == '+') {
            X++;
        } else {
            X--;
        }
    }

    return X;
}
}
