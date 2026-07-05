// public class recursion{
//     public static void main(int n) {
//         if (n == 0) {
//             return;
//         } 
//         System.out.println(n);
//         main(n-1);
//     }
//     public static void main(String[] args) {
//         int n = 8;
//         main(n);
//     }
// }

// public class recursion{
//     public static void numbers(int n){
//         if (n == 11){
//             return;
//         }
//         System.out.println(n);
//         numbers(n + 1);
//     }
//     public static void main(String[] args){
//         int n = 1;
//         numbers(n);
//     }
// }

// public class recursion{
//     public static void main(int i, int n, int sum){
//         if (i ==n){
//             sum += i;
//             System.out.println(sum);
//             return;
//         } 
//         sum += i;
//      main(i+1, n, sum);
//      System.out.println(i);
//     }
//     public static void main(String[] args){
      
//         main(1, 10, 0);
//     }
// }

// public class recursion{
//     public static int main(int n){
//       if(n == 1||n == 0){
//         return 1;
//       }

//         int fact_nm1 = main(n-1);
//         int  fact_n = n * fact_nm1;
//         return fact_n;
//     }

//     public static void main(String[] args){
//         int n = 5;
//         int ans = main(n);
//         System.out.println(ans);
//     }
// }

public class recursion{
    public static void main(int a, int b, int n){
        if(n ==0) {
            return ;
        }
        int c = a+b;
        System.out.println(c);
        main(b, c, n-1);
    }

    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        System.out.println(a);
        System.out.println(b);
        int n = 7;
        main(a, b, n-2);
    }
}