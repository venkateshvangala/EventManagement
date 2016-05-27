package dao.impl

import dao.PersonDao
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile
import play.api.Play
import models.data.Persons
import models.data.Person
import scala.concurrent.Future
import slick.driver.PostgresDriver.api._
import scala.concurrent.ExecutionContext.Implicits.global


object PersonDaoImpl extends PersonDao{
  
  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)
  val users = TableQuery[Persons]
  
  def all: Future[Seq[Person]] = {
    dbConfig.db.run(users.result)
  }
  
  def add(person: Seq[Person]): Future[String] = {
    dbConfig.db.run(users ++= person).map(result => "Success").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

}