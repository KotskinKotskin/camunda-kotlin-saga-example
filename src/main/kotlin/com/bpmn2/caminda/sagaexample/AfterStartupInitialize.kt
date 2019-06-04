package com.bpmn2.caminda.sagaexample

import model.Account
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.stereotype.Component
import repository.AccountRepository


@Component
class ApplicationReady(private val accountRepository: AccountRepository): ApplicationListener<ApplicationReadyEvent> {
    private val logger = LoggerFactory.getLogger(ApplicationReady::class.java)
    override fun onApplicationEvent(event: ApplicationReadyEvent) {
      var account1 = Account(1,0.0)
        var account2 = Account(2, 0.0)
        accountRepository.save(account1)
        accountRepository.save(account2)


        logger.info(">>> Init done, accounts created")
    }
}


