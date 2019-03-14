package com.example.hhtestapp.data

import com.example.hhtestapp.data.api.Api
import com.example.hhtestapp.data.database.dao.DataDao
import com.example.hhtestapp.data.database.mapper.DataMapper
import javax.inject.Inject

class MainRepository @Inject constructor(val apiService: Api,
                                         val dataDao: DataDao,
                                         val dataMapper: DataMapper) {

}