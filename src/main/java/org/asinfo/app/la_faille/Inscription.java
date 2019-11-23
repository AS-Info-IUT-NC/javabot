package org.asinfo.app.la_faille;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.asinfo.app.la_faille.helpers.ConstantesLaFaille;
import org.jetbrains.annotations.NotNull;

import static org.asinfo.app.la_faille.helpers.MessagesLaFaille.*;
import static org.asinfo.lib.discord.Messages.envoyerReponsePersoMessage;
import static org.asinfo.lib.discord.Messages.messageValide;
import static org.asinfo.lib.discord.Roles.*;

/**
 * Fonction d'inscription et de désinscription au groupe/role de la Faille.
 */
public class Inscription extends ListenerAdapter implements ConstantesLaFaille {

    /**
     * Réalise l'inscription/la désinscription d'un utilisateur suite aux commandes dédiées.
     *
     * @param event Message sur un salon textuel (GuildMessageReceivedEvent)
     */
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if (!roleExiste(event, ROLE)) return;
        if (messageValide(event, JOIN, QUIT)) {
            Role role = getRoleAvecNom(event, ROLE);
            if (messageValide(event, JOIN)) {
                inscrire(event, role);
            } else {
                desinscrire(event, role);
            }
        }
    }

    /**
     * Réalise l'inscription d'un utilisateur.
     *
     * @param event Message sur un salon textuel (GuildMessageReceivedEvent)
     * @param role Role 'La Faille'
     */
    private static void inscrire(GuildMessageReceivedEvent event, Role role){
        if (!aLeRole(event, role)) {
            ajouterRoleA(event, role);
            bienvenueLaFaille(event);
        } else {
            dejaInscritLaFaille(event);
        }
    }

    /**
     * Réalise l'inscription d'un utilisateur.
     *
     * @param event Message sur un salon textuel (GuildMessageReceivedEvent)
     * @param role Role 'La Faille'
     */
    private static void desinscrire(GuildMessageReceivedEvent event, Role role){
        if (aLeRole(event, role)) {
            retirerRoleA(event, role);
            auRevoirLaFaille(event);
        } else {
            dejaDesinscritLaFaille(event);
        }
    }
}
