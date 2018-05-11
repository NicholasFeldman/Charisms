package tech.feldman.charisms.backend.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tech.feldman.charisms.backend.domain.Quote
import tech.feldman.charisms.backend.repository.QuoteRepository
import javax.validation.Valid

@RestController
@RequestMapping("/api/quotes")
@Api("/api/quotes")
class QuoteController(private val repository: QuoteRepository) {

    @GetMapping
    @ApiOperation("Get all of the quotes")
    fun getAllQuotes() =
            repository.findAll()

    @PostMapping
    @ApiOperation("Create a new quote")
    fun createNewQuote(@Valid @RequestBody quote: Quote): Quote =
            repository.save(quote)

    @GetMapping("/{id}")
    @ApiOperation("Get a single quote")
    fun getQuoteById(@PathVariable id: Long): ResponseEntity<Quote> {
        return repository.findById(id).map { quote ->
            ResponseEntity.ok(quote)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/{id}")
    @ApiOperation("Update a quote")
    fun updateQuoteById(@PathVariable id: Long, @Valid @RequestBody newQuote: Quote): ResponseEntity<Quote> {
        return repository.findById(id).map { existingQuote ->
            val updatedQuote = existingQuote.copy(quote = newQuote.quote)

            ResponseEntity.ok().body(repository.save(updatedQuote))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a quote")
    fun deleteQuoteByID(@PathVariable id: Long): ResponseEntity<Void> {
        return repository.findById(id).map { quote ->
            repository.delete(quote)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}
