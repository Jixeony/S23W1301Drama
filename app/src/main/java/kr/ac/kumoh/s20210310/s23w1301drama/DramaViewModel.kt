package kr.ac.kumoh.s20210310.s23w1301drama

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DramaViewModel() : ViewModel() {
    private val SERVER_URL = "https://port-0-s23w10backend-5r422alq88mvj3.sel4.cloudtype.app/"
    private val dramaApi: DramaApi
    private val _dramaList = MutableLiveData<List<Drama>>()
    val dramaList: LiveData<List<Drama>>
        get() = _dramaList

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        dramaApi= retrofit.create(DramaApi::class.java)
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                val response = dramaApi.getDramas()
                _dramaList.value = response
            } catch (e: Exception) {
                Log.e("fetchData()", e.toString())
            }
        }
    }
}