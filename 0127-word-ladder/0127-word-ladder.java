class Solution {
    static class Pair{
        String str;
        int count;
        public Pair(String str, int count){
            this.str=str;
            this.count=count;
        }

    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs= new HashSet<>();
        for(String word: wordList){
            hs.add(word);
        }
        hs.remove(beginWord);
        if(hs.contains(endWord)==false) return 0; 
        Queue<Pair> qu= new LinkedList<>();
        qu.offer(new Pair(beginWord,1));
        while(!qu.isEmpty()){
            Pair curr= qu.poll();
            String wd= curr.str;
            int lev= curr.count;
            if(wd.equals(endWord)){
                return lev;
            }
            int len = wd.length();
            for(int i=0; i<len; i++){
                char [] arr= wd.toCharArray();
                for(char ch = 'a'; ch<='z'; ch++){
                    if (arr[i]==ch) continue; //skip
                    arr[i]=ch;
                    String re = new String(arr);
                    if(hs.contains(re)){
                        qu.add(new Pair(re, lev+1));
                        hs.remove(re);
                    }
                }
            }

        }
        return 0;

    }
}