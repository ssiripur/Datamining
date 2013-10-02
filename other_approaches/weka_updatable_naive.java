import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ArffLoader;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayesMultinomialUpdateable;
import weka.classifiers.bayes.NaiveBayesUpdateable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * This example trains NaiveBayes incrementally on data obtained
 * from the ArffLoader.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 */
public class weka_updatable_naive {

  /**
   * Expects an ARFF file as first argument (class attribute is assumed
   * to be the last attribute).
   *
   * @param args        the commandline arguments
   * @throws Exception  if something goes wrong
   */
  public static void main(String[] args) throws Exception {
    // load data
	  File f=new File("outptnm_update.txt");
	  FileWriter fw=new FileWriter(f);
	  BufferedWriter bw=new BufferedWriter(fw);
    ArffLoader loader = new ArffLoader();
    loader.setFile(new File("train1.arff"));
    Instances structure = loader.getStructure();
    structure.setClassIndex(structure.numAttributes() - 1);

    // train NaiveBayes
   // NaiveBayesUpdateable nb = new NaiveBayesUpdateable();
    NaiveBayesMultinomialUpdateable nmb=new NaiveBayesMultinomialUpdateable();
   // nb.setUseKernelEstimator(true);
   // nb.buildClassifier(structure);
    nmb.buildClassifier(structure);
    
    Instance current;
    int count=0;
    while ((current = loader.getNextInstance(structure)) != null)
    {
    	System.out.println(count);
    	count++;
      //nb.updateClassifier(current);
    	nmb.updateClassifier(current);
    }
    // output generated model
    
    count=0;
    
    ArffLoader loader1 = new ArffLoader();
    loader1.setFile(new File("testm.arff"));
    Instances structure1 = loader1.getStructure();
    structure1.setClassIndex(structure1.numAttributes() - 1);
  
    Instance cur;
    while((cur = loader1.getNextInstance(structure1))!= null){
   
  // double lab= nb.classifyInstance(cur);
   double lab= nmb.classifyInstance(cur);
   int lab1=(int)lab;
   lab1++;
   bw.write(lab1+"");
   bw.newLine();
   count++;
   System.out.println(count +"output"+ lab);
    }
    
    
    
//    Instances Unlabeled= new Instances(new BufferedReader(new FileReader("input2.txt")));
//    Unlabeled.setClassIndex(Unlabeled.numAttributes()-1);
//    Instances labeled = new Instances(Unlabeled);
//    for(int i=0; i< Unlabeled.numInstances(); i++){
//    double predictedlabel = nb.classifyInstance(Unlabeled.instance(i));
//    System.out.println(predictedlabel);
    	bw.close();
    }
    }
    

    
  

