package org.asinfo.lib.discord;

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
        return !message.equals(testString1) && !message.equals(testString2);
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
}
