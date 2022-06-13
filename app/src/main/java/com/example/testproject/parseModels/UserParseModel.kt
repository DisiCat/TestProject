package com.example.testproject.parseModels

import com.squareup.moshi.Json

data class UserParseModel(

    @Json(name = "user_id") var userId: Int? = null,
    @Json(name = "user_type") var userType: Int? = null,
    @Json(name = "referral") var referral: String? = null,
    @Json(name = "referral_bonus") var referralBonus: Int? = null,
    @Json(name = "phone_code") var phoneCode: String? = null,
    @Json(name = "phone_number") var phoneNumber: String? = null,
    @Json(name = "name") var name: String? = null,
    @Json(name = "second_name") var secondName: String? = null,
    @Json(name = "place") var place: String? = null,
    @Json(name = "location_type") var locationType: String? = null,
    @Json(name = "solar_staff") var solarStaff: Boolean? = null,
    @Json(name = "avatar") var avatar: String? = null,
    @Json(name = "type_blocked") var typeBlocked: Int? = null,
    @Json(name = "payout_status") var payoutStatus: Int? = null,
    @Json(name = "payout_reject_msg") var payoutRejectMsg: String? = null,
    @Json(name = "firebase_id") var firebaseId: String? = null,
    @Json(name = "chat_id") var chatId: String? = null,
    @Json(name = "api_key") var apiKey: String? = null,
    @Json(name = "app_brand_id") var appBrandId: Int? = null
)
