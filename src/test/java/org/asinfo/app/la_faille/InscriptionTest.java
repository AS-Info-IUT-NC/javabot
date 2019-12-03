package org.asinfo.app.la_faille;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.junit.jupiter.api.Test;

import javax.security.auth.login.LoginException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test des inscriptions.
 */
public class InscriptionTest {

    /**
     * Event test.
     *
     * @throws IOException    the io exception
     * @throws LoginException the login exception
     */
    @Test
    void eventTest() throws IOException, LoginException {
        JDA jda = new JDABuilder(System.getenv("DISCORD_TOKEN")).build();
        Inscription inscription = new Inscription();
        jda.addEventListener(inscription);
        assertTrue(jda.getEventManager().getRegisteredListeners().contains(inscription));
    }
}
