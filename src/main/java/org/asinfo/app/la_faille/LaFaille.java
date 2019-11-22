package org.asinfo.app.la_faille;

import net.dv8tion.jda.api.JDA;

public class LaFaille {

    public LaFaille(JDA jda){
        jda.addEventListener(new ConfigRole());
        jda.addEventListener(new Inscription());
        jda.addEventListener(new AppelGroupe());
    }
}
