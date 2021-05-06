public class Main {
    public static void main(String args[]){
        String[] m1 = new String[]{"k"};
        //should print true

        String[] m2 = new String[]{"###",
                                   "#k#",
                                   "###"};
        //should print false: no exit

        String[] m3 = new String[]{"###",
                                   "#k ",
                                   "###"};
        //should print true

        String[] m4 = new String[]{"k ",
                                   "kk"};
        //should print false: too many k's

        String[] m5 = new String[]{"########",
                                   "# # ####",
                                   "# #k#   ",
                                   "# # # ##",
                                   "# # # ##",
                                   "#      #",
                                   "########"};
        //should print true

        String[] m6 = new String[]{"########",
                                   "# # ## #",
                                   "# #k#  #",
                                   "# # # ##",
                                   "# # #  #",
                                   "#     ##",
                                   "########"};
        //should print false: no exit

        Maze maze1 = new Maze(m1);
        Maze maze2 = new Maze(m2);
        Maze maze3 = new Maze(m3);
        Maze maze4 = new Maze(m4);
        Maze maze5 = new Maze(m5);
        Maze maze6 = new Maze(m6);
        MazeSolver ms1 = new MazeSolver(maze1);
        MazeSolver ms2 = new MazeSolver(maze2);
        MazeSolver ms3 = new MazeSolver(maze3);
        MazeSolver ms4 = new MazeSolver(maze4);
        MazeSolver ms5 = new MazeSolver(maze5);
        MazeSolver ms6 = new MazeSolver(maze6);

        try{
            boolean result1 = ms1.solveMaze();
            System.out.println(result1);
        }catch(Exception e){
            System.out.println(false);
        }

        try{
            boolean result2 = ms2.solveMaze();
            System.out.println(result2);
        }catch(Exception e){
            System.out.println(false);
        }

        try{
            boolean result3 = ms3.solveMaze();
            System.out.println(result3);
        }catch(Exception e){
            System.out.println(false);
        }

        try{
            boolean result4 = ms4.solveMaze();
            System.out.println(result4);
        }catch(Exception e){
            System.out.println(false);
        }

        try{
            boolean result5 = ms5.solveMaze();
            System.out.println(result5);
        }catch(Exception e){
            System.out.println(false);
        }

        try{
            boolean result6 = ms6.solveMaze();
            System.out.println(result6);
        }catch(Exception e){
            System.out.println(false);
        }
    }
}
