public class AVLTree {
    private class AVLNode {
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;

        private AVLNode(int value) {
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }

    private AVLNode root;

    public AVLTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    public AVLNode insert(AVLNode root, int value) {
        if (root == null)
            return new AVLNode(value);
        if (value < root.value)
            root.leftChild = insert(root.leftChild, value);
        else
            root.rightChild = insert(root.rightChild, value);
        return root;
    }
}