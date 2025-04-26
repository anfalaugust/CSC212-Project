package DSproject;

public class Node<T> {
public T data;
public Node<T> next;
	
public Node (T val) {
data = val;
next = null;
}
	
public Node () {
data = null;
next = null;
}

}
