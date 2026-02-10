package com.example.bfhl.model;

public class ApiResponse {

    public boolean is_success;
    public String official_email;
    public Object data;
    public String error;

    public ApiResponse(boolean is_success, String official_email, Object data, String error) {
        this.is_success = is_success;
        this.official_email = official_email;
        this.data = data;
        this.error = error;
    }
}
