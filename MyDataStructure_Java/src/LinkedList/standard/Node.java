package LinkedList.standard;

public class Node {
    //存放当前节点的数据
    private int data;
    //存放下一个节点的指针
    private Node next;

    public Node(){

    }
    public Node(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
