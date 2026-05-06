class Solution {
    /*
        Alien Dictionary
        Topolical Sort DAG Directed Edges but not cycles. 

    Create a graph of character dependencies.

    For each pair of adjacent words:
        compare characters from left to right
        when first different char is found:
            char from word1 -> char from word2
            break

    Then topological sort gives the alien alphabet order.

    */
     /*
        Alien Dictionary
        Topolical Sort DAG Directed Edges but not cycles.

    Create a graph of character dependencies.

    For each pair of adjacent words:
        compare characters from left to right
        when first different char is found:
            char from word1 -> char from word2
            break

    Then topological sort gives the alien alphabet order.

    */
    StringBuilder res = new StringBuilder();

    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Set<Character> visited = new HashSet<>();
        Set<Character> visiting = new HashSet<>();

        for( String word : words){
            for (char c : word.toCharArray()){
                if (!graph.containsKey(c)) {
                    graph.put(c, new HashSet<>());
                }
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i], word2 = words[i + 1];
            if (word1.length() > word2.length()
             && word1.startsWith(word2)) {
                return "";
            }

            for (int j = 0; j < word1.length(); j++) {

                char a = word1.charAt(j), b = word2.charAt(j);
                if (a != b) {
                    graph.get(a).add(b);
                    break;
                }
            }

        }

        for (Map.Entry<Character, Set<Character>> entry : graph.entrySet()) {
            if (!dfs(entry.getKey(), graph, visited, visiting)) {
                return "";
            }
        }
        

        return res.reverse().toString();
    }

    public boolean dfs(Character node,
                       Map<Character, Set<Character>> graph,
                       Set<Character> visited,
                       Set<Character> visiting) {

        if (visiting.contains(node)) {
            return false;
        }

        if (visited.contains(node)) {
            return true;
        }

        visiting.add(node);
        for (char neighbor : graph.getOrDefault(node, Set.of())) {
            if (!dfs(neighbor, graph, visited, visiting)) {
                return false;
            }
        }

        visiting.remove(node);
        visited.add(node);
        res.append(node);

        return true;
    }
}
