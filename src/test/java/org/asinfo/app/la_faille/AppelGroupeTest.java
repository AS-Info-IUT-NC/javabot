package org.asinfo.app.la_faille;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.junit.jupiter.api.Test;

import javax.security.auth.login.LoginException;
import java.io.IOException;

import static org.asinfo.lib.util.ConfigClient.getProp;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppelGroupeTest {

    @Test
    void eventTest() throws IOException, LoginException {
        JDA jda = new JDABuilder(getProp("DISCORD_TOKEN")).build();
        AppelGroupe appelGroupe = new AppelGroupe();
        jda.addEventListener(appelGroupe);
        assertTrue(jda.getEventManager().getRegisteredListeners().contains(appelGroupe));
    }
}
