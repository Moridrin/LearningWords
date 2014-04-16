//<editor-fold defaultstate="collapsed" desc="Jibberish">

package connections;

//</editor-fold>

/**
 * This enum is for //TODO.
 *
 * @organization: Moridrin
 * @author        J.B.A.J. Berkvens
 * @date          2014/04/15
 */
public enum LastUsed {
    File,
    MySQL;
    
    private static LastUsed lastUsed;
    
    public static LastUsed getLastUsed(){
        return lastUsed;
    }
    
    public static void setLastUsed(LastUsed lastUsed){
        LastUsed.lastUsed = lastUsed;
    }
}
