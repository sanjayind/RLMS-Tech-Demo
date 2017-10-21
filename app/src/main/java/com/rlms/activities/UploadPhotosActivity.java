package com.rlms.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.rlms.R;
import com.rlms.adapters.UploadLiftImageData;
import com.rlms.adapters.UploadPhotosAdapter;
import com.rlms.apiresponsehandler.ApiResponseListener;
import com.rlms.exception.ApiException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class UploadPhotosActivity extends Activity implements View.OnClickListener, UploadPhotosAdapter.IUploadRecipeDataListener, ApiResponseListener {
    private static int RESULT_LOAD_CAMERA = 1;
    private static int RESULT_LOAD_GALLERY = 2;
    private String mPackageName;
    private static final String SHARE_IMAGE_AUTHORITY_NAME = ".shareImageProvider";
    private int mOriginalFileName;
    private GridView mGridView;
    private UploadPhotosAdapter mImageAdapter;
    private final ArrayList<UploadLiftImageData> mThumbImageArrayList = new ArrayList<>();
    private TextView title, details;

    private ArrayList<Uri> list = new ArrayList<>();
    private String mFileName = "RLMS";
    private String mFileExtension = ".txt";
    private List<String> photoTypes = new ArrayList<>();

    private String titleStr, detailsStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_images);

        titleStr = getIntent().getExtras().getString("title");
        detailsStr = getIntent().getExtras().getString("details");

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mGridView = (GridView) findViewById(R.id.gridview);
        title = ((TextView) findViewById(R.id.titlevalue));
        details = ((TextView) findViewById(R.id.detailsvalue));

        title.setText(titleStr);
        details.setText(detailsStr);

        mImageAdapter = new UploadPhotosAdapter(this, photoTypes, mThumbImageArrayList, this);
        mGridView.setAdapter(mImageAdapter);

        photoTypes.add("Select Image");
        photoTypes.add("machinePhoto");
        photoTypes.add("panelPhoto");
        photoTypes.add("ARDPhoto");
        photoTypes.add("COPPhoto");
        photoTypes.add("LOPPhoto");
        photoTypes.add("cartopPhoto");
        photoTypes.add("autoDoorHeaderPhoto");
        photoTypes.add("cartwiringPhotoopPhoto");
        photoTypes.add("lobbyPhoto");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.form_submit: {
//                String titleText = mTitle.getText().toString();
//                String procedureText = mProcedure.getText().toString();
//                String descriptionText = mDescription.getText().toString();
//                String body = "<b>Title -</b>\n<p>%1$s</p>\n<b>Ingredients -</b>\n<p>%2$s</p>\n<b>Procedure -</b>\n<p>%3$s</p>\n<b>Description -</b>\n<p>%4$s</p>";
//                StringBuilder ingredientBuilder = new StringBuilder();
//                if (mEditTextList != null && mEditTextList.size() > 0) {
//                    for (EditText s : mEditTextList) {
//                        if (s.getText().toString().length() > 0)
//                            ingredientBuilder.append("&#8226;&nbsp;").append(s.getText().toString()).append("<br/>");
//                    }
//                }
//                String formattedString = String.format(body, titleText, ingredientBuilder, procedureText, descriptionText);
//                ArrayList<Bitmap> bitmaps = new ArrayList<>();
//                for (UploadLiftImageData b : mThumbImageArrayList) {
//                    bitmaps.add(b.getRecipeImage());
//                }
//                String contentString = Html.fromHtml(formattedString).toString();
//                ArrayList<Uri> uriList = new ArrayList<>();
//                uriList = storeDataUsingFileProvider(bitmaps, contentString);
//                if (titleText.length() > 0) {
//                    openDirectMailComposeActivity(uriList);
//                } else {
//                    Toast.makeText(this, "Please provide title for this recipe.", Toast.LENGTH_SHORT).show();
//                }
//                break;
//            }
        }
    }

    private void openDirectMailComposeActivity(ArrayList<Uri> imageList) {
        Intent intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
        intent.setType("text/*");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"dev.klanle@gmail.com"});
        intent.putExtra(Intent.EXTRA_STREAM, imageList);
        final PackageManager pm = getPackageManager();
        final List<ResolveInfo> matches = pm.queryIntentActivities(intent, 0);
        ResolveInfo best = null;
        for (final ResolveInfo info : matches)
            if (info.activityInfo.packageName.endsWith(".gm") ||
                    info.activityInfo.name.toLowerCase().contains("gmail")) best = info;
        if (best != null) {
            intent.setClassName(best.activityInfo.packageName, best.activityInfo.name);
        }
        startActivity(intent);
    }

    public String getFileProviderAuthorityName() {
        mPackageName = getApplicationContext().getPackageName();
        String fileProviderAuthorityName = mPackageName + SHARE_IMAGE_AUTHORITY_NAME;
        return fileProviderAuthorityName;
    }

    public ArrayList<Uri> storeDataUsingFileProvider(ArrayList<Bitmap> bitmap, String contentString) {
        for (int i = 0; i < bitmap.size(); i++) {
            if (bitmap != null) {
                try {
                    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                    bitmap.get(i).compress(Bitmap.CompressFormat.PNG, 100, bytes);
                    mOriginalFileName = new Random().nextInt();
                    FileOutputStream imageFileStream = openFileOutput(mOriginalFileName + ".png", Context.MODE_PRIVATE);
                    imageFileStream.write(bytes.toByteArray());
                    list.add(FileProvider.getUriForFile(this, getFileProviderAuthorityName(), getFileStreamPath(mOriginalFileName + ".png")));
                    imageFileStream.close();
                    bytes.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (contentString.length() > 0) {
            try {
                mFileName = UUID.randomUUID().toString();
                ;
                FileOutputStream textFileStream = openFileOutput(mFileName + mFileExtension, Context.MODE_PRIVATE);
                textFileStream.write(contentString.getBytes());
                list.add(FileProvider.getUriForFile(this, getFileProviderAuthorityName(), getFileStreamPath(mFileName + mFileExtension)));
                textFileStream.close();
            } catch (FileNotFoundException fnfe) {
                fnfe.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private Bitmap getScaledBitmap(Uri uri) {
        Bitmap thumb = null;
        try {
            ContentResolver cr = getContentResolver();
            InputStream in = cr.openInputStream(uri);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 6;
            thumb = BitmapFactory.decodeStream(in, null, options);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return thumb;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (null != data) {
            if (requestCode == RESULT_LOAD_GALLERY && resultCode == RESULT_OK) {
                //Taking multiple images..
                ClipData clipData = data.getClipData();
                if (data.getClipData() != null) {
                    for (int i = 0; i < clipData.getItemCount(); i++) {
                        ClipData.Item item = clipData.getItemAt(i);
                        Uri uri = item.getUri();
                        UploadLiftImageData imageData = new UploadLiftImageData();
                        imageData.setRecipeImage(getScaledBitmap(uri));
                        imageData.setClearRecipe(R.drawable.ic_close_black_24dp);
                        imageData.setmImageType(photoTypes.get(0));
                        mThumbImageArrayList.add(imageData);
                    }
                } else {
                    //Taking single image..
                    Uri mImageUri = data.getData();
                    UploadLiftImageData imageData = new UploadLiftImageData();
                    imageData.setRecipeImage(getScaledBitmap(mImageUri));
                    imageData.setClearRecipe(R.drawable.ic_close_black_24dp);
                    imageData.setmImageType(photoTypes.get(0));
                    mThumbImageArrayList.add(imageData);
                }
            } else if (requestCode == RESULT_LOAD_CAMERA && resultCode == RESULT_OK) {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                UploadLiftImageData imageData = new UploadLiftImageData();
                imageData.setRecipeImage(bitmap);
                imageData.setmImageType(photoTypes.get(0));
                imageData.setClearRecipe(R.drawable.ic_close_black_24dp);
                mThumbImageArrayList.add(imageData);
            }
            if (mThumbImageArrayList != null && mThumbImageArrayList.size() > 0) {
                mImageAdapter = new UploadPhotosAdapter(this, photoTypes, mThumbImageArrayList, this);
                mGridView.setAdapter(mImageAdapter);
            }
        }
    }

    @Override
    public void addNewImage(int Position) {
        CharSequence[] names = {"Camera", "Gallery"};
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Take Image from..");
        alert.setItems(names, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, RESULT_LOAD_CAMERA);
                } else {
                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                    startActivityForResult(intent, RESULT_LOAD_GALLERY);
                }
            }
        }).setNegativeButton("", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //empty impl..
            }
        }).create().show();
    }

    @Override
    public void addPhotosType(int Position) {
        mImageAdapter.notifyDataSetChanged();
    }

    @Override
    public void uploadImage(ByteArrayInputStream inputStream, String mapId, String photoType) {
        Toast.makeText(this, "Work in progress", Toast.LENGTH_SHORT).show();
//        AuthRepository.uploadUserPicture("","",this,ReqPriority.HIGH,inputStream);
    }

    @Override
    public void clearImageData(int position) {
        if (mThumbImageArrayList != null && mThumbImageArrayList.size() > 0) {
            mThumbImageArrayList.remove(position);
            if (mImageAdapter != null) {
                mImageAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onSuccess(Object response, APIResponseMode apiResponseMode) {
        if (mThumbImageArrayList != null && mThumbImageArrayList.size() > 0) {
//            mThumbImageArrayList.remove(position);
            if (mImageAdapter != null) {
                mImageAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onError(Object response, ApiException exception) {

    }
}