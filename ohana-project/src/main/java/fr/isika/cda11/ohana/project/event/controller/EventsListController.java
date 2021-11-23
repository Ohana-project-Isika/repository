package fr.isika.cda11.ohana.project.event.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import fr.isika.cda11.ohana.project.common.dto.AssociationDto;
import fr.isika.cda11.ohana.project.common.service.AssociationService;
import fr.isika.cda11.ohana.project.event.models.Event;
import fr.isika.cda11.ohana.project.event.service.EventService;

import static fr.isika.cda11.ohana.project.common.models.Constant.ACCOUNT_ATTRIBUTE;

@Named
@ViewScoped
public class EventsListController implements Serializable {

    private static final long serialVersionUID = -1606040173965309710L;

    private List<Event> events = new ArrayList<>();
    private UIComponent component;

    @Inject
    private EventService eventService;
    @Inject
    private AssociationService associationService;
    @PostConstruct
    private void init() {
        events = eventService.findAll();
    }

    public List<Event> getEvents() {
		return events;
	}
    public void setEvents(List<Event> events) {
		this.events = events;
	}

    public String listEventByAsso(){
        events.clear();
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
                .getSession(false);
        if (session.getAttribute(ACCOUNT_ATTRIBUTE) != null) {
            AssociationDto associationDto = associationService.findAssociationByIdService((Long)session.getAttribute(ACCOUNT_ATTRIBUTE));
            events.addAll(associationDto.getTicketing().getEvents());
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(component.getClientId(), new FacesMessage("Vous n'avez aucun évènement actuellement"));
            return "";
        } else {
            return "verificationPanier";
        }
    }

    private void foreach() {
    }
}
