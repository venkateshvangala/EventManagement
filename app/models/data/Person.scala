package models.data

import slick.driver.PostgresDriver.api._
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile
import play.api.Play
import scala.concurrent.Future
import play.api.libs.json.Json


case class Person(id: Long, name: String)

object Person {
  implicit val recordWrites = Json.writes[Person]
}

class Persons(tag: Tag) extends Table[Person](tag, "person") {
  def id = column[Long]("id", O.PrimaryKey)
  def name = column[String]("name") 
  def * = (id, name) <> ((Person.apply _).tupled, Person.unapply)
}



//object Personss {
//
//  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)
//  val users = TableQuery[Person]
//
//  def add(user: Person): Future[String] = {
//    dbConfig.db.run(users += user).map(res => "User successfully added").recover {
//      case ex: Exception => ex.getCause.getMessage
//    }
//  }
//
//  def delete(id: Long): Future[Int] = {
//    dbConfig.db.run(users.filter(_.id === id).delete)
//  }
//
//  def get(id: Long): Future[Option[Person]] = {
//    dbConfig.db.run(users.filter(_.id === id).result.headOption)
//  }
//
//  def listAll: Future[Seq[Person]] = {
//    dbConfig.db.run(users.result)
//  }
//}

