import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by santu_pc on 9/7/2016.
  */
object TransaformationsAndActions {

  def main(args: Array[String]) {
    System.setProperty("hadoop.home.dir","E:\\MS\\PrinciplesofBigDataManagement\\hadoop-common-2.2.0-bin-master")
    // initialise spark context
    val conf = new SparkConf().setAppName("CountSpark").setMaster("local[2]").set("spark.executor.memory","8g")
    val sc = new SparkContext(conf)

    val textFile = sc.textFile("E:\\MS\\RealTimeBigDataAnalytics\\Words.txt")

    val counts = textFile.map(word => (word, 1))
      .reduceByKey(_ + _)
      .sortByKey(true)

    //var SmallArr = new Array[String](5)
    var KeyArr = new Array[String](5)
    //val ParallelRDD = sc.parallelize((1 to 100), 4)
    //println(textFile.take(2))
    //SmallArr = textFile.takeOrdered(2)(
     // Ordering[String].reverse)

    KeyArr = textFile.take(2)
    println(textFile.count())

    for(s <- KeyArr){
     println(s)
    }

    //KeyArr.foreach((o: String) => println(o))

    counts.saveAsTextFile("E:\\MS\\RealTimeBigDataAnalytics\\LabAssignment2")

  }

}
