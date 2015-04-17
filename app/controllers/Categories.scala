package controllers

/**
 * Created by Doston on 14.04.2015.
 */

import models._
import play.api.Logger
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick._
import play.api.mvc._

import scala.slick.lifted.TableQuery

class Categories extends Controller{

  val categories = TableQuery[CategoryTable]

  def list = DBAction { implicit rs =>
    Ok(views.html.listCategories(categories.list))
  }

  def showAddForm = DBAction { implicit rs =>
    Ok(views.html.addCategory())
  }

  def add = DBAction { implicit request =>
    val formParams = request.body.asFormUrlEncoded
    val name = formParams.get("name")(0)
    val categoryId = (categories returning categories.map(_.id)) += Category(None, name)
    Logger.info(s"LastId = $categoryId")
    Redirect(routes.Tabs.list())
  }


  def remove(id: Int) = DBAction { implicit request =>
    categories.filter(_.id === id).delete;
    Redirect(routes.Categories.list())
  }

  def update(id: Int) = DBAction { implicit rs =>
    val formParams = rs.body.asFormUrlEncoded
    val name = formParams.get("name")(0)

    val category = Category(Some(id), name)
    categories.filter(_.id === id).update(category)

    Redirect(routes.Categories.list())
  }

  def showEditForm(categoryId: Int) = DBAction { implicit request =>
    val byId = categories.findBy(_.id)
    val category = byId(categoryId).list.head

    Ok(views.html.editCategory(category))
  }


}
