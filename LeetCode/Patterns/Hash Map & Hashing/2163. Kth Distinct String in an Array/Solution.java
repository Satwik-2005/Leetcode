class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();
        int n = arr.length;

        for(int i=0;i<n;i++) {
            String str = arr[i];
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for(Map.Entry<String, Integer> mp : map.entrySet()) {
            System.out.println(mp.getKey() + " -> " +  mp.getValue());

            int value = mp.getValue();

            if(value == 1  &&  k == 1)
                return mp.getKey();

            else if(value == 1  &&  k > 1)
                k -= 1;
        }

        return "";
    }
}