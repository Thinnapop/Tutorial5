import java.util.Random;
import java.util.Vector;

class Node {
    Covid_vaccine data;
    Node next;

    public Node(Covid_vaccine data) {
        this.data = data;
        this.next = null;
    }
}

class Covid_vaccine {
    String ID;
    String fName;
    String lName;
    Vector<String> previousVaccine;

    public Covid_vaccine(String ID, String fName, String lName, Vector<String> previousVaccine) {
        this.ID = ID;
        this.fName = fName;
        this.lName = lName;
        this.previousVaccine = previousVaccine;
    }

    public String displayTraversal() {
        StringBuilder vaccines = new StringBuilder();
        for (int i = 0; i < previousVaccine.size(); i++) {
            vaccines.append(previousVaccine.get(i));
            if (i < previousVaccine.size()-1) {
                vaccines.append(" -> ");
            }
        }
        return vaccines.toString();
    }

    public Covid_vaccine delete() {
        if (!previousVaccine.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(previousVaccine.size());
            String removedVaccine = previousVaccine.remove(randomIndex);
            System.out.println("Removed Vaccine: " + removedVaccine);
            return this;
        } else {
            System.out.println("Vector is empty");
            return null;
        }
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        head = null;
    }

    public void insert(Covid_vaccine data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void delete() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            head = head.next;  
        }
    }

    public void deleteAll() {
        head = null;  
    }

    public boolean isEmpty() {
        return head == null;  
    }

    public int getSize() {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data.ID + ", Name: " + temp.data.fName + " " + temp.data.lName + ", Vaccines: " + temp.data.displayTraversal());
            temp = temp.next;
        }
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

       
        Vector<String> vaccines1 = new Vector<>();
        vaccines1.add("Cinovex ->");
        Vector<String> vaccines2 = new Vector<>();
        vaccines2.add("Convidecia ->");

        
        Covid_vaccine newPerson = new Covid_vaccine(("0000"), "John", "Doe", new Vector<>(vaccines2));
        list.insert(newPerson);
        Covid_vaccine newPerson1 = new Covid_vaccine(("0001"), "Jane", "Smith", new Vector<>(vaccines1));
        list.insert(newPerson1);
        Covid_vaccine newPerson2 = new Covid_vaccine(("0002"), "Alex", "Johnson", new Vector<>(vaccines2));
        list.insert(newPerson2);
        Covid_vaccine newPerson3 = new Covid_vaccine(("0003"), "Emily", "Brown", new Vector<>(vaccines1));
        list.insert(newPerson3);
        Covid_vaccine newPerson4 = new Covid_vaccine(("0004"), "Chris", "Davis", new Vector<>(vaccines2));
        list.insert(newPerson4);
        Covid_vaccine newPerson5 = new Covid_vaccine(("0005"), "Katie", "Miller", new Vector<>(vaccines1));
        list.insert(newPerson5);
        Covid_vaccine newPerson6 = new Covid_vaccine(("0006"), "David", "Wilson", new Vector<>(vaccines2));
        list.insert(newPerson6);
        Covid_vaccine newPerson7 = new Covid_vaccine(("0007"), "Olivia", "Moore", new Vector<>(vaccines1));
        list.insert(newPerson7);
        Covid_vaccine newPerson8 = new Covid_vaccine(("0008"), "Michael", "Taylor", new Vector<>(vaccines2));
        list.insert(newPerson8);
        Covid_vaccine newPerson9 = new Covid_vaccine(("0009"), "Sophia", "Anderson", new Vector<>(vaccines1));
        list.insert(newPerson9);
        

        System.out.println("List of applicants after adding 4 specific vaccines:");
        list.traverse();

        
        Random rand = new Random();
        int deleteCount = 0;

        while (deleteCount < 2) {
            int positionToDelete = rand.nextInt(10); 
            Node temp = list.head;
            Node prev = null;

            for (int i = 0; temp != null && i < positionToDelete; i++) {
                prev = temp;
                temp = temp.next;
            }

            if (temp != null) {
                if (prev != null) {
                    prev.next = temp.next; 
                } else {
                    list.head = temp.next;  
                }
                System.out.println("Deleted applicant at position: " + positionToDelete);
                deleteCount++;
            }
        }

        
        System.out.println("\nList after randomly deleting two applicants:");
        list.traverse();

       
        list.deleteAll();
        System.out.println("\nAfter deleting all applicants:");
        list.traverse();  
    }
}
