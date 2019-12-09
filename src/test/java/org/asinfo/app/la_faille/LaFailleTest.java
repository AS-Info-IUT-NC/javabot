package org.asinfo.app.la_faille;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.security.auth.login.LoginException;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * Tests unitaires de la classe {@link LaFaille}.
 */
public class LaFailleTest {

    private static JDA jda;

    /**
     * Initialisation JDA.
     * @throws LoginException LoginException
     */
    @BeforeAll
    static void init() throws LoginException {
        jda = new JDABuilder(System.getenv("DISCORD_TOKEN")).build();
    }

    /**
     * Test de l'initialisation des services LaFaille.
     */
    @Test
    void initServices() {
        new LaFaille(jda);
        assumeTrue(jda.getRegisteredListeners().get(0).getClass().getSimpleName().equals("Inscription"));
        assumeTrue(jda.getRegisteredListeners().get(1).getClass().getSimpleName().equals("AppelGroupe"));
    }
}
