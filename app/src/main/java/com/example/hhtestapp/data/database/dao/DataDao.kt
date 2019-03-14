package com.example.hhtestapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hhtestapp.data.database.entity.UserEntity

@Dao
interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userEntity: UserEntity)

    @Query("SELECT * FROM user LIMIT 1")
    fun findUser(): UserEntity

    companion object {
        const val USER_TABLE = "user"
    }
}