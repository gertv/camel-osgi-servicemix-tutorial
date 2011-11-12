package org.fusesource.devoxx.reportincident.model;

import java.util.Date;

public class Incident extends Abstract implements Serializable {

    private static final long serialVersionUID = 1L;

    private String incidentRef;
    private Date incidentDate;
    private String givenName;
    private String familyName;
    private String summary;
    private String details;
    private String email;
    private String phone;
    private long incidentId;
    private String creationUser;
    private Date creationDate;

}
