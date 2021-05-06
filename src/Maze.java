public class Maze {
    char[][] maze;
    private int lines;
    private int columns;

    public char[][] getMaze() {
        return maze;
    }

    public void setMaze(char[][] maze) {
        this.maze = maze;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Maze(String[] ex){
        this.maze = arrayToMatrix(ex);
    }

    public void setMatrixDimensions(String[] mazeArray){
        int[] dimensions = new int[2];
        int l = 0;
        for(String s: mazeArray){
            l++;
            setColumns(s.length());
        }
        setLines(l);
    }

    public char[][] arrayToMatrix(String[] mazeArray) throws RuntimeException{
        this.setMatrixDimensions(mazeArray);
        char[][] matrix = new char[this.getLines()][this.getColumns()];
        int l = 0;

        for(int i = 0; i < this.getLines(); i++){
            for(int j = 0; j < this.getColumns(); j++){
                String s = mazeArray[i];
                matrix[i][j] = s.charAt(j);
            }
        }
        return matrix;
    }

    public int[] getPlayerCoordinates(){
        int kcount = 0;
        int[] coord = new int[2];
        for(int i = 0; i < this.getLines(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                if(maze[i][j] == 'k'){
                    kcount++;
                    coord[0] = i;
                    coord[1] = j;
                }
            }
        }
        if(kcount != 1){
            throw new RuntimeException();
        }
        //System.out.println("PLAYER COORDINATES ARE: " + coord[0] + " " + coord[1]);
        return coord;
    }

    public void setPlayerCoordinates(int[] coord){
        maze[coord[0]][coord[1]] = 'k';
    }

    public void print(){
        for(int i = 0; i < this.getLines(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}
