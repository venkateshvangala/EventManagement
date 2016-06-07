package models.data

import java.sql.Timestamp
import slick.driver.PostgresDriver.api._
import play.api.libs.json.Json
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import play.api.libs.json.JsString

case class EventType(
  id: Long, 
  name: String, 
  description: String, 
  createdBy: String, 
  createdOn: Timestamp, 
  updatedBy: String, 
  updateOn: Timestamp,
  eventImg: Array[Byte]
)

class EventTypeTable(tag: Tag) extends Table[EventType](tag, "em_event_type") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  def description = column[String]("description")
  def createdBy = column[String]("created_by")
  def createdOn = column[Timestamp]("created_on")
  def updatedBy = column[String]("updated_by")
  def updatedOn = column[Timestamp]("updated_on")
  def eventImg  = column[Array[Byte]]("event_img")
  
  def * = (id, name, description, createdBy, createdOn, updatedBy, updatedOn, eventImg) <> ((EventType.apply _).tupled, EventType.unapply)
}

object EventType {
  implicit val tsreads: Reads[Timestamp] = Reads.of[Long] map (new Timestamp(_))
  implicit val tswrites: Writes[Timestamp] = Writes { (ts: Timestamp) => JsString(ts.toString)}
  implicit val test = Json.format[EventType]
}



