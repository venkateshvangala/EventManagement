package models.data

import slick.driver.PostgresDriver.api._
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile
import play.api.Play
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


case class Person(id: Long, name: String)

class PersonsTable(tag: Tag) extends Table[Person](tag, "person") {
  def id = column[Long]("id", O.PrimaryKey)
  def name = column[String]("name") 
  override def * = (id, name) <>(Person.tupled, Person.unapply)
}



object Persons {

  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  val users = TableQuery[PersonsTable]

  def add(user: Person): Future[String] = {
    dbConfig.db.run(users += user).map(res => "User successfully added").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  def delete(id: Long): Future[Int] = {
    dbConfig.db.run(users.filter(_.id === id).delete)
  }

  def get(id: Long): Future[Option[Person]] = {
    dbConfig.db.run(users.filter(_.id === id).result.headOption)
  }

  def listAll: Future[Seq[Person]] = {
    dbConfig.db.run(users.result)
  }

}