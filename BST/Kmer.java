package BST;

/**
 * This class allows to make the kmer distribution.
 */
public class Kmer {
    private String DNA;
    private int occurrence = 0;

    public Kmer(){
        this.DNA = null;
        this.occurrence = 0;
    }

    /**
     * Constructor to create a kmer entry.
     * @param DNA is a String
     */
    public Kmer(String DNA){
        this.DNA = DNA;
        this.occurrence = 1;
    }

    /**
     * Gets the String value in DNA.
     * @return String in DNA
     */
    public String getDNA(){
        return DNA;
    }

    /**
     * Set the String value in DNA
     */
    public void setDNA(String value){
        DNA = value;
    }
    /**
     * Gets the number of occurrences of DNA.
     * @return int that pertains to the number of occurrences of the String
     */
    public int getOccurrence(){
        return occurrence;
    }

    /**
     * Increments the occurrence of DNA.
     */
    public void setOccurrence(){
        this.occurrence+=1;
    }
}