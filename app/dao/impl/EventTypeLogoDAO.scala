package dao.impl

import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile
import play.api.Play

import scala.concurrent.Future
import slick.driver.PostgresDriver.api._
import models.data.{EventTypeLogo, EventTypeLogoTable}

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by venkateshv on 8/6/16.
  */
object EventTypeLogoDAO {

  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)
  val eventTypesLogo = TableQuery[EventTypeLogoTable]

  def all: Future[Seq[EventTypeLogo]] = {
    dbConfig.db.run(eventTypesLogo.result)
  }

  def add(eventType: Seq[EventTypeLogo]): Future[String] = {
    dbConfig.db.run(eventTypesLogo ++= eventType).map(result => "Success").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

}
