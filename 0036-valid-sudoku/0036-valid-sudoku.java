class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows= new HashSet[9];

        Set<Character>[] columns= new HashSet[9];

        Set<Character>[] boxes = new HashSet[9];

        for(int i=0;i<9;i++){
            rows[i]= new HashSet<>();
            columns[i]= new HashSet<>();
            boxes[i]= new HashSet<>();
        }

        for(int row=0;row<9;row++){
            for(int col =0;col<9;col++){
                char ch= board[row][col];

                if(ch=='.'){
                    continue;
                }

                int boxIndex= (row/3)*3+(col/3);
                if(rows[row].contains(ch)||columns[col].contains(ch)||boxes[boxIndex].contains(ch)){
                    return false;
                }

                rows[row].add(ch);
                columns[col].add(ch);
                boxes[boxIndex].add(ch);
                 }
        }
      return true;
    }
}