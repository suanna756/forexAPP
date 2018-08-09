package forex;

import java.io.IOException;
import java.net.ConnectException;
import java.sql.*;

public class databaseForex {

	static Connection connect;

	public static void getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("the mysql driver has been load successfully");
		String url = "jdbc:mysql://localhost:3306/finan?autoReconnect=true&useSSL=false";
		connect = DriverManager.getConnection(url, "root", "su501233977");
		System.out.println("connected to the database successfully");
	}

	public static void close() throws SQLException {
		connect.close();
		System.out.print("the database conenction has been closed");
	}

	public static void input(api a) throws IOException {
		System.out.print(a.getforexRate("USDGBP"));

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		api a = new api();
		// getConnection();
		//input(a);
		// a.getdigitCurrency("BTCUSD");
		String price=a.getforexRate("GBPUSD");
		System.out.print("\n"+"price: "+price);
		
		
	}
}
