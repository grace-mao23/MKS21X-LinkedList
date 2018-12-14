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

 private Node getNode(int index) { //private
   int current = 0;
   Node result = start;
   while (current < index) {
     result = result.next();
     current++;
   }
   return result;
 }

 public Integer get(int index) {
   return getNode(index).getData();
 }

 public Integer set(int index,Integer value) {
   Node old = getNode(index);
   Integer result = old.getData();
   old.setData(value);
   return result;
 }

 public boolean contains(Integer value) {
   Node current = start;
   while (current.next() != null) {
     current = current.next();
     if (value == current.getData()) {
       return true;
     }
   }
   return false;
 }

 public int indexOf(Integer value) {
   Node current = start;
   int result = 0;
   if (start.getData() == value) {
     return result;
   }
   while (current.next() != null) {
     current = current.next();
     result++;
     if (current.getData() == value) {
       return result;
     }
   }
   return -1;
 }

 public String toString() {
   String result = "[";
   if (end == null) {
     return "[]";
   }
   Node current = start;
   result += current.getData() + ", ";
   while (current.next() != null) {
     current = current.next();
     result += current.getData() + ", ";
   }
   result = result.substring(0,result.length() - 2);
   return result + "]";
 }

 public static void main(String[] args) {
   MyLinkedList test = new MyLinkedList();
   System.out.println(test.toString());
   test.add(0);
   test.add(2);
   test.add(5);
   System.out.println(test.toString());
   System.out.println(test.contains(0));
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
