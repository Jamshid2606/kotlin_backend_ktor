package uz.talabalar_daftari.features.register

import kotlinx.serialization.Serializable

@Serializable
data class RegisterReceiveRemote(
    val name:String,
    val username:String,
    val birthday:String,
    val phoneNumber:String,
    val education:String,
    val course:String,
    val fakultet:String,
    val email:String,
    val addTime:String,
    val password:String
)

@Serializable
data class RegisterResponseRemote(
    val token:String
)