package LinkedList.Double;

public class TestNode {
    private Node head = new Node();

    public void addNode(Node newNode){
        Node temp = head;
        while (temp.getNext()!=null){
            temp = temp.getNext();
        }
        newNode.setLast(temp);
        temp.setNext(newNode);
    }

    public void print(){
        Node temp = head;
        while (temp.getNext()!=null){

            temp = temp.getNext();
            System.out.println(temp.getData());
        }
    }

    public static void main(String[] args) {
        Node newNode1 = new Node(7);
        Node newNode2 = new Node(0);
        Node newNode3 = new Node(1);
        Node newNode4 = new Node(8);
        Node newNode5 = new Node(9);
        Node newNode6 = new Node(5);
        TestNode testNode = new TestNode();
        testNode.addNode(newNode1);
        testNode.addNode(newNode2);
        testNode.addNode(newNode3);
        testNode.addNode(newNode4);
        testNode.addNode(newNode5);
        testNode.addNode(newNode6);
        testNode.print();
    }
}
