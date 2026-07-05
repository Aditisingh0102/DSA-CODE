// // // public class Recursions {
// // //     public static  int countPaths(int i, int j, int n, int m){
// // //         if(i == n || j == m){
// // //             return 0;
// // //         }
// // //         if(i == n -1 && j == m -1){
// // //             return 1;
// // //         }
// // //         int downPaths = countPaths(i + 1, j, n, m );
// // //         int rightPaths = countPaths(i, j+1, n, m);
// // //         return downPaths + rightPaths;
// // //     }

// // //     public static void main(String args[]){
// // //         int n = 3, m = 3;
// // //         int totalPaths = countPaths(0, 0, n, m);
// // //         System.out.println(totalPaths);
// // //     }
    
// // // }

// // public class Recursions{
// //     public static int placeTiles(int n , int m ){
// //         if(n ==m){
// //             return  2;
// //         }
// //         if(n < m){
// //             return 1;
// //         }
// //         int verticalways = placeTiles(n - m, m);
// //         int horizontalways = placeTiles(n - 1, m);
// //         return verticalways + horizontalways;

// //     }

// //     public static void main(String[] args){
// //         int n = 4,m = 2;
       
// //         System.out.println(placeTiles(n, m));
// //     }
// // }

// public class Recursions{
//     public static int callGuests(int n){
//         if(n <= 1){
//             return 1;
//         }
//         int way1 = callGuests(n-1);
//         int way2 = (n-1) * callGuests(n-2);
//         return way1 + way2;

//     }
//     public static void main(String[] args) {
//         int n = 4;
//         System.out.println(callGuests(n));
//     }
// }
import java.util.*;
public class Recursions{
    public static void printSubset(ArrayList<Integer>  subset){
        for(int i = 0; i< subset.size(); i++){
            System.out.print(subset.get(i)+"");
        }
        System.out.println();
    }
    public static void findSubsets(int n, ArrayList<Integer> subset){
       if(n == 0){
        printSubset(subset);
        return;
       }
        subset.add(n);
        findSubsets(n-1, subset);

            subset.remove(subset.size() - 1);
            findSubsets(n-1, subset);
    }
    public static void main(String[] args) {
        int n= 3;
        ArrayList<Integer> subset = new ArrayList<>();
        findSubsets(n, subset);
    }
}