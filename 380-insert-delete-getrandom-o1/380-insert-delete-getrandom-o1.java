class RandomizedSet {

    List<Integer> list;
    Set<Integer> set;
    
    public RandomizedSet() {
        set = new HashSet<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (set.add(val)) {
            list.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if (set.remove(val)) {
            list.remove((Integer)val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int index = (int) (Math.random()*((double)list.size()));
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */