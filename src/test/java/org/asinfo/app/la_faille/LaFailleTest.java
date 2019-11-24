package org.asinfo.app.la_faille;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.junit.jupiter.api.Test;

import javax.security.auth.login.LoginException;
import java.io.IOException;

import static org.asinfo.lib.util.ConfigClient.getProp;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The type La faille test.
 */
public class LaFailleTest {

    /**
     * todo javadoc
     * Constr test.
     *
     * @throws IOException    the io exception
     * @throws LoginException the login exception
     */
    @Test
    void ConstrTest() throws IOException, LoginException {
        JDA jda = new JDABuilder(getProp("DISCORD_TOKEN")).build();
        LaFaille laFaille = new LaFaille(jda);
        assertFalse(jda.getEventManager().getRegisteredListeners().isEmpty());
    }
}
