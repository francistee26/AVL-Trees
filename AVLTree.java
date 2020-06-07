public class AVLTree {
    private class AVLNode {
        private int value;
        private int height;
        private AVLNode leftChild;
        private AVLNode rightChild;

        private AVLNode(int value) {
            this.value = value;
            this.height = 0;
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

        setHeight(root);

        return balance(root);
    }

    private AVLNode balance(AVLNode root) {
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.leftChild) < 0) {
                // System.out.println(root.leftChild.value + " leftRotate");
                root.leftChild = rotateLeft(root.leftChild);
            }
            // System.out.println(root.value + " rightRotate");
            return rotateRight(root);
        }

        else if (isRightHeavy(root)) {
            if (balanceFactor(root.rightChild) > 0) {
                root.rightChild = rotateRight(root.rightChild);
                // System.out.println(root.rightChild.value + " rightRotate");
            }
            return rotateLeft(root);
            // System.out.println(root.value + " leftRotate");
        }
        return root;
    }

    private AVLNode rotateLeft(AVLNode root) {
        var newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root) {
        var newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private void setHeight(AVLNode node) {
        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    public boolean isBalanced() {
        return isBalance(root);
    }

    private boolean isBalance(AVLNode root) {
        if (root == null)
            return true;
        if (balanceFactor(root) == 0 || balanceFactor(root) == 1)
            return true;
        return false;
    }

    public boolean isPerfect() {
        return isPerfect(root);
    }

    private boolean isPerfect(AVLNode root) {
        if (root == null)
            return true;
        if (balanceFactor(root) != 0)
            return false;
        return balanceFactor(root) == 0 && isPerfect(root.leftChild) && isPerfect(root.rightChild);
    }

}