package BST;

public class NodeKmer {
    private Kmer value;
    private NodeKmer leftChild;
    private NodeKmer rightChild;

    /**
     * Constructor for root node.
     */
    public NodeKmer(){
        value = new Kmer();
        leftChild = null;
        rightChild = null;
    }

    /**
     * Constructor for children nodes.
     * @param value is a String passed to create a new node
     */
    public NodeKmer(String value){
        this.value = new Kmer(value);
        leftChild = null;
        rightChild = null;
    }

    /**
     * Gets the Kmer in the Node
     */
    public Kmer getValue(){
        return value;
    }

    /**
     * Inserts a new node. If the root node is null then it sets the value of itself.
     * Otherwise, it compares the key to the node's value and traverses until it finds a child node that is empty.
     * @param node is the current NodeKmer being checked
     * @param insertedString is the String to be inserted into the binary tree
     */
    public void insertKmer(NodeKmer node, String insertedString){
        // if null, then insert
        if (node.getValue().getDNA() == null) {
            node.getValue().setDNA(insertedString);
            node.getValue().setOccurrence();
        }
        else if(node.getValue().getDNA().compareTo(insertedString) <= 0) {
            if (node.getValue().getDNA().compareTo(insertedString) == 0)
                node.getValue().setOccurrence();
            else if (node.leftChild == null) {
                node.leftChild = new NodeKmer(insertedString);
            }
            else {
                insertKmer(node.leftChild, insertedString);
            }
        }

        // if not null, call this method again, check current value to either traverse to left/right child
        else if(node.getValue().getDNA().compareTo(insertedString) > 0){
            if (node.rightChild == null){
                node.rightChild = new NodeKmer(insertedString);
            }
            else {
                insertKmer(node.rightChild, insertedString);
            }
        }
    }

    /**
     * Using the key, this method traverses through the binary tree by comparing the key to the node's value.
     * Searching is executed until it reaches to a leaf node, or it has found a matching value for the key.
     * @param node is the current NodeKmer being checked
     * @param key is a String to be found in the binary tree
     * @return 0 if not found, 1 if found
     */
    public int searchKmer(NodeKmer node, String key) {
        if (node == null)
            return 0;
            // if key exists, then return 1
        else if (node.getValue().getDNA().compareTo(key) == 0)
            return 1;

            // if not null, then call this method again, check current value to either traverse to left/right child
        else {
            if (node.getValue().getDNA().compareTo(key) <= 0) {
                if (node.leftChild == null) {
                    return 0;
                } else {
                    return searchKmer(node.leftChild, key);
                }

            } else {
                if (node.rightChild == null) {
                    return 0;
                } else {
                    return searchKmer(node.rightChild, key);
                }

            }
        }
    }

    /**
     * Deletes all the nodes in the binary tree.
     * @param node is the current NodeKmer being traversed
     */
    public void destroyKmer(NodeKmer node){

        if (node != null) {
            destroyKmer(node.leftChild);
            destroyKmer(node.rightChild);
            node.setValueKmer(null);
        }

    }

    /**
     * Sets the value of the node.
     * @param value is the String to be passed to set the node's value
     */
    public void setValueKmer(String value){
        this.value.setDNA(value);
    }

    /**
     * Prints kmer distribution.
     * @param node is the current NodeKmer being traversed
     */
    public void kmerKmer(NodeKmer node){

        if (node != null) {
            System.out.println(node.getValue().getDNA() + " : " + node.getValue().getOccurrence());
            kmerKmer(node.leftChild);
            kmerKmer(node.rightChild);
        }

    }
}
