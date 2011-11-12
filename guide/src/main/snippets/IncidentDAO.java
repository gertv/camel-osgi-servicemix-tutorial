package org.fusesource.devoxx.reportincident.dao;

import java.util.List;
import org.fusesource.devoxx.reportincident.model.Incident;

public interface IncidentDAO {

  public Incident getIncident(long paramLong);
  public List<Incident> findIncident();
  public List<Incident> findIncident(String paramString);
  public void saveIncident(Incident paramIncident);
  public void removeIncident(long paramLong);

}