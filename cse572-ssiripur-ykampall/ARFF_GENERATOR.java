import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;


public class ARFF_GENERATOR {
	
		public static void main(String[] args) throws IOException, InterruptedException
		{
			
			File f1,f2,f3;
			int end_feature=108532;//
			f1=new File("training.txt");
		//	f3=new File(".txt");
			f2=new File("train1.arff");
			f3=new File("label_training.txt");
			f2.createNewFile();
			FileReader fr1,fr2;
			fr1=new FileReader(f1);
			fr2=new FileReader(f3);
			FileWriter fw=new FileWriter(f2);
			BufferedReader br1,br2;
			br1=new BufferedReader(fr1);
			br2=new BufferedReader(fr2);
			BufferedWriter bw=new BufferedWriter(fw);
			try{
				bw.write("@RELATION DATASET");
				bw.newLine();
				
			for(int j=1;j<end_feature+1;j++)
			{
				bw.write("@ATTRIBUTE field_"+j+"   "+"NUMERIC");
				bw.newLine();
			}
			bw.write("@ATTRIBUTE class       {");
			bw.write("1");
			for(int j=2;j<21;j++)
			{
				bw.write(",");
				bw.write(""+j);
			}
			bw.write("}");
			bw.newLine();
			bw.write("@DATA");
			int last=1;
			TreeMap<Integer,Integer>data=new TreeMap<Integer,Integer>() ;
			for(int j=0;j<2534102;j++)//1734532,2534102
			{
		//	if(last<3002){
				System.out.println("output file"+j);
				System.out.println();
				String s=br1.readLine();
				String[] st=(s).split(" ");
	            int rowID=Integer.parseInt(st[0]);
	            int colID=Integer.parseInt(st[1]);
	            int dat=Integer.parseInt(st[2]);
	            if(last!=rowID)
	            {
	            	System.out.println("writing started");
	            	Set<Integer> s1=data.keySet();
	            	Iterator<Integer> itera=s1.iterator();
	            	bw.newLine();
			
	            	for(int k=1;k<108533;k++)//108532
	                {
	                	if(data.containsKey(k))
	                	{
	                		bw.write(data.get(k)+",");
	                	}
	                	else
	                	{
	                		bw.write("0"+",");
	                	}
	                }
	                 bw.write(br2.readLine());	
	            	data=new TreeMap<Integer,Integer>();
	            	
	            	data.put(colID,dat);
		         }
	            
	            else
	            {
	            	data.put(colID,dat);
	            }
	            last=rowID;
			//}
			}
			
			System.out.println("writing started");
	    	Set<Integer> s1=data.keySet();
	    	Iterator<Integer> itera=s1.iterator();
	    	bw.newLine();
	    	for(int k=1;k<108533;k++)//108532
	        {
	        	if(data.containsKey(k))
	        	{
	        		bw.write(data.get(k)+",");
	        	}
	        	else
	        	{
	        		bw.write("0"+",");
	        	}
	        }
	    	bw.write(br2.readLine());	
		}
finally
{

		bw.close();
		br2.close();
		br1.close();}
		}


}
