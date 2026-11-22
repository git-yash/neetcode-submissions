class RandomizedSet {
    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;

    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        return false;
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int index = map.get(val);
            int endVal = list.get(list.size() - 1);

            list.set(index, endVal);
            map.put(endVal, index);

            list.remove(list.size() - 1);
            map.remove(val);

            return true;
        }

        return false;
    }
    
    public int getRandom() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(list.size());

        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */