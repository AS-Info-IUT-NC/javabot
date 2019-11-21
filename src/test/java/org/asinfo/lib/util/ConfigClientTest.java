package org.asinfo.lib.util;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.asinfo.lib.util.ConfigClient.getProp;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Tests unitaires de la classe {@link ConfigClientTest}.
 */
class ConfigClientTest {

    @Test
    void getPropTest() throws IOException {
        assertNull(getProp("FAIL"));
        assertNotNull(getProp("DISCORD_TOKEN"));
    }
}
