package MiddleExams;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server1 {
	static ServerSocket serversocket = null;
	static ArrayList<Student> liststudent = new ArrayList<>();

	public static void AddStudent() {
		liststudent.add(new Student("Nguyen A", 18));
		liststudent.add(new Student("Tran B", 19));
		liststudent.add(new Student("Le C", 20));
		liststudent.add(new Student("Ngo D", 21));
		liststudent.add(new Student("Ly E", 22));
	}

	public static void main(String[] args) throws IOException {
		AddStudent();
		try {
			serversocket = new ServerSocket(9999);
			System.out.println("Server is starting...");
			while (true) {
				Socket socket = serversocket.accept();
				ThreadSocket threadSocket = new ThreadSocket(socket, liststudent);
				threadSocket.start();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			serversocket.close();
		}

	}
}
