package org.asinfo.app.la_faille.helpers;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import static org.asinfo.lib.discord.Messages.*;
import static org.asinfo.lib.discord.Roles.getRoleAvecNom;
import static org.asinfo.lib.discord.Roles.membresDe;
import static org.asinfo.app.la_faille.helpers.ConstantesLaFaille.*;


/**
 * Classe utilitaire pour le package la_faille ; messages du bot.
 */
public class MessagesLaFaille {

    /**
     * Message de bienvenue.
     *
     * @param event Message sur un salon textuel (GuildMessageReceivedEvent)
     */
    public static void bienvenueLaFaille(GuildMessageReceivedEvent event){
        envoyerMessagePerso(event.getAuthor(), event.getChannel(),"Bienvenue ! Tu es maintenant un chevalier de La Faille !");
    }

    /**
     * Message d'au revoir.
     *
     * @param event Message sur un salon textuel (GuildMessageReceivedEvent)
     */
    public static void auRevoirLaFaille(GuildMessageReceivedEvent event){
        envoyerMessagePerso(event.getAuthor(), event.getChannel(),"Au revoir. La Faille n'est jamais loin.");
    }

    /**
     * Appel des utilisateur ayant le role 'La Faille'
     *
     * @param event Message sur un salon textuel (GuildMessageReceivedEvent)
     */
    public static void appelerLaFaille(GuildMessageReceivedEvent event){
        String auteurMention = event.getAuthor().getName();
        envoyerMessageGroupe(membresDe(event.getGuild(), getRoleAvecNom(event.getGuild(), ROLE)), event.getChannel(),  auteurMention + " vous réclame !");
    }

    /**
     * Message de notification groupe vide.
     *
     * @param event Message sur un salon textuel (GuildMessageReceivedEvent)
     */
    public static void groupeVideLaFaille(GuildMessageReceivedEvent event){
        envoyerMessage(event.getChannel(), "Il n'y a personne dans la faille...");
    }

    /**
     * Message lorsque inscription appelée par un membre ayant déjà le role 'La Faille'
     *
     * @param event Message sur un salon textuel (GuildMessageReceivedEvent)
     */
    public static void dejaInscritLaFaille(GuildMessageReceivedEvent event){
        envoyerMessagePerso(event.getAuthor(), event.getChannel(),"Tu es déjà membre de la Faille ;)");
    }

    /**
     * Message lorsque désinscription appelée par un membre n'ayant déjà pas le role 'La Faille'
     *
     * @param event Message sur un salon textuel (GuildMessageReceivedEvent)
     */
    public static void dejaDesinscritLaFaille(GuildMessageReceivedEvent event){
        envoyerMessagePerso(event.getAuthor(), event.getChannel(),"Tu n'es DEJA pas un membre de la Faille...");
    }
}
