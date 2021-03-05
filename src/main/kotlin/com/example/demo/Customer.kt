package com.example.demo

import javax.persistence.*


@Entity
@Table(name = "customer")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //hack to avoid adding plugin to generate default constructor required by Hibernate
    val id: Long? = null,
    val name: String? = null,
    val company: String? = null)
