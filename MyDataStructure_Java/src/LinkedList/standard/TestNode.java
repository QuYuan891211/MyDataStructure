package LinkedList.standard;

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
       int length = 0;
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
        if(index < 1 && index > getLength()){
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
        if(index < 1 && index > getLength()){
            System.out.println("index error");
            return;
        }
        Node temp = head;
        for(int i = 1; i < index; i++){
            temp = temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
    }
    //头插法逆置,就地逆置
    public void reverse(){
        Node temp = head;
        if(getLength() < 2){
            return;
        }
        Node p = temp.getNext().getNext();
        temp.getNext().setNext(null);
        while (p != null){
            Node q = p.getNext();
            p.setNext(getNodeByIndex(1));
            temp.setNext(p);
            p=q;
            //print();

        }
    }



    public Node getNodeByIndex(int index){
        if(index < 1 && index > getLength()-1){
            System.out.println("index error");
            return head;
        }
        Node temp = head;
        for(int i = 1;i<=index;i++){
            temp = temp.getNext();
        }
        return temp;
    }
    //冒泡排序（bubble sort）
    public void orderByBubbleSort(){
        Node temp = head;
        if(getLength()<2){
            return;
        }
        boolean flag;
        for(int i = 1;i<getLength();i++){
            flag = false;
            for(int j = getLength()-1; j>=i;j--){
                if(getNodeByIndex(j).getData() > getNodeByIndex(j+1).getData()){
                    flag = true;
                    Node temp1 = getNodeByIndex(j);
                    Node temp2 = getNodeByIndex(j+1);
                    int tempData = temp1.getData();
                    temp1.setData(temp2.getData());
                    temp2.setData(tempData);
                }
            }
            if (!flag){ break;}
        }
    }

    //简单选择排序 Simple selection sort
    public void orderBySimpleSelectionSort(){
        Node temp = head;
        if(getLength()<2){
            return;
        }
        for(int i = 1; i<=getLength()-1;i++){
            int minData = getNodeByIndex(i).getData();
            int minIndex = i;
            for(int j = i+1;j<=getLength();j++){
                if(minData>getNodeByIndex(j).getData()){
                    minData = getNodeByIndex(j).getData();
                    minIndex = j;
                }
            }
            if (minIndex != i ){
                int tempData = getNodeByIndex(minIndex).getData();
                getNodeByIndex(minIndex).setData(getNodeByIndex(i).getData());
                getNodeByIndex(i).setData(tempData);
            }
        }

    }

    public static void main(String[] args){
        Node newNode1 = new Node(7);
        Node newNode2 = new Node(77);
        Node newNode3 = new Node(1);
        Node newNode4 = new Node(8);
        Node newNode5 = new Node(4);
        Node newNode6 = new Node(5);
        TestNode testNode = new TestNode();
        testNode.addNode(newNode1);
        testNode.addNode(newNode2);
        testNode.addNode(newNode3);
        testNode.addNode(newNode4);
        testNode.addNode(newNode5);
        testNode.addNode(newNode6);
        testNode.deleteNode();
        Node insertNode = new Node(2);
        testNode.insertNodeByIndex(3,insertNode);
        testNode.deleteNodeByIndex(1);
        testNode.orderBySimpleSelectionSort();
        //testNode.orderByBubbleSort();
        //testNode.reverse();
        testNode.print();
        System.out.println(" get node by index: "+ testNode.getNodeByIndex(3).getData());
        System.out.println("Length: " + testNode.getLength());
    }

}
