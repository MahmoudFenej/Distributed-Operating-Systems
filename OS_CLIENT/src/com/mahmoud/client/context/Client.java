package com.mahmoud.client.context;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

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
				
				String menu = istream.readLine();
				System.out.println(menu);
				
				String option = scanner.nextLine();

				ostream.println(option);
				ostream.flush();
				
				String enterMessage = istream.readLine();
				System.out.println(enterMessage);
				
				String input = scanner.nextLine();

				ostream.println(input);
				ostream.flush();
				
				String line = istream.readLine();
				System.out.println(line);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
