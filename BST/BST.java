package BST;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class BST {


    public static void runBST(){

        int i;
        int select;
        int number;
        String holderString;
        Scanner sc = new Scanner(System.in);
        ArrayList<Kmer> kmerDist = new ArrayList<>();
        Node root = null;
        do {
            System.out.println("(1) create() - creates an empty binary search tree");
            System.out.println("(2) search() - checks if the key inputted is in the tree");
            System.out.println("(3) insert() - adds a new node to the current binary search tree");
            System.out.println("(4) destroy() - deletes the binary tree and all its nodes");
            System.out.println("(5) K-mer distribution");
            System.out.println("(6) Exit");
            select = sc.nextInt();
            switch (select) {
                case 1:
                    if(!Objects.isNull(root))
                        System.out.println("Binary Tree already exists.");
                    else {
                        root=new Node();
                        System.out.println("Binary Tree created.");
                    }
                    break;
                case 2:
                    if(!Objects.isNull(root)) {
                        try {
                            System.out.print("Input a string: ");
                            sc.nextLine();
                            holderString = sc.nextLine();
                            if (root.search(root, holderString) == 1)
                                System.out.println("Key exists");
                            else
                                System.out.println("Key does not exist");
                        } catch (Exception e){
                            System.out.println("Root node has no value.");
                        }
                    }
                    else
                        System.out.println("Error. Binary tree does not exist.");
                    break;
                case 3:
                    if(!Objects.isNull(root)) {
                            System.out.print("Input a string: ");
                            sc.nextLine();
                            holderString = sc.nextLine();

                            System.out.print("Input k: ");
                            number = sc.nextInt();
                            if (number > holderString.length()) {
                                System.out.println("Error. k is greater than the length of the string.");
                            } else {
                                for (i = 0; i < holderString.length() - number + 1; i++) {
                                    root.insert(root, holderString.substring(i, i + number));
                                }
                                System.out.println("Nodes have been created.");
                            }
                        }
                    else
                        System.out.println("Error. Binary tree does not exist.");
                    break;
                case 4:
                    if(!Objects.isNull(root))
                    {
                        root.destroy(root);
                        root = null;
                        System.out.println("Binary tree has been deleted.");
                    }
                    else
                        System.out.println("Error. There's no binary tree to delete.");
                    break;
                case 5:
                    try {
                        if (root.getNodeValue() == null)
                            System.out.println("Root node does not contain any value.");

                        else if (!Objects.isNull(root)) {
                            kmerDist.clear();
                            root.kmer(root, kmerDist);
                            for (i = 0; i < kmerDist.size(); i++) {
                                System.out.println(kmerDist.get(i).getDNA() + ": " + kmerDist.get(i).getOccurrence());
                            }
                        }
                    } catch (Exception e){
                        System.out.println("Error. There's no binary tree.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        } while(select!=6);
    }
}
