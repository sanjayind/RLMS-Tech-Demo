package com.rlms.callback;

import com.rlms.model.response.ComplaintsResponse;

import java.util.List;

public interface OnFetchItemsFinishCallback {

//    public void onFetchItemsCallback(List<Complaints> fetchedComplaintsList);

    public void onFetchItemsCallback(List<ComplaintsResponse> fetchedComplaintsList);

}