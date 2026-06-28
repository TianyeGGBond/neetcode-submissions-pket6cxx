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

                for(int j = 0; j< word.length; j++){
                    char cur = word[j];

                    for(char c = 'a'; c <='z'; c++){
                        if(c == cur) continue;
                        word[j] = c;
                        String newS = new String(word);
                        if(newS.equals(endWord)) return step + 1;
                        if(set.contains(newS)){
                            q.offer(newS);
                            set.remove(newS);
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
