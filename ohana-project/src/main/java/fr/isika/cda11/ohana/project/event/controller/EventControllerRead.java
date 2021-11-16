package fr.isika.cda11.ohana.project.event.controller;

import fr.isika.cda11.ohana.project.event.models.Event;
import fr.isika.cda11.ohana.project.event.service.EventService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
@Getter
@Setter
public class EventControllerRead implements Serializable {

    private static final long serialVersionUID = -1606040173965309710L;

    private Event event;

    @Inject
    private EventService eventService;

    public void findEvent() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map<String, String> parameterMap =
                facesContext.getExternalContext().getRequestParameterMap();
        Long eventId = Long.parseLong(parameterMap.get("eventId"));
        event = eventService.findById(eventId);
    }

}
