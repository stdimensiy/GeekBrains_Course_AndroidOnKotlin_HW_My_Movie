package ru.geekbrains.androidonkotlin.hw.mymovie.domain

import android.os.Parcel
import android.os.Parcelable

data class MovieTMDB(
    val adult: Boolean = false,
    val backdrop_path: String? = null,
    val genre_ids: ArrayList<Int>? = ArrayList(),
    val id: Int = 0,
    val original_language: String? = null,
    val original_title: String? = null,
    val overview: String? = null,
    val popularity: Double = 0.toDouble(),
    val poster_path: String? = null,
    val release_date: String? = null,
    val title: String? = null,
    val video: Boolean = false,
    val vote_average: Double = 0.toDouble(),
    val vote_count: Int = 0
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        TODO("genre_ids"),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readDouble(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (adult) 1 else 0)
        parcel.writeString(backdrop_path)
        parcel.writeInt(id)
        parcel.writeString(original_language)
        parcel.writeString(original_title)
        parcel.writeString(overview)
        parcel.writeDouble(popularity)
        parcel.writeString(poster_path)
        parcel.writeString(release_date)
        parcel.writeString(title)
        parcel.writeByte(if (video) 1 else 0)
        parcel.writeDouble(vote_average)
        parcel.writeInt(vote_count)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieTMDB> {
        override fun createFromParcel(parcel: Parcel): MovieTMDB {
            return MovieTMDB(parcel)
        }

        override fun newArray(size: Int): Array<MovieTMDB?> {
            return arrayOfNulls(size)
        }
    }
}
