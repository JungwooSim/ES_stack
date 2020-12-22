package me.elasticsearch.entity

import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import javax.persistence.Id

@Document(indexName = "hotel", createIndex = true)
data class Hotel(
        @Id @Field(type = FieldType.Auto) val id: String,
        @Field(type = FieldType.Text) val name: String,
        @Field(type = FieldType.Text) val address: String,
        @Field(type = FieldType.Text) val area: String,
        @Field(type = FieldType.Text) val type: String,
//        @Field(type = FieldType.) val location: String
)
