package me.elasticsearch.entity

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class HotelRepositoryTest {

    @Autowired
    lateinit var hotelRepository: HotelRepository

    @Test
    fun findFindByOrderByNumberDesc() {
        val hotel: Hotel = hotelRepository.findFindByOrderByNumberDesc();
        println(hotel.location.lat)
        println(hotel.location.lon)
        println(hotel.number)
    }

    @Test
    fun save() {
        val lastHotel: Hotel = hotelRepository.findFindByOrderByNumberDesc();
        val geoPoint = Hotel.MyGeoPoint(lastHotel.location.lon, lastHotel.location.lat)

        val hotel = Hotel("name","address","area","type", lastHotel.number+1, geoPoint)
        val hotelSave = hotelRepository.save(hotel)

        println(hotelSave.id)
    }
}
