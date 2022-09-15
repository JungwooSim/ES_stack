package com.example.api.service

import com.example.api.entity.HotelRepository
import org.springframework.stereotype.Service

@Service
class ApiService(
    private val hotelRepository: HotelRepository
) {

    fun count() {
//        hotelRepository.count()

        println(hotelRepository.count())
    }
}