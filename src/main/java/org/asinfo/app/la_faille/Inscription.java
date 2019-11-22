package org.asinfo.app.la_faille;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.asinfo.app.la_faille.helpers.ConstantesLaFaille;
import org.jetbrains.annotations.NotNull;

import static org.asinfo.app.la_faille.helpers.MessagesLaFaille.auRevoirLaFaille;
import static org.asinfo.app.la_faille.helpers.MessagesLaFaille.bienvenueLaFaille;
import static org.asinfo.lib.discord.Messages.messageValide;
import static org.asinfo.lib.discord.Roles.*;

public class Inscription extends ListenerAdapter implements ConstantesLaFaille {

    /* Todo completer
    Vérifier si déjà inscrit
    Vérifier si admin?
     */
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if (!roleExiste(event, ROLE)) return;
        if (messageValide(event, JOIN, QUIT)) {
            Member membre = event.getMember();
            Role role = getRoleAvecNom(event, ROLE);
            if (messageValide(event, JOIN)) {
                ajouterRoleA(event, membre, role);
                bienvenueLaFaille(event);
            } else {
                retirerRoleA(event, membre, role);
                auRevoirLaFaille(event);
            }
        }
    }
}
