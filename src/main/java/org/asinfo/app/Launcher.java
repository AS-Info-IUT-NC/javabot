package org.asinfo.app;

import javax.servlet.http.HttpServlet;

public class Launcher extends HttpServlet {

    public void init(){
        Main m = new Main();
        try {
            m.main(new String[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
