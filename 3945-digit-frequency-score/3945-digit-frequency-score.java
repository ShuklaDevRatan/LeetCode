class Solution {
public int digitFrequencyScore(int n) {
int score = 0;
    while (n > 0) {
        int digit = n % 10;
        score += digit;
        n /= 10;
    }

    return score;
}
}
