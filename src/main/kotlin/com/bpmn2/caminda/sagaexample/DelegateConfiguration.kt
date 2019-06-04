package com.bpmn2.caminda.sagaexample

import Delegate.ChangeBalanceDelegate
import Delegate.ErrorSimulatorDelegate
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import repository.AccountRepository

@Configuration
class DelegateConfiguration {
  @Bean
  fun changeBalanceDelegate(acountRepository: AccountRepository): JavaDelegate = ChangeBalanceDelegate(acountRepository)

  @Bean
  fun errorSimulatorDelegate(acountRepository: AccountRepository): JavaDelegate = ErrorSimulatorDelegate(acountRepository)
}
