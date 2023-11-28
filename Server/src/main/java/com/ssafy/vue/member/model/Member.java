package com.ssafy.vue.member.model;

import java.util.Date;

public class Member {
    private String user_name, user_password, email_id, email_domain;
    private String user_id, salt, access_token, refresh_token, profile_image;
    private Date join_date;
    private byte[] blob_image;

    public Member() { }

    public Member(String user_name, String user_password, String email_id, String email_domain, String user_id,
                  String salt,
                  String access_token, String refresh_token, String profile_image, Date join_date, byte[] blob_image) {
        this.user_name = user_name;
        this.user_password = user_password;
        this.email_id = email_id;
        this.email_domain = email_domain;
        this.user_id = user_id;
        this.salt = salt;
        this.access_token = access_token;
        this.refresh_token = refresh_token;
        this.profile_image = profile_image;
        this.join_date = join_date;
        this.blob_image = blob_image;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getEmail_domain() {
        return email_domain;
    }

    public void setEmail_domain(String email_domain) {
        this.email_domain = email_domain;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    public byte[] getBlob_image() {
        return blob_image;
    }

    public void setBlob_image(byte[] blob_image) {
        this.blob_image = blob_image;
    }

    @Override
    public String toString() {
        return "Member{" +
                "user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", email_id='" + email_id + '\'' +
                ", email_domain='" + email_domain + '\'' +
                ", user_id='" + user_id + '\'' +
                ", salt='" + salt + '\'' +
                ", access_token='" + access_token + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                ", profile_image='" + profile_image + '\'' +
                ", join_date=" + join_date +
                '}';
    }
}
