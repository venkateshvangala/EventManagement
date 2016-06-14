package dto

import scala.beans.BeanProperty
import models.data._
import play.api.libs.json._
import java.sql.Timestamp

case class EventTypeDTO (
    @BeanProperty id: Long,
    @BeanProperty name: String, 
    @BeanProperty description: String, 
    @BeanProperty createdBy: String, 
    @BeanProperty updatedBy: String, 
    @BeanProperty  createdOn: Timestamp, 
    @BeanProperty updatedOn: Timestamp)

object EventTypeDTO{

  def toDTO(event: EventType) = {
     EventTypeDTO(event.id, event.name, event.description, event.createdBy, event.updatedBy, event.createdOn, event.updateOn) 
  }

  implicit val tsreads: Reads[Timestamp] = Reads.of[Long] map (new Timestamp(_))
  implicit val tswrites: Writes[Timestamp] = Writes { (ts: Timestamp) => JsString(ts.toString)}
  implicit val test = Json.format[EventType]
  implicit val DTOFormat = Json.format[EventTypeDTO]

}
 