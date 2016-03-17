package com.kali.scala.inpatient

/**
  * Created by kalit_000 on 12/03/2016.
  */

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}

object Scalamp_4_Lab {

  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    val conf = new SparkConf().setMaster("local[*]").setAppName("YOUR_APP_NAME_USER").set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)

    val zones=java.util.TimeZone.getAvailableIDs

    zones.map(s => s.split("/")).filter(_.length > 1).map(x => x(1)).grouped(10).toArray.map(x => x(0))

    //reduce left
    1.to(10).reduceLeft(_*_)
    def fact(n:Int)=1.to(n).reduceLeft(_ * _)
    fact(10)

    def pow(a:Int,b:Int)=1.to(b).map(n => a).reduceLeft(_ * _)

    pow(2,16)

  }


}
