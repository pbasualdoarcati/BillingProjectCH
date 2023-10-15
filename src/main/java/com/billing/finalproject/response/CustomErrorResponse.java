package com.billing.finalproject.response;

import org.springframework.http.HttpStatus;

public class CustomErrorResponse {
    private String message;
    private String details;
    private HttpStatus status;
    private String path;

    public CustomErrorResponse() {
    }

    public CustomErrorResponse(String message, String details, HttpStatus status, String path) {
        this.message = message;
        this.details = details;
        this.status = status;
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
