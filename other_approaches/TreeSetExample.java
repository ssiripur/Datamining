import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;


public class TreeSetExample {
	ArrayList<Integer> rowdata;
	TreeMap<Integer,ArrayList<Integer>> tm=new TreeMap<Integer,ArrayList<Integer>>();
	HashSet<String> hs=new HashSet<String>();
public  void code() throws IOException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		File f1,f2,f3,f4;
		f1= new File("training.txt");
//		f3=new File("label_training.txt");
		f2=new File("TUnique_colwise.txt");
		f3=new File("uniquerowId.txt");
		f4=new File("duplrowId.txt");
		f2.createNewFile();
		f3.createNewFile();
		f4.createNewFile();
		FileReader fr=new FileReader(f1);
		FileWriter fw=new FileWriter(f2);
		FileWriter fw1=new FileWriter(f3);
		FileWriter fw2=new FileWriter(f4);
	//	FileReader fr1=new FileReader(f3);

		BufferedWriter bw=new BufferedWriter(fw);
		BufferedWriter bw1=new BufferedWriter(fw1);
		BufferedWriter bw2=new BufferedWriter(fw2);
		BufferedReader br=new BufferedReader(fr);
		//int count=0;
		for(int i=0;i<2534102;i++)//2534102
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
		try
		{
			
		
		while(it.hasNext())
		{
			int i=it.next();
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
		   StringBuilder sb1=new StringBuilder();
		   for(int j=0;j<th.size();j++)
		   {
			   sb1.append(th.get(j));
		   }
		   String p=sb1.toString();
		   MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(p.getBytes());
			String encryptedString = new String(messageDigest.digest());
			if(hs.contains(encryptedString))
			{
				StringBuilder common=new StringBuilder();
				common.append(i);
				System.out.println("key already present");
//				bw.write(i);
//				bw.newLine();
				//count++;
				bw2.write(common.toString());
				bw2.newLine();
			}
			else
			{
				StringBuilder unique=new StringBuilder();
				unique.append(i);
				System.out.println("unique column  is:"+i);
				Object StringBuilder;
				bw1.write(unique.toString());
				bw1.newLine();
				hs.add(encryptedString);
				count++;
				
				 for(int j=0;j<th.size();j++)
					   {
						   StringBuilder sb=new StringBuilder();
						   sb.append(count);
						   sb.append(" ");
						   sb.append(th.get(j));
						   sb.append(" ");
						   j++;
						   sb.append(th.get(j));
						   bw.write(sb.toString());
						   bw.newLine();
						   if(j==th.size()-1)
						   {
							   System.out.println(sb.toString());
						   }
					   }
				
			}
		    
		}System.out.println("total output would be"+count);
		}
		finally{
		bw.close();
		bw2.close();
		bw1.close();
		br.close();
		
		}
		
	}
public static  void main(String[] args) throws IOException, NoSuchAlgorithmException
{
	TreeSetExample trs=new TreeSetExample();
	trs.code();
}
}
