package com.rlms.model.request;

/**
 * Created by amitsingh on 17/09/17.
 */

public class ImageUploadRequest {
    private String liftCustomerMapId;
    private String photoType;

    public String getLiftCustomerMapId() {
        return liftCustomerMapId;
    }

    public void setLiftCustomerMapId(String liftCustomerMapId) {
        this.liftCustomerMapId = liftCustomerMapId;
    }

    public String getPhotoType() {
        return photoType;
    }

    public void setPhotoType(String photoType) {
        this.photoType = photoType;
    }
}
