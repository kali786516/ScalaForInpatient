package com.kali.scala.inpatient

/**
  * Created by kalit_000 on 12/03/2016.
  */

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}

import scala.collection.immutable.HashMap

class Point2(val x:Double,val y:Double) {
  def move(dx:Double,dy:Double)=new Point(x+dx,y+dy)
  def distanceFromOrigin=math.sqrt(x*x+y*y)
  override def toString=f"(${x},${y})"
}

object Scalamp_4_1_Lab {

  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    val conf = new SparkConf().setMaster("local[*]").setAppName("YOUR_APP_NAME_USER").set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)

    val p=new Point2(3,4)

    println(p.move(10,12))

    println(p.distanceFromOrigin)

   //map test=

    val a=Map("New York" -> "USA")

    println(a.values)
    val b=HashMap("Delhi" -> "India")

    println(b("Delhi"))
    //println(a.keySet("New York"))



  }


}
