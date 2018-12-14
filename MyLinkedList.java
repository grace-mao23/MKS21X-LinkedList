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
   while (current != null) {
     if (value == current.getData()) {
       return true;
     }
     current = current.next();
   }
   return false;
 }

 public int indexOf(Integer value) {
   Node current = start;
   int result = 0;
   while (current != null) {
     if (current.getData() == value) {
       return result;
     }
     current = current.next();
     result++;
   }
   return -1;
 }

 public void add(int index, Integer value) {
   Node n = new Node(value, getNode(index-1), getNode(index));
   getNode(index-1).setNext(n);
   getNode(index).setPrev(n);
   length++;
 }

 public Integer remove(int index) {
   Integer result = get(index);
   if (getNode(index).next() == null) {
     getNode(index-1).setNext(end);
  //   end.setPrev(getNode(index-2));
     end = getNode(index-1);
     end.setNext(null);
     length--;
     return result;
   }
   getNode(index-1).setNext(getNode(index+1));
   getNode(index).setPrev(getNode(index-1));
   length--;
   return result;
 }

 public boolean remove(Integer value){
   int index = indexOf(value);
   System.out.println(index + ": " + value);
   remove(index);
   return true;
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
   System.out.println(test.size());
   test.add(1,1);
   System.out.println(test.toString());
   System.out.println(test.size());
   test.remove(Integer.valueOf(5)); // turns int 5 into Integer 5
   System.out.println(test.toString());
   System.out.println(test.size());
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
