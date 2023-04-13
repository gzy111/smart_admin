package com.example.smart_admin.domain;

public class LoginRequest {

    private Long userId;
    private String password;

    private String adminFlg;

    private String passCode;

    public String getAdminFlg() {
        return adminFlg;
    }

    public void setAdminFlg(String adminFlg) {
        this.adminFlg = adminFlg;
    }

    public String getPassCode() {
        return passCode;
    }

    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
