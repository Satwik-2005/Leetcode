class Solution {

    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {

        int n = mat.length;

        int m = mat[0].length;

        int wordLen = word.length();



        // 8 Possible directions

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};

        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};



        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        char firstChar = word.charAt(0);



        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                // Only start searching if the first character matches

                if (mat[i][j] == firstChar) {



                    // Check all 8 directions iteratively

                    for (int k = 0; k < 8; k++) {

                        int currX = i, currY = j, idx;



                        // Match the rest of the characters in direction k

                        for (idx = 1; idx < wordLen; idx++) {

                            int nextX = currX + dx[k];

                            int nextY = currY + dy[k];



                            // Boundary and character match check

                            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && mat[nextX][nextY] == word.charAt(idx)) {

                                currX = nextX;

                                currY = nextY;

                            } else {

                                break; // Mismatch or out of bounds

                            }

                        }



                        // If we matched the entire word, store the starting index

                        if (idx == wordLen) {

                            ArrayList<Integer> pos = new ArrayList<>(2); // Initialise size 2 to optimize allocation

                            pos.add(i);

                            pos.add(j);

                            ans.add(pos);

                            break; // Stop checking other directions for this starting cell

                        }

                    }

                }

            }

        }

        return ans;

    }

}