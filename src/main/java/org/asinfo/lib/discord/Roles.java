package org.asinfo.lib.discord;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.managers.GuildManager;

/**
 * Classe utilitaire Discord ; relative aux roles.
 */
public class Roles {

    /**
     * Retourne l'objet Role associé à un nom de role pour un serveur.
     *
     * @param guild Serveur (Guild)
     * @param nom   Nom du role (String)
     * @return Objet lié au role (Role) ; null si aucun role correspondant
     */
    public static Role getRoleAvecNom(Guild guild, String nom) {
        int index = guild.getRoles().size();
        Role[] roles = new Role[index];
        for (int i = 0; i < index; i++) {
            roles[i] = guild.getRoles().get(i);
            if (roles[i].getName().equals(nom)) {
                return roles[i];
            }
        }
        return null;
    }

    /**
     * Ajoute un role à un membre du serveur.
     *
     * @param member Utilisateur (Member)
     * @param role  Role a ajouter (Role)
     */
    public static void ajouterRoleA(Member member, Role role) {
        if (!roleExiste(member.getGuild(), role)) return;
        GuildManager manager = member.getGuild().getManager();
        manager.getGuild().addRoleToMember(member, role).queue();
    }

    /**
     * Retire un role à un membre du serveur.
     *
     * @param member Utilisateur (Member)
     * @param role  Role a retirer (Role)
     */
    public static void retirerRoleA(Member member, Role role) {
        if (!roleExiste(member.getGuild(), role)) return;
        GuildManager manager = member.getGuild().getManager();
        manager.getGuild().removeRoleFromMember(member, role).queue();
    }

    /**
     * Teste si un utilisateur a le role spécifié.
     *
     * @param member Utilisateur (Member)
     * @param role  Role à tester (Role)
     * @return True si le membre a le role testé (boolean)
     */
    public static boolean aLeRole(Member member, Role role) {
        boolean res = false;
        if (!roleExiste(member.getGuild(), role)) return res;
        int index = member.getRoles().size();
        for (int i = 0; i < index; i++) {
            if (role == member.getRoles().get(i)) res = true;
            break;
        }
        return res;
    }

    /**
     * Teste si un role existe dans un serveur.
     *
     * @param guild Serveur (Guild)
     * @param role  Nom du role à tester (Role)
     * @return True si le role existe (boolean)
     */
    public static boolean roleExiste(Guild guild, Role role) {
        boolean res = false;
        int index = guild.getRoles().size();
        for (int i = 0; i < index; i++) {
            if (guild.getRoles().get(i) == role) {
                res = true;
            }
        }
        return res;
    }

    /**
     * Retourne les utilisateurs ayant un role défini.
     *
     * @param guild Serveur (Guild)
     * @param role  Role ciblé (Role)
     * @return Les utilisateurs ayant le role ciblé (User[])
     */
    public static User[] membresDe(Guild guild, Role role) {
        if (!roleExiste(guild, role)) return null;
        int index = guild.getMembersWithRoles(role).size();
        if (index == 0) return null;
        User[] users = new User[index];
        for (int i = 0; i < index; i++) {
            users[i] = guild.getMembersWithRoles(role).get(i).getUser();
        }
        return users;
    }
}
