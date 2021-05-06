public class MazeSolver {
    //nextCoord = {-1, -1} -> Player reached an exit
    //nextCoord = {-2, -2} -> Maze has no exit
    private Stack splitStack;
    private Maze maze;
    boolean result;

    public MazeSolver(Maze maze){
        this.maze = maze;
        this.splitStack = new Stack();
    }

    public boolean solveMaze(){
        int[] coord = maze.getPlayerCoordinates();
        int x = coord[0];
        int y = coord[1];
        int ok = -1;

        while(ok == -1){
            int[] next = findNextStep(x, y);
            if(next[0] == -1){
                //System.out.println("true");
                result = true;
                break;
            }
            else if(next[0] == -2){
                //System.out.println("false");
                result = false;
                break;
                //jump to last split
            }
            else{
                x = next[0];
                y = next[1];
                //System.out.println("Next step is: " + x + " " + y);
                if((x == 0) && (y == 0)){
                    break;
                }
                //maze.print();
            }
        }

        return result;
    }

    public int[] findNextStep(int x, int y){
        int[] nextCoord = new int[2];
        if(checkIfSplit(x, y)){
            int[] splitCoord = {x, y};
            splitStack.push(splitCoord);
        }
        if((x == 0) || (y == 0) || (x == (maze.getLines() - 1)) || (y == (maze.getColumns() - 1))){
            nextCoord[0] = -1;
            nextCoord[1] = -1;
            return nextCoord;
        }
        if((maze.getMaze()[x+1][y] == '#') && (maze.getMaze()[x][y+1] == '#')
                && (maze.getMaze()[x-1][y] == '#') && (maze.getMaze()[x][y-1] == '#')){
            if(splitStack.isEmpty()){
                nextCoord[0] = -2;
                nextCoord[1] = -2;
                return nextCoord;
            }
            else{
                int[] coord = splitStack.pop();
                maze.setPlayerCoordinates(coord);
                maze.getMaze()[x][y] = '#';
                solveMaze();
            }
        }
        if(maze.getMaze()[x+1][y] == ' '){
            nextCoord[0] = x + 1;
            nextCoord[1] = y;
        }
        else if(maze.getMaze()[x][y+1] == ' '){
            nextCoord[0] = x;
            nextCoord[1] = y + 1;
        }
        else if(maze.getMaze()[x-1][y] == ' '){
            nextCoord[0] = x - 1;
            nextCoord[1] = y;
        }
        else if(maze.getMaze()[x][y-1] == ' '){
            nextCoord[0] = x;
            nextCoord[1] = y - 1;
        }

        maze.getMaze()[x][y] = '#';

        return nextCoord;
    }

    public boolean checkIfSplit(int x, int y){
        boolean b = false;
        if((x == 0) || (y == 0) || (x == (maze.getLines() - 1)) || (y == (maze.getColumns() - 1))){
            return b;
        }
        if((maze.getMaze()[x+1][y] == ' ') && (maze.getMaze()[x][y+1] == ' ') ||
                (maze.getMaze()[x+1][y] == ' ') && (maze.getMaze()[x-1][y] == ' ') ||
                (maze.getMaze()[x+1][y] == ' ') && (maze.getMaze()[x][y-1] == ' ') ||
                (maze.getMaze()[x][y+1] == ' ') && (maze.getMaze()[x-1][y] == ' ') ||
                (maze.getMaze()[x][y+1] == ' ') && (maze.getMaze()[x][y-1] == ' ') ||
                (maze.getMaze()[x-1][y] == ' ') && (maze.getMaze()[x][y-1] == ' ')){
            //System.out.println("true");
            b = true;
        }
        return b;
    }
}
