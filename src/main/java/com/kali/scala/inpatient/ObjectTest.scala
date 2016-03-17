package com.kali.scala.inpatient

/**
  * Created by kalit_000 on 15/02/2016.
  */

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}

object ObjectTest {

  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    val conf = new SparkConf().setMaster("local[*]").setAppName("YOUR_APP_NAME_USER").set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)

    println("Hi kali")

    //recurcive function

    def fac(n:Int) = {
    var r=1
    for (i <- 1 to n) r=r*i
    r
    }

    println(fac(10))

   //recurcive factorial function

    def facrecurcise(n:Int):Int=
    {
      if (n <1) 1 else   n * facrecurcise(n-1)

    }

    println(facrecurcise(5))

   //send number of values....

    def sum(n:Int*)= {
    var result=0
    for(args <- n) result +=args
    result
    }

    println(sum(1 to 10 : _*))


    def recurcisesumlist(n:List[Int]):Int =
    {
      n match
        {
        case n::tail => n + recurcisesumlist(tail)
        case Nil => 0
        }
    }

    println(recurcisesumlist(List(1,2,4)))

    def recurciseSum(args:Int*):Int ={
      if (args.length == 0) 0
      else
        args.head + recurciseSum(args.tail :_*)

    }

    println(recurciseSum(1 to 5:_*))

    //TEST  :-

    //TEST 1:- check vowel or not

    def isVowel(ch:Char) = ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'

    println(isVowel('k'))

    def vowelcontains(ch:Char)="aeiou".contains(ch)

    println(vowelcontains('a'))


    def vowel(s:String) ={
      var result=""
      for (i <- s)
        {
         if (isVowel(i)) result += i
        }
      result

    }

    println(vowel("kali"))

    def vowel2(s:String)={
      for (ch <- s if (isVowel(ch))) yield ch
    }

    println(vowel2("charan"))


    def vowelrecursive(s:String):String={

      if (s.length ==0) "/" else
        {
          val ch=s(0)
          val rest=vowel2(s.substring(1))
          if (isVowel(ch)) ch + rest else rest
        }
    }

    println(vowelrecursive("kali"))

  }
}
