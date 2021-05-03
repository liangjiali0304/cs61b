public class BubbleGrid {
    public int row_size;
    public int column_size;

    public UnionFind BubbleGrid(int [][] arr){
        
    }

    public int[] popBubbles(int[][] darts){

    return new int[5];
    }

    public boolean isStuck(int row, int column){
        if (row == 0 || BubbleGrid[row][column] == 1){
            return true;
        }
        return false;
    }
    public void check_neighbour(int row, int column){
        boolean status = true; //
        //check left neighbour
        if (column > 0){
            status = status & isStuck(row,column-1);
        }

        if (column < column_size - 1){
            status = status & isStuck(row,column+1);
        }



    }


}
