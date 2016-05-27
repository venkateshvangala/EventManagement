package dao

import scala.concurrent.Future

import scala.concurrent.ExecutionContext.Implicits.global
import scala.collection.Seq
import models.data.Person

trait PersonDao {
    def all(): Future[Seq[Person]]
    def add(person: Seq[Person]): Future[String]
}