package Delegate

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import repository.AccountRepository
import java.util.Random
import org.camunda.bpm.engine.delegate.BpmnError



class ErrorSimulatorDelegate(private val accountRepository : AccountRepository): JavaDelegate {
    override fun execute(execution: DelegateExecution) {
      var random = Random()
      var digit = random.nextGaussian()

       var error = false

      if (digit > 0.6) {
          error = true
      }
      execution.setVariable("error", error)

      var account1 = accountRepository.getOne(1)
      var account2 = accountRepository.getOne(2)

        if (account1.balance != account2.balance*(-1)) {
            execution.setVariable("account1balance", account1.balance)
            execution.setVariable("account2balance", account2.balance)
            throw BpmnError("balanceError", "error in balance")
        }

    }
}
