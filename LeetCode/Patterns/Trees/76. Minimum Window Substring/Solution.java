class Solution {
    public String minWindow(String s, String t) {
        // optimal one

        int n = s.length();
        int m = t.length();

        int minLength = (int) 1e9;
        int startIndex = -1;
        int left = 0;
        int right = 0;
        int count = 0;

        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<m;i++) {
            char ch = t.charAt(i);

            map.put(ch , map.getOrDefault(ch , 0) + 1);
        }

        while(right < n) { 
            char ch = s.charAt(right);

            if(map.getOrDefault(ch , 0) > 0)
                count += 1;

            map.put(ch , map.getOrDefault(ch , 0) - 1);

            while(count == m) {
                if(right - left + 1  <  minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }

                char leftCharacter = s.charAt(left);

                map.put(leftCharacter , map.getOrDefault(leftCharacter , 0) + 1);

                if(map.getOrDefault(leftCharacter , 0) > 0)
                    count -= 1;

                left += 1;
            }

            right += 1;
        }

        return startIndex == -1 ? "" : s.substring(startIndex , startIndex + minLength);
    }
}