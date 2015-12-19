name := "play-spring-data-elasticsearch"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test,
  "javax.inject" % "javax.inject" % "1",
  "org.springframework.data" % "spring-data-elasticsearch" % "1.3.1.RELEASE",
  "org.elasticsearch" % "elasticsearch" % "1.7.3",
  "org.springframework.guice" % "spring-guice" % "1.0.0.BUILD-SNAPSHOT"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
resolvers += "Spring Snapshots" at "http://maven.springframework.org/snapshot"


// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
