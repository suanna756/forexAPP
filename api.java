package forex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class api {
	
	
	public static void main(String[] args) throws IOException {
	//	String url="https://data.fixer.io/api/latest?access_key=d6966f7fcd2147e96fbab3bda69a638f";
		
	String url="https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=USD&to_currency=JPY&apikey=ZP6SWN37QBLNACU5"/*or u follow demo*/;
	/*avaliable :{    "Realtime Currency Exchange Rate": {      
	 *"1. From_Currency Code": "USD",     
	 *"2. From_Currency Name": "United States Dollar",      
	 *"3. To_Currency Code": "JPY",      
	 *"4. To_Currency Name": "Japanese Yen",    
	 *"5. Exchange Rate": "109.88687500",  
	 *"6. Last Refreshed": "2018-06-27 10:18:22",    
	 *"7. Time Zone": "UTC"  
	 *  }}*/
		URL realURL=new URL(url);
		URLConnection connection=realURL.openConnection();
		connection.connect();
		
		BufferedReader in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
	String line;
		while ((line=in.readLine())!=null) {
		System.out.print(line);
			
		}
		in.close();
		
		
	}
}
