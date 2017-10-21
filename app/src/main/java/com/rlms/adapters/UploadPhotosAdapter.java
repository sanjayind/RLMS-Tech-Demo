package com.rlms.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.rlms.R;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by srishti on 11/14/16.
 */
public class UploadPhotosAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<UploadLiftImageData> mImages;
    private IUploadRecipeDataListener mIClearListener;
    private List<String> mTypes;

    public UploadPhotosAdapter(Context context, List<String> photoTypes, ArrayList<UploadLiftImageData> imageDatas, IUploadRecipeDataListener listener) {
        this.mIClearListener = listener;
        this.mContext = context;
        this.mImages = imageDatas;
        this.mTypes = photoTypes;
    }

    @Override
    public int getCount() {
        if (mImages.size() > 0) {
            return mImages.size() + 1;
        } else {
            return 1;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        if (position == mImages.size()) {
            convertView = layoutInflater.inflate(R.layout.add_new_image_view, null);
            FrameLayout frameLayout = (FrameLayout) convertView.findViewById(R.id.addImages);
            if (mImages.size() == 0) {
                convertView.setX(parent.getWidth() / 4);
            }
            frameLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mIClearListener != null) {
                        mIClearListener.addNewImage(position);
                    }
                }
            });
        } else {
            final UploadLiftImageData data = mImages.get(position);
            convertView = layoutInflater.inflate(R.layout.upload_lift_image_view, null);
            final ImageView imageViewPic = (ImageView) convertView.findViewById(R.id.imageview_cover);
            final ImageView imageViewClear = (ImageView) convertView.findViewById(R.id.imageview_clear);
            imageViewPic.setImageBitmap(data.getRecipeImage());
            imageViewClear.setImageResource(data.getClearRecipe());
            imageViewClear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mIClearListener != null) {
                        mIClearListener.clearImageData(position);
                    }
                }
            });
            final Spinner spinner = (Spinner) convertView.findViewById(R.id.typeSpinner);
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, mTypes);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(dataAdapter);
            spinner.setTag(position);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item = parent.getItemAtPosition(position).toString();
                    if (position != 0) {
                        UploadLiftImageData data = mImages.get((Integer) parent.getTag());
                        data.setmImageType(item);
                        if (mIClearListener != null) {
                            mIClearListener.addPhotosType(position);
                        }
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            TextView typeTV = ((TextView) convertView.findViewById(R.id.typeText));
            typeTV.setText(data.getmImageType());

            Button uploadButton = ((Button) convertView.findViewById(R.id.uploadImageButton));
            uploadButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UploadLiftImageData data = mImages.get(position);
                    uploadPicture(data.getRecipeImage());
                }
            });
        }

        return convertView;
    }

    public synchronized void uploadPicture(Bitmap image) {
        if (image != null) {
            try {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                image.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] bitmapData = stream.toByteArray();

                ByteArrayInputStream inputStream = new ByteArrayInputStream(bitmapData);
                if (mIClearListener != null) {
                    mIClearListener.uploadImage(inputStream, "", "");
                }
//                        mFrontUploadTask = UserRepository.uploadUserPicture(mUserId, groupName, mFrontImageUploadListener, ReqPriority.HIGH, inputStream);
            } catch (OutOfMemoryError e) {
            }
        }
    }

    public interface IUploadRecipeDataListener {
        void clearImageData(int Position);

        void addNewImage(int Position);

        void addPhotosType(int Position);

        void uploadImage(ByteArrayInputStream inputStream, String mapId, String photoType);
    }
}