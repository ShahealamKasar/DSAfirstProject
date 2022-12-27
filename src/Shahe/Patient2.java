package Shahe;

import java.util.Scanner;

public class Patient2 {
	
	class Node{
		int pid;
		String name;
		Node next;
		
		Node(int pid, String name){
			this.pid = pid;
			this.name = name;
			this.next = null;
		}
	}
	
	public Node head = null;
	public Node tail = null;
	
	public void addNode(int pid, String name) {
		
		Node newNode = new Node(pid, name);
		
		if(head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public void display() {
		Node current = head;
		if(head == null) {
			System.out.println("Empty list");
			return;
		}
		
		while(current != null) {
			System.out.print(current.pid +" " +current.name+ " --> ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		Patient2 p = new Patient2();
		Scanner sc = new Scanner(System.in);
		System.out.println("How many patient do you want to add");
		int count = sc.nextInt();
		while(count > 0) {
			System.out.println("Enter patient ID and Name");
			int pid = sc.nextInt();
			String name = sc.nextLine();
			p.addNode(pid, name);
			count--;
		}
		p.display();
	}

}

