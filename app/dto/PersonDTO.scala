package dto

import models.data._
import play.api.libs.json.Json
import scala.beans.BeanProperty

case class PersonDTO (@BeanProperty name: String)

object PersonDTO {

  def fromBook(b: Person) = {
     PersonDTO(b.name) 
  }

  implicit val DTOFormat = Json.format[PersonDTO]

}