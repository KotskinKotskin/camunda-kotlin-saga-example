package com.bpmn2.caminda.sagaexample


import model.Account
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import repository.AccountRepository

@EnableProcessApplication
@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = arrayOf(AccountRepository::class))
@EntityScan(basePackageClasses = arrayOf(Account::class))
class SagaExampleApplication
fun main(args: Array<String>) {
	runApplication<SagaExampleApplication>(*args)


}
