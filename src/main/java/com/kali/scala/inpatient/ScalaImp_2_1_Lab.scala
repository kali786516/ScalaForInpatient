package com.kali.scala.inpatient

/**
  * Created by kalit_000 on 12/03/2016.
  */

import net.liftweb.util.True
import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}

object ScalaImp_2_1_Lab {

  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    val conf = new SparkConf().setMaster("local[*]").setAppName("YOUR_APP_NAME_USER").set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)


    //Exc a) function to test wheter a charcter is a vowel or not

    def isvowel(ch:Char)={ ch == 'a' || ch == 'e' || ch == 'i'  }

    println(isvowel('a'))

    // Ex b) using contains

    def isvowel2(c:Char)="aeiou".contains(c)

    println(isvowel2('e'))

   // Ex c) write a function that return vowels

    def vowels(s:String)=
    {
      var result=""
      for (a <- s) {
       if (isvowel2(a)) result += a
      }
      result
    }

    println(vowels("kali"))

    //Ex d) use yield

    def vowels2(a:String)=
    { for(b <- a if isvowel(b)) yield b   }

    println(vowels2("kali"))

    //Ex e) upper & lowercase

  }
}
