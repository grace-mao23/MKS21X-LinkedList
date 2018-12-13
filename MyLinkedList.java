class Node{
 private int data;
 private Node next,prev;

 public Node(int d, Node n, Node p) {
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

class MyLinkedList{
 private int size;
 private Node start,end;

 public MyLinkedList(int s) {
   size = s;
 }

 public int size() {
   return size;
 }
 public boolean add(int value) {
   return true;
 }
 public String toString() {
   return "";
 }
}
