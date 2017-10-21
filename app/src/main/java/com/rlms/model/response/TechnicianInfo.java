package com.rlms.model.response;

import com.google.gson.annotations.SerializedName;

public class TechnicianInfo {

    @SerializedName("branchCompanyMapId")
    String branchCompanyMapId;

    @SerializedName("branchName")
    String branchName;

    @SerializedName("companyName")
    String companyName;

    @SerializedName("firstName")
    String firstName;

    @SerializedName("lastName")
    String lastName;

    @SerializedName("userId")
    String userId;

    @SerializedName("userRoleId")
    int userRoleId;

    @SerializedName("address")
    String address;

    @SerializedName("contactNumber")
    String contactNumber;

    @SerializedName("latitude")
    double latitude;

    @SerializedName("longitude")
    double longitude;

    @SerializedName("pinCode")
    String pinCode;

    @SerializedName("userRoleName")
    String userRoleName;

    @SerializedName("emailId")
    String emailId;

    @SerializedName("appRegId")
    String appRegId;

    @SerializedName("area")
    String area;

    @SerializedName("city")
    String city;

    @SerializedName("companyId")
    String companyId;

    @SerializedName("userName")
    String userName;

    public TechnicianInfo() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBranchCompanyMapId() {
        return branchCompanyMapId;
    }

    public void setBranchCompanyMapId(String branchCompanyMapId) {
        this.branchCompanyMapId = branchCompanyMapId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAppRegId() {
        return appRegId;
    }

    public void setAppRegId(String appRegId) {
        this.appRegId = appRegId;
    }
}
