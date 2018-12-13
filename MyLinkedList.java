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
}

class MyLinkedList{
 private int size;
 private Node start,end;

 public int size() {
   return 0;
 }
 public boolean add(int value) {
   return true;
 }
 public String toString() {
   return "";
 }
}
