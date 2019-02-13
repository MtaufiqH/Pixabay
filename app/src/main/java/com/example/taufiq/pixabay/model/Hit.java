
package com.example.taufiq.pixabay.model;

import com.google.gson.annotations.SerializedName;


public class Hit {

    @SerializedName("comments")
    private Long mComments;
    @SerializedName("downloads")
    public Long mDownloads;
    @SerializedName("favorites")
    private Long mFavorites;
    @SerializedName("id")
    private Long mId;
    @SerializedName("imageHeight")
    private Long mImageHeight;
    @SerializedName("imageSize")
    private Long mImageSize;
    @SerializedName("imageWidth")
    private Long mImageWidth;
    @SerializedName("largeImageURL")
    public String mLargeImageURL;
    @SerializedName("likes")
    public Long mLikes;
    @SerializedName("pageURL")
    private String mPageURL;
    @SerializedName("previewHeight")
    private Long mPreviewHeight;
    @SerializedName("previewURL")
    private String mPreviewURL;
    @SerializedName("previewWidth")
    private Long mPreviewWidth;
    @SerializedName("tags")
    public String mTags;
    @SerializedName("type")
    private String mType;
    @SerializedName("user")
    private String mUser;
    @SerializedName("user_id")
    private Long mUserId;
    @SerializedName("userImageURL")
    private String mUserImageURL;
    @SerializedName("views")
    public Long mViews;
    @SerializedName("webformatHeight")
    private Long mWebformatHeight;
    @SerializedName("webformatURL")
    private String mWebformatURL;
    @SerializedName("webformatWidth")
    private Long mWebformatWidth;

}
