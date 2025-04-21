package br.com.project_test.DAO;

import br.com.project_test.Models.Address;
import br.com.project_test.Models.Host;
import br.com.project_test.database.JDBCMysqlConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HostDAO{
    public void register_UserHost(Host host) throws SQLException {
        String register_host = "INSERT INTO host_(id, name_user, email, password_user, type_user)" +
                " VALUES(?, ?, ?, ?, ?)";
        PreparedStatement stmt = JDBCMysqlConnection.connection().prepareStatement(register_host);
        stmt.setString(1, host.getId().toString());
        stmt.setString(2, host.getName());
        stmt.setString(3, host.getEmail());
        stmt.setString(4, host.getPassword());
        stmt.setInt(5, host.getType_user());

        stmt.executeUpdate();
        stmt.close();

        String register_address = "INSERT INTO addresses(state, city, street, number_house," +
                " complement, district, user_id, event_id, host_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        for (Address address : host.getAddresses()) {
            PreparedStatement stmt_adress = JDBCMysqlConnection.connection().prepareStatement(register_address);
            stmt_adress.setString(1, address.getState());
            stmt_adress.setString(2, address.getCity());
            stmt_adress.setString(3, address.getStreet());
            stmt_adress.setInt(4, address.getNumber_house());
            stmt_adress.setString(5, address.getComplement());
            stmt_adress.setString(6, address.getDistrict());
            stmt_adress.setString(7, null);
            stmt_adress.setString(8, null);
            stmt_adress.setString(9,  host.getId().toString());

            stmt_adress.execute();
            stmt_adress.close();
        }
    }
}
