class RandomizedSet {
    //map<val, idx>
    private HashMap<Integer, Integer> store = new HashMap<>();
    private List<Integer> list = new ArrayList<>();
    private Random rand = new Random();

    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if(store.containsKey(val)){
            return false;
        }

        store.put(val, list.size()); //last index or keep an idx
        list.add(val);
        
        return true;
    }
    
    public boolean remove(int val) {
        if (!store.containsKey(val)){
            return false;
        }

    
        int idx = store.get(val);
        
        int lastVal = list.get(list.size() -1);
        list.set(idx, lastVal);
        store.put(lastVal, idx);

        list.removeLast();
        store.remove(val);
    

        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */