package service

import scala.concurrent.Future
import models.data.Person


trait TestService{
  def getAllUser(): Future[Seq[Person]]
}