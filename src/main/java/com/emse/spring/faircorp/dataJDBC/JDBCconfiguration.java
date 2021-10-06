package com.emse.spring.faircorp.dataJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JDBCconfiguration {

    public static final String database_url = "jdbc:h2:mem:faircorp;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE"; // (2)
    public static final String username = "sa";
    public static final String password = "";

    public static final Logger logger = LoggerFactory.getLogger(JDBCconfiguration.class);

    public static void main(String[] args) {

        try {
            Class.forName("org.h2.Drive"); // (1)
        }
        catch (ClassNotFoundException e) {
            logger.error("Unable to load JDBC Driver", e);
        }
        try {
            Connection connection = DriverManager.getConnection(database_url, username, password); // (3)
        }
        catch (SQLException e) {
            logger.error("Unable to connect to the database", e);
        }

        new JDBCconfiguration().insertSite(new Site("123","wenxu"));
    }

    public void insertSite(Site site) {
        try(Connection conn = DriverManager.getConnection(database_url, username, password)){
            String sql = "insert into SITE (id, name) values (?, ?)";
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, site.getID());
                stmt.setString(2, site.getName());
                stmt.executeUpdate();
            }
        }
        catch(SQLException e) {
//            throw new DatabaseException("Impossible to insert site " +
//                    site.getName(), e);
            logger.error("Impossible to insert site " + site.getName());
            e.printStackTrace();
        }
    }
}
