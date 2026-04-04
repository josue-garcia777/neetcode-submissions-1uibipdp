class Solution {
    /**
     * @param {number} n
     * @param {number[][]} edges
     * @return {number[]}
     */
    findMinHeightTreesBFS(n, edges) {
    const graph = Array.from({length: n}, ()=>[]);
    for(const [a,b] of edges){
        graph[a].push(b);
        graph[b].push(a);
    }

    const bfs = (start) =>{
        let level = 0;
        const queue = [start];
        const visited = new Set();
        visited.add(start);

        while(queue.length >0){
            const size = queue.length;
            for(let i=0; i<size; i++){
                const node = queue.shift();

                for(const neighbor of graph[node]){
                    if(visited.has(neighbor)){
                        continue;
                    }

                    queue.push(neighbor);
                    visited.add(neighbor);
                }
            }
            
            level++; 
        }
        
        return level-1;
    }


    const levels = new Array(n);
    let min = +Infinity;
    for(let i=0; i<n; i++){
        const level = bfs(i);
        levels[i]=level;
        min = Math.min(min, level);
    }
    
    const res = [];
    for(let i=0; i<n; i++){
        if(levels[i]===min){
            res.push(i)
        }
    }
    
    return res;
};


findMinHeightTrees(n, edges) {
    if(n === 1) return [0];
    const graph = Array.from({length: n}, ()=>[]);
    const indegree = Array(n).fill(0);
    
    for(const [a,b] of edges){
        graph[a].push(b);
        graph[b].push(a);
        indegree[a]++;
        indegree[b]++;
    }

    const queue = [];

    for(let i=0; i<n; i++){
        if(indegree[i]=== 1){
            queue.push(i); //all the leaves;
        }
    }

    let remainingNodes = n;
    while(remainingNodes > 2){
        const size = queue.length;
        remainingNodes -= size;
        for(let i=0; i<size; i++){
            const leaf = queue.shift();
            for(const neighbor of graph[leaf]){
                indegree[neighbor]--;
                if(indegree[neighbor] === 1){
                    //it has become a leaf
                    queue.push(neighbor);
                }
            }
        }
    }

    return queue;


    };
}
