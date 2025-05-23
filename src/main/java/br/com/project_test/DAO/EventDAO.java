package br.com.project_test.DAO;

import br.com.project_test.Models.Address;
import br.com.project_test.Models.Event;
import br.com.project_test.Models.Host;
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
            stmt.setString(2, event.getName());
            stmt.setTimestamp(3, event.getDate_time_event());
            stmt.setTimestamp(4, event.getEnd_date_event());
            stmt.setString(5, event.getImages_event().toString());
            stmt.setInt(6, event.getLimit());

            stmt.execute();
            stmt.close();

            String registerAddressEvent = "INSERT INTO addresses(state, city, street, number_house," +
                    " complement, district, user_id, event_id, host_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

            for(Address address : event.getAddresses_event()) {
                PreparedStatement stmtAddressEvent = JDBCMysqlConnection.connection().prepareStatement(registerAddressEvent);
                stmtAddressEvent.setString(1, address.getState());
                stmtAddressEvent.setString(2, address.getCity());
                stmtAddressEvent.setString(3, address.getStreet());
                stmtAddressEvent.setInt(4, address.getNumber_house());
                stmtAddressEvent.setString(5, address.getComplement());
                stmtAddressEvent.setString(6, address.getDistrict());
                stmtAddressEvent.setString(7, null);
                stmtAddressEvent.setString(8, event.getId().toString());
                stmtAddressEvent.setString(9, event.getHost().getId().toString());

                stmtAddressEvent.executeUpdate();
            }
        }catch (SQLException ex) {
            throw ex;
        }
    }
}
