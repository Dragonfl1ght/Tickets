package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException, ParseException {

        File file = new File("src/main/files/tickets.json");
        String data = new String(Files.readAllBytes(Path.of(file.getPath())));
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        TicketsList ticket = gson.fromJson(data, TicketsList.class);
        ArrayList<Ticket> tickets = ticket.getTickets();
        Map <String, Long> timemap = new HashMap<String, Long>();
        List<Integer> sum = new ArrayList<>();

        double median;
        double avgsum = 0;
        double dif;
        for (Ticket t: tickets)
        {
            if((t.getDestination().equals("TLV") && t.getOrigin().equals("VVO"))
            || (t.getDestination().equals("VVO") && t.getOrigin().equals("TLV"))){
                sum.add(t.getPrice());
                long timedif = Math.abs(t.getArrivalDate().getTime() - t.getDepartureDate().getTime())/60000;
                if(timemap.containsKey(t.getCarrier())){
                    if(timemap.get(t.getCarrier()) > timedif)
                        timemap.put(t.getCarrier(), timedif);
                    }
                else
                    timemap.put(t.getCarrier(), timedif);
            }
        }
        timemap.keySet().forEach(k -> System.out.println(k + "-" + timemap.get(k)));
        sum.sort(getIndexComparator());
        if(sum.size() % 2 == 0){
            median = (double) (sum.get(sum.size() / 2) + sum.get(sum.size() / 2 - 1)) / 2;
        }
        else
            median = (double) sum.get(sum.size()/2 + 1);
        for(Integer i: sum)
            avgsum += i;
        avgsum /= sum.size();
        dif = Math.abs(avgsum - median);
        System.out.println(dif);
    }
    public static Comparator<Integer> getIndexComparator() {
        return new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1  - o2;
            }
        };
    }
}