package com.rlms.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rlms.R;
import com.rlms.Repository.AuthRepository;
import com.rlms.Repository.ReqPriority;
import com.rlms.adapters.VisitDetailsListAdapter;
import com.rlms.apiresponsehandler.ApiResponseListener;
import com.rlms.callback.RecyclerViewItemClickListener;
import com.rlms.exception.ApiException;
import com.rlms.model.Technician;
import com.rlms.model.VisitDetails;
import com.rlms.model.request.LiftsReqest;
import com.rlms.model.response.ApiResponse;
import com.rlms.model.response.ComplaintsResponse;
import com.rlms.model.response.LiftInfoResponse;
import com.rlms.model.response.LiftParamResponse;
import com.rlms.model.response.TechnicianInfo;
import com.rlms.utils.Preferences;
import com.rlms.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

public class AllLiftsActivity extends AppCompatActivity implements ApiResponseListener {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_lifts);
        recyclerView = ((RecyclerView) findViewById(R.id.liifList));
        fetchLifts();
    }

    private void fetchLifts() {
        LiftsReqest liftsReqest = new LiftsReqest();
        Preferences preferences = new Preferences(this);
        Technician technician = preferences.getStoreTechnician();
        liftsReqest.setUserRoleId(technician.getUserRoleId());
        AuthRepository.getAllLifts(this, ReqPriority.HIGH, liftsReqest);
    }

    @Override
    public void onSuccess(Object response, APIResponseMode apiResponseMode) {

        if (response != null) {
            ApiResponse apiResponse = (ApiResponse) response;
            if (apiResponse != null && apiResponse.status) {
                LiftInfoResponse[] result;
                try {
                    result = (LiftInfoResponse[]) (new Gson().fromJson(apiResponse.message, LiftInfoResponse[].class));
                    MoviesAdapter mAdapter = new MoviesAdapter(result);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                } catch (Exception e) {
                    Toast.makeText(this, "" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "" + apiResponse.message, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(Object response, ApiException exception) {

    }

    public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
        private LiftInfoResponse[] moviesList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView title, liftId;

            public MyViewHolder(View view) {
                super(view);
                title = (TextView) view.findViewById(R.id.liftsNo);
                liftId = (TextView) view.findViewById(R.id.liftsId);
            }
        }

        public MoviesAdapter(LiftInfoResponse[] movie) {
            this.moviesList = movie;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lift_list_row, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            final LiftInfoResponse liftInfoResponse = moviesList[position];
            holder.title.setText(liftInfoResponse.getLiftNumber());
            holder.liftId.setText(liftInfoResponse.getLiftId() + "");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AllLiftsActivity.this, UpdateLiftParamatersActivity.class);
                    intent.putExtra("liftMapId", liftInfoResponse.getLiftCustoMapId());
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return moviesList.length;
        }
    }
}
