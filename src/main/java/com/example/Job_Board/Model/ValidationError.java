package com.example.Job_Board.Model;

public class ValidationError {
    private String fieldName;
    private String errormessage;

    public ValidationError() {
    }

    public ValidationError(String fieldName, String errormessage) {
        this.fieldName = fieldName;
        this.errormessage = errormessage;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }

    @Override
    public String toString() {
        return "ValidationError{" +
                "fieldName='" + fieldName + '\'' +
                ", errormessage='" + errormessage + '\'' +
                '}';
    }
}
