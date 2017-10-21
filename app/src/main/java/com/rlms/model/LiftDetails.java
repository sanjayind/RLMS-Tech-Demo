package com.rlms.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LiftDetails {

    @SerializedName("liftNumber")
    @Expose
    private String liftNumber;
    @SerializedName("address")
    @Expose
    private Object address;
    @SerializedName("customerName")
    @Expose
    private Object customerName;
    @SerializedName("branchName")
    @Expose
    private Object branchName;
    @SerializedName("companyName")
    @Expose
    private Object companyName;
    @SerializedName("city")
    @Expose
    private Object city;
    @SerializedName("area")
    @Expose
    private Object area;
    @SerializedName("pinCode")
    @Expose
    private Object pinCode;
    @SerializedName("companyId")
    @Expose
    private Object companyId;
    @SerializedName("branchCompanyMapId")
    @Expose
    private Object branchCompanyMapId;
    @SerializedName("branchCustomerMapId")
    @Expose
    private Object branchCustomerMapId;
    @SerializedName("liftId")
    @Expose
    private Object liftId;
    @SerializedName("latitude")
    @Expose
    private Object latitude;
    @SerializedName("longitude")
    @Expose
    private Object longitude;
    @SerializedName("serviceStartDate")
    @Expose
    private Object serviceStartDate;
    @SerializedName("serviceStartDateStr")
    @Expose
    private Object serviceStartDateStr;
    @SerializedName("serviceEndDate")
    @Expose
    private Object serviceEndDate;
    @SerializedName("serviceEndDateStr")
    @Expose
    private Object serviceEndDateStr;
    @SerializedName("dateOfInstallation")
    @Expose
    private Object dateOfInstallation;
    @SerializedName("dateOfInstallationStr")
    @Expose
    private Object dateOfInstallationStr;
    @SerializedName("amcStartDate")
    @Expose
    private Object amcStartDate;
    @SerializedName("amcEndDate")
    @Expose
    private Object amcEndDate;
    @SerializedName("amcStartDateStr")
    @Expose
    private Object amcStartDateStr;
    @SerializedName("amcEndDateStr")
    @Expose
    private Object amcEndDateStr;
    @SerializedName("amcType")
    @Expose
    private Object amcType;
    @SerializedName("amcAmount")
    @Expose
    private Object amcAmount;
    @SerializedName("doorType")
    @Expose
    private Object doorType;
    @SerializedName("noOfStops")
    @Expose
    private Object noOfStops;
    @SerializedName("engineType")
    @Expose
    private Object engineType;
    @SerializedName("machineMake")
    @Expose
    private Object machineMake;
    @SerializedName("machineCapacity")
    @Expose
    private Object machineCapacity;
    @SerializedName("machineCurrent")
    @Expose
    private Object machineCurrent;
    @SerializedName("machinePhoto")
    @Expose
    private Object machinePhoto;
    @SerializedName("breakVoltage")
    @Expose
    private Object breakVoltage;
    @SerializedName("panelMake")
    @Expose
    private Object panelMake;
    @SerializedName("panelPhoto")
    @Expose
    private Object panelPhoto;
    @SerializedName("ard")
    @Expose
    private Object ard;
    @SerializedName("ardPhoto")
    @Expose
    private Object ardPhoto;
    @SerializedName("noOfBatteries")
    @Expose
    private Object noOfBatteries;
    @SerializedName("batteryCapacity")
    @Expose
    private Object batteryCapacity;
    @SerializedName("batteryMake")
    @Expose
    private Object batteryMake;
    @SerializedName("copMake")
    @Expose
    private Object copMake;
    @SerializedName("copPhoto")
    @Expose
    private Object copPhoto;
    @SerializedName("lopMake")
    @Expose
    private Object lopMake;
    @SerializedName("lopPhoto")
    @Expose
    private Object lopPhoto;
    @SerializedName("collectiveType")
    @Expose
    private Object collectiveType;
    @SerializedName("simplexDuplex")
    @Expose
    private Object simplexDuplex;
    @SerializedName("cartopPhoto")
    @Expose
    private Object cartopPhoto;
    @SerializedName("autoDoorMake")
    @Expose
    private Object autoDoorMake;
    @SerializedName("autoDoorHeaderPhoto")
    @Expose
    private Object autoDoorHeaderPhoto;
    @SerializedName("wiringShceme")
    @Expose
    private Object wiringShceme;
    @SerializedName("wiringPhoto")
    @Expose
    private Object wiringPhoto;
    @SerializedName("fireMode")
    @Expose
    private Object fireMode;
    @SerializedName("intercomm")
    @Expose
    private Object intercomm;
    @SerializedName("alarm")
    @Expose
    private Object alarm;
    @SerializedName("alarmBattery")
    @Expose
    private Object alarmBattery;
    @SerializedName("accessControl")
    @Expose
    private Object accessControl;
    @SerializedName("lobbyPhoto")
    @Expose
    private Object lobbyPhoto;
    @SerializedName("fyaTranId")
    @Expose
    private Object fyaTranId;
    @SerializedName("liftCustomerMapId")
    @Expose
    private Integer liftCustomerMapId;
    @SerializedName("photoType")
    @Expose
    private Object photoType;
    @SerializedName("liftType")
    @Expose
    private Object liftType;
    @SerializedName("blank")
    @Expose
    private Boolean blank;

    public String getLiftNumber() {
        return liftNumber;
    }

    public void setLiftNumber(String liftNumber) {
        this.liftNumber = liftNumber;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public Object getCustomerName() {
        return customerName;
    }

    public void setCustomerName(Object customerName) {
        this.customerName = customerName;
    }

    public Object getBranchName() {
        return branchName;
    }

    public void setBranchName(Object branchName) {
        this.branchName = branchName;
    }

    public Object getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Object companyName) {
        this.companyName = companyName;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public Object getArea() {
        return area;
    }

    public void setArea(Object area) {
        this.area = area;
    }

    public Object getPinCode() {
        return pinCode;
    }

    public void setPinCode(Object pinCode) {
        this.pinCode = pinCode;
    }

    public Object getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Object companyId) {
        this.companyId = companyId;
    }

    public Object getBranchCompanyMapId() {
        return branchCompanyMapId;
    }

    public void setBranchCompanyMapId(Object branchCompanyMapId) {
        this.branchCompanyMapId = branchCompanyMapId;
    }

    public Object getBranchCustomerMapId() {
        return branchCustomerMapId;
    }

    public void setBranchCustomerMapId(Object branchCustomerMapId) {
        this.branchCustomerMapId = branchCustomerMapId;
    }

    public Object getLiftId() {
        return liftId;
    }

    public void setLiftId(Object liftId) {
        this.liftId = liftId;
    }

    public Object getLatitude() {
        return latitude;
    }

    public void setLatitude(Object latitude) {
        this.latitude = latitude;
    }

    public Object getLongitude() {
        return longitude;
    }

    public void setLongitude(Object longitude) {
        this.longitude = longitude;
    }

    public Object getServiceStartDate() {
        return serviceStartDate;
    }

    public void setServiceStartDate(Object serviceStartDate) {
        this.serviceStartDate = serviceStartDate;
    }

    public Object getServiceStartDateStr() {
        return serviceStartDateStr;
    }

    public void setServiceStartDateStr(Object serviceStartDateStr) {
        this.serviceStartDateStr = serviceStartDateStr;
    }

    public Object getServiceEndDate() {
        return serviceEndDate;
    }

    public void setServiceEndDate(Object serviceEndDate) {
        this.serviceEndDate = serviceEndDate;
    }

    public Object getServiceEndDateStr() {
        return serviceEndDateStr;
    }

    public void setServiceEndDateStr(Object serviceEndDateStr) {
        this.serviceEndDateStr = serviceEndDateStr;
    }

    public Object getDateOfInstallation() {
        return dateOfInstallation;
    }

    public void setDateOfInstallation(Object dateOfInstallation) {
        this.dateOfInstallation = dateOfInstallation;
    }

    public Object getDateOfInstallationStr() {
        return dateOfInstallationStr;
    }

    public void setDateOfInstallationStr(Object dateOfInstallationStr) {
        this.dateOfInstallationStr = dateOfInstallationStr;
    }

    public Object getAmcStartDate() {
        return amcStartDate;
    }

    public void setAmcStartDate(Object amcStartDate) {
        this.amcStartDate = amcStartDate;
    }

    public Object getAmcEndDate() {
        return amcEndDate;
    }

    public void setAmcEndDate(Object amcEndDate) {
        this.amcEndDate = amcEndDate;
    }

    public Object getAmcStartDateStr() {
        return amcStartDateStr;
    }

    public void setAmcStartDateStr(Object amcStartDateStr) {
        this.amcStartDateStr = amcStartDateStr;
    }

    public Object getAmcEndDateStr() {
        return amcEndDateStr;
    }

    public void setAmcEndDateStr(Object amcEndDateStr) {
        this.amcEndDateStr = amcEndDateStr;
    }

    public Object getAmcType() {
        return amcType;
    }

    public void setAmcType(Object amcType) {
        this.amcType = amcType;
    }

    public Object getAmcAmount() {
        return amcAmount;
    }

    public void setAmcAmount(Object amcAmount) {
        this.amcAmount = amcAmount;
    }

    public Object getDoorType() {
        return doorType;
    }

    public void setDoorType(Object doorType) {
        this.doorType = doorType;
    }

    public Object getNoOfStops() {
        return noOfStops;
    }

    public void setNoOfStops(Object noOfStops) {
        this.noOfStops = noOfStops;
    }

    public Object getEngineType() {
        return engineType;
    }

    public void setEngineType(Object engineType) {
        this.engineType = engineType;
    }

    public Object getMachineMake() {
        return machineMake;
    }

    public void setMachineMake(Object machineMake) {
        this.machineMake = machineMake;
    }

    public Object getMachineCapacity() {
        return machineCapacity;
    }

    public void setMachineCapacity(Object machineCapacity) {
        this.machineCapacity = machineCapacity;
    }

    public Object getMachineCurrent() {
        return machineCurrent;
    }

    public void setMachineCurrent(Object machineCurrent) {
        this.machineCurrent = machineCurrent;
    }

    public Object getMachinePhoto() {
        return machinePhoto;
    }

    public void setMachinePhoto(Object machinePhoto) {
        this.machinePhoto = machinePhoto;
    }

    public Object getBreakVoltage() {
        return breakVoltage;
    }

    public void setBreakVoltage(Object breakVoltage) {
        this.breakVoltage = breakVoltage;
    }

    public Object getPanelMake() {
        return panelMake;
    }

    public void setPanelMake(Object panelMake) {
        this.panelMake = panelMake;
    }

    public Object getPanelPhoto() {
        return panelPhoto;
    }

    public void setPanelPhoto(Object panelPhoto) {
        this.panelPhoto = panelPhoto;
    }

    public Object getArd() {
        return ard;
    }

    public void setArd(Object ard) {
        this.ard = ard;
    }

    public Object getArdPhoto() {
        return ardPhoto;
    }

    public void setArdPhoto(Object ardPhoto) {
        this.ardPhoto = ardPhoto;
    }

    public Object getNoOfBatteries() {
        return noOfBatteries;
    }

    public void setNoOfBatteries(Object noOfBatteries) {
        this.noOfBatteries = noOfBatteries;
    }

    public Object getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Object batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public Object getBatteryMake() {
        return batteryMake;
    }

    public void setBatteryMake(Object batteryMake) {
        this.batteryMake = batteryMake;
    }

    public Object getCopMake() {
        return copMake;
    }

    public void setCopMake(Object copMake) {
        this.copMake = copMake;
    }

    public Object getCopPhoto() {
        return copPhoto;
    }

    public void setCopPhoto(Object copPhoto) {
        this.copPhoto = copPhoto;
    }

    public Object getLopMake() {
        return lopMake;
    }

    public void setLopMake(Object lopMake) {
        this.lopMake = lopMake;
    }

    public Object getLopPhoto() {
        return lopPhoto;
    }

    public void setLopPhoto(Object lopPhoto) {
        this.lopPhoto = lopPhoto;
    }

    public Object getCollectiveType() {
        return collectiveType;
    }

    public void setCollectiveType(Object collectiveType) {
        this.collectiveType = collectiveType;
    }

    public Object getSimplexDuplex() {
        return simplexDuplex;
    }

    public void setSimplexDuplex(Object simplexDuplex) {
        this.simplexDuplex = simplexDuplex;
    }

    public Object getCartopPhoto() {
        return cartopPhoto;
    }

    public void setCartopPhoto(Object cartopPhoto) {
        this.cartopPhoto = cartopPhoto;
    }

    public Object getAutoDoorMake() {
        return autoDoorMake;
    }

    public void setAutoDoorMake(Object autoDoorMake) {
        this.autoDoorMake = autoDoorMake;
    }

    public Object getAutoDoorHeaderPhoto() {
        return autoDoorHeaderPhoto;
    }

    public void setAutoDoorHeaderPhoto(Object autoDoorHeaderPhoto) {
        this.autoDoorHeaderPhoto = autoDoorHeaderPhoto;
    }

    public Object getWiringShceme() {
        return wiringShceme;
    }

    public void setWiringShceme(Object wiringShceme) {
        this.wiringShceme = wiringShceme;
    }

    public Object getWiringPhoto() {
        return wiringPhoto;
    }

    public void setWiringPhoto(Object wiringPhoto) {
        this.wiringPhoto = wiringPhoto;
    }

    public Object getFireMode() {
        return fireMode;
    }

    public void setFireMode(Object fireMode) {
        this.fireMode = fireMode;
    }

    public Object getIntercomm() {
        return intercomm;
    }

    public void setIntercomm(Object intercomm) {
        this.intercomm = intercomm;
    }

    public Object getAlarm() {
        return alarm;
    }

    public void setAlarm(Object alarm) {
        this.alarm = alarm;
    }

    public Object getAlarmBattery() {
        return alarmBattery;
    }

    public void setAlarmBattery(Object alarmBattery) {
        this.alarmBattery = alarmBattery;
    }

    public Object getAccessControl() {
        return accessControl;
    }

    public void setAccessControl(Object accessControl) {
        this.accessControl = accessControl;
    }

    public Object getLobbyPhoto() {
        return lobbyPhoto;
    }

    public void setLobbyPhoto(Object lobbyPhoto) {
        this.lobbyPhoto = lobbyPhoto;
    }

    public Object getFyaTranId() {
        return fyaTranId;
    }

    public void setFyaTranId(Object fyaTranId) {
        this.fyaTranId = fyaTranId;
    }

    public Integer getLiftCustomerMapId() {
        return liftCustomerMapId;
    }

    public void setLiftCustomerMapId(Integer liftCustomerMapId) {
        this.liftCustomerMapId = liftCustomerMapId;
    }

    public Object getPhotoType() {
        return photoType;
    }

    public void setPhotoType(Object photoType) {
        this.photoType = photoType;
    }

    public Object getLiftType() {
        return liftType;
    }

    public void setLiftType(Object liftType) {
        this.liftType = liftType;
    }

    public Boolean getBlank() {
        return blank;
    }

    public void setBlank(Boolean blank) {
        this.blank = blank;
    }

    @Override
    public String toString() {
        return "LiftDetails{" +
                "liftNumber='" + liftNumber + '\'' +
                ", address=" + address +
                ", customerName=" + customerName +
                ", branchName=" + branchName +
                ", companyName=" + companyName +
                ", city=" + city +
                ", area=" + area +
                ", pinCode=" + pinCode +
                ", companyId=" + companyId +
                ", branchCompanyMapId=" + branchCompanyMapId +
                ", branchCustomerMapId=" + branchCustomerMapId +
                ", liftId=" + liftId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", serviceStartDate=" + serviceStartDate +
                ", serviceStartDateStr=" + serviceStartDateStr +
                ", serviceEndDate=" + serviceEndDate +
                ", serviceEndDateStr=" + serviceEndDateStr +
                ", dateOfInstallation=" + dateOfInstallation +
                ", dateOfInstallationStr=" + dateOfInstallationStr +
                ", amcStartDate=" + amcStartDate +
                ", amcEndDate=" + amcEndDate +
                ", amcStartDateStr=" + amcStartDateStr +
                ", amcEndDateStr=" + amcEndDateStr +
                ", amcType=" + amcType +
                ", amcAmount=" + amcAmount +
                ", doorType=" + doorType +
                ", noOfStops=" + noOfStops +
                ", engineType=" + engineType +
                ", machineMake=" + machineMake +
                ", machineCapacity=" + machineCapacity +
                ", machineCurrent=" + machineCurrent +
                ", machinePhoto=" + machinePhoto +
                ", breakVoltage=" + breakVoltage +
                ", panelMake=" + panelMake +
                ", panelPhoto=" + panelPhoto +
                ", ard=" + ard +
                ", ardPhoto=" + ardPhoto +
                ", noOfBatteries=" + noOfBatteries +
                ", batteryCapacity=" + batteryCapacity +
                ", batteryMake=" + batteryMake +
                ", copMake=" + copMake +
                ", copPhoto=" + copPhoto +
                ", lopMake=" + lopMake +
                ", lopPhoto=" + lopPhoto +
                ", collectiveType=" + collectiveType +
                ", simplexDuplex=" + simplexDuplex +
                ", cartopPhoto=" + cartopPhoto +
                ", autoDoorMake=" + autoDoorMake +
                ", autoDoorHeaderPhoto=" + autoDoorHeaderPhoto +
                ", wiringShceme=" + wiringShceme +
                ", wiringPhoto=" + wiringPhoto +
                ", fireMode=" + fireMode +
                ", intercomm=" + intercomm +
                ", alarm=" + alarm +
                ", alarmBattery=" + alarmBattery +
                ", accessControl=" + accessControl +
                ", lobbyPhoto=" + lobbyPhoto +
                ", fyaTranId=" + fyaTranId +
                ", liftCustomerMapId=" + liftCustomerMapId +
                ", photoType=" + photoType +
                ", liftType=" + liftType +
                ", blank=" + blank +
                '}';
    }
}


