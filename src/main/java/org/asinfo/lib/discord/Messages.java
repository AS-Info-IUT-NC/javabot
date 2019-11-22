package org.asinfo.lib.discord;

import com.jagrosh.jdautilities.examples.doc.Author;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

// todo javadoc

/**
 * The type Messages.
 */
public class Messages {

    /**
     * Message valide boolean.
     *
     * @param event      the event
     * @param testString the test string
     * @return the boolean
     */
    public static boolean messageValide(GuildMessageReceivedEvent event, String testString){
        return event.getMessage().getContentRaw().equals(testString);
    }

    /**
     * Message valide boolean.
     *
     * @param event       the event
     * @param testString1 the test string 1
     * @param testString2 the test string 2
     * @return the boolean
     */
    public static boolean messageValide(GuildMessageReceivedEvent event, String testString1, String testString2){
        String message = event.getMessage().getContentRaw();
        return message.equals(testString1) || message.equals(testString2);
    }

    /**
     * Message valide boolean.
     *
     * @param event      the event
     * @param testString the test string
     * @return the boolean
     */
    public static boolean messageValide(GuildMessageReceivedEvent event, String[] testString){
        String message = event.getMessage().getContentRaw();
        for (String s : testString) {
            if (message.equals(s)) return true;
        }
        return false;
    }

    public static boolean messageContient(GuildMessageReceivedEvent event, String testString){
        String[] splitMessage = event.getMessage().getContentRaw().split(" ");
        for(String mot:splitMessage){
            if (mot.equals(testString)) return true;
        }
        return false;
    }

    /**
     *
     * @param event
     * @param reponse
     */
    public static void envoyerReponseMessage(GuildMessageReceivedEvent event, String message, String reponse){
        if (event.getMessage().getContentRaw().equals(message)){
            event.getChannel().sendMessage(reponse).queue();
        }
    }

    public static void envoyerReponsePersoMessage(GuildMessageReceivedEvent event, String message, String reponse){
        if (!messageContient(event, message)) return;
        String auteur = event.getAuthor().getAsMention();
        event.getChannel().sendMessage(auteur + "\n" + reponse).queue();
    }

    public static void envoyerMessageGroupe(GuildMessageReceivedEvent event, String message, String reponse, User[] users){
        if (!messageContient(event, message)) return;
        if (users == null) return;
        String mentionsGroupe = "";
        for(User user:users){
            mentionsGroupe = mentionsGroupe.concat(" " + user.getAsMention());
        }
        event.getChannel().sendMessage(mentionsGroupe + "\n" + reponse).queue();
    }
}
