package LinkedList.standard;

import sun.security.util.Length;

public class TestNode {
    private Node head = new Node();
    public void print(){
        Node temp = head;
        while (temp.getNext() != null){
            System.out.println(temp.getNext().getData());
            temp = temp.getNext();
        }
    }
    public int getLength(){
       Node temp = head;
       int length = 1;
       while (temp.getNext() != null){
           length ++;
           temp = temp.getNext();
       }
       return length;
    }
    public void addNode(Node newNode){
        Node temp = head;
        while (temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(newNode);
    }
    public void deleteNode(){
        Node temp = head;
        if(temp.getNext() == null){
            return;
        }
        while(temp.getNext().getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(null);
    }
    public void insertNodeByIndex(int index,Node newNode){
        if(index < 1 && index > getLength()-1){
            System.out.println("index error");
            return;
        }
        Node temp = head;
        if(head.getNext() == null){
            head.setNext(newNode);
            return;
        }
        for(int i = 1; i < index; i++){
            temp = temp.getNext();
        }
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
    }
    public void deleteNodeByIndex(int index){
        if(index < 1 && index > getLength()-1){
            System.out.println("index error");
            return;
        }
        Node temp = head;
        for(int i = 1; i < index; i++){
            temp = temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
    }
    public static void main(String[] args){
        Node newNode1 = new Node(4);
        Node newNode2 = new Node(2);
        Node newNode3 = new Node(5);
        TestNode testNode = new TestNode();
        testNode.addNode(newNode1);
        testNode.addNode(newNode2);
        testNode.addNode(newNode3);
        testNode.deleteNode();
        Node newNode4 = new Node(66);
        testNode.insertNodeByIndex(2,newNode4);
        testNode.deleteNodeByIndex(1);
        testNode.print();
        System.out.println("Length: " + testNode.getLength());
    }

}
