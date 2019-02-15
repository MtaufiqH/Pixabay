
package com.example.taufiq.pixabay.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Pojo {



    @SerializedName("hits")
    private List<Hit> mHits;
    @SerializedName("total")
    private Long mTotal;
    @SerializedName("totalHits")
    private Long mTotalHits;

    public List<Hit> getmHits() {
        return mHits;
    }

}
