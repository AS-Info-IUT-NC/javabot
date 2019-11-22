package org.asinfo.app.la_faille;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static org.asinfo.lib.discord.Messages.messageValide;
import static org.asinfo.lib.discord.Roles.*;

public class Inscription extends ListenerAdapter {

    /* Todo completer
    Message de départ
    Message d'arrivée
     */
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if (messageValide(event, "!fjoin", "!fquit")) {
            Member membre = event.getMember();
            Role role = getRoleAvecNom(event, "La Faille");
            if (messageValide(event, "!faille")) {
                ajouterRoleA(event, membre, role);
            } else {
                retirerRoleA(event, membre, role);
            }
        }
    }
}
