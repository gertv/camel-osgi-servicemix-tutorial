@WebServiceClient(name = "ReportIncidentEndpointService", 
                  wsdlLocation = "file:full/path/to/report_incident.wsdl",
                  targetNamespace = "http://reportincident.devoxx.fusesource.org") 
public class ReportIncidentEndpointService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE =
            new QName("http://reportincident.devoxx.fusesource.org",
                      "ReportIncidentEndpointService");
    public final static QName ReportIncidentPort =
            new QName("http://reportincident.devoxx.fusesource.org", "ReportIncidentPort");

    public ReportIncidentEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ReportIncidentEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ReportIncidentEndpointService() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns ReportIncidentEndpoint
     */
    @WebEndpoint(name = "ReportIncidentPort")
    public ReportIncidentEndpoint getReportIncidentPort() {
        return super.getPort(ReportIncidentPort, ReportIncidentEndpoint.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.
     *     Supported features not in the <code>features</code> parameter will have their
     *     default values.
     * @return
     *     returns ReportIncidentEndpoint
     */
    @WebEndpoint(name = "ReportIncidentPort")
    public ReportIncidentEndpoint getReportIncidentPort(WebServiceFeature... features) {
        return super.getPort(ReportIncidentPort, ReportIncidentEndpoint.class, features);
    }

}
