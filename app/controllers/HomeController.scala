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
 
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page. 
 */
@Singleton
class HomeController @Inject() extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  
//  def getAllEventType = Action.async { request =>
//     EventTypeService.getAllEventTypes.map { events =>  
//         Ok(Json.toJson(events.map(EventTypeDTO.toDTO(_))))
//    }
//  }
//  
//  def addEventType = Action.async { request =>
//    var requestBody = request.body.asMultipartFormData 
//    var jsonRequestData = requestBody.get.dataParts
//    var eventName = jsonRequestData.apply("name").mkString
//    var eventDescription = jsonRequestData.apply("description").mkString
//    val resourceFile = requestBody.get.file("event_logo")
//    val source = scala.io.Source.fromFile( resourceFile.get.ref.file,  "ISO-8859-1")
//    val eventImageBytes= source.map(_.toByte).toArray
//    source.close()
//    var newEvent = Seq(EventType(0, eventName, eventDescription, "Venkatesh Kumar V", Helpers.getTimeStamp(new java.util.Date), "Venkatesh Kumar V", Helpers.getTimeStamp(new java.util.Date), eventImageBytes))
//    EventTypeService.addEventType(newEvent).map { addedEvent => 
//      Ok(addedEvent)
//    }
//  }
//
//  def updateEventType = Action.async { request =>
//    var requestBody = request.body.asMultipartFormData 
//    var jsonRequestData = requestBody.get.dataParts
//    
//    var eventId = jsonRequestData.apply("id").mkString.toLong
//    var eventName = jsonRequestData.apply("name").mkString
//    var eventDescription = jsonRequestData.apply("description").mkString
//    
//    val resourceFile = requestBody.get.file("event_logo")
//    val source = scala.io.Source.fromFile( resourceFile.get.ref.file,  "ISO-8859-1")
//    val eventImageBytes= source.map(_.toByte).toArray
//    source.close()
//    var eventTypeToUpdate = EventType(eventId, eventName, eventDescription, "Venkatesh Kumar V", Helpers.getTimeStamp(new java.util.Date), "Venkatesh", Helpers.getTimeStamp(new java.util.Date), eventImageBytes)
//    EventTypeService.updateEventType(eventTypeToUpdate);
//    
//    EventTypeService.getAllEventTypes.map { events =>  
//         Ok(Json.toJson(events.map(EventTypeDTO.toDTO(_))))
//    }
//  }
//  
//  def deleteEventType(id: String) = Action { request =>
//    Ok(EventTypeService.deleteEventType(id.toLong))
//  }
//  

//  def getJsonResponse = Action.async  { request =>
//    val books = TestServiceImpl.getAllUser();
//     books.map { person => 
//           val booksDTO = person.map(PersonDTO.fromBook(_))
//          Ok(Json.toJson(booksDTO))
//     }
//  }
//  
//  def getEventTypes = Action.async { request =>
//    val eventTypes = EventTypeDAOImpl.all
//    eventTypes.map { events =>  
//        Ok(Json.toJson(events))         
//    }
//  }
//  
//  def addEventType = Action { request =>
//
//    val eventTypes = EventTypeDAOImpl.all
//    
//    implicit def date2timestamp(date: java.util.Date) = 
//    new java.sql.Timestamp(date.getTime)
//
//val date = new java.util.Date
//
////conversion happens implicitly
//val timestamp: java.sql.Timestamp = date
//
// val test = Array[Byte](192.toByte, 168.toByte, 1, 9)
//
//
//    var newEvent = Seq(EventType(0, "Product Launch test", "Product Release", "Venkatesh Kumar", date, "Venkatesh Kumar V", date, test))
//    var addedEvent = EventTypeDAOImpl.add(newEvent)
//    
//    
//         Ok(Json.toJson(newEvent))         
//     
//  }
//  
//   def uploadToDB = Action { request =>
//        val body = request.body.asMultipartFormData
//        
//        var name = body.get.dataParts.apply("name").mkString
//        var id = body.get.dataParts.apply("id").mkString
//        
//        Logger.info("id..." + id + "  name____" + name)
//        
//        val resourceFile = body.get.file("upload-file")
//         val source = scala.io.Source.fromFile( resourceFile.get.ref.file,  "ISO-8859-1")
//         val byteArray = source.map(_.toByte).toArray
//         source.close()
//        
//    val event = Seq(EventTypeLogo(1L, byteArray))
//    EventTypeLogoDAO.add(event);
//        
//                     val b64 = new sun.misc.BASE64Encoder().encode(byteArray)
//    var image = "data:image/png;base64," + b64;
//            
//         Ok(image)
//   }
   
  
}

  