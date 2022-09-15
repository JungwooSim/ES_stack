package com.example.api.entity

import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import javax.persistence.Id

@Document(indexName = "hotel", createIndex = true)
class Hotel(
        name: String,
        address: String,
        area: String,
        type: String,
        number: Long,
        location: MyGeoPoint
) {
    @Id
    @Field(type = FieldType.Auto)
    val id: String? = null

    @Field(type = FieldType.Text)
    val name: String = name

    @Field(type = FieldType.Text)
    val address: String = address

    @Field(type = FieldType.Text)
    val area: String = area

    @Field(type = FieldType.Text)
    val type: String = type

    @Field(type = FieldType.Long)
    val number: Long = number

    var location: MyGeoPoint = location

    class MyGeoPoint(lon: Any?, lat: Any?) {
        @Field(type = FieldType.Float)
        val lon: Double = lon.toString().toDoubleOrNull() ?: 0.0

        @Field(type = FieldType.Float)
        val lat: Double = lat.toString().toDoubleOrNull() ?: 0.0
    }
}
