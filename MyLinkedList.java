class MyLinkedList{
 private int length = 0;
 private Node start,end;

 public MyLinkedList() {
   //empty constructor
 }

 public int size() {
   return length;
 }

 public boolean add(Integer value) {
   if (end == null) {
     end = new Node(value,end,null);
     start = end;
   } else {
     Node n = new Node(value, end.prev(), null);
     end.setNext(n);
     end = n;
   }
   length++;
   return true;
 }

 private Node get(int index) {
   int current = 0;
   Node result = start;
   while (current <= index) {
     result = result.next();
     current++;
   }
   return result;
 }

 public String toString() {
   String result = "[";
   if (start == null) {
     return "[]";
   }
   Node current = start;
   while (current.next() != null) {
     result += current.getData() + ", ";
     current = current.next();
   }
   result = result.substring(0,result.length() - 2);
   return result + "]";
 }
}

class Node{
 private Integer data;
 private Node next,prev;

 public Node(int d, Node p, Node n) {
   data = d;
   next = n;
   prev = p;
 }

 public int getData() {
   return data;
 }

 public Node next() {
   return next;
 }

 public Node prev() {
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
