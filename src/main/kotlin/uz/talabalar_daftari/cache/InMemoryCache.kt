package uz.talabalar_daftari.cache

import uz.talabalar_daftari.features.register.RegisterReceiveRemote

data class TokenCache(
    val username:String,
    val token:String
)

object InMemoryCache {
    val userList:MutableList<RegisterReceiveRemote> = mutableListOf()
    val token:MutableList<TokenCache> = mutableListOf()
}