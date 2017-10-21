package com.rlms.model.request;

/**
 * Created by amitsingh on 03/08/17.
 */

public class ComplaintStatusRequest {
    int complaintId;
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }
}
