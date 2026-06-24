class Solution {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<String, Set<Character>> threeBy3Map = new HashMap<>();
        int row = board.length;
        int col = board[0].length;

        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                char val = board[r][c];
                if(val == '.'){
                    continue;
                }
                
                String cellKey = buildCellKey(r, c);
                Set<Character> rowSet = rowMap.getOrDefault(r, new HashSet<>());
                Set<Character> colSet = colMap.getOrDefault(c, new HashSet<>());
                Set<Character> cellSet = threeBy3Map.getOrDefault(cellKey, new HashSet<>());


                if(rowSet.contains(val)) return false;
                if(colSet.contains(val)) return false;
                if(cellSet.contains(val)) return false;

                rowSet.add(val);
                colSet.add(val);
                cellSet.add(val);

                rowMap.put(r, rowSet);
                colMap.put(c, colSet);
                threeBy3Map.put(cellKey, cellSet);
            }
        }

        return true;
    }

    private String buildCellKey(int r, int c){
        StringBuilder sb = new StringBuilder();

        sb.append(r/3).append(":").append(c/3);

        return sb.toString();
    }
}
