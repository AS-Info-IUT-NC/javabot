package org.asinfo.lib.discord;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

/**
 * Classe utilitaire Discord ; relative aux messages.
 */
public class Messages {

    /**
     * Teste un message envoyé sur un salon textuel.
     *
     * @param event Message sur un salon textuel (GuildMessageReceivedEvent)
     * @param testString Message valide (String)
     * @return True si message valide (boolean)
     */
    public static boolean messageValide(GuildMessageReceivedEvent event, String testString){
        return event.getMessage().getContentRaw().equals(testString);
    }

    /**
     * Teste un message envoyé sur un salon textuel, avec deux options.
     *
     * @param event Message sur un salon textuel (GuildMessageReceivedEvent)
     * @param testString1 Message valide (String)
     * @param testString2 Message valide (String)
     * @return True si message valide (boolean)
     */
    public static boolean messageValide(GuildMessageReceivedEvent event, String testString1, String testString2){
        String message = event.getMessage().getContentRaw();
        return message.equals(testString1) || message.equals(testString2);
    }

    /**
     * Teste un message envoyé sur un salon textuel, avec plusieurs options.
     *
     * @param event Message sur un salon textuel (GuildMessageReceivedEvent)
     * @param testString Messages valides (String[])
     * @return True si message valide (boolean)
     */
    public static boolean messageValide(GuildMessageReceivedEvent event, String[] testString){
        String message = event.getMessage().getContentRaw();
        for (String s : testString) {
            if (message.equals(s)) return true;
        }
        return false;
    }

    /**
     * Teste si le message contient un (et un seul) terme.
     *
     * @param event Message sur un salon textuel (GuildMessageReceivedEvent)
     * @param testString Terme recherché (String)
     * @return True si le message contient le terme recherché (boolean)
     */
    public static boolean messageContient(GuildMessageReceivedEvent event, String testString){
        String[] splitMessage = event.getMessage().getContentRaw().split(" ");
        for(String mot:splitMessage){
            if (mot.equals(testString)) return true;
        }
        return false;
    }

    /**
     * Envoie une réponse lorsqu'un terme (et un seul) et détecté dans un message.
     *
     * @param event Message sur un salon textuel (GuildMessageReceivedEvent)
     * @param message Terme à repérer dans les messages (String)
     * @param reponse Réponse (String)
     */
    public static void envoyerReponseMessage(GuildMessageReceivedEvent event, String message, String reponse){
        if (event.getMessage().getContentRaw().equals(message)){
            event.getChannel().sendMessage(reponse).queue();
        }
    }

    /**
     * Envoie une réponse à l'auteur lorsqu'un terme (et un seul) et détecté dans son message.
     *
     * @param event Message sur un salon textuel (GuildMessageReceivedEvent)
     * @param message Terme à repérer dans les messages (String)
     * @param reponse Réponse (String)
     */
    public static void envoyerReponsePersoMessage(GuildMessageReceivedEvent event, String message, String reponse){
        if (!messageContient(event, message)) return;
        String auteur = event.getAuthor().getAsMention();
        event.getChannel().sendMessage(auteur + "\n" + reponse).queue();
    }

    /**
     * Envoie un message groupé lorsqu'un terme (et un seul) et détecté dans un message.
     *
     * @param event Message sur un salon textuel (GuildMessageReceivedEvent)
     * @param message Terme à repérer dans les messages (String)
     * @param messageAEnvoyer Message à envoyer (String)
     * @param users Utilisateurs à mentionner (User[])
     */
    public static void envoyerMessageGroupe(GuildMessageReceivedEvent event, String message, String messageAEnvoyer, User[] users){
        if (!messageContient(event, message)) return;
        if (users == null) return;
        String mentionsGroupe = "";
        for(User user:users){
            mentionsGroupe = mentionsGroupe.concat(" " + user.getAsMention());
        }
        event.getChannel().sendMessage(mentionsGroupe + "\n" + messageAEnvoyer).queue();
    }
}
