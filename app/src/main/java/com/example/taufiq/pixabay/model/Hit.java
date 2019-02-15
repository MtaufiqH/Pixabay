
package com.example.taufiq.pixabay.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Hit {

    @SerializedName("comments")
    @Expose
    private Long mComments;
    @SerializedName("downloads")
    @Expose
    public Long mDownloads;
    @SerializedName("favorites")
    @Expose
    private Long mFavorites;
    @SerializedName("id")
    @Expose
    private Long mId;
    @SerializedName("imageHeight")
    @Expose
    private Long mImageHeight;
    @SerializedName("imageSize")
    @Expose
    private Long mImageSize;
    @SerializedName("imageWidth")
    @Expose
    private Long mImageWidth;
    @SerializedName("largeImageURL")
    @Expose
    public String mLargeImageURL;
    @SerializedName("likes")
    @Expose
    public Long mLikes;
    @SerializedName("pageURL")
    @Expose
    private String mPageURL;
    @SerializedName("previewHeight")
    @Expose
    private Long mPreviewHeight;
    @SerializedName("previewURL")
    @Expose
    private String mPreviewURL;
    @SerializedName("previewWidth")
    @Expose
    private Long mPreviewWidth;
    @SerializedName("tags")
    @Expose
    public String mTags;
    @SerializedName("type")
    @Expose
    private String mType;
    @SerializedName("user")
    @Expose
    private String mUser;
    @SerializedName("user_id")
    @Expose
    private Long mUserId;
    @SerializedName("userImageURL")
    @Expose
    private String mUserImageURL;
    @SerializedName("views")
    @Expose
    public Long mViews;
    @SerializedName("webformatHeight")
    @Expose
    private Long mWebformatHeight;
    @SerializedName("webformatURL")
    @Expose
    private String mWebformatURL;
    @SerializedName("webformatWidth")
    @Expose
    private Long mWebformatWidth;

}
