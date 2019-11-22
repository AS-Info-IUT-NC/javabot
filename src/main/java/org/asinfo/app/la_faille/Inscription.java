package org.asinfo.app.la_faille;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.GuildManager;

public class Inscription extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        if (event.getMessage().getContentRaw().equals("!jfaille")) {
            int index = event.getGuild().getRoles().size();
            Role[] roles = new Role[index];
            int aoeIndex = -1;
            for (int i = 0; i < index; i++) {
                roles[i] = event.getGuild().getRoles().get(i);
                if (roles[i].getName().equals("La Faille")) {
                    aoeIndex = i;
                    i = index;
                }
            }
            GuildManager manager = event.getGuild().getManager();
            if (event.getMember() != null) {
                manager.getGuild().addRoleToMember(event.getMember(), roles[aoeIndex]).queue();
            }
        } else if (event.getMessage().getContentRaw().equals("!qfaille")){
            int index = event.getGuild().getRoles().size();
            Role[] roles = new Role[index];
            int aoeIndex = -1;
            for (int i = 0; i < index; i++) {
                roles[i] = event.getGuild().getRoles().get(i);
                if (roles[i].getName().equals("La Faille")) {
                    aoeIndex = i;
                    i = index;
                }
            }
            GuildManager manager = event.getGuild().getManager();
            if (event.getMember() != null) {
                manager.getGuild().removeRoleFromMember(event.getMember(), roles[aoeIndex]).queue();
            }
        }
    }
}
