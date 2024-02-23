/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.riley0122.dbToExcel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Properties;

import org.junit.Test;

/**
 * Unit tests
 */
public class AppTest 
{
    /**
     * Testing parsing arguements
     */
    @Test
    public void EmptyArgsGivesEmptyResult()
    {
        Properties args = App.parseArgs(new String[0]);
        assertEquals(new Properties(), args);
        assertNull(args.getProperty("something"));
    }

    @Test
    public void CheckValuesAreBeingSet()
    {
        String[] args = {"--key=value", "--verbose", "--something=nothing"};
        Properties parsedArgs = App.parseArgs(args);
        assertEquals("value", parsedArgs.getProperty("key"));
        assertEquals("true", parsedArgs.getProperty("verbose"));
        assertEquals("nothing", parsedArgs.getProperty("something"));
    }
}
