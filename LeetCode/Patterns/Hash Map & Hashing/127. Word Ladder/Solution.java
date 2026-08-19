class Pair {
    String first;
    int second;

    public Pair(String first , int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = wordList.size();

        Queue<Pair> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        
        for(int i=0;i<length;i++)
            set.add(wordList.get(i));

        queue.offer(new Pair(beginWord , 1));
        set.remove(beginWord);

        while(!queue.isEmpty()) {
            String word = queue.peek().first;
            int count = queue.peek().second;
            queue.poll();

            if(word.equals(endWord) == true)
                return count;

            for(int i=0;i<word.length();i++) {
                for(char ch='a';ch <= 'z';ch++) {
                    char []replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;

                    String replacedWord = new String(replacedCharArray);

                    if(set.contains(replacedWord) == true) {
                        set.remove(replacedWord);
                        queue.offer(new Pair(replacedWord , count + 1));
                    }
                }
            }
        }

        return 0;
    }
}