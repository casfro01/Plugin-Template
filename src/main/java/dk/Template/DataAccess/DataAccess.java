package dk.Template.DataAccess;

import dk.Template.Template;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.stream.Collectors;

public class DataAccess {
    private DBConnector connector;

    // dbpath -> relative
    public DataAccess(Template plugin, String dbPath) throws SQLException {
        this.connector = new DBConnector("jdbc:sqlite:" + plugin.getDataFolder().getAbsolutePath() + dbPath);
    }


    /**
     * Bygger databasen med den sql fil som man laver
     */
    public void runDBScript() throws Exception{
        executeSQL_File();
    }

    private void executeSQL_File() throws Exception {
        try (
                InputStream is = getClass().getClassLoader().getResourceAsStream("SQL.sql");
                Connection conn = connector.getConnection();
                Statement stmt = conn.createStatement()) {

            if (is == null) throw new NullPointerException("SQL File is not found!");
            String sql = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));
            // Split statements by semicolon, yk like a normal person
            String[] commands = sql.split("(?<=;)");
            for (String command : commands) {
                command = command.trim();
                if (!command.isEmpty()) {
                    stmt.execute(command);
                }
            }

        }
    }
}
