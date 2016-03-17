package com.kali.scala.inpatient

/**
  * Created by kalit_000 on 20/02/2016.
  */

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}

object MapTuples {

  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    val conf = new SparkConf().setMaster("local[*]").setAppName("YOUR_APP_NAME_USER").set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)

    val scores=Map("Alice" -> 10,"Bob" -> 3, "cindy" -> 8)

    val bobsscore=scores("Bob")

    val test=scores.getOrElse("kali",0)

    def sum(args:Int *):Int={

      var result=0

      for (arg <- args) result +=arg

       result
    }

    //println(sum( 1to 10 :_*)) //:_* consider the values as seq of something

    //println(bobsscore)

    //println(test)

    def recusrsivesum(argss:Int *):Int ={

      if (argss.length == 0) 0
      else
        argss.head + recusrsivesum(argss.tail:_*)

    }

    println(recusrsivesum(1 to 50:_*))



  }





}
