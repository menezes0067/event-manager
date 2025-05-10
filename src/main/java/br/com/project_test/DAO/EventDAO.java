package br.com.project_test.DAO;

import br.com.project_test.Models.Event;
import br.com.project_test.database.JDBCMysqlConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class EventDAO {
    public void event_register(Event event) throws SQLException{
        try {
            String register = "INSERT INTO event_(id, name_event, date_time_event, final_date_event," +
                    " images, limit_of_people) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = JDBCMysqlConnection.connection().prepareStatement(register);
            stmt.setString(1, event.getId().toString());
            stmt.setString(2, event.getName().toString());
            stmt.setTimestamp(3, event.getDate_time_event());
            stmt.setTimestamp(4, event.getEnd_date_event());
            stmt.setString(5, event.getImages_event().toString());
            stmt.setInt(6, event.getLimit());

            stmt.execute();
            stmt.close();
        }catch (SQLException ex) {
            throw ex;
        }
    }
}
