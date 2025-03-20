package DSproject;

public class LinkedList {
private Node<T> head;
private Node<T> current;
int count;
  
public LinkedList () {
head = current = null; }
  
public boolean empty () {
return head == null; }
  
public boolean last () {
return current.next == null; }
  
public boolean full () {
return false; }
  
public void findfirst () {
current = head; }
  
public void findnext () {
current = current.next; }
  
public T retrieve () {
return current.data; }
  
public void update (T val) {
current.data = val; }

public void insert (T val) {
Node<T> tmp;
if (empty()) {
current = head = new Node<T> (val);
} //if
else {
tmp = current.next;
current.next = new Node<T> (val);
current = current.next;
current.next = tmp;
}  //else
  count++;
} //method

public void remove () {
if (current == head) {
head = head.next;
} //if
else {
Node<T> tmp = head;
while (tmp.next != current)
tmp = tmp.next;
tmp.next = current.next;
} // else
if (current.next == null)
current = head;
else
current = current.next;
count--;
} //method
  
public int getCount() {
return count; }

}
