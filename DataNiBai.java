package ramos;
import java.util.Scanner;


public class DataNiBai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose a data structure:");
            System.out.println("1. Stack  2. Queue  3. Linked List  4. Circular Linked List  5. Exit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            if (choice == 5) break;
            switch (choice) {
                case 1: stackMenu(sc); break;
                case 2: queueMenu(sc); break;
                case 3: linkedListMenu(sc); break;
                case 4: circularListMenu(sc); break;
                default: System.out.println("Invalid choice.");
            }
        }
        System.out.println("Goodbye!");
        sc.close();
    }

    static class Stack {
        int[] arr = new int[100];
        int top = -1;
        boolean push(int v) {
            if (top == arr.length - 1) return false;
            arr[++top] = v; return true;
        }
        Integer pop() {
            if (top == -1) return null;
            return arr[top--];
        }
        void display() {
            if (top == -1) System.out.println("Stack empty");
            else {
                System.out.print("Stack: ");
                for (int i = top; i >= 0; i--) System.out.print(arr[i] + " ");
                System.out.println();
            }
        }
    }

    static void stackMenu(Scanner sc) {
        Stack s = new Stack();
        while (true) {
            System.out.print("Stack: 1-Push 2-Pop 3-Display 4-Back: ");
            int op = sc.nextInt();
            if (op == 4) break;
            switch (op) {
                case 1:
                    System.out.print("Value to push: ");
                    int v = sc.nextInt();
                    if (!s.push(v)) System.out.println("Stack full!");
                    break;
                case 2:
                    Integer popped = s.pop();
                    System.out.println(popped == null ? "Stack empty!" : "Popped: " + popped);
                    break;
                case 3: s.display(); break;
                default: System.out.println("Invalid option.");
            }
        }
    }

    static class Queue {
        int[] arr = new int[100];
        int front = 0, size = 0, rear = 99;
        boolean enqueue(int v) {
            if (size == arr.length) return false;
            rear = (rear + 1) % arr.length;
            arr[rear] = v;
            size++;
            return true;
        }
        Integer dequeue() {
            if (size == 0) return null;
            int val = arr[front];
            front = (front + 1) % arr.length;
            size--;
            return val;
        }
        void display() {
            if (size == 0) System.out.println("Queue empty");
            else {
                System.out.print("Queue: ");
                for (int i = 0; i < size; i++)
                    System.out.print(arr[(front + i) % arr.length] + " ");
                System.out.println();
            }
        }
    }

    static void queueMenu(Scanner sc) {
        Queue q = new Queue();
        while (true) {
            System.out.print("Queue: 1-Enqueue 2-Dequeue 3-Display 4-Back: ");
            int op = sc.nextInt();
            if (op == 4) break;
            switch (op) {
                case 1:
                    System.out.print("Value to enqueue: ");
                    int v = sc.nextInt();
                    if (!q.enqueue(v)) System.out.println("Queue full!");
                    break;
                case 2:
                    Integer deq = q.dequeue();
                    System.out.println(deq == null ? "Queue empty!" : "Dequeued: " + deq);
                    break;
                case 3: q.display(); break;
                default: System.out.println("Invalid option.");
            }
        }
    }

    static class Node {
        int val;
        Node next;
        Node(int v) { val = v; }
    }

    static class LinkedList {
        Node head;
        void insertEnd(int v) {
            Node n = new Node(v);
            if (head == null) head = n;
            else {
                Node cur = head;
                while (cur.next != null) cur = cur.next;
                cur.next = n;
            }
        }
        Integer deleteBeg() {
            if (head == null) return null;
            int val = head.val;
            head = head.next;
            return val;
        }
        void display() {
            if (head == null) System.out.println("List empty");
            else {
                System.out.print("List: ");
                for (Node cur = head; cur != null; cur = cur.next)
                    System.out.print(cur.val + " ");
                System.out.println();
            }
        }
    }

    static void linkedListMenu(Scanner sc) {
        LinkedList list = new LinkedList();
        while (true) {
            System.out.print("List: 1-InsertEnd 2-DeleteBeg 3-Display 4-Back: ");
            int op = sc.nextInt();
            if (op == 4) break;
            switch (op) {
                case 1:
                    System.out.print("Value to insert: ");
                    int v = sc.nextInt();
                    list.insertEnd(v);
                    break;
                case 2:
                    Integer del = list.deleteBeg();
                    System.out.println(del == null ? "List empty!" : "Deleted: " + del);
                    break;
                case 3: list.display(); break;
                default: System.out.println("Invalid option.");
            }
        }
    }

    static class CircularLinkedList {
        Node tail;
        void insert(int v) {
            Node n = new Node(v);
            if (tail == null) {
                tail = n;
                tail.next = tail;
            } else {
                n.next = tail.next;
                tail.next = n;
                tail = n;
            }
        }
        Integer delete() {
            if (tail == null) return null;
            Node head = tail.next;
            if (head == tail) {
                int val = head.val;
                tail = null;
                return val;
            }
            int val = head.val;
            tail.next = head.next;
            return val;
        }
        void display() {
            if (tail == null) {
                System.out.println("Circular list empty");
                return;
            }
            System.out.print("Circular List: ");
            Node cur = tail.next;
            do {
                System.out.print(cur.val + " ");
                cur = cur.next;
            } while (cur != tail.next);
            System.out.println();
        }
    }

    static void circularListMenu(Scanner sc) {
        CircularLinkedList clist = new CircularLinkedList();
        while (true) {
            System.out.print("Circular List: 1-Insert 2-Delete 3-Display 4-Back: ");
            int op = sc.nextInt();
            if (op == 4) break;
            switch (op) {
                case 1:
                    System.out.print("Value to insert: ");
                    int v = sc.nextInt();
                    clist.insert(v);
                    break;
                case 2:
                    Integer del = clist.delete();
                    System.out.println(del == null ? "List empty!" : "Deleted: " + del);
                    break;
                case 3: clist.display(); break;
                default: System.out.println("Invalid option.");
            }
        }
    }
}
