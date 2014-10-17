import sbtrelease._
import ReleaseStateTransformations._

ReleasePlugin.releaseSettings

sonatypeSettings

ReleaseKeys.releaseProcess := Seq[sbtrelease.ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  ReleaseStep{ state =>
    val extracted = Project extract state
    extracted.runAggregated(PgpKeys.publishSigned in Global in extracted.get(thisProjectRef), state)
  },
  setNextVersion,
  commitNextVersion,
  ReleaseStep{ state =>
    val extracted = Project extract state
    extracted.runAggregated(SonatypeKeys.sonatypeReleaseAll in Global in extracted.get(thisProjectRef), state)
  },
  pushChanges
)
