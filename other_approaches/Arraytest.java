import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Arraytest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	ArrayList<Integer> row;
	ArrayList<Integer> column;
	ArrayList<Integer> data;
	BufferedWriter bw;
	
	public  void code() throws IOException {
		// TODO Auto-generated method stub
		File f1,f2,f3;
		f1= new File("training.txt");
		f3=new File("label_training.txt");
		f2=new File("t.csv");
		f2.createNewFile();
		FileReader fr=new FileReader(f1);
		FileWriter fw=new FileWriter(f2);
		FileReader fr1=new FileReader(f3);

		BufferedWriter bw=new BufferedWriter(fw);
		BufferedReader br=new BufferedReader(fr);
		//BufferedReader br1=new BufferedReader(fr1);
 row=new ArrayList<Integer>();
 column=new ArrayList<Integer>();
 data=new ArrayList<Integer>();
for(int i=0;i<2534102;i++)
		{
	System.out.println(i);
	int r=0,c=0,d=0;
	String s=br.readLine();
	String[] Stringarr=s.split(" ");
      r=Integer.parseInt(Stringarr[0]);
      c=Integer.parseInt(Stringarr[1]);
      d=Integer.parseInt(Stringarr[2]);
      row.add(r);
      column.add(c);
      data.add(d);
      }//this.sort(0,2534101);
	//a.add(i);
		}}
