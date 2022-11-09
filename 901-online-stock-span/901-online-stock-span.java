class StockSpanner {
    List<Pair<Integer, Integer>> list;
    
    public StockSpanner() {
        list = new ArrayList<>();    
    }
    
    public int next(int price) {
        int res = 1;
        
        if (list.size() == 0) {
            list.add(new Pair(price, res));
        } else {
            int index = list.size()-1;
            while (index > -1 && list.get(index).getKey() <= price) {
                int amt = list.get(index).getValue();
                res += amt;
                index -= amt;
            }
            list.add(new Pair(price, res));
        }
        
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */