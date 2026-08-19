class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int[] res:reservedSeats) {
            int row = res[0];
            int seat = res[1];

            map.putIfAbsent(row, new ArrayList<>());
            map.get(row).add(seat);
        }

        int ans = (n-map.size())*2;

        for(int row:map.keySet()){
            List<Integer> res = map.get(row);

            boolean left=true;
            boolean mid=true;
            boolean right=true;

            for(int i=2; i<=5; i++){
                if(res.contains(i)){
                    left=false;
                }
            }

            for(int i=4; i<=7; i++){
                if(res.contains(i)){
                    mid=false;
                }
            }

            for(int i=6; i<=9; i++){
                if(res.contains(i)){
                    right=false;
                }
            }

            if(left && right) ans+=2;
            else if(left || mid || right) ans++;
        }

        return ans;
    }
}