class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        List<Node>[] graph = buildGraph(edges, n);

        PriorityQueue<Node> minheap =
        new PriorityQueue<>((a, b) -> a.w() - b.w());

        minheap.offer(new Node(src, 0));

        Map<Integer, Integer> distance = new HashMap<>();//i will use it to check visited as well

        while (!minheap.isEmpty()){
            Node currentNode = minheap.poll();

            int curr = currentNode.dst();
            int w = currentNode.w();

            
            if (distance.containsKey(curr)){
                continue; //already visited.
            }

            distance.put(curr, w);

            for (Node neigh : graph[curr]){
                if (distance.containsKey(neigh.dst())){
                    continue;
                }

                int newWeight = w + neigh.w(); 
                minheap.offer(new Node(neigh.dst(), newWeight));
            }
        }

          for (int node = 0; node < n; node++) {
            if (!distance.containsKey(node)){
                distance.put(node, -1);
            }
            //for unreachable nodes
         }

        return distance;
    }

    private record Node(int dst, int w){}
    private List<Node>[] buildGraph(List<List<Integer>> edges, int n){
        List<Node>[] graph = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> edge : edges){
            int src = edge.get(0), dst = edge.get(1), w = edge.get(2);
            graph[src].add(new Node(dst, w));
        }

        return graph;
    }  
}
