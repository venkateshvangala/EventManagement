package dao

import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile
import play.api._
import scala.concurrent.Future
import slick.driver.PostgresDriver.api._
import scala.concurrent.ExecutionContext.Implicits.global
import models.data.{EventType, EventTypeTable, EventTypeTableQuery}
import models.data.EventType



object EventTypeDAO{
  
  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  def all: Future[Seq[EventType]] = {
    dbConfig.db.run(EventTypeTableQuery.result)
  }
  
  def add(eventType: Seq[EventType]): Future[String] = {
    dbConfig.db.run(EventTypeTableQuery ++= eventType).map(result => "Success").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }
  
  def update(id: Long, eventType: EventType): Future[Unit] = {
    dbConfig.db.run(EventTypeTableQuery.filter(_.id === id).update(eventType)).map(_ => ())
  }
  
  def delete(id: Long): Future[String] = {
    dbConfig.db.run(EventTypeTableQuery.filter(_.id === id).delete).map(result => "Success").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }
  
  def findById(id: Long): Future[Option[EventType]] = { 
    dbConfig.db.run(EventTypeTableQuery.filter(_.id === id).result.headOption)
  }
  
}