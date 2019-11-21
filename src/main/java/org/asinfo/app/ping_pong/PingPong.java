package org.asinfo.app.ping_pong;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * Programme de test.
 */
public class PingPong extends ListenerAdapter {

    /**
     * Réponse automatique au message "!ping".
     * @param event Messages envoyés sur le serveur
     */
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        if (event.getAuthor().isBot()) return;
        String message = event.getMessage().getContentRaw();
        if (message.equals("!ping")){
            event.getChannel().sendMessage("pong!").queue();
        }
    }
}
