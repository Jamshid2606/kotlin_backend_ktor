package uz.talabalar_daftari.features.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginReceiveRemoteWidthUserName(
    val username:String,
    val password:String
)
@Serializable
data class LoginReceiveRemoteWidthEmail(
    val email:String,
    val password:String
)

@Serializable
data class LoginReceiveRemoteWidthGoogleEmail(
    val email:String
)
@Serializable
data class LoginResponseRemote(
    val token: String
)