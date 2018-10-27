package com.mahmoud.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connexion extends Thread {
	static int nbThread = 0;
	Socket socket;

	public Connexion(Socket socket) throws Exception {
		this.socket = socket;
		nbThread++;
	}

	public void run() {
		try {
			System.out.println("New connection N" + nbThread);
			InputStreamReader reader = new InputStreamReader(socket.getInputStream());
			BufferedReader istream = new BufferedReader(reader);
			PrintWriter ostream = new PrintWriter(socket.getOutputStream());
			while (true) {
				// Reading from client
				String input = istream.readLine();
				System.out.println("Connection class has received: " + input);
				
				IOperation operation = OperationFactory.getOperation(input);
				int opResult = operation.executeOperation();
				// echo line to the server
				ostream.println(opResult);
				ostream.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}