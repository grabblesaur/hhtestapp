package com.example.hhtestapp.data.database.mapper

import com.example.hhtestapp.data.api.model.User
import com.example.hhtestapp.data.database.entity.UserEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataMapper @Inject constructor() {

    fun mapToUserEntity(user: User) =
            UserEntity(
                id = user.id,
                name = user.name
            )

    fun mapToUser(userEntity: UserEntity) =
            User(
                id = userEntity.id,
                name = userEntity.name
            )
}