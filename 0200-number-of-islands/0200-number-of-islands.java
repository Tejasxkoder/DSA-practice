class Solution {

    public int numIslands(char[][] grid) {

        int islandCount = 0;

        // Traverse every cell of the grid
        for (int row = 0; row < grid.length; row++) {

            for (int col = 0; col < grid[0].length; col++) {

                // New island found
                if (grid[row][col] == '1') {

                    islandCount++;

                    // Visit the complete island
                    dfs(grid, row, col);
                }
            }
        }

        return islandCount;
    }

    private void dfs(char[][] grid, int row, int col) {

        // Base Case 1: Outside the grid
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length) {
            return;
        }

        // Base Case 2: Water or already visited
        if (grid[row][col] == '0') {
            return;
        }

        // Mark current land as visited
        grid[row][col] = '0';

        // Visit Up
        dfs(grid, row - 1, col);

        // Visit Down
        dfs(grid, row + 1, col);

        // Visit Left
        dfs(grid, row, col - 1);

        // Visit Right
        dfs(grid, row, col + 1);
    }
}