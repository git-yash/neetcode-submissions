class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, r, c, 0));
                }
            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid, int r, int c, int area) {
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return 0;
        }

        if(grid[r][c] == 0) return 0;

        grid[r][c] = 0;

        int up = dfs(grid, r + 1, c, area);
        int right = dfs(grid, r, c + 1, area);
        int down = dfs(grid, r - 1, c, area);
        int left = dfs(grid, r, c - 1, area);

        return area + up + right + down + left + 1;
    }
}
