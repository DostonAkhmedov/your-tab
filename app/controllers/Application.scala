package controllers

import models.user

import play.api.mvc.Controller
import play.api.mvc._
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick._
import models._

import scala.slick.lifted.TableQuery


object Application extends Controller {

  val user_table = TableQuery[UserTable]

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }


}