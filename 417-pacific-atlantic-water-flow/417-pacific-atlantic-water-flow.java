class Solution {
    Set<Integer> pacific;
    Set<Integer> atlantic;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        pacific = new HashSet<>();
        atlantic = new HashSet<>();
        
        
        for (int i=0; i<heights.length; i++) {
            for (int j=0; j<heights[0].length; j++) {
                if ((i==0 || j==0) && !pacific.contains(i*heights[0].length+j)) {
                    pacific(heights, i, j);
                }
                if ((i==heights.length-1 || j==heights[0].length-1) && !atlantic.contains(i*heights[0].length+j)) {
                    atlantic(heights, i, j);
                }
            }
        }
        
        List<List<Integer>> list = new ArrayList<>();
        
        for (Integer coordinate: pacific) {
            if (atlantic.contains(coordinate)) {
                List<Integer> sublist = new ArrayList<>();
                sublist.add(coordinate/(heights[0].length));
                sublist.add(coordinate%(heights[0].length));
                list.add(sublist);
            }
        }
        
        return list;
    }
    
    
    public void pacific(int[][] heights, int x, int y) {
        pacific.add(x*heights[0].length + y);
        
        if (x!=0 && heights[x-1][y] >= heights[x][y] && !pacific.contains((x-1)*heights[0].length+y)) {
            pacific(heights, x-1, y);
        }
        if (x!=heights.length-1 && heights[x+1][y] >= heights[x][y] && !pacific.contains((x+1)*heights[0].length+y)) {
            pacific(heights, x+1, y);
        }
        if (y!=0 && heights[x][y-1] >= heights[x][y] && !pacific.contains(x*heights[0].length+(y-1))) {
            pacific(heights, x, y-1);
        }
        if (y!=heights[0].length-1 && heights[x][y+1] >= heights[x][y] && !pacific.contains(x*heights[0].length+(y+1))) {
            pacific(heights, x, y+1);
        }
        
    }
    
    public void atlantic(int[][] heights, int x, int y) {
        atlantic.add(x*heights[0].length + y);
        
        if (x!=0 && heights[x-1][y] >= heights[x][y] && !atlantic.contains((x-1)*heights[0].length+y)) {
            atlantic(heights, x-1, y);
        }
        if (x!=heights.length-1 && heights[x+1][y] >= heights[x][y] && !atlantic.contains((x+1)*heights[0].length+y)) {
            atlantic(heights, x+1, y);
        }
        if (y!=0 && heights[x][y-1] >= heights[x][y] && !atlantic.contains(x*heights[0].length+(y-1))) {
            atlantic(heights, x, y-1);
        }
        if (y!=heights[0].length-1 && heights[x][y+1] >= heights[x][y] && !atlantic.contains(x*heights[0].length+(y+1))) {
            atlantic(heights, x, y+1);
        }
        
    }
}