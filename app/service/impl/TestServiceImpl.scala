package service.impl

import service.TestService
import scala.concurrent.Future
import models.data.Person
import dao.PersonDao
import dao.impl.PersonDaoImpl

object TestServiceImpl extends TestService{
  
  def getAllUser: Future[Seq[Person]] = {
      PersonDaoImpl.all();  
  }
}