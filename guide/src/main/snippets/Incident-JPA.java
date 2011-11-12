import javax.persistence.*;

@Entity
@Table(name = "T_INCIDENT")
public class Incident extends Abstract implements Serializable {

    @Column(name = "INCIDENT_REF", length = 55)
    private String incidentRef;

    @Column(name = "INCIDENT_DATE")
    private Date incidentDate;

    @Column(name = "GIVEN_NAME", length = 35)
    private String givenName;

    @Column(name = "FAMILY_NAME", length = 35)
    private String familyName;

    @Column(name = "SUMMARY", length = 35)
    private String summary;

    @Column(name = "DETAILS")
    private String details;

    @Column(name = "EMAIL", length = 60)
    private String email;

    @Column(name = "PHONE", length = 35)
    private String phone;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "INCIDENT_ID")
    private long incidentId;

    @Column(name = "CREATION_USER")
    private String creationUser;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    /* SNIP */
}
