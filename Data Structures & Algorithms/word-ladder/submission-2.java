class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;

        int step = 1;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                char[] word = q.poll().toCharArray();
                for(int j = 0; j < word.length; j++){
                    char cur = word[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == cur) continue;
                        word[j] = c;
                        String s = new String(word);
                        if(s.equals(endWord)) return step + 1;
                        if(set.contains(s)){
                            q.offer(s);
                            set.remove(s);
                        }
                    }
                    word[j] = cur;
                }
            }
            step++;
        }
        return 0;
    }
}
