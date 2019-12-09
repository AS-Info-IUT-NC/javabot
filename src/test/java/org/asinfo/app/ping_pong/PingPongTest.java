package org.asinfo.app.ping_pong;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.security.auth.login.LoginException;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * Tests unitaires de la classe {@link PingPong}.
 */
class PingPongTest {

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
     * Test de l'initialisation des services PingPong.
     */
    @Test
    void initServices() {
        PingPong pingPong = new PingPong(jda);
        assumeTrue(jda.getRegisteredListeners().contains(pingPong));
        jda.removeEventListener(pingPong);
    }

}
