package uz.talabalar_daftari.features.login

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import uz.talabalar_daftari.cache.InMemoryCache
import uz.talabalar_daftari.cache.TokenCache
import java.util.UUID

fun Application.configureLoginRouting() {
    routing {
        post("/loginUserName") {
            val receive = call.receive<LoginReceiveRemoteWidthUserName>()
            val first = InMemoryCache.userList.firstOrNull { it.username == receive.username }
            if (first==null){
                call.respond(HttpStatusCode.BadRequest, "User Not Found")
            }else{
                if (first.password == receive.password){
                    val token = UUID.randomUUID().toString()
                    InMemoryCache.token.add(TokenCache(username = receive.username, token = token))
                    call.respond(LoginResponseRemote(token = token))
                    return@post
                }else{
                    call.respond(HttpStatusCode.BadRequest, "Invalid Password")
                }
            }
        }
        post("/loginEmail"){
            val receive = call.receive<LoginReceiveRemoteWidthEmail>()
            val first = InMemoryCache.userList.firstOrNull { it.email == receive.email }
            if (first==null){
                call.respond(HttpStatusCode.BadRequest, "User Not Found")
            }else{
                if (first.password == receive.password){
                    val token = UUID.randomUUID().toString()
                    InMemoryCache.token.add(TokenCache(username = receive.email, token = token))
                    call.respond(LoginResponseRemote(token = token))
                    return@post
                }else{
                    call.respond(HttpStatusCode.BadRequest, "Invalid Password")
                }
            }
        }
        post("/loginGoogleEmail"){
            val receive = call.receive<LoginReceiveRemoteWidthGoogleEmail>()
            val first = InMemoryCache.userList.firstOrNull { it.email == receive.email }
            if (first==null){
                call.respond(HttpStatusCode.BadRequest, "User Not Found")
            }else{
                val token = UUID.randomUUID().toString()
                InMemoryCache.token.add(TokenCache(username = receive.email, token = token))
                call.respond(LoginResponseRemote(token = token))
                return@post
            }
        }
    }
}
