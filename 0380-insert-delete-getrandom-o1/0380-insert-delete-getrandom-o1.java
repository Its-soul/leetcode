class RandomizedSet {
    private HashMap<Integer, Integer> set = new HashMap<>();
    private ArrayList<Integer> arr = new ArrayList<>();
    private int size;
    public RandomizedSet() {
        size = 0;
    }
    public boolean insert(int val) {
        if (set.containsKey(val)) return false;
        set.put(val, size);
        arr.add(val);
        size++;
        return true;
    }
    public boolean remove(int val) {
        if (!set.containsKey(val)) return false;
        int index = set.get(val);
        int lastVal = arr.get(size - 1);
        arr.set(index, lastVal);
        set.put(lastVal, index);
        arr.remove(size - 1);
        size--;
        set.remove(val);
        return true;
    }
    public int getRandom() {
        int rand = (int)(Math.random() * size);
        return arr.get(rand);
    }
}
