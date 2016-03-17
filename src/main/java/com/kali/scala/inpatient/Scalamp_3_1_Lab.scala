package com.kali.scala.inpatient

/**
  * Created by kalit_000 on 12/03/2016.
  */

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}

import scala.collection.mutable.ArrayBuffer

object Scalamp_3_1_Lab {

  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    val conf = new SparkConf().setMaster("local[*]").setAppName("YOUR_APP_NAME_USER").set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)

    //a remove second -ve numbers from array

    val a=ArrayBuffer(1,2,3,-4,-6,7)

    val indexs=for(i <- 0 until a.length if a(i) < 0) yield i

    val indextoremove=indexs.drop(1)

    println(indextoremove)

    for (i <- indextoremove.reverse) a.remove(i)
    println(a)

    // Grouping cluster first letters

    val words=Array("Mary","had","a")

    words.groupBy(_.substring(0,1))

   words.groupBy(_.length)

    //partitions and zips

    println("New York".partition(_.isUpper))

    val k=ArrayBuffer(1,2,-4,-5,6,7)

    val (neg,pos)=k.partition(_< 0)
     var result=pos

    result += neg(0)

    println(result)

    //zipping

    val symbols=Array("<",">","!")
    val counts=Array(2,4,5)
    val pairs=symbols.zip(counts)










  }


}
