package Shahe;

import java.util.Scanner;

public class Patient {
	Scanner sc = new Scanner(System.in);

	class Node {
		int pid;
		String name;
		String address;
		int weight;
		int oxegen_level;
		int Blood_Pressure;
		String Blood_group;
		float Body_temp;
		Node next;

		Node(int pid, String name, String address, int weight, int oxegen_level, int Blood_Pressure,
				String Blood_group,float Body_temp) {
			this.pid = pid;
			this.name = name;
			this.address = address;
			this.weight = weight;
			this.oxegen_level = oxegen_level;
			this.Blood_Pressure = Blood_Pressure;
			this.Blood_group = Blood_group;
			this.Body_temp = Body_temp;
			this.next = null;
		}
	}

	public Node head = null;
	public Node tail = null;

	public void addNode(int pid, String name, String address, int weight, int oxegen_level, int Blood_Pressure,
			String Blood_group,float Body_temp) {

		Node newNode = new Node(pid, name, address, weight, oxegen_level, Blood_Pressure, Blood_group,Body_temp);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	void addNode() {
		System.out.println("How many patient do you want to add");
		int count = sc.nextInt();
		while (count > 0) {
			System.out.println("Enter patient pid");
			int pid = sc.nextInt();
			System.out.println("Enter patient name ");
			String name = sc.next();
			System.out.println("Enter patient address ");
			String address = sc.next();
			System.out.println("Enter patient Blood_group ");
			String Blood_group = sc.next();
			System.out.println("Enter patient weight");
			int weight = sc.nextInt();
			System.out.println("Enter patient Blood_Pressure");
			int Blood_Pressure = sc.nextInt();
			System.out.println("Enter patient Oxygen Level");
			int oxegen_level = sc.nextInt();
			System.out.println("Enter Patient body temperature in Fahrenheit");
			float Body_temp = sc.nextFloat();
			if(oxegen_level <= 80 && Body_temp >= 100.00)
	         {
				 System.out.println("");
	        	 System.out.println("Go to Emergency Ward Bcoz ur Oxygen level is less than 80 and Body temperature greter than 100 Fehrenheit");
	        	 System.out.println("");
	         }else
	         {
	        	 System.out.println("");
	        	 System.out.println("Go to general Ward ");
	        	 System.out.println("");
	         }
			
			
			addNode(pid, name, address, weight, oxegen_level, Blood_Pressure, Blood_group,Body_temp);
			count--;
		}
	}

	public void display() {
		Node current = head;
		if (head == null) {
			System.out.println("Empty list");
			return;
		}

		while (current != null) {
			System.out.print("Patient ID :" + current.pid + " " + "Patient Name :" + current.name + " --> ");

			System.out.println(" ");
			current = current.next;
		}
		System.out.println("\n============================================");

	}

	void deleteNode(int key) {
		// Store head node
		Node temp = head, prev = null;
		// If head node itself holds the key to be deleted
		if (temp != null && temp.pid == key) {
			head = temp.next; // Changed head
			return;
		}
		// Search for the key to be deleted, keep track of
		// the previous node as we need to change temp.next
		while (temp != null && temp.pid != key) {
			prev = temp;
			temp = temp.next;
		}
		// If key was not present in linked list
		if (temp == null)
			return;
		// Unlink the node from linked list
		prev.next = temp.next;
	}

	public void swapNodes(int x, int y) {

		if (x == y)
			return;

		Node prevX = null, currX = head;
		while (currX != null && currX.pid != x) {
			prevX = currX;
			currX = currX.next;
		}

		Node prevY = null, currY = head;
		while (currY != null && currY.pid != y) {
			prevY = currY;
			currY = currY.next;
		}

		if (currX == null || currY == null)
			return;

		if (prevX != null)
			prevX.next = currY;
		else
			head = currY;

		if (prevY != null)
			prevY.next = currX;
		else
			head = currX;

		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;
	}

	public boolean search(Node head, int PID1) {
		Node current = head; // Initialize current
		while (current != null) {
			if (current.pid == PID1)
				return true; // data found
			current = current.next;
		}
		return false; // data not found
	}

	 public int getCount()
	    {
	        Node temp = head;
	        int count = 0;
	        while (temp != null) {
	            count++;
	            temp = temp.next;
	        }
	        return count;
	    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Patient p = new Patient();
		int opt = 1000;
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("***** Welcome to (COVID-19) Patient Management System  *****");
		while (opt != 0) {
			System.out.println("Menu");
			System.out.println("1. ADD patient Details :");
			System.out.println("2. Show Patient List");
			System.out.println("3. Delete patient");
			System.out.println("4. Swap Patient");
			System.out.println("5. Check Patient Discharge Status");
			System.out.println("6. Total Bed Occupied by Patient");
			System.out.println("0. Exit");
			System.out.println("Enter your Option");
			opt = sc.nextInt();
			switch (opt) {
			case 1:
				p.addNode();
				break;
			case 2:
				p.display();
				break;

			case 3:
				System.out.println("Enter patient ID to delete patient");
				int PID = sc.nextInt();
				p.deleteNode(PID);

				p.display();
				break;
			case 4:
				System.out.println("Enter 1st patient ID to swap");
				int pid1 = sc.nextInt();
				System.out.println("Enter 2nd patient ID to swap");
				int pid2 = sc.nextInt();
				System.out.println("Patientlist Before calling swapnodes()");
				p.display();
				p.swapNodes(pid1, pid2);

				System.out.println("Patientlist After calling swapnodes()");
				p.display();
				break;
			case 5:
				System.out.println("Enter patient ID to Search patient");
				int PID1 = sc.nextInt();
				
				 if (p.search(p.head, PID1))
			            System.out.println("Not Discharge");
			        else
			            System.out.println("Discharged");
			            
				break;
			case 6:
				 System.out.println("Total Bed Occupied by Patient is :"+ p.getCount());
			            
				break;
			case 0:
				System.out.println("Thank You For Using (COVID-19) Patient Management System Application");
				System.exit(0);
			default:
				System.out.println("Illegal Options taken");
			}
		}
		sc.close();

	}

}
