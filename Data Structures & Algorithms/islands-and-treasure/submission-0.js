class Solution {
    /**
     * @param {number[][]} grid
     * 
     */
    islandsAndTreasure(grid) {
        const row = grid.length;
        const col = grid[0].length;

        const dfs = (r, c, distance) =>{
            if(r < 0 || c<0 || r>=row || c>=col){
                return;
            }
    
             // wall
            if (grid[r][c] === -1) {
                return;
            }
            
            // if this path is already worse than the best known distance, stop
            if (grid[r][c] < distance) {
                return;
            }

            grid[r][c]=distance;
           
            
            distance++;
            dfs(r-1,c,distance);//up
            dfs(r+1,c, distance);//down
            dfs(r, c-1, distance); //left
            dfs(r, c+1, distance); //right

        }

        for(let r=0; r<row; r++){
            for(let c=0; c<col; c++){
                if(grid[r][c]==0){
                    dfs(r,c,0)
                }
            }
        }

    }
    /*  
        //Distance is like level in a tree.
        for each cell
            find a 0 starting point.
            start dfs(r,c, distance) of 0
            if(out of bounds) return;
            if(grid[r][c]<0) //-1 return
            if(grid[r][c]<distance) return; Already found a better solution. 
            grid[r][c]= distance;
            dfs(up, distance+1);
            dfs(down, distance+1); etc...
            
            FOR BFS : Idea
            // - All gates (cells with value 0) are starting points.
        // - Perform BFS from all gates simultaneously.
        // - Each BFS level represents distance from nearest gate.
        // - Update only empty rooms (value = 2147483647).
    */

    /**
     * Input: [
        [INF, -1, 0,    INF],
        [INF,INF, INF,   -1],
        [INF, -1, INF,   -1],
        [0, -1,  INF,  INF]
    ]

    Output: [
        [3,-1,0,1],
        [2,2,1,-1],
        [1,-1,2,-1],
        [0,-1,3,4]
    ]

     * 
     * 
     */
}
