package com.ncrcorp.ncrhire.pojo;

public class SourceCode {
    String source_code;
    int language_id;
    String expected_output;

    public SourceCode() {
    }

    public SourceCode(String source_code, int language_id, String expected_output) {
        this.source_code = source_code;
        this.language_id = language_id;
        this.expected_output = expected_output;
    }

    public String getSource_code() {
        return source_code;
    }

    public void setSource_code(String source_code) {
        this.source_code = source_code;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getExpected_output() {
        return expected_output;
    }

    public void setExpected_output(String expected_output) {
        this.expected_output = expected_output;
    }
}
