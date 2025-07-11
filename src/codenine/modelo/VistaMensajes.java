package codenine.modelo;

import javax.swing.UIManager;

public class VistaMensajes {

    public VistaMensajes() {
    }

    public static void mensaje() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
    }
}
