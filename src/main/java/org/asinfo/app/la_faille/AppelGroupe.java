package org.asinfo.app.la_faille;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.asinfo.app.la_faille.helpers.ConstantesLaFaille;
import org.jetbrains.annotations.NotNull;

import static org.asinfo.app.la_faille.helpers.MessagesLaFaille.*;
import static org.asinfo.lib.discord.Messages.*;
import static org.asinfo.lib.discord.Roles.*;

public class AppelGroupe extends ListenerAdapter implements ConstantesLaFaille {
    // Todo dev?
    // vérifier si AUTRES membres ? Exclure l'auteur.

    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if (!roleExiste(event, ROLE)) return;
        if (!messageContient(event, CALL)) return;
        if (membresDe(event, ROLE) != null){
            appelerLaFaille(event);
        } else {
            groupeVideLaFaille(event);
        }

    }
}
