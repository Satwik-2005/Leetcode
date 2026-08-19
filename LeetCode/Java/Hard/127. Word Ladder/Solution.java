class Pair {
    String first;
    int second;

    public Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();

        queue.offer(new Pair(beginWord, 1));

        for(int i=0;i<wordList.size();i++) 
            set.add(wordList.get(i));

        set.remove(beginWord);

        while(!queue.isEmpty()) {
            Pair node = queue.poll();
            
            String word = node.first;
            int value = node.second;

            if(word.equals(endWord) == true)
                return value;

            for(int i=0;i<word.length();i++) {
                for(char ch='a';ch<='z';ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if(set.contains(replacedWord) == true) {
                        set.remove(replacedWord);
                        queue.offer(new Pair(replacedWord, value + 1));
                    }
                }
            }
        }

        return 0;
    }
}