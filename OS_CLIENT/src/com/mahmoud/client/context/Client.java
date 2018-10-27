package com.mahmoud.client.context;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import com.mahmoud.client.util.ObjectInput;

public class Client {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		try {

			Socket client = new Socket("localhost", 564);
			PrintWriter ostream = new PrintWriter(client.getOutputStream());
			InputStreamReader reader = new InputStreamReader(client.getInputStream());
			BufferedReader istream = new BufferedReader(reader);

			while (true) {

				System.out.println(" Hello user: \n 1-counting phrase lenght \n 2-number factorial \n 3-number Power ");
				int option = scanner.nextInt();
				int power = 0;
				System.out.println("enter your input");
				String inputToServer = scanner.next();

				if (option == 3) {
					System.out.println("enter the power number");
					power = scanner.nextInt();
				}
				
				ObjectInput objectInput = new ObjectInput(option, inputToServer, power);
				
				ostream.println(objectInput.toString());
				ostream.flush();

				String line = istream.readLine();

				System.out.println(line);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
