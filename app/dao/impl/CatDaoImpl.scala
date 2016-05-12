package dao.impl

import slick.lifted.TableQuery
import models.data.Persons
import scala.concurrent.Future
import slick.driver.PostgresDriver.api._
import scala.concurrent.ExecutionContext.Implicits.global
import models.data.Person
import models.data.Persons
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile
import play.api.Play
   


object CatDaoImpl  {
  
//  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)
//  
//  def findbyId(id: Long): Future[Option[Person]] = {
//    dbConfig.db.run(this.filter(_.id === id).result.headOption)
//  }
//  
//  def listAll: Future[Seq[Person]] = {
//    dbConfig.db.run(this.result)
//  }

}