package org.asinfo.app.ping_pong;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * Programme de test.
 */
public class PingPong extends ListenerAdapter {

    /**
     * Initialise des fonctionnalités PingPong.
     * @param jda JDA créé dans Main (JDA)
     */
    public PingPong(JDA jda){
        jda.addEventListener(this);
    }

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
