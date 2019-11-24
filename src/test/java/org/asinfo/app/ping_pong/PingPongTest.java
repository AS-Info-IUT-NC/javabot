package org.asinfo.app.ping_pong;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.junit.jupiter.api.Test;

import javax.security.auth.login.LoginException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests unitaires de la classe {@link PingPong}.
 */
class PingPongTest {

    @Test
    void ConstrTest() throws IOException, LoginException {
        JDA jda = new JDABuilder(System.getenv("DISCORD_TOKEN")).build();
        PingPong pingPong = new PingPong(jda);
        assertFalse(jda.getEventManager().getRegisteredListeners().isEmpty());
    }

    @Test
    void eventTest() throws IOException, LoginException {
        JDA jda = new JDABuilder(System.getenv("DISCORD_TOKEN")).build();
        PingPong pingPong = new PingPong(jda);
        assertTrue(jda.getEventManager().getRegisteredListeners().contains(pingPong));
    }
}
