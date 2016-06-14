package controllers

import javax.inject._
import play.api.mvc._
import play.api.Logger
import service.EventTypeService
import models.data.{EventTypeJsonFormatter, EventType }
import scala.concurrent.ExecutionContext.Implicits.global
import play.api.libs.json._
import dto.EventTypeDTO
import utils.Helpers
import models.data.EventType
import java.sql.Timestamp
import dto.EventTypeMapDTO


@Singleton
class EventTypeController @Inject() extends Controller {
  
def getAllEventType = Action.async { request =>
     EventTypeService.getAllEventTypes.map { events =>  
         Ok(Json.toJson(events.map(EventTypeDTO.toDTO(_))))
    }
  }
  
  def addEventType = Action.async { request =>
    var requestBody = request.body.asMultipartFormData 
    var jsonRequestData = requestBody.get.dataParts
    var eventName = jsonRequestData.apply("name").mkString
    var eventDescription = jsonRequestData.apply("description").mkString
    val resourceFile = requestBody.get.file("event_logo")
    val source = scala.io.Source.fromFile( resourceFile.get.ref.file,  "ISO-8859-1")
    val eventImageBytes= source.map(_.toByte).toArray
    source.close()
    var newEvent = Seq(EventType(0, eventName, eventDescription, "Venkatesh Kumar V", Helpers.getTimeStamp(new java.util.Date), "Venkatesh Kumar V", Helpers.getTimeStamp(new java.util.Date), eventImageBytes))
    EventTypeService.addEventType(newEvent).map { addedEvent => 
      Ok(addedEvent)
    }
  }

  def updateEventType = Action.async { request =>
    var requestBody = request.body.asMultipartFormData 
    var jsonRequestData = requestBody.get.dataParts
    
    var eventId = jsonRequestData.apply("id").mkString.toLong
    var eventName = jsonRequestData.apply("name").mkString
    var eventDescription = jsonRequestData.apply("description").mkString
    
    val resourceFile = requestBody.get.file("event_logo")
    val source = scala.io.Source.fromFile( resourceFile.get.ref.file,  "ISO-8859-1")
    val eventImageBytes= source.map(_.toByte).toArray
    source.close()
    var eventTypeToUpdate = EventType(eventId, eventName, eventDescription, "Venkatesh Kumar V", Helpers.getTimeStamp(new java.util.Date), "Venkatesh", Helpers.getTimeStamp(new java.util.Date), eventImageBytes)
    EventTypeService.updateEventType(eventTypeToUpdate);
    
    EventTypeService.getAllEventTypes.map { events =>  
         Ok(Json.toJson(events.map(EventTypeDTO.toDTO(_))))
    }
  }
  
  def deleteEventType(id: String) = Action { request =>
    Ok(EventTypeService.deleteEventType(id.toLong))
  }
  
}