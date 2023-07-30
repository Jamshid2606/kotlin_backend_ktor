package uz.talabalar_daftari.features.login

import io.ktor.client.request.*
import io.ktor.server.testing.*
import kotlin.test.Test

class ConfigureLoginRoutingTest {

    @Test
    fun testPostLogin() = testApplication {
        application {
            configureLoginRouting()
        }
        client.post("/login").apply {
            TODO("Please write your test here")
        }
    }
}