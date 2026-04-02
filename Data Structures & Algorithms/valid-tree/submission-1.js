class Solution {
    /**
     * @param {number} n
     * @param {number[][]} edges
     * @returns {boolean}
     * graph:
     * 0: [1, 2, 3]
     * 1: [4]
     * tree:
     *      0
     * 1    2   3
     *   4
     * 
     * 
     * 2
     * graph:
     * 0: [1],
     * 1: [2,3,4]
     * 2: [3]
     *  
     *      0
     *      1
     *  2   3   4
     *    3
     * 
     * //Undirected means they are connected both ways. 
     * valid tree means no cicle and all nodes needs to be conected. 
     * (we can do this by comparing n with visited.size) 
     */
    validTreeDFS(n, edges) {
        const graph = Array.from({length: n}, ()=>[]);
        for(let [a,b] of edges){
            graph[a].push(b);
            graph[b].push(a);
        }
        
        /** Graph: 
         * [ 
         * 0:[1,2,3],
         * 1:[0, 4]
         * 2:[0]
         * 3:[0]
         * 4:[1]
         * ]
         */

        const visited = new Set();
        const dfsCycle =(node, parent)=>{
            if(visited.has(node)){
                //detected a loop
                return false;
            }

            visited.add(node);
            for(const neighbor of graph[node]){
                if(neighbor === parent){
                   continue;
                }
                
                if(!dfsCycle(neighbor, node)) {
                    return false;
                }
            }

            return true;
        }


        return dfsCycle(0,-1) && visited.size === n;
    }

     validTree(n, edges) {
        const graph = Array.from({length: n}, ()=>[]);
        for(let [a,b] of edges){
            graph[a].push(b);
            graph[b].push(a);
        }
        
        /** Graph: 
         * [ 
         * 0:[1,2,3],
         * 1:[0, 4]
         * 2:[0]
         * 3:[0]
         * 4:[1]
         * ]
         */
        
        const visited = new Set();
        const queue = [[0,-1]];
        
        while(queue.length >0){
            const [node, parent] = queue.shift();
            if(visited.has(node)) return false;
            visited.add(node);
            for(const neighbor of graph[node]){
                if(neighbor === parent){
                    continue;
                }

                queue.push([neighbor, node]);

            } 
        }


        return visited.size === n;
    }
}
