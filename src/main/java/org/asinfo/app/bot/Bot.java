package org.asinfo.app.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * Fonctionnalités de présentation.
 */
public class Bot extends ListenerAdapter {

    private static final String COMMANDES = "**Général**\n`!javabot` : \n`!projet` : \n\n**La Faille**\n`!jfaille` : Rejoindre la Faille\n`!qfaille` : Quitter la faille\n`!lafaille` : Appeler les membres de la faille";

    /**
     * Initialise des fonctionnalités Bot.
     * @param jda JDA créé dans Main (JDA)
     */
    public Bot(JDA jda){
        jda.addEventListener(this);
    }

    /**
     * Réponse automatique au message "!javabot" ; présentation.
     * @param event Messages envoyés sur le serveur
     */
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        if (event.getAuthor().isBot()) return;
        String message = event.getMessage().getContentRaw();
        if (message.equals("!javabot")){
            event.getChannel().sendMessage("Hello c'est moi, Javabot !").queue();
        } else if (message.equals("!projet")){
            event.getChannel().sendMessage("Contribuez ici au projet :\nhttps://github.com/AS-Info-IUT-NC/javabot").queue();
        } else if (message.equals("!help")){
            event.getChannel().sendMessage(COMMANDES).queue();
        }
    }
}
