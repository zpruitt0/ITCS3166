import java.util.Map;

public class IPRouter {
	
	private String address;
	private Map <String, String> rTable;
	private int [] octets;
        private String [] binCon;//For array of each octet coverted to binary
	
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

	
        public int[] getOctets(){
            
            return octets;
            
        }
        
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
	
        //Convert IP address to binary 
        public void convertOctetsToBinary(int[] old){
            
            binCon = new String[4];//For convert to binary
            
            for(int i = 0; i< old.length; i++){
                
               binCon[i] = changeToBinary(old[i])+"";
               
               //System.out.println(binCon[i]);- check to see it works
                
            }//End for loop for iterating through binary array
               
        }//End convertOctetsToBinary
        
        public String changeToBinary(int octet){
            
            String temp = "";
            String bin = "";
            boolean cont = true;
            
           //Use while loop to make a sequence of binary digits 
           while(cont){
               
            if((octet%2 == 0 || octet%2 == 1) && octet != 0){
               
                 temp += (octet%2+"");
                 octet=octet/2;
               
            }else{
               
                 cont=false;
               
            }//End logic chain
            
           }//End while
           
           //Reverse binary digits to accurately represent binary conversion
           for(int i = temp.length()-1; i >= 0; i--){
               
               bin+= temp.charAt(i)+"";
               
           }//End reverse string for loop
           
           return bin;
            
        }//End changeToBinary
        
}
