package MiddleExams;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try {
			String name;
			String age;
			System.out.println("successful connection");
			Scanner scanner = new Scanner(System.in);
			while (true) {
				Socket clientsocket = new Socket("localhost", 9999);
				DataInputStream dis = new DataInputStream(clientsocket.getInputStream());
				DataOutputStream dos = new DataOutputStream(clientsocket.getOutputStream());
				System.out.print("Name : ");
				name = scanner.nextLine();
				dos.writeUTF(name);
				age = dis.readUTF();
				if (age.equals("No Information")) {
					clientsocket = new Socket("localhost", 8000);
					dis = new DataInputStream(clientsocket.getInputStream());
					dos = new DataOutputStream(clientsocket.getOutputStream());
					dos.writeUTF(name);
					age = dis.readUTF();
				}
				System.out.print("Age: " + age);
				System.out.println();

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
