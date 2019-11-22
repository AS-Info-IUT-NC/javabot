package org.asinfo.lib.discord;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.GenericGuildEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.managers.GuildManager;

// todo javadoc

/**
 * The type Roles.
 */
public class Roles {

    /**
     * Get role avec nom role.
     *
     * @param event the event
     * @param nom   the nom
     * @return the role
     */
    public static Role getRoleAvecNom(GenericGuildEvent event, String nom){
        int index = event.getGuild().getRoles().size();
        Role[] roles = new Role[index];
        int finalIndex = -1;
        for (int i = 0; i < index; i++) {
            roles[i] = event.getGuild().getRoles().get(i);
            if (roles[i].getName().equals(nom)) {
                return roles[i];
            }
        }
        return null;
    }

    /**
     * Ajouter role a.
     *
     * @param event  the event
     * @param membre the membre
     * @param role   the role
     */
    public static void ajouterRoleA(GuildMessageReceivedEvent event, Member membre, Role role){
        GuildManager manager = event.getGuild().getManager();
        if (event.getMember() != null) {
            manager.getGuild().addRoleToMember(event.getMember(), role).queue();
        }
    }

    /**
     * Retirer role a.
     *
     * @param event  the event
     * @param membre the membre
     * @param role   the role
     */
    public static void retirerRoleA(GuildMessageReceivedEvent event, Member membre, Role role){
        GuildManager manager = event.getGuild().getManager();
        if (event.getMember() != null) {
            manager.getGuild().removeRoleFromMember(event.getMember(), role).queue();
        }
    }
}
