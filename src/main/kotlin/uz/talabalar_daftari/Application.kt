package uz.talabalar_daftari

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import uz.talabalar_daftari.features.login.configureLoginRouting
import uz.talabalar_daftari.features.register.configureRegisterRouting
import uz.talabalar_daftari.plugins.*

fun main() {
    embeddedServer(CIO, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureRouting()
    configureSerialization()
    configureRegisterRouting()
    configureLoginRouting()
}
