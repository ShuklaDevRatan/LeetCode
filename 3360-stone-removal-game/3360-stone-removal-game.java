class Solution {
    public boolean canAliceWin(int n) {
        int stones = 10;
        int turn = 0;

        while (n >= stones) {
            n -= stones;
            stones--;
            turn++;
        }

        return turn % 2 == 1;
    }
}