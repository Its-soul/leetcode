// class Solution {
//     public int[] assignTasks(int[] servers, int[] tasks) {

//         PriorityQueue<Integer> available = new PriorityQueue<>((a, b) -> {
//             if (servers[a] != servers[b]) {
//                 return Integer.compare(servers[a], servers[b]);
//             }

//             return Integer.compare(a, b);
//         });

//         PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
//             if (a[0] != b[0]) {
//                 return Long.compare(a[0], b[0]);
//             }

//             if (a[1] != b[1]) {
//                 return Long.compare(a[1], b[1]);
//             }

//             return Long.compare(a[2], b[2]);
//         });

//         for (int i = 0; i < servers.length; i++) {
//             available.offer(i);
//         }

//         int[] result = new int[tasks.length];

//         for (int i = 0; i < tasks.length; i++) {

//             while (!busy.isEmpty() && busy.peek()[0] <= i) {
//                 long[] server = busy.poll();
//                 available.offer((int) server[2]);
//             }

//             long time = i;

//             if (available.isEmpty()) {
//                 time = busy.peek()[0];

//                 while (!busy.isEmpty() && busy.peek()[0] <= time) {
//                     long[] server = busy.poll();
//                     available.offer((int) server[2]);
//                 }
//             }

//             int index = available.poll();

//             result[i] = index;

//             busy.offer(new long[]{
//                 time + tasks[i],
//                 servers[index],
//                 index
//             });
//         }

//         return result;
//     }
// }

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        PriorityQueue<Integer> available = new PriorityQueue<>((a, b) -> {
            if (servers[a] != servers[b]) {
                return Integer.compare(servers[a], servers[b]);
            }

            return Integer.compare(a, b);
        });

        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Long.compare(a[0], b[0]);
            }

            if (a[1] != b[1]) {
                return Long.compare(a[1], b[1]);
            }

            return Long.compare(a[2], b[2]);
        });

        for (int i = 0; i < servers.length; i++) {
            available.offer(i);
        }

        int[] result = new int[tasks.length];

        long currentTime = 0;

        for (int i = 0; i < tasks.length; i++) {

            currentTime = Math.max(currentTime, i);

            while (!busy.isEmpty() && busy.peek()[0] <= currentTime) {
                long[] server = busy.poll();
                available.offer((int) server[2]);
            }

            if (available.isEmpty()) {
                currentTime = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= currentTime) {
                    long[] server = busy.poll();
                    available.offer((int) server[2]);
                }
            }

            int index = available.poll();

            result[i] = index;

            busy.offer(new long[]{
                currentTime + tasks[i],
                servers[index],
                index
            });
        }

        return result;
    }
}