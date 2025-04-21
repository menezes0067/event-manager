package br.com.project_test.Controllers;

import br.com.project_test.DAO.HostDAO;
import br.com.project_test.Models.Host;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import java.sql.SQLException;
import java.util.UUID;

public class HostController {
    private static HostDAO hostDAO = new HostDAO();
    private static Gson gson = new Gson();

    public static String register_host(Request req, Response res) throws SQLException {
        Host host = gson.fromJson(req.body(), Host.class);
        host.setId(UUID.randomUUID());

        hostDAO.register_UserHost(host);
        res.status(201);
        res.header("Location", "/hosts" + host.getId());

        return gson.toJson(host);
    }
}
