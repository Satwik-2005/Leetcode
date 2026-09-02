class Solution {
public int solve(int n, String s) {
    // code here
    HashMap<Character,Integer> hm = new HashMap<>();
    HashSet<Character> hs = new HashSet<>();


    for(char ch:s.toCharArray()){
        if(!hs.contains(ch) && (hm.containsKey(ch) || hm.size()<n)){
        hm.put(ch,hm.getOrDefault(ch,0)+1);
        if(hm.get(ch) == 2) hm.remove(ch);
    }else{
        hs.add(ch);
    }
    }
return hs.size();
}
}
