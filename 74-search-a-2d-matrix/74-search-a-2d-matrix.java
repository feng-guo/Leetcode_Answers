class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0;
        int right = rows*columns-1;
        
        while (left < right && matrix[left/columns][left%columns] != target) {
            int mid = (left+right)/2;
            int r = mid/columns;
            int c = mid%columns;
            if (matrix[r][c] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return matrix[left/columns][left%columns] == target;
    }
}