class Solution {
    int max;
    public int maxProfit(int[] prices) {
        max = 0;
        int lowest_buy = prices[0];
        
        
        
        
        for (int i=0; i<prices.length; i++){
            if (prices[i] - lowest_buy > max) {
                max = prices[i] - lowest_buy;
            }
            
            if (prices[i] < lowest_buy) {
                lowest_buy = prices[i];
            }
        }
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         for (int i=0; i<prices.length; i++) {
//             pq.add(prices[i]);
//         }
//         for (int i=prices.length-1; i>0; i--) {
//             if (prices[i] - pq.peek() > max) {
//                 max = prices[i] - pq.peek();
//             }
//             pq.remove(prices[i]);
//         }
        
        
        
        // max = 0;
        // for (int i=0; i<prices.length-1; i++) {
        //     for (int j=i+1; j<prices.length; j++) {
        //         if (prices[j] - prices[i] > max) {
        //             max = prices[j] - prices[i];
        //         }
        //     }
        // }
        return max;
    }
}