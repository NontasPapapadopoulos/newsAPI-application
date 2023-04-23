package com.example.newsapiclient.data.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Source(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
): Serializable {

    override fun hashCode(): Int {
        var result = id.hashCode()
        if(id.isNullOrEmpty()){
            result = 31 * result + id.hashCode()
        }
        return result
    }
}