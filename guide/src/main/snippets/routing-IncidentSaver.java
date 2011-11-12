package org.fusesource.devoxx.reportincident.internal;

import org.apache.camel.Exchange;
import org.fusesource.devoxx.reportincident.model.Incident;
import org.fusesource.devoxx.reportincident.service.IncidentService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class IncidentSaver {
    
    private IncidentService incidentService = null;

    public void process(Exchange exchange) throws ParseException {

        List<Map<String, Object>> models = new ArrayList<Map<String, Object>>();
        Map<String, Object> model = new HashMap<String, Object>();

        // Get models from message
        models = (List<Map<String, Object>>) exchange.getIn().getBody();
        
        // Get Header origin from message
        String origin = (String) exchange.getIn().getHeader("origin");

        Iterator<Map<String, Object>> it = models.iterator();
        
        // Specify current Date
        DateFormat format = new SimpleDateFormat( "dd/MM/yyyy HH:mm:ss" );
        String currentDate = format.format( new Date() );
        Date creationDate = format.parse( currentDate );
        
        while (it.hasNext()) {

            model = it.next();

            for (String key : model.keySet()) {
                
                // Retrieve incident from model
                Incident incident = (Incident) model.get(key);
                incident.setCreationDate(creationDate);
                incident.setCreationUser(origin);

                // Save org.fusesource.devoxx.reportincident.model.Incident
                incidentService.saveIncident(incident);
            }

        }

    }
    
    // Property used to inject service implementation
    public void setIncidentService(IncidentService incidentService) {
        this.incidentService = incidentService;
    }
}
