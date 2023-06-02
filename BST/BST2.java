package BST;

public class BST2 {

//1: create, 3: insert (input string and int k), 5: k-mer distribution, 4:destroy
    public static void runBST2(String dna, int kmer){
        int i;
        int number; // initialize k
        String holderString = dna; // initialize string before running
        NodeKmer root;

        // create binary tree
        root=new NodeKmer();
        
        number = kmer;
        
        for (i = 0; i < holderString.length() - number + 1; i++) {
            root.insertKmer(root, holderString.substring(i, i + number));
        }
        
        // print kmer distribution
        // root.kmerKmer(root);
  
       
}

}
