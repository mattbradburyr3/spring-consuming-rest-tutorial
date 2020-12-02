package com.example.consumerestkotlin

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject


// This app follows the spring boot 'Consuming a restful web service' tutorial: https://spring.io/guides/gs/consuming-rest/ but converts it to Kotlin


@SpringBootApplication
class ConsumeRestKotlinApplication {



	val log: Logger = LoggerFactory.getLogger(ConsumeRestKotlinApplication::class.java)

	@Bean
	fun RestTemplate(builder: RestTemplateBuilder): RestTemplate {
		return builder.build()
	}

	@Bean
	fun run(restTemplate: RestTemplate): CommandLineRunner {
		return CommandLineRunner { args ->
			val quote: Quote? = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote::class.java)
			log.info(quote.toString())
		}
	}
}
fun main(args: Array<String>) {
	runApplication<ConsumeRestKotlinApplication>(*args)
}