import java.util.*;
public class binarytree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
             newNode.left = buildTree(nodes);
             newNode.right = buildTree(nodes);

             return newNode;
            
        }
    }
    //preorder -> root left right
    public static void preorder(Node root){
        if(root == null){
            return;
        }
       System.out.println(root.data);
       preorder(root.left);
       preorder(root.right);
    }
    //inorder -> left root right
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data + " ");
        inorder(root.right);
    }
    //postorder -> left right root
    public static void postorder(Node root){
        if(root== null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data + "");;
    }
//level order -> level by level
    public static void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node currNode = q.remove();
            if(currNode == null) {
                System.out.println();
                if(q.isEmpty()){
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.println(currNode.data + "");
                if(currNode.left != null){
                    q.add(currNode.left);
                } 
                   
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }

    }
    // public static int countOfNodes(Node root){
    //     if(root == null){
    //         return 0;
    //     }
    //     int leftNodes = countOfNodes(root.left);
    //     int rightNodes = countOfNodes(root.right);
    //     return leftNodes + rightNodes + 1;
    // }

     public static int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftNodes = sumOfNodes(root.left);
        int rightNodes = sumOfNodes(root.right);

        return leftNodes + rightNodes + root.data;
    }

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree.idx = -1;
        Node root = BinaryTree.buildTree(nodes);

        //preorder(root);
        // Inorder(root);
        // postorder(root);
        // levelOrder(root);
        System.out.println(sumOfNodes(root));
    }
}
