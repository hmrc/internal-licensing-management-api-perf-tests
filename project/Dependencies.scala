import sbt.*

object Dependencies {

  val test = Seq(
    "uk.gov.hmrc"                  %% "api-performance-test-runner" % "2.2.0",
    "com.fasterxml.jackson.module" %% "jackson-module-scala"        % "2.14.2"
  )

}
