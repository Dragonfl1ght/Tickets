package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {
    private String origin;
    private String origin_name;
    private String destination;
    private String destination_name;
    private String departure_date;
    private String departure_time;
    private String arrival_date;
    private String arrival_time;
    private String carrier;
    private Integer stops;

    public Date getDepartureDate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm");
        String s = this.departure_date + " " + this.departure_time;
        return dateFormat.parse(s);
    }
    public Date getArrivalDate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm");
        String s = this.arrival_date + " " + this.arrival_time;
        return dateFormat.parse(s);
    }
    public String getOrigin() {
        return origin;
    }

    public String getOrigin_name() {
        return origin_name;
    }

    public String getDestination() {
        return destination;
    }

    public String getDestination_name() {
        return destination_name;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public String getCarrier() {
        return carrier;
    }

    public Integer getStops() {
        return stops;
    }

    public Integer getPrice() {
        return price;
    }

    private Integer price;
}
