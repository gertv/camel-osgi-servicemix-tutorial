package org.fusesource.devoxx.reportincident.internal;

/* SNIP */

public class WebService {

    public void process(Exchange exchange) throws ParseException {
        
        InputReportIncident webincident = (InputReportIncident)exchange.getIn().getBody();

        List<Map<String, Incident>> models = new ArrayList<Map<String, Incident>>();
        Map<String, Incident> model = new HashMap<String, Incident>();
            
        // Convert the InputReportIncident into
        // an org.apache.camel.example.reportincident.model.Incident instance
        Incident incident = new Incident();
        
        DateFormat format = new SimpleDateFormat( "dd-MM-yyyy" );
        incident.setIncidentDate(format.parse(webincident.getIncidentDate()));
        
        incident.setDetails(webincident.getDetails());
        incident.setEmail(webincident.getEmail());
        incident.setFamilyName(webincident.getFamilyName());
        incident.setGivenName(webincident.getGivenName());
        incident.setIncidentRef(webincident.getIncidentId());
        incident.setPhone(webincident.getPhone());
        incident.setSummary(webincident.getSummary());
        
        // Get Header origin from message
        String origin = (String) exchange.getIn().getHeader("origin");

        // Specify current Date
        format = new SimpleDateFormat( "dd/MM/yyyy HH:mm:ss" );
        String currentDate = format.format( new Date() );
        Date creationDate = format.parse( currentDate );
        
        incident.setCreationDate(creationDate);
        incident.setCreationUser(origin);
        
        // and place it in a model (cfr camel-bindy)
        model.put(Incident.class.getName(), incident);
        models.add(model);
        
        // replace with our input
        exchange.getOut().setBody(models);
        
        // propagate the header
        exchange.getOut().setHeader("origin", origin);
         
     }
}
