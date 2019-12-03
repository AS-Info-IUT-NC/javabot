package org.asinfo.app.la_faille;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.asinfo.app.Main;
import org.junit.jupiter.api.Test;

import javax.security.auth.login.LoginException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Tests unitaires de la classe {@link LaFaille}.
 */
public class LaFailleTest {

    /**
     * Implémentation du service global.
     *
     * @throws IOException    the io exception
     * @throws LoginException the login exception
     */
    @Test
    void ConstrTest() throws IOException, LoginException {
        JDA jda = new JDABuilder(System.getenv("DISCORD_TOKEN")).build();
        LaFaille laFaille = new LaFaille(jda);
        assertFalse(jda.getEventManager().getRegisteredListeners().isEmpty());
    }
}
