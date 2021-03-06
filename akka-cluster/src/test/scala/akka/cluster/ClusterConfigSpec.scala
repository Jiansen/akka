/**
 *  Copyright (C) 2009-2012 Typesafe Inc. <http://www.typesafe.com>
 */

package akka.cluster

import akka.testkit.AkkaSpec
import akka.util.duration._
import akka.util.Duration

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class ClusterConfigSpec extends AkkaSpec {

  "Clustering" must {

    "be able to parse generic cluster config elements" in {
      val settings = new ClusterSettings(system.settings.config, system.name)
      import settings._
      FailureDetectorThreshold must be(8.0 plusOrMinus 0.0001)
      FailureDetectorMaxSampleSize must be(1000)
      FailureDetectorImplementationClass must be(classOf[AccrualFailureDetector].getName)
      FailureDetectorMinStdDeviation must be(100 millis)
      FailureDetectorAcceptableHeartbeatPause must be(3 seconds)
      SeedNodes must be(Seq.empty[String])
      SeedNodeTimeout must be(5 seconds)
      PeriodicTasksInitialDelay must be(1 seconds)
      GossipInterval must be(1 second)
      HeartbeatInterval must be(1 second)
      LeaderActionsInterval must be(1 second)
      UnreachableNodesReaperInterval must be(1 second)
      JoinTimeout must be(60 seconds)
      NrOfGossipDaemons must be(4)
      AutoJoin must be(true)
      AutoDown must be(true)
      SchedulerTickDuration must be(33 millis)
      SchedulerTicksPerWheel must be(512)
    }
  }
}
