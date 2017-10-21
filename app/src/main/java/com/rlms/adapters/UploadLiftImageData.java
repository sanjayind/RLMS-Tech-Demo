package com.rlms.adapters;

import android.graphics.Bitmap;

/**
 * Created by srishti on 11/14/16.
 */
public class UploadLiftImageData {
    private Bitmap mRecipeImage;
    private int mClearRecipe;
    private String mImageType;

    public String getmImageType() {
        return mImageType;
    }

    public void setmImageType(String mImageType) {
        this.mImageType = mImageType;
    }

    public Bitmap getRecipeImage() {
        return mRecipeImage;
    }

    public void setRecipeImage(Bitmap mRecipeImage) {
        this.mRecipeImage = mRecipeImage;
    }

    public int getClearRecipe() {
        return mClearRecipe;
    }

    public void setClearRecipe(int mDeleteRecipe) {
        this.mClearRecipe = mDeleteRecipe;
    }
}
