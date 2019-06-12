import java.util.Map;

public class IPRouter {
	
	private String address;
	private int mask;
	private Map <String, String> rTable;
	private int [] octets;
	
	public IPRouter(String inAdd, Map<String,String> inRTable)
	{
		address = inAdd;
		rTable = inRTable;
		mask = Integer.parseInt(inAdd.substring(inAdd.length()-2));
		octets = new int [4];		
	}
	
	public void setAddress(String inAdd)
	{
		setMask(inAdd);
		address = inAdd.substring(0, inAdd.length()-3);
		setOctets(address);
	}
	
	public void setOctets(String inAdd)
	{
		String [] strOctets= inAdd.split("[.]");	
		for(int i = 0; i < strOctets.length; i++) 
		{
			octets[i] = Integer.parseInt(strOctets[i]);
		}
	}

	
	public void setMask(String inAdd)
	{
		mask = Integer.parseInt(address.substring(address.length()-2));
	}
	
	//needs to be done
	//public int [] conversion()
	//{
	/*
	 * Hint: the IP addresses first need to be converted to binary in order to extract and compare the network part . see sample IP address conversion here:
	 * https://webpages.uncc.edu/aatzache/ITCS3166/ExerciseD.doc
	 */
		
	//return 0;
	//}
	
}
