import java.util.Map;

public class IPRouter {
	
	private String address;
	private Map <String, String> rTable;
	private int [] octets;
    private String [] binCon;//For array of each octet coverted to binary
	
	public IPRouter(String inAdd, Map<String,String> inRTable)
	{
		address = inAdd;
		rTable = inRTable;
		octets = new int [4];	 
	}
	
	//Utilizes setOctets because those things should only change when a new address
	//is entered in the byte.byte.byte.byte String format
	public void setAddress(String inAdd)
	{
		address = inAdd;
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
        
    //may not be needed////////////////////////////////////////////////vv
	private void setMask(String inAdd)
	{
		int mask;
		mask = Integer.parseInt(inAdd.substring(inAdd.length()-(inAdd.length()-inAdd.indexOf("/")-1)));
	}
	///////////////////////////////////////////////////////////////////^^
	
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
    
    //Parsing routing table to get the destination IP addresses and masks. converts mask to appropriate binary. AND with input IP address.
    public void getRoutingData()
        {
    	//gets masks from each key value in the routing table
    	int [] tableMasks = new int [3];
    	
    	int i = 2;;
        	for(String key : rTable.keySet())
        	{
        		if(key.contains("."))
        		{
        			tableMasks[i] = Integer.parseInt(key.substring(key.length()-(key.length()-key.indexOf("/")-1)));
        			i--;
        		}
        	}
        //gets destination ip addresses in the routing table without the masks attached to them
        String [] tableIPs = new String[3];	
    	i = 2;;
    	for(String key : rTable.keySet())
    	{
    		if(key.contains("."))
    		{
    			tableIPs[i] = key.substring(0, key.indexOf("/"));
    			i--;
    		}
    	}
    	
    	
        
    	//testing gettings masks and ip addresses
    	//for(int j = 0; j<tableIPs.length;j++)
    	//{
    	//System.out.println("Table IP : "+tableIPs[j]+" has mask of " + tableMasks[j]);
    	//}
    	String [] dottedMaskBins = new String[3];
    	String maskToBinary = "";
    	
    	for(int placeInTableMasks = 0;placeInTableMasks < dottedMaskBins.length; placeInTableMasks++)
    	{
    		///outer loop goes through placeInTableMasks, the overall table where all masks are stored
    		//inner loop goes through every character in the string
    		for(int in = 0; in < 35;in++)
    		{
    			if(in<tableMasks[placeInTableMasks]) 
    			{
	    			if(in==8 || in == 17 || in == 26)
	    			{
	    				maskToBinary = maskToBinary+".";
	    			}
	    			else
	    			{
	    				maskToBinary = maskToBinary+"1";
	    			}
    			}
    			else
    			{
	    			if(in%8==0&&in!=32)
	    			{
	    				maskToBinary = maskToBinary+".";
	    			}
	    			else
	    			{
	        			maskToBinary = maskToBinary+"0";
	    			}
    			}
    			
    		}//end inner for loop
    		dottedMaskBins[placeInTableMasks] = maskToBinary;
    		System.out.println(dottedMaskBins[placeInTableMasks]);//////////////////////////////////////////////test println statement
    		maskToBinary = "";
    		
    	}
    	
    	
        }///////end of getRoutingData        
       
}/////end of class
