package org.asinfo.app.la_faille;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static org.asinfo.app.la_faille.helpers.MessagesLaFaille.*;
import static org.asinfo.lib.discord.Messages.messageValide;
import static org.asinfo.lib.discord.Roles.*;
import static org.asinfo.app.la_faille.helpers.ConstantesLaFaille.*;

/**
 * Fonction d'inscription et de désinscription au groupe/role de la Faille.
 */
public class Inscription extends ListenerAdapter {

    /**
     * Réalise l'inscription/la désinscription d'un utilisateur suite aux commandes dédiées.
     *
     * @param event Message sur un salon textuel (GuildMessageReceivedEvent)
     */
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if (messageValide(event.getMessage(), JOIN, QUIT)) {
            Role role = getRoleAvecNom(event.getGuild(), ROLE);
            if (messageValide(event.getMessage(), JOIN)) {
                inscrire(event.getMember(), role, event);
            } else {
                desinscrire(event.getMember(), role, event);
            }
        }
    }

    /**
     * Réalise l'inscription d'un utilisateur.
     *
     * @param member Membre (Member)
     * @param role Role 'La Faille'
     * @param event Evénement (GuildMessageReceivedEvent)
     */
    private static void inscrire(Member member, Role role, GuildMessageReceivedEvent event){
        if (!aLeRole(member, role)) {
            ajouterRoleA(member, role);
            bienvenueLaFaille(event);
        } else {
            dejaInscritLaFaille(event);
        }
    }

    /**
     * Réalise l'inscription d'un utilisateur.
     *
     * @param member Membre (Member)
     * @param role Role 'La Faille'
     * @param event Evénement (GuildMessageReceivedEvent)
     */
    private static void desinscrire(Member member, Role role, GuildMessageReceivedEvent event){
        if (aLeRole(member, role)) {
            retirerRoleA(member, role);
            auRevoirLaFaille(event);
        } else {
            dejaDesinscritLaFaille(event);
        }
    }
}
