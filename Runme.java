import java.util.ArrayList;
import java.util.Scanner;

public class Runme {
    static void run(){
    Scanner sc= new Scanner(System.in);

    String custom= new String();
    int merDistribution=0;
    int raisedto=0;

    ArrayList<Float> h1 = new ArrayList<Float>();
    ArrayList<Float> h2 = new ArrayList<Float>();
    ArrayList<Float> bst = new ArrayList<Float>();

    System.out.print("[1] General Testing | [2] Binary Search Tree: ");
    if(sc.nextInt() == 2){
        BST.BST.runBST();
    }
    else{

    System.out.print("Enter desired value for k or 0 for default value: ");
        int k = sc.nextInt();
        if(k==0){
         k=15;
        }

        System.out.print("[1] Custom Input | [2] Randomized Generated Input: ");
        int ipt = sc.nextInt();
        System.out.println("\nTesting will run total of k = "+ k+" times\n");

        //if custom input
        if(ipt==1){
         System.out.print("Input: ");
         custom = sc.next();
         System.out.println();
         System.out.print("k Value for mer-Distribution: ");
         merDistribution = sc.nextInt();
         System.out.println("\nWorking XXHash32 Function...");
         custominput.run(h1, "xx", k, custom, merDistribution);
         System.out.println("\nWorking MurMurHash3 Function...");
         custominput.run(h2, "mm3", k, custom, merDistribution);
         System.out.println("\nWorking Binary Search Tree Function...");
         custominput.run(bst, "bst", k, custom, merDistribution);

         printcustominput.run("xx", custom, merDistribution);
         printcustominput.run("mm3", custom, merDistribution);
         printcustominput.run("bst", custom, merDistribution);
        }
        
        //if randomized generated input
        if(ipt==2){
         System.out.print("String Length: 10^ ");
         raisedto =sc.nextInt();
         System.out.print("k Value for mer-Distribution: ");
         merDistribution = sc.nextInt();
         System.out.println("\nWorking XXHash32 Function...");
         Runner.run(h1, "xx", k, merDistribution, raisedto); //1=merge 2=bubble
         System.out.println("\nWorking MurMurHash3 Function...");
         Runner.run(h2, "mm3", k, merDistribution, raisedto); //1=merge 2=bubble
         System.out.println("\nWorking Binary Search Tree Function...");
         Runner.run(bst, "bst", k, merDistribution, raisedto);
        }

        //prints out average running times
        if(ipt==1){
         System.out.println("\nAverage Running Times | n = " + custom.length()+" | k = "+merDistribution+":");
         System.out.println("------------------------------------------");
         System.out.printf("%s %8s %8s\n", "XXHash32:","MurMurHash3:","Binary Search Tree:");
         System.out.printf("%.3fms %7.3fms %10.3fms\n",h1.get(0),h2.get(0), bst.get(0)); 
         System.out.println("\nHashing Functions Number of Collisions ");
         System.out.println("--------------------------------------");
         System.out.printf("%s %7s \n","XXHash32:","MurMurHash3:");
         System.out.printf("%-1.0f %9.0f\n",h1.get(1),h2.get(1)); 
         System.exit(0);
        }

        if(ipt==2){
         System.out.println("\nAverage Running Times | n = 10^"+raisedto+" | k = "+merDistribution+":");
         System.out.println("------------------------------------------");
         System.out.printf("%s %8s %8s\n", "XXHash32:","MurMurHash3:", "Binary Search Tree:");
         
        System.out.printf("%.3fms %7.3fms %11.3fms\n",h1.get(0),h2.get(0),bst.get(0));
         
         System.out.println("\nHashing Functions Average Collisions ");
         System.out.println("------------------------------------");
         System.out.printf("%s %7s \n","XXHash32:","MurMurHash3:"); 
         
        System.out.printf("%-1.0f %9.0f\n",h1.get(1),h2.get(1));
         
        }  
    sc.close();
    }
}
}
