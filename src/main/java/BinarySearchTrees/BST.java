package BinarySearchTrees;

public class BST {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert(123);
        bst.insert(31);
        bst.insert(1123);
        bst.insert(1);
        bst.insert(912);
        bst.insert(9);

        System.out.println("Trvrsl");
        bst.traverse();
        bst.delete(31);
        System.out.println("Trvrsl after removal");
        bst.traverse();
    }
}

class Node<T> {
    private T data;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node(T data) {
        this.data=data;
    }
    @Override
    public String toString() {
        return this.data.toString();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }
}

interface Tree<T> {
    public void traverse();
    public void insert(T data);
    public void delete(T data);
    public T getMaxValue();
    public T getMinValue();
}

class BinarySearchTree<T extends Comparable<T> > implements Tree<T>{
    private Node<T> root;

    @Override
    public void insert(T data){
        if(root == null) {
            root = new Node<T>(data);
        } else insertNode(data, root);
    }

    @Override
    public void traverse() {
        if(root != null) {
            inOrderTraversal(root);
        }
        System.out.println();
    }

    private void inOrderTraversal(Node<T> root) {
        if(root == null) return;

        inOrderTraversal(root.getLeftChild());
        System.out.print( " " + root.getData());
        inOrderTraversal(root.getRightChild());
    }

    @Override
    public T getMaxValue() {
        if(root == null) return null;
        return getMax(root);
    }

    @Override
    public T getMinValue() {
        if(root == null) return null;
        return getMin(root);
    }

    private void insertNode(T newData, Node<T> node) {
        if(newData.compareTo(node.getData()) < 0 ) {
            if(node.getLeftChild() != null) {
                insertNode(newData, node.getLeftChild());
            } else {
                Node<T> newNode = new Node<T>(newData);
                node.setLeftChild(newNode);
            }
        } else {
            if(node.getRightChild() != null) {
                insertNode(newData, node.getRightChild());
            } else {
                Node<T> newNode = new Node<T>(newData);
                node.setRightChild(newNode);
            }
        }
    }

    @Override
    public void delete(T data) {
        if(root != null) deleteNode(root, data);
    }

    private Node<T> deleteNode(Node<T> node, T data) {
        if(node == null) return node;
        if(data.compareTo(node.getData()) < 0) {
            node.setLeftChild(deleteNode(node.getLeftChild(), data));
        } else if(data.compareTo(node.getData())>0) {
            node.setRightChild(deleteNode(node.getRightChild(), data));
        } else{
            if(node.getLeftChild() == null && node.getRightChild() == null) {
                return null;
            }
            else if(node.getRightChild() == null) {
                Node<T> tmpNode = node.getLeftChild();
                node = null;
                return tmpNode;
            } else if (node.getLeftChild() == null) {
                Node<T> tmpNode = node.getRightChild();
                node = null;
                return tmpNode;
            } else {
                Node<T> tmpNode = getPredecessor(node.getLeftChild());
                node.setData(tmpNode.getData());
                node.setLeftChild(deleteNode(node.getLeftChild(), tmpNode.getData()));
            }
        }
        return node;
    }

    private Node<T> getPredecessor(Node<T> node) {
        if(node.getRightChild() != null) getPredecessor(node.getRightChild());
        return node;
    }

    private T getMax(Node<T> node) {
        if(node.getRightChild() !=null ) {
            return getMax(node.getRightChild());
        } else {
            return node.getData();
        }
    }

    private T getMin(Node<T> node) {
        if(node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        } else {
            return node.getData();
        }
    }
}
