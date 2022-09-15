package com.example.api.entity

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface HotelRepository : ElasticsearchRepository<Hotel, String>