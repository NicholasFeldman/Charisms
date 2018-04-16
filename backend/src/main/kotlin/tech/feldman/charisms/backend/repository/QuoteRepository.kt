package tech.feldman.charisms.backend.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import tech.feldman.charisms.backend.domain.Quote

@Repository
interface QuoteRepository : JpaRepository<Quote, Long>
