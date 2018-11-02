package MiddleExams;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ThreadSocket extends Thread {
	Socket socket = null;
	ArrayList<Student> liststudent = null;

	public ThreadSocket(Socket socket, ArrayList<Student> liststudent) {
		super();
		this.socket = socket;
		this.liststudent = liststudent;
	}

	public void run() {
		try {
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			boolean check = false;
			while (true) {
				String name = dis.readUTF();
				for (int i = 0; i < liststudent.size(); i++) {
					if (liststudent.get(i).name.equals(name)) {
						dos.writeUTF(liststudent.get(i).getAge() + "");
						check = true;
						break;
					}
				}
				if (check == false)
					dos.writeUTF("No Information");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
