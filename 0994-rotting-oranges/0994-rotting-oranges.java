class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue= new ArrayDeque<>();
        int fresh=0;
        int minutes=0;

        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                if(grid[row][col]==2){
                    queue.offer(new int[]{row,col});
                }
                else if(grid[row][col]==1){
                    fresh++;
                }
            }
        }
        int [][] direction={
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };

        while(!queue.isEmpty()&& fresh>0){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] current= queue.poll();

                int row= current[0];
                int col= current[1];

                for(int [] dir: direction){
                    int newRow= row+dir[0];
                    int newCol=col+dir[1];

                    if(newRow<0|| newRow>=grid.length||newCol<0||newCol>=grid[0].length){
                        continue;
                    }
                    if(grid[newRow][newCol]!=1){
                        continue;
                    }
                    grid[newRow][newCol]=2;

                    fresh--;

                    queue.offer(new int[]{newRow,newCol});
                    }
                }
                            minutes++;
            }
        return fresh==0? minutes:-1;
        }
}
