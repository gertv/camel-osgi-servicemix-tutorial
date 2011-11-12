@WebService(targetNamespace = "http://reportincident.devoxx.fusesource.org",
            name = "ReportIncidentEndpoint")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ReportIncidentEndpoint {

    @WebResult(name = "outputReportIncident",
               targetNamespace = "http://reportincident.devoxx.fusesource.org",
               partName = "out")
    @WebMethod(operationName = "ReportIncident",
               action = "http://reportincident.devoxx.fusesource.org/ReportIncident")
    public OutputReportIncident reportIncident(
        @WebParam(partName = "in", name = "inputReportIncident",
                  targetNamespace = "http://reportincident.devoxx.fusesource.org")
        InputReportIncident in
    );

}
