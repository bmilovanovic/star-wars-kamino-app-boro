package kamino.star.wars.residents.details

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kamino.star.wars.home.slider.Attribute

class Resident {

    @SerializedName("name")
    @Expose
    var name: String = ""

    @SerializedName("height")
    @Expose
    var height: Int = 0

    @SerializedName("mass")
    @Expose
    var mass: String = ""

    @SerializedName("hair_color")
    @Expose
    var hairColor: String = ""

    @SerializedName("skin_color")
    @Expose
    var skinColor: String = ""

    @SerializedName("eye_color")
    @Expose
    var eyeColor: String = ""

    @SerializedName("birth_year")
    @Expose
    var birthYear: String = ""

    @SerializedName("gender")
    @Expose
    var gender: String = ""

    @SerializedName("homeworld")
    @Expose
    var homeworld: String = ""

    @SerializedName("created")
    @Expose
    var created: String = ""

    @SerializedName("edited")
    @Expose
    var edited: String = ""

    @SerializedName("image_url")
    @Expose
    var imageUrl: String = ""

    var attributes = emptyList<Attribute>()
}
