class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int max = 0;
        for(int i=0; i<intervals.length; i++) {
            max = Math.max(max, intervals[i][1]);
        }
        int[] times = new int[max+1];
        for (int i=0; i<intervals.length; i++) {
            times[intervals[i][0]]++;
            times[intervals[i][1]]--;
        }
        int max_rooms = 0;
        for (int i=1; i<max+1; i++) {
            times[i] += times[i-1];
            max_rooms = Math.max(max_rooms, times[i]);
        }
        
        return max_rooms;
    }
}