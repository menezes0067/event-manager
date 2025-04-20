package br.com.project_test.Models;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public class Event {
    private UUID id;
    private String name;
    private List<Address> addresses_event;
    private List<String> images_event;
    private Date date_time_event;
    private Date end_date_event;
    private int limit;

    public Event() {}

    public Event(String name, List<Address> addresses_event, List<String> images_event,
                 Date date_time_event, Date end_date_event, int limit){
        this.id = UUID.randomUUID();
        this.name = name;
        this.addresses_event = addresses_event;
        this.images_event = images_event;
        this.date_time_event = date_time_event;
        this.end_date_event = end_date_event;
        this.limit = limit;
    }

    public UUID getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddresses_event(List<Address> addresses_event){
        this.addresses_event = addresses_event;
    }

    public List<Address> getAddresses_event() {
        return addresses_event;
    }

    public void setDate_time_event(Date date_time_event) {
        this.date_time_event = date_time_event;
    }

    public Date getDate_time_event() {
        return date_time_event;
    }

    public void setEnd_date_event(Date end_date_event) {
        this.end_date_event = end_date_event;
    }

    public Date getEnd_date_event() {
        return end_date_event;
    }

    public void setImages_event(List<String> images_event) {
        this.images_event = images_event;
    }

    public List<String> getImages_event() {
        return images_event;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }
}
