package com.theworld.androidtemplatewithnavcomponents.ui

import androidx.lifecycle.ViewModel
import com.theworld.androidtemplatewithnavcomponents.network.Api
import com.theworld.androidtemplatewithnavcomponents.utils.Resource
import com.theworld.androidtemplatewithnavcomponents.utils.SafeApiCall
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class PostOfficeViewModel @Inject constructor(
    private val api: Api,
) : ViewModel(), SafeApiCall {

    companion object {
        private const val TAG = "PostOfficeViewModel"
    }





/*------------------------------------ Change Password -----------------------------------------*/

    fun fetchPostOffice() = flow {
        val list = safeApiCall {
            api.fetchPostOffices()
        }

        emit(list)
    }.flowOn(Dispatchers.IO)
        .conflate()


}
