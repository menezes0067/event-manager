package br.com.project_test;

import br.com.project_test.Controllers.ClientController;
import br.com.project_test.Controllers.EventController;
import br.com.project_test.Controllers.HostController;
import br.com.project_test.DAO.ClientDAO;
import br.com.project_test.Models.Client;

import java.sql.SQLException;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        post("/users", ClientController::register_client);
        get("/users", ClientController::consult_user);


        post("/hosts", HostController::register_host);

        post("/events", EventController::register_event);
    }
}
