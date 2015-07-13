package com.bktsh.vm
import com.bktsh.vm.Coin._
import javafx.scene.effect.DisplacementMap
import java.math.MathContext

object VendingMachine {

  var balance : Float = 0.0f
  def display(msg: Any): Unit = println(msg)

  def insertCoin(coin: Coin): Unit = {
    def increaseBalance(addr: Float): Unit = {
      balance += addr
      display(s"Balance: ${balance}")
    }
    coin match {
      case Quarter => increaseBalance(0.25f)
      case Dime    => increaseBalance(0.10f)
      case Nickle  => increaseBalance(0.05f)
      case Penny   => increaseBalance(0.01f)
      case _       => display("Invalid coin. Please take your coininsert a valid one!")
    }
  }
}