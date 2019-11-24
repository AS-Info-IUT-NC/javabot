package org.asinfo.lib.discord;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.GenericGuildEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.managers.GuildManager;

/**
 * Classe utilitaire Discord ; relative aux roles.
 */
public class Roles {

    /**
     * Retourne l'objet Role associé à un nom de role.
     *
     * @param event Evénement (GenericGuildEvent)
     * @param nom   Nom du role (String)
     * @return Objet lié au role (Role) ; null si aucun role correspondant
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
     * Ajoute un role à un membre du serveur à partir d'un message reçu.
     *
     * @param event  Message sur un salon textuel (GuildMessageReceivedEvent)
     * @param role   Role a ajouter (Role)
     */
    public static void ajouterRoleA(GuildMessageReceivedEvent event, Role role){
        GuildManager manager = event.getGuild().getManager();
        if (event.getMember() != null) {
            manager.getGuild().addRoleToMember(event.getMember(), role).queue();
        }
    }

    /**
     * Retire un role à un membre du serveur à partir d'un message reçu.
     *
     * @param event  Message sur un salon textuel (GuildMessageReceivedEvent)
     * @param role   Role a retirer (Role)
     */
    public static void retirerRoleA(GuildMessageReceivedEvent event, Role role){
        GuildManager manager = event.getGuild().getManager();
        if (event.getMember() != null) {
            manager.getGuild().removeRoleFromMember(event.getMember(), role).queue();
        }
    }

    /**
     * Teste si un utilisateur a le role spécifié, à partir d'un message reçu.
     *
     * @param event Message sur un salon textuel (GuildMessageReceivedEvent)
     * @param role Role à tester (Role)
     * @return True si le membre a le role testé (boolean)
     */
    public static boolean aLeRole(GuildMessageReceivedEvent event, Role role){
        if (event.getMember() == null) return false;
        int index = event.getMember().getRoles().size();
        for (int i = 0 ; i < index ; i++){
            if (role == event.getMember().getRoles().get(i)) return true;
        }
        return false;
    }

    /**
     * Teste si un role existe sur le serveur à partir d'un message reçu.
     *
     * @param event Message sur un salon textuel (GuildMessageReceivedEvent)
     * @param role Nom du role à tester (String)
     * @return True si le role existe (boolean)
     */
    public static boolean roleExiste(GuildMessageReceivedEvent event, String role){
        int index = event.getGuild().getRoles().size();
        for (int i = 0; i < index; i++) {
            if (event.getGuild().getRoles().get(i).getName().equals(role)){
                return true;
            }
        }
        return false;
    }

    /**
     * Retourne les utilisateurs ayant un role particulier, à partir d'un message reçu.
     *
     * @param event Message sur un salon textuel (GuildMessageReceivedEvent)
     * @param role Role ciblé (Role)
     * @return Les utilisateurs ayant le role ciblé (User[])
     */
    public static User[] membresDe(GuildMessageReceivedEvent event, String role){
        if (!roleExiste(event, role)) return null;
        Role r = getRoleAvecNom(event, role);
        int index = event.getGuild().getMembersWithRoles(r).size();
        if (index == 0) return null;
        User[] users = new User[index];
        for (int i = 0 ; i < index ; i++){
            users[i] = event.getGuild().getMembersWithRoles(r).get(i).getUser();
        }
        return users;
    }
}
