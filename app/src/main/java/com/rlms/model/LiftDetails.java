package com.rlms.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class LiftDetails {

        @SerializedName("liftNumber")
    private String liftNumber;

//    @SerializedName("address")
//    private String address;
//
//    @SerializedName("customerName")
//    private String customerName;
//
//    @SerializedName("branchName")
//    private String branchName;
//
//    @SerializedName("companyName")
//    private String companyName;
//
//    @SerializedName("city")
//    private String city;
//
//    @SerializedName("area")
//    private String area;
//
//    @SerializedName("pinCode")
//    private Integer pinCode;
//
//    @SerializedName("companyId")
//    private Integer companyId;
//
//    @SerializedName("branchCompanyMapId")
//    private Integer branchCompanyMapId;

//    @SerializedName("branchCustomerMapId")
//    private Integer branchCustomerMapId;

//    @SerializedName("liftId")
//    private Integer liftId;

    @SerializedName("latitude")
    private String latitude;

    @SerializedName("longitude")
    private String longitude;

//    @SerializedName("serviceStartDate")
//    private Date serviceStartDate;

//    @SerializedName("serviceStartDateStr")
//    private String serviceStartDateStr;

//    @SerializedName("serviceEndDate")
//    private Date serviceEndDate;
//
//    @SerializedName("serviceEndDateStr")
//    private String serviceEndDateStr;

//    @SerializedName("dateOfInstallation")
//    private Date dateOfInstallation;

//    @SerializedName("dateOfInstallationStr")
//    private String dateOfInstallationStr;

//    @SerializedName("amcStartDate")
//    private Date amcStartDate;

//    @SerializedName("amcEndDate")
//    private Date amcEndDate;

//    @SerializedName("amcStartDateStr")
//    private String amcStartDateStr;
//
//    @SerializedName("amcEndDateStr")
//    private String amcEndDateStr;

//    @SerializedName("amcType")
//    private Integer amcType;

//    @SerializedName("amcTypeStr")
//    private String amcTypeStr;
//
//    @SerializedName("amcAmount")
//    private String amcAmount;

    @SerializedName("doorType")
    private Integer doorType;

    @SerializedName("noOfStops")
    private String noOfStops;

    @SerializedName("engineType")
    private Integer engineType;

    @SerializedName("machineMake")
    private String machineMake;

    @SerializedName("machineCapacity")
    private String machineCapacity;

    @SerializedName("machineCurrent")
    private String machineCurrent;

//    @SerializedName("machinePhoto")
//    private String machinePhoto;

    @SerializedName("breakVoltage")
    private String breakVoltage;

    @SerializedName("panelMake")
    private String panelMake;

//    @SerializedName("panelPhoto")
//    private String panelPhoto;

    @SerializedName("ard")
    private String ard;

//    @SerializedName("ardPhoto")
//    private String ardPhoto;

    @SerializedName("noOfBatteries")
    private Integer noOfBatteries;

    @SerializedName("batteryCapacity")
    private String batteryCapacity;

    @SerializedName("batteryMake")
    private String batteryMake;

    @SerializedName("copMake")
    private String copMake;

//    @SerializedName("copPhoto")
//    private String copPhoto;

    @SerializedName("lopMake")
    private String  lopMake;

//    @SerializedName("lopPhoto")
//    private String lopPhoto;

    @SerializedName("collectiveType")
    private Integer collectiveType;

    @SerializedName("simplexDuplex")
    private Integer simplexDuplex;

//    @SerializedName("cartopPhoto")
//    private String cartopPhoto;

//    @SerializedName("autoDoorMake")
//    private String autoDoorMake;

//    @SerializedName("autoDoorHeaderPhoto")
//    private String autoDoorHeaderPhoto;

    @SerializedName("wiringShceme")
    private Integer wiringShceme;

//    @SerializedName("wiringPhoto")
//    private String wiringPhoto;

    @SerializedName("fireMode")
    private Integer fireMode;

//    @SerializedName("intercomm")
//    private String intercomm;

//    @SerializedName("alarm")
//    private Integer alarm;

    @SerializedName("alarmBattery")
    private String alarmBattery;

    @SerializedName("accessControl")
    private String accessControl;

    @SerializedName("liftCustomerMapId")
    private Integer liftCustomerMapId;

    @SerializedName("photoType")
    private Integer photoType;

    @SerializedName("liftType")
    private Integer liftType;

//    @SerializedName("lobbyPhoto")
//    private String lobbyPhoto;
//
//    @SerializedName("fyaTranId")
//    private Integer fyaTranId;



//    @SerializedName("isBlank")
//    private boolean isBlank;
//
//    @SerializedName("activeFlag")
//    private Integer activeFlag;


    public String getLiftNumber() {
        return liftNumber;
    }

    public void setLiftNumber(String liftNumber) {
        this.liftNumber = liftNumber;
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

    public Integer getDoorType() {
        return doorType;
    }

    public void setDoorType(Integer doorType) {
        this.doorType = doorType;
    }

    public String getNoOfStops() {
        return noOfStops;
    }

    public void setNoOfStops(String noOfStops) {
        this.noOfStops = noOfStops;
    }

    public Integer getEngineType() {
        return engineType;
    }

    public void setEngineType(Integer engineType) {
        this.engineType = engineType;
    }

    public String getMachineMake() {
        return machineMake;
    }

    public void setMachineMake(String machineMake) {
        this.machineMake = machineMake;
    }

    public String getMachineCapacity() {
        return machineCapacity;
    }

    public void setMachineCapacity(String machineCapacity) {
        this.machineCapacity = machineCapacity;
    }

    public String getMachineCurrent() {
        return machineCurrent;
    }

    public void setMachineCurrent(String machineCurrent) {
        this.machineCurrent = machineCurrent;
    }

    public String getBreakVoltage() {
        return breakVoltage;
    }

    public void setBreakVoltage(String breakVoltage) {
        this.breakVoltage = breakVoltage;
    }

    public String getPanelMake() {
        return panelMake;
    }

    public void setPanelMake(String panelMake) {
        this.panelMake = panelMake;
    }

    public String getArd() {
        return ard;
    }

    public void setArd(String ard) {
        this.ard = ard;
    }

    public Integer getNoOfBatteries() {
        return noOfBatteries;
    }

    public void setNoOfBatteries(Integer noOfBatteries) {
        this.noOfBatteries = noOfBatteries;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getBatteryMake() {
        return batteryMake;
    }

    public void setBatteryMake(String batteryMake) {
        this.batteryMake = batteryMake;
    }

    public String getCopMake() {
        return copMake;
    }

    public void setCopMake(String copMake) {
        this.copMake = copMake;
    }

    public String getLopMake() {
        return lopMake;
    }

    public void setLopMake(String lopMake) {
        this.lopMake = lopMake;
    }

    public Integer getCollectiveType() {
        return collectiveType;
    }

    public void setCollectiveType(Integer collectiveType) {
        this.collectiveType = collectiveType;
    }

    public Integer getSimplexDuplex() {
        return simplexDuplex;
    }

    public void setSimplexDuplex(Integer simplexDuplex) {
        this.simplexDuplex = simplexDuplex;
    }

    public Integer getWiringShceme() {
        return wiringShceme;
    }

    public void setWiringShceme(Integer wiringShceme) {
        this.wiringShceme = wiringShceme;
    }

    public Integer getFireMode() {
        return fireMode;
    }

    public void setFireMode(Integer fireMode) {
        this.fireMode = fireMode;
    }

    public String getAlarmBattery() {
        return alarmBattery;
    }

    public void setAlarmBattery(String alarmBattery) {
        this.alarmBattery = alarmBattery;
    }

    public String getAccessControl() {
        return accessControl;
    }

    public void setAccessControl(String accessControl) {
        this.accessControl = accessControl;
    }

    public Integer getLiftCustomerMapId() {
        return liftCustomerMapId;
    }

    public void setLiftCustomerMapId(Integer liftCustomerMapId) {
        this.liftCustomerMapId = liftCustomerMapId;
    }

    public Integer getPhotoType() {
        return photoType;
    }

    public void setPhotoType(Integer photoType) {
        this.photoType = photoType;
    }

    public Integer getLiftType() {
        return liftType;
    }

    public void setLiftType(Integer liftType) {
        this.liftType = liftType;
    }
}


