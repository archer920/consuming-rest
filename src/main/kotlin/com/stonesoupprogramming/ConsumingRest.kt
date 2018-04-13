package com.stonesoupprogramming

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.web.client.RestTemplate

/**
 * The following data classes are instantiated by Jackson and converted from JSON to
 * objects. Normally, the class needs to have all of the properties in the JSON, but
 * we can change this by using the ignoreUnknown = true argument
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class Value(var id: Long = 0, var quote: String = "")

@JsonIgnoreProperties(ignoreUnknown = true)
data class Quote(var type : String = "", var value : Value? = null)

fun main (args : Array<String>){
    //Create a new RestTemplate and use getForObject to make a GET request
    //to the server and return an instance of Quote representing the response
    val quote = RestTemplate().getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote::class.java)

    //Print the response to the console
    println(quote)
}