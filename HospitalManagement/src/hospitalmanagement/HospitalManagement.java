
package hospitalmanagement;

import com.sust.gui.LogIn;
import javax.swing.UIManager;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class HospitalManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                try {
            // select Look and Feel
             UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
             //com.jtattoo.plaf.texture.TextureLookAndFeel
             //com.jtattoo.plaf.hifi.HiFiLookAndFeel
             //com.jtattoo.plaf.noire.NoireLookAndFeel
             //com.jtattoo.plaf.aero.AeroLookAndFeel
            // start application
            LogIn logIn = new LogIn();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
