import java.util.ArrayList;
import static BST.BST2.runBST2;

public class custominput {
    static void run(ArrayList<Float> results, String type, int k, String strInput, int merDistribution){
        float avg=0;
        float avgcoll=0;

        for(int k1=0; k1<k; k1++){ //k = 15; runs each n for 15 times
            long start = System.currentTimeMillis();  //Initializes start time
            if(type == "xx"){
                HashTable hashTable = new HashTable(strInput.length(), "xx");
                HashTable.createHashTable(strInput, merDistribution, hashTable);
                avgcoll+= hashTable.collisionCounter;
                // hashTable.print();
            }

            else if(type == "mm3"){
                HashTable hashTable = new HashTable(strInput.length(), "mm3");
                HashTable.createHashTable(strInput, merDistribution, hashTable);
                avgcoll+= hashTable.collisionCounter;
                // hashTable.print();
            }

            else if(type == "bst"){
                runBST2(strInput, merDistribution);
            }
            
            long end = System.currentTimeMillis() - start;
            avg+=end; 
        }
        
        //Calculates for Average Running time
        avg/=k; //divides sum of running times by k
        results.add(0, avg);
        avgcoll/=k;
        results.add(1, avgcoll);
    }
}
