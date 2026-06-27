package exercise5;
class Node { Task task; Node next; Node(Task t) { task = t; } }
public class TaskLinkedList {
    private Node head;
    public void addTask(Task t) {
        if(head==null) head = new Node(t);
        else { Node curr = head; while(curr.next!=null) curr = curr.next; curr.next = new Node(t); }
    }
    public Task searchTask(String id) {
        Node curr = head;
        while(curr!=null) { if(curr.task.getTaskId().equals(id)) return curr.task; curr = curr.next; }
        return null;
    }
    public static void main(String[] args) {
        TaskLinkedList tll = new TaskLinkedList();
        tll.addTask(new Task("T1", "Do work"));
        System.out.println(tll.searchTask("T1"));
    }
}
