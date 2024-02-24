/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.riley0122.dbToExcel;

import java.util.List;
import java.util.Properties;
import java.io.File;
import java.sql.*;

public class sqlite{
    public  List<Properties> rows;
    public List<String> columns;
    public String[] requiredProperties = {"filename"};
    Properties settings;

    public sqlite(Properties dbProperties)
    {
        settings = dbProperties;
        // Class.forName("org.sqlite.JDBC");
    }

    public void readDatabase()
    {
        File file = new File(settings.getProperty("filename"));
        if (!file.exists() || !file.isFile())
        {
            System.err.println(settings.getProperty("filename") + " is not a file, or doesn't exist!");
            return;
        }

        try (
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + file.getAbsolutePath());
        ){
            System.out.println(connection.getSchema());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong reading the database!");
        }
    }
}
