/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import sbt._
import sbt.Classpaths.publishTask
import Keys._
import sbtassembly.Plugin._
import AssemblyKeys._

object testBuild extends Build {
  // Target JVM version
  val SCALAC_JVM_VERSION = "jvm-1.6"
  val JAVAC_JVM_VERSION = "1.6"

  lazy val root = Project("root", file("."), settings = rootSettings) aggregate(allProjects: _*)
  lazy val core = Project("core", file("core"), settings = coreSettings)
  lazy val foo = Project("foo", file("foo"), settings = fooSettings) dependsOn (core)
  lazy val bar = Project("bar", file("bar"), settings = barSettings) dependsOn (core)

  lazy val allProjects = Seq[ProjectReference](core, foo, bar)

  def sharedSettings = Defaults.defaultSettings ++ Seq(
    organization       := "org.raymond.test",
    version            := "0.1.0",
    scalaVersion       := "2.10.3",

    // also check the local Maven repository ~/.m2
    resolvers ++= Seq(Resolver.file("Local Maven Repo", file(Path.userHome + "/.m2/repository"))),

    publishMavenStyle := true,

    libraryDependencies ++= Seq(
        "org.scalatest"    %% "scalatest"       % "1.9.1"  % "test"
    ),

    parallelExecution := true

  ) ++ net.virtualvoid.sbt.graph.Plugin.graphSettings


  def coreSettings = sharedSettings ++ Seq(
    name := "test-core"
  )

  def commonSettings = sharedSettings ++ Seq(
    name := "test-common"
  )

  def rootSettings = sharedSettings ++ Seq(
    publish := {}
  )

  def fooSettings = sharedSettings ++ Seq(
    name :="test-foo",
    unmanagedSourceDirectories in Compile <++= baseDirectory { base =>
      Seq(
            base / "../common/src/main/scala"
         )
    }
  ) ++ assemblySettings

  def barSettings = sharedSettings ++ Seq(
    name :="test-bar",
    unmanagedSourceDirectories in Compile <++= baseDirectory { base =>
      Seq(
            base / "../common/src/main/scala"
         )
    }
  ) ++ assemblySettings


}
