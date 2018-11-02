package MiddleExams;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server2 {
	static ServerSocket serversocket = null;
	static ArrayList<Student> liststudent = new ArrayList<>();

	public static void AddStudent() {
		liststudent.add(new Student("Nguyen M", 19));
		liststudent.add(new Student("Tran N", 20));
		liststudent.add(new Student("Le O", 21));
		liststudent.add(new Student("Ngo P", 22));
		liststudent.add(new Student("Ly Q", 23));
	}

	public static void main(String[] args) throws IOException {
		AddStudent();
		try {
			serversocket = new ServerSocket(8000);
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
