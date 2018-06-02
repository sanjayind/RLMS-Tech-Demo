package com.rlms.activities;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rlms.R;
import com.rlms.model.response.LiftParamResponse;

import java.util.ArrayList;
import java.util.List;

public class LiftParametersActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    LiftParamsRecyclerAdapter mAdapter;
    ArrayList<LiftParamResponse> liftParamsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lift_parameters);

        recyclerView = ((RecyclerView) findViewById(R.id.liftParamRecyclerView));
        gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);

        mSwipeRefreshLayout = ((SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout));
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchLiftParam();
            }
        });
        fetchLiftParam();
    }

    private ArrayList<LiftParamResponse> fetchLiftParam() {
        liftParamsList = new ArrayList<>();
        mAdapter = new LiftParamsRecyclerAdapter(this, liftParamsList);
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        return new ArrayList<>();
    }

    public class LiftParamsRecyclerAdapter extends RecyclerView.Adapter<LiftParamsRecyclerAdapter.LiftViewHolder> {
        private List<LiftParamResponse> mData;
        private Context context;

        public class LiftViewHolder extends RecyclerView.ViewHolder {
            TextView paramKeyTV, paramValueTV;

            public LiftViewHolder(View itemView) {
                super(itemView);
                paramKeyTV = (TextView) itemView.findViewById(R.id.param_key);
                paramValueTV = (TextView) itemView.findViewById(R.id.param_value);

            }
        }

        public LiftParamsRecyclerAdapter(Context context, List<LiftParamResponse> arr) {
            this.mData = arr;
            this.context = context;
        }

        @Override
        public LiftViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            view = LayoutInflater.from(context).inflate(R.layout.lift_params_row_item, parent, false);
            return new LiftViewHolder(view);
        }

        @Override
        public void onBindViewHolder(LiftViewHolder holder, final int position) {
            if (mData.size() > 0) {
                final LiftParamResponse complain = mData.get(position);
                holder.paramKeyTV.setText("" + complain.getParamKey());
                holder.paramValueTV.setText("" + complain.getParamValue());
            }
        }

        @Override
        public int getItemCount() {
            if (mData == null) {
                return 0;
            }
            return mData.size();
        }
    }
}
