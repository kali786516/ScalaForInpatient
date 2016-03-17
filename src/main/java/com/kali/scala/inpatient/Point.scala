package com.kali.scala.inpatient

/**
  * Created by kalit_000 on 21/02/2016.
  */
import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}

class Point(val x:Double,val y:Double) {
  def move(dx:Double,dy:Double)=new Point(x +dx,y+dy)
  def distancefromOrigin=math.sqrt(x *x+y*y)
  override def toString=f"(${x},${y})"
}

object testcpoint {
  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    val conf = new SparkConf().setMaster("local[*]").setAppName("YOUR_APP_NAME_USER").set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)

    val p=new Point(3,4)

    println(p.move(5,4))



  }

}

