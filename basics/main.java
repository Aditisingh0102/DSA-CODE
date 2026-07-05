public class main{
    public static void show(int counter){
    if(counter <= 5){
        System.out.println("show() - " + counter);
        show(counter += 1);
        System.out.println("BACKTRACKING -" + counter);
    }
            
        }
    
    public static void main(String args[]){
    show( 1);
    }
}