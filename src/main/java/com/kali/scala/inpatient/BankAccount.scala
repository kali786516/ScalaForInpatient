package com.kali.scala.inpatient

/**
  * Created by kalit_000 on 12/03/2016.
  */

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}
import org.apache.tools.ant.listener.TimestampedLogger

trait Logged {

  def log(msg:String) {}
}

trait ConsoleLogger extends Logged {
  override def log(msg:String) { println(msg)}
}

trait TimestampLogger extends Logged {
  override def log(msg:String): Unit = {
    super.log(new java.util.Date()+ ""+ msg)
  }
}

trait ShortLogger extends Logged {
  val maxlength=15
  override def log(msg:String): Unit = {
    super.log(
      if (msg.length <= maxlength) msg
      else msg.substring(0,maxlength-3) + "...")
    }
}

class SavingsAccount extends Logged {
  private  var balance:Double = 1000
  def withdraw(amount:Double) ={
    if (amount > balance) log("Go Fuck Your Self:Insuffient Funds")
    else
      balance -=amount
      log(s"Amount withdrawn:-${amount}")
      log(s"Remaining Balance:-${balance}")
    }
  def balanceenquiry:String ={
   val BalanceenquiryMessage =f"Your Balance:-${balance}"
    return BalanceenquiryMessage
  }

}

object BankAccount {

  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    val conf = new SparkConf().setMaster("local[*]").setAppName("BANK_ACCOUNT").set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)

    val a=new SavingsAccount with ConsoleLogger with TimestampLogger
    println(a.balanceenquiry)
    println(a.withdraw(10))

    //currying example
    /*
    * def mul(x:Int,y:Int)=x*y
    *
    * def mulOneAtATime(x:Int) =(y:Int) => x * y
    *
    *
    * */

  }


}
