package ru.geekbrains.androidonkotlin.hw.mymovie.domain

import androidx.lifecycle.MutableLiveData

data class GroupResponseObject(
    val nameGroupResponse: String? = null,
    val standard_list: String? = null,
    val FuncFetch: (standard_list: String, page: Int, currentGroupResponseObject: GroupResponseObject) -> Unit
) {
    val currentLiveData = MutableLiveData<ArrayList<MovieTMDB>>()
}

