class Solution {

    public String findRollOut(String s, int[] roll) {

        // Step 1: Sort the roll array in-place to process shifts sequentially

        Arrays.sort(roll);



        char[] c = s.toCharArray();

        int n = c.length;

        int rollIdx = roll.length - 1;

        int activeRolls = 0;



        // Step 2: Traverse the string backwards

        for (int i = n - 1; i >= 0; i--) {

            // Count how many roll operations cover the current index (1-based index 'i + 1')

            while (rollIdx >= 0 && roll[rollIdx] >= i + 1) {

                activeRolls++;

                rollIdx--;

            }



            // Step 3: Apply the accumulated shifts modulo 26

            int shift = activeRolls % 26;

            c[i] = (char) ('a' + (c[i] - 'a' + shift) % 26);

        }



        return new String(c);

    }

}