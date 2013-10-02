import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class Arff_Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
     File f1=new File("test_unique_row_wise.txt");
     File f2=new File("test_data_arrff.arff");
FileWriter fw=new FileWriter(f2);
BufferedWriter bw=new BufferedWriter(fw);
     FileReader fr=new FileReader(f1);
   BufferedReader br=new BufferedReader(fr);
   String s;
   HashMap<Integer,ArrayList<Integer>> hs=new HashMap<Integer,ArrayList<Integer>>();
 //  ArrayList<Integer> al=new ArrayList<Integer>()   ;
//   s=br.readLine();
//   String[] s1=s.split(" ");
  int  last=-1;
  bw.write("@RELATION DATASET");
//for(int j=1;j<endFeature;j++)
//{
//	bw.write(j+",");
//}
//bw.write("class");
//bw.write("class");
bw.newLine();
//int count2=0;
//int last=0,newest=0;
int lastfeature=1,latest=0;
for(int i=1;i<45533;i++)
{
	bw.write("@ATTRIBUTE field_"+i+"   "+"NUMERIC");
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
bw.newLine();
   while((s=br.readLine())!=null)
   {
	   String[] str=s.split(" ");
	   System.out.println(s);
	   int rowId=Integer.parseInt(str[0]);
	   int colId=Integer.parseInt(str[1]);
	   int data=Integer.parseInt(str[2]);
	   
//	  if(last==-1)
//	  {
//		  ArrayList<Integer> coldata=new ArrayList<Integer>();
//        }
//	  if(last!=Integer.parseInt(str[0]))
//	   {
//	   ArrayList<Integer> coldata=new ArrayList<Integer>();
//	   }
	   if(hs.containsKey(rowId))
			   {
		   ArrayList<Integer> al=hs.get(rowId);
		   al.add(colId);
		   al.add(data);
		 //  hs.put(,al);
		  
			   }
	   else
	   {
		   ArrayList<Integer> al=new ArrayList<Integer>();
		   al.add(colId);
		   al.add(data);
		   hs.put(rowId,al);
	   }
	  
   }
   
   Set<Integer> keys=hs.keySet();
   TreeSet<Integer> tk=new TreeSet(keys);
   Iterator itr=tk.iterator();
   while(itr.hasNext())
   {
	   HashMap<Integer,Integer> row_wise=new HashMap<Integer,Integer>();
	   int a=(int) itr.next();
	  ArrayList<Integer> al= hs.get(a);
	  System.out.println(a);
	  for(int k=0;k<al.size();k++,k++)
	  {
		  row_wise.put(al.get(k),al.get(k+1));
	  }
	  int count=1;
	  while(count!=45533)
	  {
		  
		  if(row_wise.containsKey(count))
		  {
			  bw.write(row_wise.get(count)+",");
			  //bw.write(",");
			  //System.out.print(",");
		  }
		  else
		  {
			  bw.write("?,");
			  //System.out.print("?,");
		  }
			count++;  
	  }
	  bw.write("1");
	  bw.newLine();
//	  System.out.print("1");
//	  System.out.println("tested");
   }
    
   bw.close();
   br.close();
   
     
	}

}
