package efiovo1;
public class PersonalNumber {
    
    private int pNo;
    
    
    public PersonalNumber(int pNo) {
        this.pNo = pNo;
    }
    
    public int getpNo() {
        return pNo;
    }
    
    @Override
    public String toString() {
        return String.valueOf(pNo);
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + pNo;
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PersonalNumber other = (PersonalNumber) obj;
        if (pNo != other.pNo)
            return false;
        return true;
    }
    
}
