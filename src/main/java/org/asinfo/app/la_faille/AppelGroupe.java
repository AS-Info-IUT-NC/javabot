package org.asinfo.app.la_faille;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static org.asinfo.app.la_faille.helpers.MessagesLaFaille.*;
import static org.asinfo.lib.discord.Messages.*;
import static org.asinfo.lib.discord.Roles.*;
import static org.asinfo.app.la_faille.helpers.ConstantesLaFaille.*;

/**
 * Fonction d'appel au groupe par mentions de tous les utilisateurs ayant le role 'La Faille'.
 */
public class AppelGroupe extends ListenerAdapter {

    /**
     * Génère un message du bot qui mentionne les utilisateur ayant le role 'La Faille'.
     *
     * @param event Message sur un salon textuel (GuildMessageReceivedEvent)
     */
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if (!messageContient(event.getMessage(), CALL)) return;
        if (membresDe(event.getGuild(), getRoleAvecNom(event.getGuild(), ROLE)) != null) {
            appelerLaFaille(event);
        } else {
            groupeVideLaFaille(event);
        }

    }
}
