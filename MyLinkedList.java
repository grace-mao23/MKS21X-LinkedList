class MyLinkedList{
 private int length = 0;
 private Node start,end;

 public MyLinkedList() {
   //empty constructor
 }

 // returns number of elements in the list
 public int size() {
   return length;
 }

 // returns true, adds value to the end of the list
 public boolean add(Integer value) {
   if (end == null) { // if list is totally empty
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

 // getNthNode --> used in other methods
 // nodes should not be accessed from outside --> private
 private Node getNode(int index) {
   int current = 0;
   Node result = start;
   while (current < index) {
     result = result.next();
     current++;
   }
   return result;
 }

 // returns data of node at indexOf
 // throws exception if out of range
 public Integer get(int index) {
   if (index < 0 || index >= size()) {
     throw new IndexOutOfBoundsException();
   }
   return getNode(index).getData();
 }

 // returns old value
 // throws exception if out of range
 public Integer set(int index,Integer value) {
   if (index < 0 || index >= size()) {
     throw new IndexOutOfBoundsException();
   }
   Node old = getNode(index);
   Integer result = old.getData();
   old.setData(value);
   return result;
 }

 // returns true if list contains element, false otherwise
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

 // returns index of first occurence of value, -1 otherwise
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

 // adds value at index
 // throws exception if out of range
 public void add(int index, Integer value) {
   if (index < 0 || index > size()) {
     throw new IndexOutOfBoundsException();
   }
   if (index == 0) {
     Node temp = new Node(value, null, start);
     start.setPrev(temp);
     start = temp;
     length++;
   }
   else if (index == size()){
     add(value);
   } else {
     Node n = new Node(value, getNode(index-1), getNode(index));
     getNode(index-1).setNext(n);
     getNode(index).setPrev(n);
     length++;
   }
 }

 // returns old element, removes element at index
 // throws exception if out of range
 public Integer remove(int index) {
   if (index < 0 || index >= size()) {
     throw new IndexOutOfBoundsException();
   }
   Integer result = get(index);
   if (index == 0) {
     start = getNode(index+1);
     return result;
   }
   if (getNode(index).next() == null) {
     getNode(index-1).setNext(end);
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

 // returns true if element at index removed, false if not present at all
 public boolean remove(Integer value){
   int index = indexOf(value);
   if (index == -1) {
     return false;
   }
   //System.out.println(index + ": " + value);
   remove(index);
   return true;
 }

 //New Method
 //in O(1) runtime, move the elements from other onto the end of this
 //The size of other is reduced to 0
 //The size of this is now the combined sizes of both original lists
 public void extend(MyLinkedList other){
   if (length == 0 || other.size() == 0) {
     start = other.start;
     end = other.end;
   } else {
     end.setNext(other.start);
     other.start.setPrev(end);
     other.start = null;
     other.end = null;
     other.length = 0;
   }
   length += other.size();
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
