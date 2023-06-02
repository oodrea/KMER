public class printcustominput {
    static void run(String type, String strInput, int merDistribution){

            if(type == "xx"){
                HashTable hashTable = new HashTable(strInput.length(), "xx");
                HashTable.createHashTable(strInput, merDistribution, hashTable);
        
                hashTable.print();
            }

            else if(type == "mm3"){
                HashTable hashTable = new HashTable(strInput.length(), "mm3");
                HashTable.createHashTable(strInput, merDistribution, hashTable);
        
                hashTable.print();
            }
            
            else if(type=="bst"){
                System.out.println("\nBST: ");
                int i;
                BST.NodeKmer root;

                // create binary tree
                root=new BST.NodeKmer();
                
                for (i = 0; i < strInput.length() - merDistribution + 1; i++) {
                    root.insertKmer(root, strInput.substring(i, i + merDistribution));
                }
                root.kmerKmer(root);
            }
 
            
        }
    
}
