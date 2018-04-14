package tech.feldman.charisms.backend

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Charisms

fun main(args: Array<String>) {
    SpringApplication.run(Charisms::class.java, *args)
}
