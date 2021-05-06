public class Stack {
    private int[][] stack;
    int size;

    public Stack(){
        this.stack = new int[20][2];
        this.size = 0;
    }

    public void push(int[] coord){
        for(int i = size-1; i >= 0; i--){
            this.stack[i+1][0] = this.stack[i][0];
            this.stack[i+1][1] = this.stack[i][1];
        }
        this.stack[0][0] = coord[0];
        this.stack[0][1] = coord[1];
        this.size++;
    }

    public int[] pop(){
        int[] coord = {this.stack[0][0], this.stack[0][1]};
        for(int i = 0; i < size-1; i++){
            this.stack[i][0] = this.stack[i+1][0];
            this.stack[i][1] = this.stack[i+1][1];
        }
        this.size--;
        return coord;
    }

    public void printStack(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        }
        for(int i = 0; i < this.size; i++){
            System.out.println(this.stack[i][0] + " " + this.stack[i][1]);
        }
        System.out.println("\n");
    }

    public boolean isEmpty(){
        return this.size == 0;
    }
}
