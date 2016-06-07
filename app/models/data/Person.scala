package models.data

import slick.driver.PostgresDriver.api._
import play.api.libs.json._


case class Person(id: Long, name: String)


class Persons(tag: Tag) extends Table[Person](tag, "person") {
  def id = column[Long]("id", O.PrimaryKey)
  def name = column[String]("name") 
  def * = (id, name) <> ((Person.apply _).tupled, Person.unapply)
}


object Formatters {
  implicit val personFormat = Json.format[Person]
}