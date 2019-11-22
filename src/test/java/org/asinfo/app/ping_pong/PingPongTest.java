package org.asinfo.app.ping_pong;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.junit.jupiter.api.Test;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import static org.asinfo.lib.util.ConfigClient.getProp;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests unitaires de la classe {@link PingPong}.
 */
class PingPongTest {

    @Test
    void ConstrYest(){
        // Todo
    }

    @Test
    void eventTest() throws IOException, LoginException {
        JDA jda = new JDABuilder(getProp("DISCORD_TOKEN")).build();
        PingPong pingPong = new PingPong(jda);
        jda.addEventListener(pingPong);
        assertTrue(jda.getEventManager().getRegisteredListeners().contains(pingPong));
    }
}
