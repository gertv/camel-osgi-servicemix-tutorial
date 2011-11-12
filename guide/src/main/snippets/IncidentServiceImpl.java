package org.fusesource.devoxx.reportincident.service.impl;

import java.util.List;

import org.fusesource.devoxx.reportincident.model.Incident;
import org.fusesource.devoxx.reportincident.dao.IncidentDAO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fusesource.devoxx.reportincident.service.IncidentService;

public class IncidentServiceImpl implements IncidentService {
    
    private static final transient Log LOG = LogFactory.getLog(IncidentServiceImpl.class);

    private IncidentDAO incidentDAO;

    public void saveIncident(Incident incident) {
        try {
            getIncidentDAO().saveIncident(incident);
        } catch (RuntimeException e) {

            e.printStackTrace();
        }
    }

    public void removeIncident(long id) {
        getIncidentDAO().removeIncident(id);
    }

    public Incident getIncident(long id) {
        return getIncidentDAO().getIncident(id);
    }

    public List<Incident> findIncident() {
        return getIncidentDAO().findIncident();
    }

    public List<Incident> findIncident(String key) {
        return getIncidentDAO().findIncident(key);
    }

    public IncidentDAO getIncidentDAO() {
        return incidentDAO;
    }

    public void setIncidentDAO(IncidentDAO incidentDAO) {
        this.incidentDAO = incidentDAO;
    }
}
