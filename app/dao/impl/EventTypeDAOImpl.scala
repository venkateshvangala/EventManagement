package dao.impl

import dao.EventTypeDAO
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile
import play.api.Play
import scala.concurrent.Future
import slick.driver.PostgresDriver.api._
import models.data.EventTypeTable
import models.data.EventType
import scala.concurrent.ExecutionContext.Implicits.global


object EventTypeDAOImpl {
  
  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)
  val eventTypes = TableQuery[EventTypeTable]
  
  def all: Future[Seq[EventType]] = {
    dbConfig.db.run(eventTypes.result)
  }
  
  def add(eventType: Seq[EventType]): Future[String] = {
    dbConfig.db.run(eventTypes ++= eventType).map(result => "Success").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }
  
  
  
}