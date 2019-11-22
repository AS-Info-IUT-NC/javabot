package org.asinfo.app;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.asinfo.app.ping_pong.PingPong;
import static org.asinfo.lib.util.ConfigClient.getProp;

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
        JDA jda = new JDABuilder(getProp("DISCORD_TOKEN")).build();

        // Montage des différents services :
        new PingPong(jda);
    }
}
