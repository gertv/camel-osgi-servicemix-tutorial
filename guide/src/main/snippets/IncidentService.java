package org.fusesource.devoxx.reportincident.service;

import java.util.List;
import org.fusesource.devoxx.reportincident.model.Incident;

public interface IncidentService {

  public Incident getIncident( long id );
  public List<Incident> findIncident();
  public List<Incident> findIncident( String key );
  public void saveIncident( Incident incident );
  public void removeIncident( long id );

}