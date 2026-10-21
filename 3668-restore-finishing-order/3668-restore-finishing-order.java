class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        boolean[] isFriend = new boolean[order.length + 1];

        for (int id : friends) {
            isFriend[id] = true;
        }

        int[] result = new int[friends.length];
        int index = 0;

        for (int id : order) {
            if (isFriend[id]) {
                result[index++] = id;
            }
        }

        return result;
    }
}