package com.mahmoud.server.context;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.mahmoud.utils.Connexion;

public class ServerContext {

	public static void main(String[] args) throws Exception {

		Socket socket = null;
		try {

			ServerSocket server = new ServerSocket(564);
			System.out.println("Server started: ");

			while (true) {
				socket = server.accept();

				Connexion connexionObject = new Connexion(socket);
				connexionObject.start();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
