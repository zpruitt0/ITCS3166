import java.util.Map;

public class IPRouter {
	
	private String address;
	private Map <String, String> rTable;
	private int [] octets;
	
	public IPRouter(String inAdd, Map<String,String> inRTable)
	{
		address = inAdd.substring(0, inAdd.length());
		rTable = inRTable;
		octets = new int [4];		
	}
	
	//Utilizes setOctets because those things should only change when a new address
	//is entered in the byte.byte.byte.byte String format
	public void setAddress(String inAdd)
	{
		address = inAdd.substring(0, inAdd.length());
		setOctets(address);
	}
	
	private void setOctets(String inAdd)
	{
		String [] strOctets= inAdd.split("[.]");	
		for(int i = 0; i < strOctets.length; i++) 
		{
			octets[i] = Integer.parseInt(strOctets[i]);
		}
	}

	//may not be needed
	private void setMask(String inAdd)
	{
		int mask;
		mask = Integer.parseInt(inAdd.substring(inAdd.length()-(inAdd.length()-inAdd.indexOf("/")-1)));
	}
	
	@Override
	public String toString()
	{
		String result = "Address: " + address;
		return result;
	}
	

	
}
