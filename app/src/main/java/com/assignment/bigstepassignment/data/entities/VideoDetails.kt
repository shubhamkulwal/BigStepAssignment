package com.assignment.bigstepassignment.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "VideoDetails")
data class VideoDetails(
    @PrimaryKey
    @SerializedName("trackId")
    var trackId: Int,
    @SerializedName("wrapperType")
    var wrapperType: String,
    @SerializedName("kind")
    var kind: String,
    @SerializedName("artistId")
    var artistId: Int,
    @SerializedName("collectionId")
    var collectionId: Int,
    @SerializedName("artistName")
    var artistName: String,
    @SerializedName("collectionName")
    var collectionName: String,
    @SerializedName("trackName")
    var trackName: String,
    @SerializedName("collectionCensoredName")
    var collectionCensoredName: String,
    @SerializedName("trackCensoredName")
    var trackCensoredName: String,
    @SerializedName("artistViewUrl")
    var artistViewUrl: String,
    @SerializedName("collectionViewUrl")
    var collectionViewUrl: String,
    @SerializedName("trackViewUrl")
    var trackViewUrl: String,
    @SerializedName("previewUrl")
    var previewUrl: String,
    @SerializedName("artworkUrl30")
    var artworkUrl30: String,
    @SerializedName("artworkUrl100")
    var artworkUrl100: String,
    @SerializedName("artworkUrl60")
    var artworkUrl60: String,
    @SerializedName("collectionPrice")
    var collectionPrice: Double,
    @SerializedName("trackPrice")
    var trackPrice: Double,
    @SerializedName("releaseDate")
    var releaseDate: String,
    @SerializedName("longDescription")
    var longDescription: String? = "",
    @SerializedName("collectionExplicitness")
    var collectionExplicitness: String,
    @SerializedName("trackExplicitness")
    var trackExplicitness: String,
    @SerializedName("country")
    var country: String,
    @SerializedName("currency")
    var currency: String,
    @SerializedName("primaryGenreName")
    var primaryGenreName: String,
    @SerializedName("discCount")
    var discCount: Int,
    @SerializedName("trackCount")
    var trackCount: Int,
    @SerializedName("trackNumber")
    var trackNumber: Int,
    @SerializedName("trackTimeMillis")
    var trackTimeMillis: Int,
    @SerializedName("discNumber")
    var discNumber: Int,
) : Serializable