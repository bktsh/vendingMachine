package com.bktsh.vm
import com.bktsh.vm.Coin._
import org.scalatest._
import java.math.MathContext

class VendingMachineTest extends FunSpec {
  
	val mc = new MathContext(2)

  //Just to avoid unit test dependency and still have float comparison
  def ~=(x: Double, y: Double, precision: Double) = {
    if ((x - y).abs < precision) true else false
  }

  
  describe("A Vending Machine") {
    val subject = VendingMachine
    
    it("should have balance of 0 when it starts ") {
        assert(subject.balance == BigDecimal(0))
      }

      it("should increase sum by 0.25 when a Querter coin is inserted") {
        subject.insertCoin(Quarter)
        assert( ~=(subject.balance ,0.25, 0.00001))
      }
      
      it("should increase sum by 0.1 when a Dime coin is inserted") {
        subject.insertCoin(Dime)
        assert( ~=(subject.balance ,0.35, 0.00001))
      }      

     it("should increase sum by 0.05 when a Nickle coin is inserted") {
        subject.insertCoin(Dime)
        assert( ~=(subject.balance ,0.45, 0.00001))
      }      

     it("should increase sum by 0.01 when a Penny coin is inserted") {
        subject.insertCoin(Penny)
        assert( ~=(subject.balance ,0.46, 0.00001))
      }
     
     it("should not increase sum and display message match my error message when a bad coin inserted") {
        subject.insertCoin(Other)
        assert( ~=(subject.balance ,0.46, 0.00001))
      }      
     
    }

}