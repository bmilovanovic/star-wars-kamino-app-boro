package kamino.star.wars.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Planet {

    @SerializedName("name")
    @Expose
    public var name: String = ""

    @SerializedName("rotation_period")
    @Expose
    var rotationPeriod: Int = 0

    @SerializedName("orbital_period")
    @Expose
    var orbitalPeriod: Int = 0

    @SerializedName("diameter")
    @Expose
    var diameter: Long = 0

    @SerializedName("climate")
    @Expose
    public var climate: String = ""

    @SerializedName("gravity")
    @Expose
    public var gravity: String = ""

    @SerializedName("terrain")
    @Expose
    public var terrain: String = ""

    @SerializedName("surface_water")
    @Expose
    var surfaceWater: Int = 0

    @SerializedName("population")
    @Expose
    var population: Long = 0L

    @SerializedName("created")
    @Expose
    var created: String = ""

    @SerializedName("edited")
    @Expose
    var edited: String = ""

    @SerializedName("image_url")
    @Expose
    var imageUrl: String = ""

    @SerializedName("likes")
    @Expose
    var likes: Long = 0L

    @SerializedName("residents")
    @Expose
    var residentUrls: List<String> = mutableListOf()
}
