public class bitmanipulation{
    public static void main(String[] args) {
        int n = 5;
        int pos = 1;
        int bitmask = 1 << pos;

        // if ((bitmask & n) == 0) {
        //     System.err.println("bit was print");
        // } else {
        //     System.err.println("bit was not printed");
        // }

        int newNumber = bitmask | n;
        System.err.println(newNumber);
    }
}