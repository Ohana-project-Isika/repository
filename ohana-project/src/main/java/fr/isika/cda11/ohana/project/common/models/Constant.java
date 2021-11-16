package fr.isika.cda11.ohana.project.common.models;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Constant {
    public static final String SELECT_EVENTS_JOIN_TICKETS = "SELECT event_name, event_description, start_date, " +
            "end_date, start_time, end_time, address_id, rate_type, applied_TVA FROM Event e JOIN Ticket t ON e.id = t.event_id";
}
