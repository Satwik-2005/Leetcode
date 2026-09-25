class Solution {



    static class Box {

        int h, w, l;



        Box(int h, int w, int l) {

            this.h = h;

            this.w = w;

            this.l = l;

        }

    }



    public int maxHeight(int[] height, int[] width, int[] length) {

        int n = height.length;



        List<Box> boxes = new ArrayList<>();



        // Generate all 3 rotations.

        for (int i = 0; i < n; i++) {

            addBox(boxes, height[i], width[i], length[i]);

            addBox(boxes, width[i], height[i], length[i]);

            addBox(boxes, length[i], height[i], width[i]);

        }



        // Sort base dimensions so w <= l.

        // Then use DFS with memoization.

        Map<String, Integer> memo = new HashMap<>();



        int ans = 0;



        // Any rotation can be the bottom box.

        for (Box b : boxes) {

            ans = Math.max(ans, b.h + dfs(b.w, b.l, boxes, memo));

        }



        return ans;

    }



    static void addBox(List<Box> boxes, int h, int w, int l) {

        if (w > l) {

            int temp = w;

            w = l;

            l = temp;

        }



        boxes.add(new Box(h, w, l));

    }



    static int dfs(int baseW, int baseL,

                   List<Box> boxes,

                   Map<String, Integer> memo) {



        String key = baseW + "," + baseL;



        if (memo.containsKey(key)) {

            return memo.get(key);

        }



        int max = 0;



        for (Box b : boxes) {

            // Both base dimensions must be strictly smaller.

            if (b.w < baseW && b.l < baseL) {

                max = Math.max(

                    max,

                    b.h + dfs(b.w, b.l, boxes, memo)

                );

            }

        }



        memo.put(key, max);

        return max;

    }

}