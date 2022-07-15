package ServicesImpl;

import java.util.*;
import java.io.*;
import CustomExceptions.*;
import Services.serviceinter;

public class serviceImpl implements serviceinter
{
	public void fileread(File f,String str, HashSet<String> hs) throws UnbalancedParanthesisException, FileNameMisMatchException, KeywordsException, IOException {
		@SuppressWarnings("resource")
		BufferedReader br1 =new BufferedReader(new FileReader(f));
		@SuppressWarnings("resource")
		BufferedReader br2 =new BufferedReader(new FileReader(f));
    	String s;
    	String temp[];
    	String fname=f.getName();
    	boolean cb=false;
    	boolean fm=false;
    	boolean kw1=true;
    	boolean kw2=true;
    	int opbrace=0; 
    	int clobrace=0;
    	while((s=br1.readLine())!=null) 
    	{
    			temp = s.split(" ");
    				for(int i=0;i<temp.length;i++)
    				{
    					if(temp[i].equals("{"))
    						opbrace++;
    					if(temp[i].equals("}"))
    						clobrace++;
    					if(temp[i].equals("String") ) 
    					{	
    						if(hs.contains(temp[i+1])) 
    						{
    							kw2=false;
    							throw new KeywordsException("Arguments of main should not be a keyword ");
    						}
    					}
    					if(temp[i].equals("class"))
    					{
    						if(hs.contains(temp[i+1])) {
    							kw1=false;
    							throw new KeywordsException("Class name should not be keyword ");
    						}
    						if(temp[i+1].equals(fname.substring(0,fname.length()-5 )))
    						{
    							
    							fm=true;
    						}
    						else
    							throw new FileNameMisMatchException("Filename and class name are not matched");
    					}				
    				}
    	}
    	
    	if(opbrace==clobrace) 
    	{
    		
    		cb=true;
    	}
    	else
    	{
    		throw new UnbalancedParanthesisException("Paranthesis are not matched");
    	}
   
		if(cb && fm && kw1 && kw2)
		{
			System.out.println("->Filename and classname matched");
			System.out.println("->Paranthesis matched");
			System.out.println("->Keywords check Done");
			System.out.println("");
			try {
				while((s=br2.readLine())!=null) 
				{
					System.out.println(s); 
					
				}
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}	
			fiwrite(str);
		}
		br1.close();
		br2.close();
		}
	    public void filewrite(String str) throws IOException 
	    {
	  		BufferedWriter fw1 = new BufferedWriter(new FileWriter("C:\\Users\\tkukkala\\Desktop\\sample1.java"));
	  		fw1.write(str);
	  		fw1.close();
	  	}
	    
	    public void fiwrite(String str) throws IOException 
	    {
	  		BufferedWriter fw2 = new BufferedWriter(new FileWriter("C:\\Users\\tkukkala\\Desktop\\sample2.java"));
	  		fw2.write(str);
	  		fw2.close();
	  		System.out.println("\n->Program copied to another file");
	  	}

}
