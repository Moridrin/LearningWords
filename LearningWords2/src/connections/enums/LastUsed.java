//<editor-fold defaultstate="collapsed" desc="Jibberish">
package connections.enums;

//</editor-fold>
/**
 * This enum is to specify which connection is last used (and which connection
 * to use for auto save.
 *
 * @organization: Moridrin
 * @author J.B.A.J. Berkvens
 * @date 2014/04/15
 */
public enum LastUsed {

    File,
    MySQL;

    private static LastUsed lastUsed;

    /**
     * This operation returns the connection that was last used by the program.
     *
     * @return is the last used connection (enum).
     */
    public static LastUsed getLastUsed() {
        return lastUsed;
    }

    /**
     * This operation sets the last used connection.
     *
     * @param lastUsed is the connection that's been used.
     */
    public static void setLastUsed(LastUsed lastUsed) {
        LastUsed.lastUsed = lastUsed;
    }
}
