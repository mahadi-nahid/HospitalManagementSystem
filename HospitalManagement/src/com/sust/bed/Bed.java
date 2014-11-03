
package com.sust.bed;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class Bed {
    
    private int b_id;
    private int ret;
    private int word;
    private final boolean isAvailable;

    public Bed(int b_id, int ret, int word, boolean isAvailable) {
        this.b_id = b_id;
        this.ret = ret;
        this.word = word;
        this.isAvailable = isAvailable;
    }
    
    public int getBedId(){
        return b_id;
    }
    public int getBedRet(){
        return ret;
    }
    public int getBedWord(){
        return word;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
     
}
