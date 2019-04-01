/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import tela.FrmLogin;

/**
 *
 * @author gusteinhoefel
 */
public class app {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
            new FrmLogin(null, true).setVisible(true);

        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(app.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
