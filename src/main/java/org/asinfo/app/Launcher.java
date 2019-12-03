package org.asinfo.app;

import javax.servlet.http.HttpServlet;

/**
 * Lancement du programme sur serveur
 */
public class Launcher extends HttpServlet {

    /**
     * Initialisation du programme.
     */
    public void init(){
        Main m = new Main();
        try {
            m.main(new String[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
