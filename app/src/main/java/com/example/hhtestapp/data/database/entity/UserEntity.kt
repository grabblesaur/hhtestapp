package com.example.hhtestapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.hhtestapp.data.database.dao.DataDao.Companion.USER_TABLE

@Entity(tableName = USER_TABLE)
data class UserEntity(
    @PrimaryKey
    val id: Int,
    var name: String
)