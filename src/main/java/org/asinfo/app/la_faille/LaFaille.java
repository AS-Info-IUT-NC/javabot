package org.asinfo.app.la_faille;

import net.dv8tion.jda.api.JDA;

/**
 * Initialisation des fonctionnalités pour les joueurs AOE.
 */
public class LaFaille {

    /**
     * Initialisation des fonctionnalités LaFaille.
     *
     * @param jda JDA créé dans Main (JDA)
     */
    public LaFaille(JDA jda){
        jda.addEventListener(new Inscription());
        jda.addEventListener(new AppelGroupe());
    }
}
