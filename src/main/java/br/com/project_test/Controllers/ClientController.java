package br.com.project_test.Controllers;

import static spark.Spark.*;

import br.com.project_test.DAO.ClientDAO;
import br.com.project_test.Models.Client;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;


public class ClientController {
    private static ClientDAO clientDAO = new ClientDAO();
    private static Gson gson = new Gson();

    public static Object register_client(Request req, Response res) throws SQLException {
        Client client = gson.fromJson(req.body(), Client.class);
        client.setId(UUID.randomUUID());

        clientDAO.register_client(client);
        res.status(201);

        return gson.toJson(client);
    }

    public static Object consult_user(Request req, Response res) throws SQLException {
        Client client = gson.fromJson(req.body(), Client.class);
        List<Client> clientList = clientDAO.consult_client(client);

        res.status(200);
        res.type("aplication/json");

        return new Gson().toJson(clientList);
    }
}
