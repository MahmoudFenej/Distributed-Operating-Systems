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

				String menu = "1-counting phrase lenght 2-number factorial 3-number Power ";
				ostream.println(menu);
				ostream.flush();

				String input = istream.readLine();
				System.out.println("Connection class has received: " + input);
				
				int result = 0;
				
				int option = Integer.parseInt(input);
				if (option == 1) {
					ostream.println("Enter String: ");
					ostream.flush();
					String phrase = istream.readLine();
					result = new CountingLengthOperation(phrase).executeOperation();
				}
				if (option == 2) {
					ostream.println("Enter number: ");
					ostream.flush();
					String line = istream.readLine();
					result = new NumberFactorialOperation(line).executeOperation();
				}
				if (option == 3) {
					ostream.println("Enter 2 number separated by :");
					ostream.flush();
					String line = istream.readLine();
					String [] res = line.split(":");
					String number = res[0];
					int power = Integer.parseInt(res[1]);
					result = new NumberPowerOperation(number, power).executeOperation();
				}

				ostream.println(result);
				ostream.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}