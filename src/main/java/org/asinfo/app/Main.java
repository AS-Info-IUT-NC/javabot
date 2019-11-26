package org.asinfo.app;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.asinfo.app.bot.Bot;
import org.asinfo.app.la_faille.LaFaille;
import org.asinfo.app.ping_pong.PingPong;

/**
 * Classe principale du programme.
 */
public class Main {
    /**
     * Point d'entrée de l'application ; mise en service du bot.
     *
     * @param args Inputs (String[])
     * @throws Exception Exception
     */
    public static void main( String[] args ) throws Exception {
        // Création de l'instance :
        JDA jda = new JDABuilder(System.getenv("DISCORD_TOKEN")).build();

        // Montage des différents services :
        new Bot(jda);
        new PingPong(jda);
        new LaFaille(jda);
    }
}
