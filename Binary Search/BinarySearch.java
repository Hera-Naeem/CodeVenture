class BinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(2);
        tree.add(1);
        tree.add(8);
        tree.add(10);
        tree.add(-1);
        System.out.println(tree);
    }

    class Node {
        int key;
        Node left;
        Node right;
    }

    Node root = null;

    public void add(int key) {
        if (this.root == null) { // if tree is empty
            Node temp = new Node(); // create temp node
            temp.key = key; // add key to the new node
            temp.left = null; // left child = null
            temp.right = null; // right child = null
            this.root = temp;
        } else { // if tree is not empty
            recAdd(this.root, key);
        }
    }

    public void recAdd(Node root, int key) { // root keeps changing, key remains the same
        if (key < root.key) { // if key is less than root, go to left
            if (root.left == null) { // if it doesnt have any left children
                Node temp = new Node(); // create temp node
                temp.key = key; // add key to the new node
                temp.left = null; // left child = null
                temp.right = null; // right child = null
                root.left = temp; // left child of root is the new node
                return; // return from function
            }
            recAdd(root.left, key); // if it has any left children (meaning its not a leaf node), keep going until you reach a leaf node
        } else if (key > root.key) { // if key is greater than root, go to right
            if (root.right == null) { // if it doesnt have any right children
                Node temp = new Node(); // create temp node
                temp.key = key; // add key to the new node
                temp.left = null; // left child = null
                temp.right = null; // right child = null
                root.right = temp; // right child of root is the new node
                return; // return from function
            }
            recAdd(root.right, key);// if it has any right children (meaning its not a leaf node), keep going until you reach a leaf node
        }
    }

    @Override
    public String toString() { // in order (ascending)
        StringBuilder sb = new StringBuilder();
        sb.append("START\n");
        recToString(this.root, sb); // call recursive function
        sb.delete(sb.length() - 1, sb.length()); // to delete extra ","" at the end, delete from second last element till the end
        sb.append("\nEND");
        return sb.toString(); // return final string
    }

    public void recToString(Node root, StringBuilder sb) {
        if (root == null) { // base case, if current node = null, return from function
            return;
        }
        recToString(root.left, sb); // go to left most node of current root
        sb.append(root.key); // print current root
        sb.append(",");
        recToString(root.right, sb); // go to right node of current root
    }

    public boolean contains(int key) {
        return recContains(this.root, key);
    }

    public boolean recContains(Node root, int key) {
        if (root == null) { // if current node is null, key not found, return false
            return false;
        }
        System.out.println("IS ROOT.KEY:" + root.key + " == KEY:" + key);
        if (key == root.key) { // if key = key of current node, key found, return true
            return true;
        } else if (key < root.key) { // if key < key of current node, the key that we're looking for has to be to the left of the current node
            return recContains(root.left, key); // call function for left child
        } else { // if key > key of current node, the key that we're looking for has to be to the right of the current node
            return recContains(root.right, key); // call function for right child
        }
    }
}
