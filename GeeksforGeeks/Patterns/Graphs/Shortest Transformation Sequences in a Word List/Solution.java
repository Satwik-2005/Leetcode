class Solution {
    public ArrayList<ArrayList<String>> findSequences(String[] words, String start,
                                                      String end) {
        // code here
        Set<String> set = new HashSet<>();
        Queue<ArrayList<String>> queue = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> usedOnLevel = new ArrayList<>();
        
        int len = words.length;
        
        for(int i=0;i<len;i++)
            set.add(words[i]);
            
        list.add(start);
        queue.offer(list);
        usedOnLevel.add(start);
        
        int level = 0;
        ArrayList<ArrayList<String>> answer = new ArrayList<>();
        
        while(!queue.isEmpty()) {
            ArrayList<String> vector = queue.poll();
            
            if(vector.size() > level) {
                level += 1;
                
                for(String it : usedOnLevel)
                    set.remove(it);
            }
            
            String word = vector.get(vector.size() - 1);
            
            if(word.equals(end)) {
                if(answer.size() == 0) 
                    answer.add(vector);
                    
                else if(answer.get(0).size() == vector.size())
                    answer.add(vector);
            }
            
            for(int i=0;i<word.length();i++) {
                for(char ch='a';ch <= 'z';ch++) {
                    char[] replacedWord = word.toCharArray();
                    replacedWord[i] = ch;
                    String replace = new String(replacedWord);
                    
                    if(set.contains(replace) == true) {
                        vector.add(replace);
                        ArrayList<String> temp = new ArrayList<>(vector);
                        
                        queue.add(temp);
                        usedOnLevel.add(replace);
                        
                        vector.remove(vector.size() - 1);
                    }
                }
            }
        }
        
        return answer;
    }
}