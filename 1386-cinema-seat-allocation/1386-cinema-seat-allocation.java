class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            map.computeIfAbsent(seat[0], k -> new HashSet<>()).add(seat[1]);
        }

        int result = (n - map.size()) * 2;

        for (Set<Integer> reserved : map.values()) {

            boolean left = true;
            boolean middle = true;
            boolean right = true;

            for (int seat = 2; seat <= 5; seat++) {
                if (reserved.contains(seat)) {
                    left = false;
                    break;
                }
            }

            for (int seat = 4; seat <= 7; seat++) {
                if (reserved.contains(seat)) {
                    middle = false;
                    break;
                }
            }

            for (int seat = 6; seat <= 9; seat++) {
                if (reserved.contains(seat)) {
                    right = false;
                    break;
                }
            }

            if (left && right) {
                result += 2;
            } else if (left || middle || right) {
                result += 1;
            }
        }

        return result;
    }
}