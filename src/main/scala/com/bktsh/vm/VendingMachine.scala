package com.bktsh.vm
import com.bktsh.vm.Coin._
import javafx.scene.effect.DisplacementMap
import java.math.MathContext
import java.util.Observer
import java.util.Observable

object VendingMachine {

  object Display extends Observer {
    override def update(subject: Observable, param: Any): Unit = param match {
      case f: Float  => display(s"Your current balance is: ${f}")
      case s: String => display(s)
    }
    def display(msg: Any): Unit = println(msg)
  }

  object CashMachine extends Observable {
    var balance: Float = 0.0f

    def acceptCoin(coin: Coin): Unit = {
      def increaseBalance(addr: Float): Unit = {
        balance += addr
        setChanged()
        notifyObservers(balance)
      }
      coin match {
        case Quarter => increaseBalance(0.25f)
        case Dime    => increaseBalance(0.10f)
        case Nickle  => increaseBalance(0.05f)
        case _ =>
          setChanged()
          notifyObservers("Invalid coin. Please take your coin and insert a valid one!")
      }
    }
  }

  val display = Display
  val cashier = CashMachine
  val init = cashier.addObserver(display)

  def acceptCoin(coin: Coin) = {
    cashier.acceptCoin(coin)
  }
  def balance = cashier.balance

}