package org.asinfo.app;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.junit.jupiter.api.Test;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import static org.asinfo.lib.util.ConfigClient.getProp;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests unitaires de la classe {@link Main}.
 */
class MainTest {

    /**
     * todo javadoc
     * Creation de l instance.
     *
     * @throws IOException    the io exception
     * @throws LoginException the login exception
     */
    @Test
    void creationDeLInstance() throws IOException, LoginException {
        JDA jda = new JDABuilder(getProp("DISCORD_TOKEN")).build();
        assertTrue(jda.getStatus().isInit());
    }

}
