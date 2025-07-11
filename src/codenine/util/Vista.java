
package codenine.util;

import javax.swing.UIManager;

public class Vista {

    public Vista() {
    }
    
    public  static void mensaje() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
    }
}
