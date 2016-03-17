package com.kali.scala.inpatient

/**
  * Created by kalit_000 on 20/02/2016.
  */

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}

object ArraysBuffer {

  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    val conf = new SparkConf().setMaster("local[*]").setAppName("YOUR_APP_NAME_USER").set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)

    import scala.collection.mutable.ArrayBuffer

    val b=ArrayBuffer("Mary","had","a","little","lamb")

    //b +="its"
    //b +=("fleece","was","white")
    //b ++=Array("as","snow")

    //b.remove(3)

    //b.insert(3,"medium-siezed")
    //b.trimEnd(5)
    //println(b)


    val test=ArrayBuffer(-4,-3,-2,-1,0,1,2,3)

    def removeallbutfirstNegative(buf:ArrayBuffer[Int]) = {
      val indexToremove = (for (i <- 0 until test.length if (test(i) < 0)) yield i).drop(1)
      for (i <- 0 until test.length if !indexToremove.contains(i)) yield test(i)
    }


  }


}
