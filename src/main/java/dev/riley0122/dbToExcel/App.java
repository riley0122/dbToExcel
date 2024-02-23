/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.riley0122.dbToExcel;

import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static Properties parseArgs(String[] args)
    {
        Properties arguements = new Properties();
        for (String arguement : args)
        {
            String arg = arguement.substring(2);

            if (arg.contains("="))
            {
                String[] split = arg.split("=");
                arguements.setProperty(split[0], split[1]);
            } else
            {
                arguements.setProperty(arg, "true");
            }
        }

        return arguements;
    }

    public static void main( String[] args )
    {
        Properties parsedArgs = parseArgs(args);
        
        System.out.println( "Hello World!" );
    }
}
