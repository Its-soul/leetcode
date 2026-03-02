class Solution {
    public int[] avoidFlood(int[] rains) {
    int n=rains.length;
    int[] ans=new int[n];
    HashMap<Integer,Integer> map=new HashMap<>();
    TreeSet<Integer> set=new TreeSet<>();
    for(int i=0;i<n;i++){
        if(rains[i]==0){
            set.add(i);
            ans[i]=1;
        }
        else{
            int src=rains[i];
            ans[i]=-1;
            if(map.containsKey(src)){
                Integer dry=set.higher(map.get(src));
                if(dry==null)return new int[0]; 
                ans[dry]=src;
                set.remove(dry);
            }
            map.put(src,i);
        }
    }
    return ans;
    }
}