package com.hackathon.junction.entity

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime


@EntityListeners(AuditingEntityListener::class)
@MappedSuperclass
abstract class BaseTimeEntity {
    @CreatedDate
    @Column(updatable = false, name = "createdDate")
    var createdDate: LocalDateTime? = null

    @LastModifiedDate
    @Column(name = "lastModifiedDate")
    var lastModifiedDate: LocalDateTime? = null
}