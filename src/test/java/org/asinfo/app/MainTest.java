package org.asinfo.app;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.junit.jupiter.api.Test;

import javax.security.auth.login.LoginException;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * Tests unitaires de la classe {@link Main}.
 */
class MainTest {

    /**
     * Test de l'initialisation de l'API.
     * @throws LoginException
     * @throws InterruptedException
     */
    @Test
    void initAPI() throws LoginException, InterruptedException {
        JDA jda = new JDABuilder(System.getenv("DISCORD_TOKEN")).build();
        sleep(1000);
        assumeTrue(jda.getStatus().isInit());
    }
}
