organization := "com.github.xuwei-k"

name := "html2image"

autoScalaLibrary := false

crossPaths := false

libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"

def gitHash: Option[String] = scala.util.Try(
  sys.process.Process("git rev-parse HEAD").lines_!.head
).toOption

homepage := Some(url("https://github.com/xuwei-k/html2image"))

licenses += ("lgpl" -> url("http://www.gnu.org/licenses/lgpl.html"))

pomExtra := (
<developers>
  <developer>
    <id>xuwei-k</id>
    <name>Kenji Yoshida</name>
    <url>https://github.com/xuwei-k</url>
  </developer>
</developers>
<scm>
  <url>git@github.com:xuwei-k/html2image.git</url>
  <connection>scm:git:git@github.com:xuwei-k/html2image.git</connection>
  <tag>{if(isSnapshot.value) gitHash.getOrElse("master") else { "v" + version.value }}</tag>
</scm>
)

javacOptions in compile ++= Seq("-target", "6", "-source", "6")
