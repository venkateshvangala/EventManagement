package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import models.data.Persons
import models.data.Person
import scala.concurrent.ExecutionContext.Implicits.global
import com.google.gson.Gson
import play.api.libs.json._
import models.data.Person
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.functional.syntax._
import service.impl.TestServiceImpl



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

//  def getJsonResponse = Action.async  { request =>
//    val userList = Persons.listAll;
//    implicit val residentFormat = Json.format[Person]
//    userList.map { person =>
//      var json = Json.toJson(person)
//      Ok(json);
//    }
//  }
  
  def getJsonResponse = Action.async  { request =>
    TestServiceImpl.getAllUser().map { person => Ok(Json.toJson(person)) } 
  }
  
}
