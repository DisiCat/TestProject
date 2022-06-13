package com.example.testproject.mappers

import com.example.testproject.entity.UserModel
import com.example.testproject.parseModels.UserParseModel

internal fun UserParseModel.toUserModel(): UserModel {
    return UserModel(
        id = this.userId,
        phoneNumber = this.phoneNumber,
        name = this.name,
        secondName = this.secondName
    )
}