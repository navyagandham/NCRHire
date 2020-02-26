package com.ncrcorp.ncrhire.pojo;

public class SubmissionDetails {
    String stdout, time, expected_output;
    int language_id, status_id;

    public SubmissionDetails() {
    }

    public SubmissionDetails(String stdout, String time, String expected_output, int language_id, int status_id) {
        this.stdout = stdout;
        this.time = time;
        this.expected_output = expected_output;
        this.language_id = language_id;
        this.status_id = status_id;
    }

    public String getStdout() {
        return stdout;
    }

    public void setStdout(String stdout) {
        this.stdout = stdout;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getExpected_output() {
        return expected_output;
    }

    public void setExpected_output(String expected_output) {
        this.expected_output = expected_output;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    @Override
    public String toString() {
        return "SubmissionDetails{" +
                "stdout='" + stdout + '\'' +
                ", time='" + time + '\'' +
                ", expected_output='" + expected_output + '\'' +
                ", language_id=" + language_id +
                ", status_id=" + status_id +
                '}';
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }
}
