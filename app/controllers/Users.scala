package controllers

import play.api.mvc._
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick._
import models._
import play.api.Logger

import scala.slick.lifted.TableQuery

class Users extends Controller{

  val user_table = TableQuery[UserTable]

  def all_users = DBAction { implicit rs =>
    Logger.info(s"SHOW_ALL = ${user_table.list}")
    Ok(views.html.users(user_table.list))
  }

  def showAddForm = Action {
    Ok(views.html.add())
  }
  def add = DBAction { implicit request =>
    val formParams = request.body.asFormUrlEncoded
    val First_name = formParams.get("First_name")(0)
    val Last_name = formParams.get("Last_name")(0)
    val Mail_address = formParams.get("Mail_address")(0)
    val Password = formParams.get("Password")(0)

    val userId = (user_table returning user_table.map(_.id)) += user(None, First_name, Last_name, Mail_address, Password)
    Redirect(routes.Users.all_users())
  }

  def remove(id: Int) = DBAction { implicit request =>
    user_table.filter(_.id === id).delete;
    Redirect(routes.Users.all_users())
  }
}
