package br.com.project_test.DAO;

import br.com.project_test.Models.Address;
import br.com.project_test.Models.Client;
import br.com.project_test.database.JDBCMysqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ClientDAO {
    public void register_client(Client client) throws SQLException{
        try {
            String register_user = "INSERT INTO user_(id, name_user, email, password_user, type_user)" +
                    " VALUES(?, ?, ?, ?, ?)";

            PreparedStatement stmt = JDBCMysqlConnection.connection().prepareStatement(register_user);
            stmt.setString(1, client.getId().toString());
            stmt.setString(2, client.getName());
            stmt.setString(3, client.getEmail());
            stmt.setString(4, client.getPassword());
            stmt.setInt(5, client.getType_user());

            stmt.execute();
            stmt.close();

            String register_address = "INSERT INTO addresses(state, city, street, number_house," +
                    " complement, district, user_id, event_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

            for (Address address : client.getAddresses()) {
                PreparedStatement stmt_adress = JDBCMysqlConnection.connection().prepareStatement(register_address);
                stmt_adress.setString(1, address.getState());
                stmt_adress.setString(2, address.getCity());
                stmt_adress.setString(3, address.getStreet());
                stmt_adress.setInt(4, address.getNumber_house());
                stmt_adress.setString(5, address.getComplement());
                stmt_adress.setString(6, address.getDistrict());
                stmt_adress.setString(7, client.getId().toString());
                stmt_adress.setString(8, null);

                stmt_adress.execute();
                stmt_adress.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> consult_client(Client client) throws SQLException {
        List<Client> list_client = new ArrayList<>();

        String consult_user = "SELECT * FROM user_ us LEFT JOIN addresses a ON us.id = a.user_id";
        PreparedStatement stmt =  JDBCMysqlConnection.connection().prepareStatement(consult_user);
        ResultSet rset = stmt.executeQuery();

        while(rset.next()) {
            UUID userId = UUID.fromString(rset.getString("id"));

            Client cli = null;

            for(Client c: list_client){
                if(c.getId().equals(userId)){
                    cli = c;
                    break;
                }
            }

            if(client == null) {
                cli = new Client();
                cli.setId(UUID.fromString(rset.getString("id")));
                cli.setName(rset.getString("name_user"));
                cli.setEmail(rset.getString("email"));
                cli.setPassword(rset.getString("password_user"));
                cli.setType_user(rset.getInt("type_user"));
                cli.setAddresses(new ArrayList<>());
                list_client.add(cli);
            }

            if(rset.getString("state") != null) {
                Address address = new Address();
                address.setState(rset.getString("state"));
                address.setCity(rset.getString("city"));
                address.setStreet(rset.getString("street"));
                address.setNumber_house(rset.getInt("number_house"));
                address.setComplement(rset.getString("complement"));
                address.setDistrict(rset.getString("district"));

                cli.getAddresses().add(address);
            }
        }

        return list_client;
    }
}
