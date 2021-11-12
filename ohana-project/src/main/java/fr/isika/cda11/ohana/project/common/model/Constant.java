package fr.isika.cda11.ohana.project.common.model;

import lombok.experimental.UtilityClass;

/**
 * Created on 11/12/2021
 *
 * @author manu
 */
@UtilityClass
public class Constant {
    public static final String SELECT_EVENTS_JOIN_TICKETS = "SELECT e.event_name, e.event_description, " +
            "e.start_date, e.end_date, e.start_time, e.end_time, e.address_id, t.rate_type, t.applied_TVA " +
            "FROM Event e JOIN Ticket t ON e.id = t.event_id";
}
