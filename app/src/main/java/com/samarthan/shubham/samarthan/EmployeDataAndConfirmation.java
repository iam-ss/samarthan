package com.samarthan.shubham.samarthan;

import com.samarthan.shubham.samarthan.Employer;

/**
 * Created by SHUBHAM on 28-10-2017.
 */

public class EmployeDataAndConfirmation {
    private String confirmation;
    private Employer[] results;

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }

    public Employer[] getResults() {
        return results;
    }

    public void setResults(Employer[] results) {
        this.results = results;
    }
}
