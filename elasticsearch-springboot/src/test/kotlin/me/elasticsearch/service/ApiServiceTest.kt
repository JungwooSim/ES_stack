package me.elasticsearch.service

import me.elasticsearch.entity.HotelRepository
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class ApiServiceTest {

    lateinit var apiService: ApiService


    @Qualifier("hotelRepository")
    @Autowired
    lateinit var hotelRepository: HotelRepository


    @BeforeEach
    fun setup(): Unit{
        apiService = ApiService(hotelRepository)
    }

//    @Test
//    @DisplayName("findTop10")
//    fun findTop10(): Unit {
//        val findAll = apiService.findTop10()
//        println(findAll)
//    }

    @Test
    fun findCount() {
        val count: Long = apiService.findCount()
        println(count)
    }
}
