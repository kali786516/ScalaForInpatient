package com.kali.scala.inpatient

/**
  * Created by kalit_000 on 12/03/2016.
  */

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}
import org.joda.time.{Minutes, Hours}

class Time(val hours:Int,val minutes:Int) {

  if (hours < 0 || hours >= 24 || minutes < 0 || minutes >= 60) throw new IllegalArgumentException

  //compare object data
  def before(other:Time)=hours < other.hours || hours == other.hours && minutes < other.minutes

  override def toString =f"${hours}:${minutes}%02d"

}

class Time2(h:Int, m:Int=0) {

  private var minutesSinceMidnight= h * 60 +m
  def hours=minutesSinceMidnight / 60
  def minutes=minutesSinceMidnight % 60
  def minutes_=(newValue:Int) {minutesSinceMidnight=hours*60 + newValue}
  if (h < 0 || h >= 24 ||m < 0 || m >= 60) throw new IllegalArgumentException
  def before2(other:Time2)=minutesSinceMidnight < other.minutesSinceMidnight
  override  def toString=f"${hours}:${minutes}%02d"

}


object Scalamp_4_2_Class_Lab {

  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    val conf = new SparkConf().setMaster("local[*]").setAppName("YOUR_APP_NAME_USER").set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)

    val mornings=new Time(9,30)
    val afternoon=new Time(16,30)
    println(mornings)
    println(afternoon)

    mornings.before(afternoon)
    afternoon.before(mornings)

   val noon=new Time2(12)
    println(noon.hours)

  }

}
