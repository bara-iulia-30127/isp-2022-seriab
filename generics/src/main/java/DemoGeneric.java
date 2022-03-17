import javax.xml.transform.sax.SAXSource;

class Node<T> {
    T value;
    Node next;

    public Node(T value) {
        this.value = value;
    }

    void printNodeInfo(){
        System.out.println(value);
    }
}

class NodeTraverUtil{
    void travers(Node<?> head){
        head.printNodeInfo();
        if(head.next!=null)
            travers(head.next);
    }
}

public class DemoGeneric {

    public static void main(String[] args) {
        Node<Integer> n1 = new Node<Integer>(10);
        Node<Integer> n2 = new Node<Integer>(20);
        Node<Integer> n3 = new Node<Integer>(30);
        n1.next = n2;
        n2.next = n3;
        NodeTraverUtil util = new NodeTraverUtil();
        util.travers(n1);

    }
}
