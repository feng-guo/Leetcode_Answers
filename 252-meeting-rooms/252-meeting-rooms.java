class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int max = 0;
        for(int i=0; i<intervals.length; i++) {
            max = Math.max(max, intervals[i][1]);
        }
        int[] times = new int[max+1];
        for (int i=0; i<intervals.length; i++) {
            times[intervals[i][0]]++;
            times[intervals[i][1]]--;
        }
        boolean in_meeting = false;
        for (int i=0; i<max+1; i++) {
            if (times[i] < 0) {
                in_meeting = false;
            } else if (times[i] == 1) {
                if (in_meeting) {
                    return false;
                } else {
                    in_meeting = true;
                }
            } else if (times[i] != 0) {
                return false;
            }
        }
        return true;
    }
}