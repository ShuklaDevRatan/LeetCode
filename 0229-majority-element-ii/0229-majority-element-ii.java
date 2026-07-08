class Solution {
    public List<Integer> majorityElement(int[] nums) {

        // Maximum 2 majority elements (> n/3) ho sakte hain
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        // ---------------------- First Pass ----------------------
        // Potential candidates find karna using Boyer-Moore Voting Algorithm
        // Yahan actual majority confirm nahi hoti.
        for (int num : nums) {

            // Agar current element candidate1 hai to uska count badhao
            if (num == candidate1) {
                count1++;
            }

            // Agar current element candidate2 hai to uska count badhao
            else if (num == candidate2) {
                count2++;
            }

            // Agar candidate1 ka count 0 ho gaya,
            // to current element ko naya candidate bana do
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            }

            // Agar candidate2 ka count 0 ho gaya,
            // to current element ko second candidate bana do
            else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            }

            // Current element dono candidates se different hai
            // Aur dono candidates already active hain.
            // Isliye dono ke support ko 1-1 kam kar do.
            else {
                count1--;
                count2--;
            }
        }

        // ---------------------- Second Pass ----------------------
        // First pass me sirf potential candidates mile the.
        // Ab unki actual frequency count karni padegi.

        count1 = 0;
        count2 = 0;

        for (int num : nums) {

            if (num == candidate1) {
                count1++;
            }
            else if (num == candidate2) {
                count2++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        // Agar candidate1 ki frequency n/3 se zyada hai
        // tabhi answer me add karo
        if (count1 > nums.length / 3) {
            ans.add(candidate1);
        }

        // Agar candidate2 ki frequency n/3 se zyada hai
        // tabhi answer me add karo
        if (count2 > nums.length / 3) {
            ans.add(candidate2);
        }

        return ans;
    }
}