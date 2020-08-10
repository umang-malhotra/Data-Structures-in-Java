package LinkedList;

public class App {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.insert(10);
        list.insert(23);
        list.insert(-2);
        list.insert(15);
        list.traverseList();
        list.remove(10);
        System.out.println(list.size());
    }
}

interface List<T> {
    public void insert(T data);
    public void remove(T data);
    public void traverseList();
    public int size();
}
class LinkedList<T extends Comparable<T>> implements List<T>{
    private Node<T> root;
    private int sizeOfList;

    // And Implement Methods from List Interface

    public void insert(T data) {
        ++this.sizeOfList;
        if(root == null) {
            this.root = new Node<T>(data);
        } else insertDataAtBeginning(data);
    }

    private void insertDataAtBeginning(T data){
        Node<T> newNode = new Node<T> (data);
        newNode.setNextNode(root);
        this.root = newNode;
    }

    private void insertDataAtEnd(T data) {
        Node<T> currentNode = root;
        while(currentNode.getNextNode() != null) {
            currentNode=currentNode.getNextNode();
        }
        Node<T> newNode = new Node<T>(data);
        currentNode.setNextNode(newNode);
    }

    public void remove(T data) {
        if(this.root == null) return;
        --this.sizeOfList;
        if(this.root.getData().compareTo(data) == 0) {
            this.root=this.root.getNextNode();
        } else {
            Node<T> previousNode = this.root;
            Node<T> currentNode = this.root.getNextNode();
            while(currentNode != null) {
                if(currentNode.getData().compareTo(data) == 0){
                    previousNode.setNextNode(currentNode.getNextNode());
                    currentNode=null;
                    return;
                }
                previousNode=previousNode.getNextNode();
                currentNode=currentNode.getNextNode();
            }
        }
    }

    public void traverseList() {
        if(this.root==null) return;
        Node<T> currentNode = root;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode=currentNode.getNextNode();
        }
    }

    public int size() {
        return this.sizeOfList;
    }
}

class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> nextNode;


    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data){
        this.data=data;
    }

    public Node<T> getNextNode(){
        return nextNode;
    }

    public void setNextNode(Node<T> newNode){
        this.nextNode = newNode;
    }

    public String toString(){
        return this.data.toString();
    }
}


