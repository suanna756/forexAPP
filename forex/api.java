package forex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.print.DocFlavor.STRING;
import javax.swing.text.StyledEditorKit.ForegroundAction;
/* the api documentation: https://www.alphavantage.co/documentation/ **/


public class api {
	public static String getforexRate(String type) throws IOException {
		String url = "https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency="
				+ type.substring(0, 3) + "&to_currency=" + type.substring(3, 6) + "&apikey=ZP6SWN37QBLNACU5";
		URL realURL = new URL(url);
		URLConnection connection = realURL.openConnection();
		connection.connect();

		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line;
		StringBuffer stringBuffer = new StringBuffer();
		while ((line = in.readLine()) != null) {
		 System.out.println(line);
			stringBuffer.append(line);

		}
		String[] lines = stringBuffer.toString().split("        ");
		// System.out.println("\n"+lines[4]);
		// return lines[5];
		String[] lines1 = lines[5].split("\"");
		// for(String s:lines1)
		// System.out.println(s);
		return lines1[3];

	}

	public String getdigitCurrency(String type) throws IOException {
		String url = "https://www.alphavantage.co/query?function=DIGITAL_CURRENCY_INTRADAY&symbol=" + type.substring(0, 3)
				+ "&market=" + type.substring(3, 6) + "&apikey=ZP6SWN37QBLNACU5";
		URL realURL = new URL(url);
		URLConnection connection = realURL.openConnection();
		connection.connect();

		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line;
		StringBuffer stringBuffer = new StringBuffer();
		while ((line = in.readLine()) != null) {
			//System.out.print(line);
			stringBuffer.append(line);

		}
		String[] strings=stringBuffer.toString().split("            ");
		//for(String s:strings)
		//	System.out.println(s);
		/*get price:        1a. price (USD)": "6588.42101692",         */
		for(int i=1;i<strings.length;i+=4)
			System.out.println(strings[i]);
		return "";
	}

	/*
	 * public static void main(String[] args) throws IOException { String url=
	 * "https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=USD&to_currency=GBP&apikey=ZP6SWN37QBLNACU5"
	 * /*or u follow demo
	 */;
	/*
	 * avaliable :{ "Realtime Currency Exchange Rate": { "1. From_Currency Code":
	 * "USD", "2. From_Currency Name": "United States Dollar",
	 * "3. To_Currency Code": "JPY", "4. To_Currency Name": "Japanese Yen",
	 * "5. Exchange Rate": "109.88687500", "6. Last Refreshed":
	 * "2018-06-27 10:18:22", "7. Time Zone": "UTC" }}
	 */

	/* url for stock */
	// String
	// url="https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=MSFT&interval=1min&apikey=demo";

	/* url for index */
	// String
	// url="https://www.alphavantage.co/query?function=SMA&symbol=MSFT&interval=15min&time_period=10&series_type=close&apikey=d6966f7fcd2147e96fbab3bda69a638f";
	/*
	 * URL realURL=new URL(url); URLConnection connection=realURL.openConnection();
	 * connection.connect();
	 * 
	 * BufferedReader in=new BufferedReader(new
	 * InputStreamReader(connection.getInputStream())); String line; StringBuffer
	 * stringBuffer=new StringBuffer(); while ((line=in.readLine())!=null) {
	 * System.out.print(line); stringBuffer.append(line);
	 * 
	 * } String[] lines=stringBuffer.toString().split("        "); for (String
	 * s:lines) { System.out.println(s);}
	 * 
	 * 
	 * in.close();
	 * 
	 * 
	 * }
	 */

}
