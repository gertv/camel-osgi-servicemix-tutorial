import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",")
public class Incident extends Abstract implements Serializable {

    private static final long serialVersionUID = 1L;

    @DataField(pos = 1)
    private String incidentRef;
    
    @DataField(pos = 2, pattern = "dd-mm-yyyy")
    private Date incidentDate;

    @DataField(pos = 3)
    private String givenName;

    @DataField(pos = 4)
    private String familyName;
    
    @DataField(pos = 5)
    private String summary;
    
    @DataField(pos = 6)
    private String details;
   
    @DataField(pos = 7)
    private String email;
    
    @DataField(pos = 8)
    private String phone;

    /* SNIP */
}