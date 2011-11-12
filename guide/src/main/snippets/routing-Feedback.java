package org.fusesource.devoxx.reportincident.internal;

import org.fusesource.devoxx.reportincident.OutputReportIncident;

public class Feedback {

    public OutputReportIncident setOk() {
        OutputReportIncident outputReportIncident = new OutputReportIncident();
        outputReportIncident.setCode("0");
        return outputReportIncident;
    }

}