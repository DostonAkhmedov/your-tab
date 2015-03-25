package controllers

/**
 * Created by Bunyod on 3/11/2015.
 */

import play.api.mvc._
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick._
import models._
import play.api.Logger

import  scala.slick.lifted.TableQuery

class admins extends Controller{

  val table = TableQuery[TabTable]

  def your_tabs = DBAction { implicit rs =>
    Logger.info(s"SHOW_ALL = ${table.list}")
    Ok(views.html.your_tabs(table.list))
  }

  def admin = Action {
    Ok(views.html.admin())
  }

//  class users extends Controller{
//
//    val user_table = TableQuery[UserTable]
//
//    def all_users = DBAction { implicit rs =>
//    Logger.info(s"SHOW_ALL = ${user_table.list}")
//      Ok()
//    }
//  }

}
