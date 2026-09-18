class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<int[]> events = new ArrayList<>();

        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]});
            events.add(new int[]{b[1], b[2]});
        }

        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];

            return a[1] - b[1];
        });

        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

        map.put(0, 1);

        List<List<Integer>> ans = new ArrayList<>();

        int prevHeight = 0;

        for (int[] event : events) {

            int x = event[0];
            int height = event[1];

            if (height < 0) {
                height = -height;
                map.put(height, map.getOrDefault(height, 0) + 1);
            } else {
                int count = map.get(height);

                if (count == 1)
                    map.remove(height);
                else
                    map.put(height, count - 1);
            }

            int currentHeight = map.firstKey();

            if (currentHeight != prevHeight) {
                ans.add(Arrays.asList(x, currentHeight));
                prevHeight = currentHeight;
            }
        }

        return ans;
    }
}