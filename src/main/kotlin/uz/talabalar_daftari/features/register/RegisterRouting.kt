package uz.talabalar_daftari.features.register

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import uz.talabalar_daftari.cache.InMemoryCache
import uz.talabalar_daftari.cache.TokenCache
import uz.talabalar_daftari.utils.isValidEmail
import java.util.UUID

fun Application.configureRegisterRouting() {
    routing {
        post("/register") {
            val receive = call.receive<RegisterReceiveRemote>()
            if (!receive.email.isValidEmail()){
                call.respond(HttpStatusCode.BadRequest, "Email is not Valid")
            }
            if (InMemoryCache.userList.map { it.username }.contains(receive.username)){
                call.respond(HttpStatusCode.Conflict, "User already exists")
            }
            if (InMemoryCache.userList.map { it.email }.contains(receive.email)){
                call.respond(HttpStatusCode.Conflict, "User already exists")
            }
            val token = UUID.randomUUID().toString()
            InMemoryCache.userList.add(receive)
            InMemoryCache.token.add(TokenCache(username = receive.username, token = token))

            call.respond(RegisterResponseRemote(token = token))
        }
    }
}
