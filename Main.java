public class Main {
    public static void main(String[] args) {
        var AVL = new AVLTree();
        // AVL.insert(10);
        // AVL.insert(20);
        // AVL.insert(30);
        AVL.insert(7);
        AVL.insert(4);
        AVL.insert(9);
        // AVL.insert(1);
        // AVL.insert(6);
        // AVL.insert(8);
        // AVL.insert(10);

        System.out.println(AVL.isPerfect());
    }
}