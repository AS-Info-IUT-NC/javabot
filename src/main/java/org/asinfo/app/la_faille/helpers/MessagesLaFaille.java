package org.asinfo.app.la_faille.helpers;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import static org.asinfo.lib.discord.Messages.*;
import static org.asinfo.lib.discord.Roles.membresDe;

/**
 * todo javadoc
 */
public class MessagesLaFaille implements ConstantesLaFaille {

    public static void bienvenueLaFaille(GuildMessageReceivedEvent event){
        envoyerReponsePersoMessage(event, JOIN, "Bienvenue ! Tu es maintenant un chevalier de La Faille !");
    }

    public static void auRevoirLaFaille(GuildMessageReceivedEvent event){
        envoyerReponsePersoMessage(event, QUIT, "Au revoir. La Faille n'est jamais loin.");
    }

    public static void appelerLaFaille(GuildMessageReceivedEvent event){
        String auteurMention = event.getAuthor().getName();
        envoyerMessageGroupe(event, CALL,  auteurMention + " vous réclame !", membresDe(event, ROLE));
    }

    public static void groupeVideLaFaille(GuildMessageReceivedEvent event){
        envoyerReponseMessage(event, CALL, "Il n'y a personne dans la faille...");
    }
}
