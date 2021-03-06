import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by santu_pc on 8/31/2016.
  */
object SentenceCount {

  def main(args: Array[String]) {
    System.setProperty("hadoop.home.dir","E:\\MS\\PrinciplesofBigDataManagement\\hadoop-common-2.2.0-bin-master")
    // initialise spark context
    val conf = new SparkConf().setAppName("CountSpark").setMaster("local[2]").set("spark.executor.memory","8g")
    val sc = new SparkContext(conf)

    val textFile = sc.textFile("E:\\MS\\PrinciplesofBigDataManagement\\Words.txt")

    val counts = textFile.map(word => (word, 1))
      .reduceByKey(_ + _)
      .sortByKey(true,1)
    counts.saveAsTextFile("E:\\MS\\RealTimeBigDataAnalytics\\SparkSentenceCount")

  }

}