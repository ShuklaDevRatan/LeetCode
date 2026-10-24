class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
            String arriveBob, String leaveBob) {
        int[] daysInMonth = {
                31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31
        };

        int aliceStart = convertToDay(arriveAlice, daysInMonth);
        int aliceEnd = convertToDay(leaveAlice, daysInMonth);

        int bobStart = convertToDay(arriveBob, daysInMonth);
        int bobEnd = convertToDay(leaveBob, daysInMonth);

        int start = Math.max(aliceStart, bobStart);
        int end = Math.min(aliceEnd, bobEnd);

        if (start > end) {
            return 0;
        }

        return end - start + 1;
    }

    private int convertToDay(String date, int[] daysInMonth) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int totalDays = day;

        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonth[i];
        }

        return totalDays;
    }
}
