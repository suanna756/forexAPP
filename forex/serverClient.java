package forex;

import java.awt.RenderingHints;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import javax.net.ssl.SSLContext;
import javax.swing.text.AbstractDocument.BranchElement;

public class serverClient {

	public static int helper(String[] command, mysql sql) throws SQLException {
		if (command[0].equals("login")) {
			// System.out.println("___________");
			return sql.login(command);
		}
		if (command[0].equals("register")) {

			return sql.register(command);
		}
		return 0;
	}

	public static void main(String args[]) throws Exception {
		mysql sql = new mysql();
		ServerSocket serverSocket = new ServerSocket(10086);
		while (true) {
			Socket socket = serverSocket.accept();
			System.out.println("a connection created");
			InputStreamReader reader = new InputStreamReader(socket.getInputStream(), "UTF-8");
			OutputStream writer = socket.getOutputStream();
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line = null;
			StringBuffer stringBuffer = new StringBuffer();
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				String[] command = line.split(",");
				if (helper(command, sql) == 1) {
					writer.write((command[0] + " successful\n").getBytes());
					System.out.println("send message to client:" + command[0] + " successful");
				} else {

					writer.write((command[0] + " failed\n").getBytes());
					System.out.println("send message to client:" + command[0] + " failed");
				}
				// stringBuffer.append(line);
			}

		}

	}

}
