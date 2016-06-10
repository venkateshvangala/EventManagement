package controllers

//import java.io.File
import scala.concurrent.ExecutionContext.Implicits.global
import dao.impl.EventTypeDAOImpl
import dto.PersonDTO
import dto.PersonDTO
import javax.inject._
import models.data.EventType
import models.data.Person
import models.data.Person
import play.api._
import play.api.libs.json._
import play.api.libs.json._
import play.api.mvc._
import play.api.mvc._
import service.impl.TestServiceImpl
import models.data.EventTypeLogo
import dao.impl.EventTypeLogoDAO
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.io.ByteArrayInputStream
import java.io.IOException
import models.data.Testing

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

  def getJsonResponse = Action.async  { request =>
    val books = TestServiceImpl.getAllUser();
     books.map { person => 
           val booksDTO = person.map(PersonDTO.fromBook(_))
          Ok(Json.toJson(booksDTO))
     }
  }
  
  def getEventTypes = Action.async { request =>
    val eventTypes = EventTypeDAOImpl.all
    eventTypes.map { events =>  
        Ok(Json.toJson(events))         
    }
  }
  
  def addEventType = Action.async { request =>

    val eventTypes = EventTypeDAOImpl.all
    eventTypes.map { events =>  
        Ok(Json.toJson(events))         
    }
    
  }
  
   def uploadToDB = Action { request =>
     
        val body = request.body.asMultipartFormData
        
        
        val resourceFile = body.get.file("upload-file")
         val source = scala.io.Source.fromFile( resourceFile.get.ref.file,  "ISO-8859-1")
         val byteArray = source.map(_.toByte).toArray
         source.close()
        
    val event = Seq(EventTypeLogo(1L, byteArray))
    EventTypeLogoDAO.add(event);
                     val b64 = new sun.misc.BASE64Encoder().encode(byteArray)
    var image = "data:image/png;base64," + b64;
            
         Ok(image)
   }
   
  
}

  