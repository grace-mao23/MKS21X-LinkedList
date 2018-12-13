class MyLinkedList{
 private int size = 0;
 private Node start,end;

 public MyLinkedList() {
   //empty constructor
 }

 public int size() {
   return size;
 }

 public boolean add(int value) {
   if (end == null) {
     end = new Node(value,end,null);
     start = end;
   } else {
     Node n = new Node(value, end.getPrev(), null);
     end.setNext(n);
     end = n;
   }
   size++;
   return true;
 }

 public String toString() {
   return "";
 }
}

class Node{
 private int data;
 private Node next,prev;

 public Node(int d, Node p, Node n) {
   data = d;
   next = n;
   prev = p;
 }

 public int getData() {
   return data;
 }

 public Node getNext() {
   return next;
 }

 public Node getPrev() {
   return prev;
 }

 public void setData(int d) {
   data = d;
 }

 public void setNext(Node n) {
   next = n;
 }

 public void setPrev(Node n) {
   prev = n;
 }
}
