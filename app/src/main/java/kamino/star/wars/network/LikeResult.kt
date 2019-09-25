package kamino.star.wars.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LikeResult {

    @SerializedName("planet_id")
    @Expose
    public var planetId: Long = 0

    @SerializedName("likes ")
    @Expose
    public var likeCount: Long = 0
}
