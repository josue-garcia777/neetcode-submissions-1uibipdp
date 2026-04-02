class Solution {
    /**
     * @param {number} numCourses
     * @param {number[][]} prerequisites
     * @return {number[]}
     * you reverse because you are adding nodes after
     * exploring their dependencies. 
     * children (courses that depend on me) → first then me
     */
    findOrder(numCourses, prerequisites) {
        const graph = Array.from({length: numCourses}, ()=>[]);
        for(const [course, prereq] of prerequisites){
            graph[prereq].push(course);
        }
        const visited = new Set();
        const visiting = new Set();
        const res = [];

        const dfs = (node)=>{
            if(visiting.has(node)) return false;
            if(visited.has(node)) return true;
            visiting.add(node);
            
            for(let neighbor of graph[node]){
                if(!dfs(neighbor)){
                    return false;
                }

            }

            visiting.delete(node);
            visited.add(node);
            res.push(node);

            return true;
        }

        for(let node = 0; node<numCourses; node++){
            if(!dfs(node)){
                return [];
            }
        }
        return res.reverse();
    }
}
