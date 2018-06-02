package com.rlms.activities;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.rlms.apiresponsehandler.ApiResponseListener;
import com.rlms.R;
import com.rlms.Repository.AuthRepository;
import com.rlms.Repository.ReqPriority;
import com.rlms.exception.ApiException;
import com.rlms.model.LiftDetails;
import com.rlms.model.request.LiftDetailsRequest;
import com.rlms.model.response.ApiResponse;
import com.rlms.utils.NetworkUtils;

public class UpdateLiftParamatersActivity extends AppCompatActivity implements View.OnClickListener, ApiResponseListener {
    RelativeLayout liftParentLayout;
    View loadingView;

    Button submit;
    protected LocationManager locationManager;
    private static final long MINIMUM_DISTANCE_CHANGE_FOR_UPDATES = 1;
    private static final long MINIMUM_TIME_BETWEEN_UPDATES = 1000;
    double sourceLatitude = 0.0, sourceLongitude = 0.0;
    double destLatitude = 0.0, destLongitude = 0.0;
    private NetworkUtils mNetworkUtils;

    ScrollView scrollView;
    EditText liftNo, doorType, noOfStops, machineType, machineCurrent, machineCapacity, breakVoltage, panelMake, simplexDuplext, adMake, fireMode, wiringScheme;
    EditText noOfBatteries, batteryCapacity, batteryMake, copMake, alarmBattery, accessControl, lopMake, collectiveTYPE;
    int mapID;
    private String[] doorTypes = {"Auto Door", "Manual Door"};
    String[] machineTypes = {"Geared", "Gearless"};
    String[] simplexes = {"Simplex", "Duplex", "Group"};
    String[] schemes = {"Pluggable", "NonPluggable"};
    String[] collectiveTypes = {"Down Collective", "Full collective"};
    String[] fireModes = {"Off", "On"};
    LiftDetails liftDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_lift_paramaters1);

        liftParentLayout = ((RelativeLayout) findViewById(R.id.liftParentLayout));
        loadingView = findViewById(R.id.loadingLayout);
        scrollView = ((ScrollView) findViewById(R.id.liftScrollView));
        submit = ((Button) findViewById(R.id.submit));
        liftParentLayout.setVisibility(View.GONE);
        loadingView.setVisibility(View.VISIBLE);

        liftNo = (EditText) findViewById(R.id.liftNo);
        doorType = (EditText) findViewById(R.id.doorType);
        noOfStops = (EditText) findViewById(R.id.noOfStops);
        machineType = (EditText) findViewById(R.id.machineType);
        machineCurrent = (EditText) findViewById(R.id.machineCurrent);
        machineCapacity = (EditText) findViewById(R.id.machineCapacity);
        breakVoltage = (EditText) findViewById(R.id.breakVoltage);
        panelMake = (EditText) findViewById(R.id.panelMake);
        simplexDuplext = (EditText) findViewById(R.id.simplexDuplext);
        adMake = (EditText) findViewById(R.id.adMake);
        fireMode = (EditText) findViewById(R.id.fireMode);
        wiringScheme = (EditText) findViewById(R.id.wiringScheme);

        noOfBatteries = (EditText) findViewById(R.id.numberOfBatteries);
        batteryCapacity = (EditText) findViewById(R.id.batteryCapacity);
        batteryMake = (EditText) findViewById(R.id.batteryMake);
        copMake = (EditText) findViewById(R.id.copMake);
        alarmBattery = (EditText) findViewById(R.id.alarmBattery);
        accessControl = (EditText) findViewById(R.id.accessControl);
        lopMake = (EditText) findViewById(R.id.lopMake);
        collectiveTYPE = (EditText) findViewById(R.id.collectiveType);

        doorType.setFocusable(false);
        machineType.setFocusable(false);
        simplexDuplext.setFocusable(false);
        wiringScheme.setFocusable(false);
        collectiveTYPE.setFocusable(false);
        fireMode.setFocusable(false);

        submit.setOnClickListener(this);
        doorType.setOnClickListener(this);
        machineType.setOnClickListener(this);
        simplexDuplext.setOnClickListener(this);
        wiringScheme.setOnClickListener(this);
        fireMode.setOnClickListener(this);
        collectiveTYPE.setOnClickListener(this);

        mapID = getIntent().getIntExtra("liftMapId", 0);
        if (mapID > 0) {
            fetchLiftDetails();
        }
        mNetworkUtils = new NetworkUtils(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!mNetworkUtils.isNetworkAvailable()) {
            Toast.makeText(this, "" + getString(R.string.server_conn_error), Toast.LENGTH_SHORT).show();
            finish();
        } else if (!mNetworkUtils.isMobileAvailable(this)) {
            Toast.makeText(this, "" + getString(R.string.server_conn_error), Toast.LENGTH_SHORT).show();
            finish();
        } else {
            showCurrentLocation();
        }
    }

    private void fetchLiftDetails() {
        LiftDetailsRequest liftsReqest = new LiftDetailsRequest();
        liftsReqest.setLiftCustomerMapId(mapID);
        AuthRepository.getLiftDetails(this, ReqPriority.HIGH, liftsReqest);
    }

    private void updateLiftDetails() {
        liftDetails.setNoOfStops(noOfStops.getText().toString());
        liftDetails.setMachineCurrent(machineCurrent.getText().toString());
        liftDetails.setMachineCapacity(machineCapacity.getText().toString());
        liftDetails.setBreakVoltage(breakVoltage.getText().toString());
        liftDetails.setArd(adMake.getText().toString());
        liftDetails.setNoOfBatteries(Integer.parseInt(noOfBatteries.getText().toString()));
        liftDetails.setBatteryCapacity(batteryCapacity.getText().toString());
        liftDetails.setBatteryMake(batteryMake.getText().toString());
        liftDetails.setCopMake(copMake.getText().toString());
        liftDetails.setAlarmBattery(alarmBattery.getText().toString());
        liftDetails.setAccessControl(accessControl.getText().toString());
        liftDetails.setLopMake(lopMake.getText().toString());
        liftDetails.setLiftCustomerMapId(mapID);
        liftDetails.setLatitude(destLatitude +"");
        liftDetails.setLongitude(destLongitude +"");



        AuthRepository.updateLiftDetails(new ApiResponseListener() {
            @Override
            public void onSuccess(Object response, APIResponseMode apiResponseMode) {
                if (response != null) {
                    ApiResponse apiResponse = (ApiResponse) response;
                    Toast.makeText(UpdateLiftParamatersActivity.this, apiResponse.message, Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onError(Object response, ApiException exception) {

            }
        }, ReqPriority.HIGH, liftDetails);
    }

    @Override
    public void onSuccess(Object response, ApiResponseListener.APIResponseMode apiResponseMode) {
        if (response != null) {
            ApiResponse apiResponse = (ApiResponse) response;
            if (apiResponse.status) {
                LiftDetails[] result;
                try {
                    result = (LiftDetails[]) (new Gson().fromJson(apiResponse.message, LiftDetails[].class));
                    if (result.length > 0) {
                        liftDetails = result[0];
                        initializeView(result);
                    }
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

    private void showCurrentLocation() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
//        locationManager.requestLocationUpdates(
//                LocationManager.GPS_PROVIDER, MINIMUM_TIME_BETWEEN_UPDATES, MINIMUM_DISTANCE_CHANGE_FOR_UPDATES,
//                new MapsActivity.MyLocationListener()
//        );
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Please enable Location in Settings", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                buildAlertMessageNoGps();
            }
            if (location != null) {
                destLatitude = location.getLatitude();
                destLongitude = location.getLongitude();
//                LatLng start = new LatLng(sourceLatitude, sourceLongitude);
//                LatLng end = new LatLng(destLatitude, destLongitude);
//                MarkerPoints.add(start);
//                MarkerPoints.add(end);

                // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//                SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                        .findFragmentById(R.id.map);
//                mapFragment.getMapAsync(UpdateLiftParamatersActivity.this);
            }
        }
    }

    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                        finish();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
        Button buttonPositive = alert.getButton(DialogInterface.BUTTON_POSITIVE);
        buttonPositive.setTextColor(getResources().getColor(R.color.colorPrimary));

        Button negPositive = alert.getButton(DialogInterface.BUTTON_NEGATIVE);
        negPositive.setTextColor(getResources().getColor(R.color.colorPrimary));
    }

    private void initializeView(LiftDetails[] result) {
        liftParentLayout.setVisibility(View.VISIBLE);
        loadingView.setVisibility(View.GONE);
        LiftDetails liftDetails = result[0];
        liftNo.setText(liftDetails.getLiftNumber());
        liftNo.setFocusable(false);
        if (liftDetails.getDoorType() != null) {
            if (liftDetails.getDoorType() == 0) {
                doorType.setText(doorTypes[0]);
            } else {
                doorType.setText(doorTypes[1]);
            }
        }
        noOfStops.setText(liftDetails.getNoOfStops());
        if (liftDetails.getEngineType() != null) {
            if (liftDetails.getEngineType() == 0) {
                machineType.setText(machineTypes[0]);
            } else {
                machineType.setText(machineTypes[1]);
            }
        }
        if (liftDetails.getCollectiveType() != null) {
            if (liftDetails.getCollectiveType() == 0) {
                collectiveTYPE.setText(collectiveTypes[0]);
            } else {
                collectiveTYPE.setText(collectiveTypes[1]);
            }
        }
        machineCurrent.setText(liftDetails.getMachineCurrent());
        machineCapacity.setText(liftDetails.getMachineCapacity());
        breakVoltage.setText(liftDetails.getBreakVoltage());
        panelMake.setText(liftDetails.getPanelMake());
        if (liftDetails.getSimplexDuplex() != null) {
            if (liftDetails.getSimplexDuplex() == 0) {
                simplexDuplext.setText(collectiveTypes[0]);
            } else if (liftDetails.getSimplexDuplex() == 1) {
                simplexDuplext.setText(collectiveTypes[1]);
            } else {
                simplexDuplext.setText(collectiveTypes[2]);
            }
        }
        adMake.setText(liftDetails.getArd());
        if (liftDetails.getFireMode() != null) {
            if (liftDetails.getFireMode() == 0) {
                fireMode.setText(fireModes[0]);
            } else {
                fireMode.setText(fireModes[1]);
            }
        }
        if (liftDetails.getWiringShceme() != null) {
            if (liftDetails.getWiringShceme() == 0) {
                wiringScheme.setText(schemes[0]);
            } else {
                wiringScheme.setText(schemes[1]);
            }
        }
        if (liftDetails.getNoOfBatteries() != null) {
            noOfBatteries.setText(liftDetails.getNoOfBatteries().toString());
        }
        batteryCapacity.setText(liftDetails.getBatteryCapacity());
        batteryMake.setText(liftDetails.getBatteryMake());
        copMake.setText(liftDetails.getCopMake());
        alarmBattery.setText(liftDetails.getAlarmBattery());
        accessControl.setText(liftDetails.getAccessControl());
        lopMake.setText(liftDetails.getLopMake());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submit) {
            if (liftDetails != null) {
                updateLiftDetails();
            }
        }
        if (v.getId() == R.id.doorType) {
            showDropDownDialog(doorTypes, doorType, v.getId());
        }
        if (v.getId() == R.id.machineType) {
            showDropDownDialog(machineTypes, machineType, v.getId());
        }
        if (v.getId() == R.id.simplexDuplext) {
            showDropDownDialog(simplexes, simplexDuplext, v.getId());
        }
        if (v.getId() == R.id.wiringScheme) {
            showDropDownDialog(schemes, wiringScheme, v.getId());
        }
        if (v.getId() == R.id.fireMode) {
            showDropDownDialog(fireModes, fireMode, v.getId());
        }
        if (v.getId() == R.id.collectiveType) {
            showDropDownDialog(collectiveTypes, collectiveTYPE, v.getId());
        }
    }

    private void showDropDownDialog(final String[] parameters, final EditText editText, final int viewId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select");
        builder.setItems(parameters, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                editText.setText(parameters[which]);
                if (viewId == R.id.doorType) {
                    liftDetails.setDoorType(which);
                }
                if (viewId == R.id.machineType) {
                    liftDetails.setEngineType(which);
                }
                if (viewId == R.id.simplexDuplext) {
                    liftDetails.setSimplexDuplex(which);
                }
                if (viewId == R.id.wiringScheme) {
                    liftDetails.setWiringShceme(which);
                }
                if (viewId == R.id.fireMode) {
                    liftDetails.setFireMode(which);
                }
                if (viewId == R.id.collectiveType) {
                    liftDetails.setCollectiveType(which);
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
