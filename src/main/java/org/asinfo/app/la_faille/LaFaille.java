package org.asinfo.app.la_faille;

import net.dv8tion.jda.api.JDA;
// todo javadoc
public class LaFaille {

    public LaFaille(JDA jda){
        jda.addEventListener(new Inscription());
        jda.addEventListener(new AppelGroupe());
    }
}
