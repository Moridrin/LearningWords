
package components;

/**
 *
 * @author J.B.A.J. Berkvens
 */
public class Test {
    
    private Test() {
    }
    
    public static Test getInstance() {
        return TestHolder.INSTANCE;
    }
    
    private static class TestHolder {

        private static final Test INSTANCE = new Test();
    }

}
