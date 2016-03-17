package com.kali.scala.inpatient

/**
  * Created by kalit_000 on 20/02/2016.
  */

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}

object vowelfunctionstest {

  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    val conf = new SparkConf().setMaster("local[*]").setAppName("YOUR_APP_NAME_USER").set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)

    def isVowel(ch:Char,vowelchars:String="aeiou")=vowelchars.contains(ch)

    //println(isVowel('k'))

    def vowels(s:String):String=
    {
      if (s.length==0) "" else
        for (ch <- s if isVowel(ch)) yield ch

    }

    println(vowels("kali"))


  }



}
