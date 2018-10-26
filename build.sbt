lazy val doobieVersion = "0.6.0"

scalaVersion := "2.12.7"

libraryDependencies += "org.tpolecat" %% "doobie-core" % doobieVersion
libraryDependencies += "org.tpolecat" %% "doobie-h2"   % doobieVersion

libraryDependencies += "org.scalatest"  %% "scalatest"        % "3.0.5"       % "test"
libraryDependencies += "org.tpolecat"   %% "doobie-scalatest" % doobieVersion % "test"
libraryDependencies += "org.scalacheck" %% "scalacheck"       % "1.14.0"      % "test"
