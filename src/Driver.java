import java.util.Map;
import java.util.HashMap;

public class Driver {

	public static void main(String[] args) {

		
	/*
	 * Routing table creation from Chapter 5, Exercise 33:
	 * Address/Mask, Next Hop
	 */
	Map<String,String> rTable = new HashMap<String, String>();	
	rTable.put("135.46.56.0/22", "Interface 0");
	rTable.put("135.46.60.0/22", "Interface 1");
	rTable.put("192.53.40.0/23", "Router 1");
	rTable.put("Default", "Router 2");
	
	//for testing purposes
	String test = "192.46.120.6/22";
	IPRouter router = new IPRouter(test, rTable);
	System.out.println(router.toString());
	router.setAddress("250.250.250.90/8");
	System.out.println(router.toString());
	router.setAddress("0.255.10.90/26");
	System.out.println(router.toString());
	
	}

}
