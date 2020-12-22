package me.elasticsearch.service

import me.elasticsearch.entity.Hotel
import me.elasticsearch.entity.HotelRepository
import org.springframework.stereotype.Service

@Service
class ApiService (val hotelRepository: HotelRepository) {
//    fun findTop10(): List<Hotel> {
//        return hotelRepository.findTop10().toList()
//    }

    fun findCount() : Long {
        return hotelRepository.count()
    }
}
