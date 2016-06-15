package controllers

import javax.inject.Inject
import javax.inject.Singleton
import play.api.mvc.Action
import play.api.mvc.Controller
 
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page. 
 */

@Singleton
class HomeController @Inject() extends Controller {
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
}

  