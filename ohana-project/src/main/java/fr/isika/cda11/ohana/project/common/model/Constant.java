package fr.isika.cda11.ohana.project.common.model;

import lombok.experimental.UtilityClass;

/**
 * Created on 11/12/2021
 *
 * @author manu
 */
@UtilityClass
public class Constant {
    public static final String SELECT_EVENTS_JOIN_TICKETS = "SELECT e FROM Event e INNER JOIN e.tickets t";
}
