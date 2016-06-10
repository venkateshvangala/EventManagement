package models.data


import play.api.libs.json._
import slick.driver.PostgresDriver.api._

/**
  * Created by venkateshv on 8/6/16.
  */
case class EventTypeLogo(id: Long, eventImage: Array[Byte])


class EventTypeLogoTable(tag: Tag) extends Table[EventTypeLogo](tag, "event_type_logo") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def eventImage  = column[Array[Byte]]("event_image")

  def * = (id, eventImage) <> ((EventTypeLogo.apply _).tupled, EventTypeLogo.unapply)
}

object EventTypeLogo {
  implicit val test = Json.format[EventTypeLogo]
}



