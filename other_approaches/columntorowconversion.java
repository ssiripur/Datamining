

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;


public class columntorowconversion {
	ArrayList<Integer> rowdata;
	TreeMap<Integer,ArrayList<Integer>> tm=new TreeMap<Integer,ArrayList<Integer>>();
	HashSet<String> hs=new HashSet<String>();
public  void code() throws IOException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		File f1,f2,f3,f4,f5,f6,f7,f8;
		int end_feature=45532;
		f8=new File("final_test_data.txt");
		f1= new File("TUnique_colwise.txt");
    	f3=new File("label_training.txt");
    	
		f2=new File("TUnique_rowwise.txt");
		f3=new File("rwuniuecol.txt");
		f4=new File("duprow.txt");
		f5=new File("label_training.txt");
		f6=new File("final_output_weka_input.arff");
		f7=new File("");
		f2.createNewFile();
		f3.createNewFile();
		f4.createNewFile();
		f6.createNewFile();
		FileReader fr=new FileReader(f1);
		FileWriter fw=new FileWriter(f2);
		FileWriter fw1=new FileWriter(f3);
		FileWriter fw2=new FileWriter(f4);
		FileReader frar=new FileReader(f5);
		FileWriter fwar=new FileWriter(f6);
		
		

		BufferedWriter bw=new BufferedWriter(fw);
		BufferedWriter bw1=new BufferedWriter(fw1);
		BufferedWriter bw2=new BufferedWriter(fw2);
		BufferedWriter bwar=new BufferedWriter(fwar);
		BufferedReader br=new BufferedReader(fr);
		BufferedReader brar=new BufferedReader(frar);
		//int count=0;
		bwar.write("@RELATION DATASET");
		bwar.newLine();
		for(int i=1;i<end_feature+1;i++)
		{
			bwar.write("@ATTRIBUTE field_"+i+"   "+"NUMERIC");
			bwar.newLine();
		}
		bwar.write("@ATTRIBUTE class       {");
		bwar.write("1");
		for(int j=2;j<21;j++)
		{
			bwar.write(",");
			bwar.write(""+j);
		}
		bwar.write("}");
		bwar.newLine();
		bwar.write("@DATA");
		bwar.newLine();
		
		
		
		
		
		
		for(int i=0;i<1429558;i++)//2534102
		{
			System.out.println("interation count:"+i);
			String[]sr=(br.readLine()).split(" ");
			int row=Integer.parseInt(sr[0]);
			int col=Integer.parseInt(sr[1]);
			int dat=Integer.parseInt(sr[2]);
			if(tm.containsKey(col))
			{
				ArrayList<Integer> p=tm.remove(col);
				p.add(row);
				p.add(dat);
				tm.put(col, p);
			}
			else
			{
				ArrayList<Integer> p=new ArrayList<Integer>();
				p.add(row);
				p.add(dat);
				tm.put(col, p);
			}
				
		}
		Set<Integer> s=tm.keySet();
		//Iterator iter=s.iterator();
		java.util.Iterator<Integer> it=s.iterator();
		int count=0;
		int linecount=0;
		
		while(it.hasNext()&&(linecount!=1000))
		{
			
			int i=it.next();
			linecount++;
			System.out.println("column selected is:"+i);
		    //StringBuilder sb=new StringBuilder();
		    ArrayList<Integer> th=tm.get(i);
//		   for(int j=0;j<th.size();j++)
//		   {
//			   StringBuilder sb=new StringBuilder();
//			   sb.append(i);
//			   sb.append(" ");
//			   sb.append(th.get(j));
//			   sb.append(" ");
//			   j++;
//			   sb.append(th.get(j));
//			   bw.write(sb.toString());
//			   bw.newLine();
//		   }
//		   StringBuilder sb1=new StringBuilder();
//		   for(int j=0;j<th.size();j++)
//		   {
//			   sb1.append(th.get(j));
//		   }
//		   String p=sb1.toString();
//		   MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
//			messageDigest.update(p.getBytes());
//			String encryptedString = new String(messageDigest.digest());
//			if(hs.contains(encryptedString))
//			{
//				StringBuilder common=new StringBuilder();
//				common.append(i);
//				System.out.println("key already present");
////				bw.write(i);
////				bw.newLine();
//				//count++;
//				bw2.write(common.toString());
//				bw2.newLine();
//			}
//			else
//			{
				StringBuilder unique=new StringBuilder();
				unique.append(i);
				System.out.println("unique column  is:"+i);
				Object StringBuilder;
				bw1.write(unique.toString());
				bw1.newLine();
//				hs.add(encryptedString);
				count++;
				HashMap<Integer,Integer> newline=new HashMap<Integer,Integer>();
				 for(int j=0;j<th.size();j++)
					   {
	                     int col=0,data=0;				 
						   StringBuilder sb=new StringBuilder();
						   sb.append(count);
						   sb.append(" ");
						   col=th.get(j);
						   System.out.println("col ID:"+col);
						   sb.append(th.get(j));
						   sb.append(" ");
						   
						   j++;
						   sb.append(th.get(j));
						   data=th.get(j);
						   System.out.println("data in col is:"+data);
						   bw.write(sb.toString());
						   bw.newLine();
						   newline.put(col,data);
						   if(j==th.size()-1)
						   {
							   System.out.println(sb.toString());
						   }
					   }
				 
				 for(int j=1;j<end_feature+1;j++)
				 {
					 if(newline.containsKey(j))
					 {
						 bwar.write(newline.get(j)+"");
					 }
					 else
					 {
						 bwar.write("?"); 
					 }
					 bwar.write(",");
				 }
				 bwar.write(brar.readLine());
				 bwar.newLine();
				 //bwar.write();
				
	//		}
		    
		}System.out.println("total output would be"+count);
		
		bw.close();
		bw2.close();
		bw1.close();
		br.close();
		bwar.close();
		
		
		
	}
public static  void main(String[] args) throws IOException, NoSuchAlgorithmException
{
	columntorowconversion trs=new columntorowconversion();
	trs.code();
}
}

