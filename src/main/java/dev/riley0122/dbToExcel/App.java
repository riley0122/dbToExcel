/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.riley0122.dbToExcel;

import java.util.Properties;

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

        if (parsedArgs.getProperty("help") != null) {
            if (parsedArgs.getProperty("help").equals("true"))
            {
                // TODO: generate help menu
            } else if (parsedArgs.getProperty("help").equals("dbTypes"))
            {
                System.out.println("Database type is specified with --dbType=TYPE\n\nAvailable types are:\n\t- sqlite\n\t- json\n\t- mysql\n\t- postgresql");
            }
            return;
        }

        if (parsedArgs.getProperty("dbType") == null || parsedArgs.getProperty("dbType").equals("true"))
        {
            System.out.println("Please specify a database type using --dbType=TYPE, To see what types are available use --help=dbTypes");
            return;
        }

        if (parsedArgs.getProperty("dbType").toLowerCase().equals("sqlite"))
        {
            System.out.println("Reading sqlite db...");
            sqlite db = new sqlite(parsedArgs);
            db.readDatabase();
        }
    }
}
