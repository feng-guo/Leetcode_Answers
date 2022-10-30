class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Double> pq = new PriorityQueue<>();
        Map<Double, List<List<Integer>>> map = new HashMap<>();
        
        for(int[] point: points) {
            double distance = Math.sqrt(point[0]*point[0] + point[1]*point[1]);
            List<Integer> coordinates = new ArrayList<>();
            coordinates.add(point[0]);
            coordinates.add(point[1]);
            pq.add(distance);
            if (map.containsKey(distance)) {
                map.get(distance).add(coordinates);
            } else {
                List<List<Integer>> coordinates_list = new ArrayList<>();
                coordinates_list.add(coordinates);
                map.put(distance, coordinates_list);
            }
        }
        
        int[][] res = new int[k][2];
        
        for (int i=0; i<k; i++) {
            List<Integer> coordinates = map.get(pq.poll()).remove(0);
            res[i][0] = coordinates.get(0);
            res[i][1] = coordinates.get(1);
        }
        
        return res;
    }
}