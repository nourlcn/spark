package spark.broadcast

/**
 * An interface for all the broadcast implementations in Spark (to allow 
 * multiple broadcast implementations). SparkContext uses a user-specified
 * BroadcastFactory implementation to instantiate a particular broadcast for the
 * entire Spark job.
 */
private[spark] trait BroadcastFactory {
  def initialize(isMaster: Boolean): Unit
  def newBroadcast[T](value_ : T, isLocal: Boolean, id: Long): Broadcast[T]
  def stop(): Unit
}
