public class bitmanipulation{
    public static void main(String[] args) {
        int n = 9;
        int pos = 3;
        int bitmask = 1 << pos;

        if ((bitmask & n) == 0) {
            System.err.println("bit was print");
        } else {
            System.err.println("bit was not printed");
        }
    }
}