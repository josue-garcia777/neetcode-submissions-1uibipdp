class Solution {
    /**
     * @param {number} n
     * @param {number[][]} edges
     * @returns {number}
     */
    countComponents(n, edges) {
        const graph = Array.from({length: n}, ()=>[]);

        for(const [a,b] of edges){
            graph[a].push(b);
            graph[b].push(a);
        }
        const visited = new Set();

        const dfs = (node)=>{
            if(visited.has(node)) return;

            visited.add(node);

            for(const neighbor of graph[node]){
                dfs(neighbor);
            }
        }


        let count =0;
        for(let node=0; node<n; node++){
            if(!visited.has(node)){
                dfs(node);
                count++;
            }
        }

        return count;
    }
}
