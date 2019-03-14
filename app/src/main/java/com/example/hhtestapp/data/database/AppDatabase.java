package com.example.hhtestapp.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.hhtestapp.data.database.dao.DataDao;
import com.example.hhtestapp.data.database.entity.UserEntity;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DataDao dataDao();
}
