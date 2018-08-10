package forex;

import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class mysql {
	String url;
	String user;
	String password;
	Connection connection;

	public mysql() throws Exception {

		// set the url pointing to the database u want to use(finan in here)
		url = "jdbc:mysql://localhost:3306/Finan?autoReconnect=true&useSSL=false";
		// set the user name
		user = "root";
		// set the password
		password = "?????";
		this.connect(url, user, password);
	}

	public void connect(String url, String user, String password) throws Exception {

		Connection connection;
		// set the driver
		String driver = "com.mysql.cj.jdbc.Driver";
		// make the driver work
		Class.forName(driver);
		connection = DriverManager.getConnection(url, user, password);
		System.out.println("conencted to the mysql");
		this.connection = connection;
	}

	public int login(String[] userdata) throws SQLException {
		// System.out.println("______________");
		Statement s = this.connection.createStatement();
		String command = "select password from user where name = \"" + userdata[1] + "\"";
		ResultSet resultSet = s.executeQuery(command);
		// get the .next() is important, it make the pointer moves to the next place,
		// so that u can get sth
		while (resultSet.next()) {
			String string = resultSet.getString("password");
			if (string.equals(userdata[2])) {
				System.out.println("mysql get:" + string);
				return 1;
			}
		}
		return 0;
	}

	public int register(String[] userdata) throws SQLException {
		/*
		 * Statement s=this.connection.createStatement(); String
		 * command=String.format("select count(*) from user where name = \'%s\'"
		 * ,userdata[1]); ResultSet r=s.executeQuery(command); if(r.next()) { //if the
		 * username isn't exists yet,then u can insert the user into mysql int count=1;
		 * ResultSet result=s.executeQuery("select count(*) from user");
		 * while(result.next()) { count=result.getInt("count(*)"); count++; }
		 * s.executeUpdate(String.format("insert into user values(%d,%s,%s)",count,
		 * userdata[1],userdata[2])); System.out.println("try"); return 1;
		 * 
		 * }
		 * 
		 * 
		 * 
		 * 
		 * else{ System.out.print("user already exists"); return 0; }
		 **/
		String command = String.format("select count(*) from user where name = \'%s\'", userdata[1]);
		Statement s = this.connection.createStatement();
		ResultSet r = s.executeQuery(command);
		r.next();
		int count0 = r.getInt("count(*)");
		// System.out.println(count0);
		if (count0 == 0) {
			// TODO: handle exception
			// if the username isn't exists yet,then u can insert the user into mysql
			int count = 1;
			ResultSet result = s.executeQuery("select count(*) from user");
			while (result.next()) {
				count = result.getInt("count(*)");
				count++;
				System.out.println(count);
				s.executeUpdate(
						String.format("insert into user values(%d,\"%s\",\"%s\")", count, userdata[1], userdata[2]));
				// System.out.println("try");
				return 1;
			}

		}
		System.out.print("user already exists");
		return 0;
	}
}
