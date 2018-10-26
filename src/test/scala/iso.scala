package com.htmlism.lexorank
package storage
package sql

import cats.effect.IO

import doobie._
import doobie.scalatest._
import org.scalatest._

import doobie.implicits._

class Iso extends FreeSpec with IOChecker {
  def transactor: Transactor[IO] = {
    val g = scala.concurrent.ExecutionContext.global

    implicit val cs: cats.effect.ContextShift[IO] = IO.contextShift(g)

    val z = sql"""
    CREATE TABLE foo (
      a int
    );"""

    val tx =
      Transactor
        .fromDriverManager[IO]("org.h2.Driver", "jdbc:h2:mem:")

    z.update.run
      .transact(tx)
      .unsafeRunSync()

    tx
  }

  "type safe queries in h2" - {
    "select one" in {
      check(sql"""select * from foo""".query[Int])
    }
  }
}

