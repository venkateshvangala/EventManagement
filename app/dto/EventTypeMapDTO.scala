package dto

 
import scala.beans.BeanProperty
import models.data._
import play.api.libs.json._
import java.sql.Timestamp

case class EventTypeMapDTO (
    @BeanProperty id: Long,
    @BeanProperty name: String 
)
object EventTypeMapDTO{

  def toDTO(event: EventType) = {
     EventTypeMapDTO(event.id, event.name) 
  }

  implicit val tsreads: Reads[Timestamp] = Reads.of[Long] map (new Timestamp(_))
  implicit val tswrites: Writes[Timestamp] = Writes { (ts: Timestamp) => JsString(ts.toString)}
  implicit val test = Json.format[EventType]
  implicit val DTOFormat = Json.format[EventTypeMapDTO]

}
 