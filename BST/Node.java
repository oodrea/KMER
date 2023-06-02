package BST;
import java.util.ArrayList;

/**
 * This class makes new nodes for the binary tree.
 */


public class Node {
    private String value;
    private Node leftChild;
    private Node rightChild;

    /**
     * Constructor for root node.
     */
    public Node(){
        value = null;
        leftChild = null;
        rightChild = null;
    }

    /**
     * Constructor for children nodes.
     * @param value is a String passed to create a new node
     */
    public Node(String value){
        this.value = value;
        leftChild = null;
        rightChild = null;
    }

    /**
     * Gets the value in the node.
     * @return value is a String value in the node
     */
    public String getNodeValue(){
            return value;
    }

    /**
     * Inserts a new node. If the root node is null then it sets the value of itself.
     * Otherwise, it compares the key to the node's value and traverses until it finds a child node that is empty.
     * @param node is the current Node being checked
     * @param insertedString is the String to be inserted into the binary tree
     */
    public void insert(Node node, String insertedString){
        // if null, then insert

        if (value == null)
           value = insertedString;
        else if(node.getNodeValue().compareTo(insertedString) <= 0) {
            if (node.leftChild == null) {
                node.leftChild = new Node(insertedString);
            }
            else
                insert(node.leftChild, insertedString);
        }

        // if not null, call this method again, check current value to either traverse to left/right child
        else if(node.getNodeValue().compareTo(insertedString) > 0){
            if (node.rightChild == null){
                node.rightChild = new Node(insertedString);
            }
            else
                insert(node.rightChild, insertedString);
        }

        }



    /**
     * Using the key, this method traverses through the binary tree by comparing the key to the node's value.
     * Searching is executed until it reaches to a leaf node, or it has found a matching value for the key.
     * @param node is the current Node being checked
     * @param key is a String to be found in the binary tree
     * @return 0 if not found, 1 if found
     */
    public int search(Node node, String key) {
        if (node == null)
           return 0;
            // if key exists, then return 1
        else if (node.getNodeValue().compareTo(key) == 0)
            return 1;

            // if not null, then call this method again, check current value to either traverse to left/right child
        else {
            if (node.getNodeValue().compareTo(key) <= 0) {
                if (node.leftChild == null) {
                    return 0;
                } else {
                    return search(node.leftChild, key);
                }

            } else {
                if (node.rightChild == null) {
                    return 0;
                } else {
                    return search(node.rightChild, key);
                }

            }
        }
    }

    /**
     * Deletes all the nodes in the binary tree.
     * @param node is the current Node being traversed
     */
    public void destroy(Node node){

        if (node != null) {
            destroy(node.leftChild);
            destroy(node.rightChild);
            node.setValue(null);
        }

    }

    /**
     * Sets the value of the node.
     * @param value is the String to be passed to set the node's value
     */
    public void setValue(String value){
        this.value = value;
    }

    /**
     * Computes for kmer distribution.
     * @param node is the current Node being traversed
     * @param KmerDist is the array list to store the kmer values in
     */
    public void kmer(Node node, ArrayList<Kmer> KmerDist){

        if(node != null){
            int isFound=0;
            int i;

            // for first node
            if(KmerDist.size() == 0)
                KmerDist.add(new Kmer(node.getNodeValue()));

            // for subsequent nodes, checks if there is the same string in the kmer distribution
            else {
                for (i = 0; (i < KmerDist.size()) && (isFound == 0); i++)
                {
                    if (node.getNodeValue().compareTo(KmerDist.get(i).getDNA()) == 0) {
                        isFound = 1;
                        KmerDist.get(i).setOccurrence();
                    }

                }
                // if not found
                if (isFound == 0) {
                    KmerDist.add(new Kmer(node.getNodeValue()));
                }
            }
            kmer(node.leftChild, KmerDist);
            kmer(node.rightChild, KmerDist);
        }

    }
}