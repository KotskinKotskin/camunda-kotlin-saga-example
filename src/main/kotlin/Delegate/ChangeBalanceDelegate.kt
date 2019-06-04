package Delegate

import com.bpmn2.caminda.sagaexample.ApplicationReady
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import repository.AccountRepository



class ChangeBalanceDelegate(private val accountRepository : AccountRepository) : JavaDelegate {

    private val logger = LoggerFactory.getLogger(ChangeBalanceDelegate::class.java)

    override fun execute(execution: DelegateExecution) {
        var accountId = execution.getVariable("accountId") as String
        var amount = execution.getVariable("amount") as Double
        var operation  = execution.getVariable("operation") as String

        var account = accountRepository.getOne(accountId.toInt())

        if (operation == "+") {
            account.balance = account.balance + amount
        }
        if (operation == "-") {
            account.balance = account.balance - amount
        }
        accountRepository.save(account);

        logger.info("Account $accountId, Operation $operation, Amount $amount")

    }

}
