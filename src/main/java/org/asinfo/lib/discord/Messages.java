package org.asinfo.lib.discord;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

/**
 * Classe utilitaire Discord ; relative aux messages.
 */
public class Messages {

    /**
     * Teste un message envoyé sur un salon textuel.
     *
     * @param message    Message à tester (Message)
     * @param testString Message valide (String)
     * @return True si message valide (boolean)
     */
    public static boolean messageValide(Message message, String testString) {
        return message.equals(testString);
    }

    /**
     * Teste un message envoyé sur un salon textuel, avec deux options.
     *
     * @param message    Message à tester (Message)
     * @param testString1 Message valide (String)
     * @param testString2 Message valide (String)
     * @return True si message valide (boolean)
     */
    public static boolean messageValide(Message message, String testString1, String testString2) {
        return message.equals(testString1) || message.equals(testString2);
    }

    /**
     * Teste un message envoyé sur un salon textuel, avec plusieurs options.
     *
     * @param message    Message à tester (Message)
     * @param testStrings Messages valides (String[])
     * @return True si message valide (boolean)
     */
    public static boolean messageValide(Message message, String[] testStrings) {
        boolean res = false;
        for (String s : testStrings) {
            if (message.equals(s)) res = true;
            break;
        }
        return res;
    }

    /**
     * Teste si le message contient un (et un seul) terme.
     *
     * @param message    Message à tester (Message)
     * @param testString Terme recherché (String)
     * @return True si le message contient le terme recherché (boolean)
     */
    public static boolean messageContient(Message message, String testString) {
        String[] splitMessage = message.getContentRaw().split(" ");
        for (String mot : splitMessage) {
            if (mot.equals(testString)) return true;
        }
        return false;
    }

    /**
     * Envoit un message.
     *
     * @param channel Chan sur lequel publier (MessageChannel)
     * @param message Message à envoyer (String)
     */
    public static void envoyerMessage(MessageChannel channel, String message) {
        channel.sendMessage(message).queue();
    }

    /**
     * Envoie un message personnalisé.
     *
     * @param user    Destinataire (User)
     * @param channel Chan sur lequel publier (MessageChannel)
     * @param message Message à envoyer (String)
     */
    public static void envoyerMessagePerso(User user, MessageChannel channel, String message) {
        channel.sendMessage(user.getAsMention() + "\n" + message).queue();
    }

    /**
     * Envoie un message groupé.
     *
     * @param channel Chan sur lequel publier (MessageChannel)
     * @param message Message à envoyer (String)
     * @param users Utilisateurs à mentionner (User[])
     */
    public static void envoyerMessageGroupe(User[] users, MessageChannel channel, String message) {
        if (users == null) return;
        String mentionsGroupe = "";
        for (User user : users) {
            mentionsGroupe = mentionsGroupe.concat(" " + user.getAsMention());
        }
        channel.sendMessage(mentionsGroupe + "\n" + message).queue();
    }
}
