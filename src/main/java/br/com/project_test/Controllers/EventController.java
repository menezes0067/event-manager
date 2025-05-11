package br.com.project_test.Controllers;


import br.com.project_test.DAO.EventDAO;
import br.com.project_test.Models.Event;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import java.sql.SQLException;
import java.util.UUID;

import static spark.Spark.*;

public class EventController {
    private static EventDAO eventDAO = new EventDAO();
    private static Gson gson = new Gson();

    public static Object register_event(Request req, Response res){
        try {
            Event event = gson.fromJson(req.body(), Event.class);
            event.setId(UUID.randomUUID());

            eventDAO.event_register(event);
            res.status(201);

            return gson.toJson(event);


        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
