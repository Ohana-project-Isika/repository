package fr.isika.cda11.ohana.project.common.model;

import lombok.experimental.UtilityClass;

/**
 * Created on 11/12/2021
 *
 * @author manu
 */
@UtilityClass
public class Constant {
    public static final String SELECT_EVENTS_JOIN_TICKETS = "SELECT e.id, event_name, event_description, start_date, " +
            "end_date, start_time, end_time, address_id, t.rate_type, t.applied_TVA FROM Event e JOIN Ticket t ON e.id = t.event_id";
}
