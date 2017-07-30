package com.rlms.model.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by amitsingh on 30/07/17.
 */

public class ComplaintsResponse implements Serializable {

    public ComplaintsResponse() {
    }

    public ComplaintsResponse(int complaintId, String status) {
        this.complaintId = complaintId;
        this.status = status;
    }

    @SerializedName("complaintId")
    private int complaintId = 0;
    @SerializedName("userRoleId")
    private int userRoleId = 0;
    @SerializedName("liftCustoMapId")
    private int liftCustoMapId = 0;
    @SerializedName("complaintNumber")
    private String complaintNumber = "";
    @SerializedName("registrationDate")
    private long registrationDate = 0;
    @SerializedName("registrationDateStr")
    private long registrationDateStr = 0;
    @SerializedName("serviceStartDate")
    private long serviceStartDate = 0;
    @SerializedName("serviceStartDateStr")
    private long serviceStartDateStr=0;
    @SerializedName("actualServiceEndDate")
    private long actualServiceEndDate=0;
    @SerializedName("actualServiceEndDateStr")
    private long actualServiceEndDateStr = 0;
    @SerializedName("liftNumber")
    private String liftNumber = "";
    @SerializedName("customerName")
    private String customerName = "";
    @SerializedName("liftAddress")
    private String liftAddress = "";
    @SerializedName("latitude")
    private String latitude = "";
    @SerializedName("longitude")
    private String longitude = "";
    @SerializedName("registrationType")
    private String registrationType = "";
    @SerializedName("registrationTypeStr")
    private String registrationTypeStr = "";
    @SerializedName("remark")
    private String remark = "";
    @SerializedName("status")
    private String status = "";
    @SerializedName("title")
    private String title = "No Title";
    @SerializedName("technicianDtls")
    private String technicianDtls = "";
    @SerializedName("complaintent")
    private String complaintent = "";
    @SerializedName("regType")
    private String regType;
    @SerializedName("complaintTechMapId")
    private int complaintTechMapId;

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public int getLiftCustoMapId() {
        return liftCustoMapId;
    }

    public void setLiftCustoMapId(int liftCustoMapId) {
        this.liftCustoMapId = liftCustoMapId;
    }

    public String getComplaintNumber() {
        return complaintNumber;
    }

    public void setComplaintNumber(String complaintNumber) {
        this.complaintNumber = complaintNumber;
    }

    public long getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(long registrationDate) {
        this.registrationDate = registrationDate;
    }

    public long getRegistrationDateStr() {
        return registrationDateStr;
    }

    public void setRegistrationDateStr(long registrationDateStr) {
        this.registrationDateStr = registrationDateStr;
    }

    public long getServiceStartDate() {
        return serviceStartDate;
    }

    public void setServiceStartDate(long serviceStartDate) {
        this.serviceStartDate = serviceStartDate;
    }

    public long getServiceStartDateStr() {
        return serviceStartDateStr;
    }

    public void setServiceStartDateStr(long serviceStartDateStr) {
        this.serviceStartDateStr = serviceStartDateStr;
    }

    public long getActualServiceEndDate() {
        return actualServiceEndDate;
    }

    public void setActualServiceEndDate(long actualServiceEndDate) {
        this.actualServiceEndDate = actualServiceEndDate;
    }

    public long getActualServiceEndDateStr() {
        return actualServiceEndDateStr;
    }

    public void setActualServiceEndDateStr(long actualServiceEndDateStr) {
        this.actualServiceEndDateStr = actualServiceEndDateStr;
    }

    public String getLiftNumber() {
        return liftNumber;
    }

    public void setLiftNumber(String liftNumber) {
        this.liftNumber = liftNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLiftAddress() {
        return liftAddress;
    }

    public void setLiftAddress(String liftAddress) {
        this.liftAddress = liftAddress;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }

    public String getRegistrationTypeStr() {
        return registrationTypeStr;
    }

    public void setRegistrationTypeStr(String registrationTypeStr) {
        this.registrationTypeStr = registrationTypeStr;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTechnicianDtls() {
        return technicianDtls;
    }

    public void setTechnicianDtls(String technicianDtls) {
        this.technicianDtls = technicianDtls;
    }

    public String getComplaintent() {
        return complaintent;
    }

    public void setComplaintent(String complaintent) {
        this.complaintent = complaintent;
    }

    public String getRegType() {
        return regType;
    }

    public void setRegType(String regType) {
        this.regType = regType;
    }

    public int getComplaintTechMapId() {
        return complaintTechMapId;
    }

    public void setComplaintTechMapId(int complaintTechMapId) {
        this.complaintTechMapId = complaintTechMapId;
    }


}
