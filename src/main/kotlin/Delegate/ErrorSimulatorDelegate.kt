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



    }
}
