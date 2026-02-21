class Solution {

    public int totalNodes;
    public int[] parentNode;
    public int[] groupSize;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        // Assign each email a unique ID
        HashMap<String, Integer> emailToIndex = new HashMap<>();

        // Map each email to its owner's name
        HashMap<String, String> emailToOwner = new HashMap<>();
        int currentIndex = 0;

        // Step 1: Create email -> index mapping
        for (List<String> account : accounts) {
            String ownerName = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, currentIndex++);
                }
                emailToOwner.put(email, ownerName);
            }
        }
        totalNodes = currentIndex;
        parentNode = new int[totalNodes];
        groupSize = new int[totalNodes];

        // Initialize Union-Find structure
        for (int i = 0; i < totalNodes; i++) {
            parentNode[i] = i;
            groupSize[i] = 1;
        }

        // Step 2: Union emails belonging to the same account
        for (List<String> account : accounts) {
            if (account.size() <= 2) continue;
            int firstEmailIndex = emailToIndex.get(account.get(1));
            for (int i = 2; i < account.size(); i++) {
                int nextEmailIndex = emailToIndex.get(account.get(i));
                union(firstEmailIndex, nextEmailIndex);
            }
        }

        // Step 3: Group emails by their root parent
        HashMap<Integer, List<String>> rootToEmails = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int emailIndex = emailToIndex.get(email);
            int rootParent = find(emailIndex);
            if (!rootToEmails.containsKey(rootParent)) {
                rootToEmails.put(rootParent, new ArrayList<>());
            }
            rootToEmails.get(rootParent).add(email);
        }
        // Step 4: Prepare final result
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (Integer root : rootToEmails.keySet()) {
            List<String> mergedEmailList = rootToEmails.get(root);
            Collections.sort(mergedEmailList);
            List<String> accountDetails = new ArrayList<>();
            accountDetails.add(emailToOwner.get(mergedEmailList.get(0)));
            accountDetails.addAll(mergedEmailList);
            mergedAccounts.add(accountDetails);
        }
        return mergedAccounts;
    }

    public boolean union(int nodeA, int nodeB) {
        int parentA = find(nodeA);
        int parentB = find(nodeB);

        if (parentA == parentB) return false;
        if (groupSize[parentA] > groupSize[parentB]) {
            parentNode[parentB] = parentA;
            groupSize[parentA] += groupSize[parentB];
        } else {
            parentNode[parentA] = parentB;
            groupSize[parentB] += groupSize[parentA];
        }
        return true;
    }
    public int find(int node) {
        if (node == parentNode[node]) {
            return node;
        }
        return find(parentNode[node]);
    }
}