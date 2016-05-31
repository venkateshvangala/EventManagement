package dto

import models.data._
import play.api.libs.json.Json

case class PersonDTO (name: String)

object PersonDTO {

  def fromBook(b: Person) = PersonDTO(b.name)

  implicit val DTOFormat = Json.format[PersonDTO]

}