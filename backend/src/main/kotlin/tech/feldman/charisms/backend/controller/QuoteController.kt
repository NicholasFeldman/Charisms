package tech.feldman.charisms.backend.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tech.feldman.charisms.backend.domain.Quote
import tech.feldman.charisms.backend.repository.QuoteRepository
import javax.validation.Valid

@RestController
@RequestMapping("/api/quotes")
class QuoteController(private val repository: QuoteRepository) {

    @GetMapping
    fun getAllQuotes() =
            repository.findAll()

    @PostMapping
    fun createNewQuote(@Valid @RequestBody quote: Quote): Quote =
            repository.save(quote)

    @GetMapping("/{id}")
    fun getQuoteById(@PathVariable id: Long): ResponseEntity<Quote> {
        return repository.findById(id).map { quote ->
            ResponseEntity.ok(quote)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/{id}")
    fun updateQuoteById(@PathVariable id: Long, @Valid @RequestBody newQuote: Quote): ResponseEntity<Quote> {
        return repository.findById(id).map { existingQuote ->
            val updatedQuote = existingQuote.copy(quote = newQuote.quote)

            ResponseEntity.ok().body(repository.save(updatedQuote))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun deleteQuoteByID(@PathVariable id: Long): ResponseEntity<Void> {
        return repository.findById(id).map { quote ->
            repository.delete(quote)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}
