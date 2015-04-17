package controllers

import play.api.mvc._
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick._
import models._
import play.api.Logger
import play.api.libs.json.Json._
import play.api.libs.json.Json

import scala.slick.lifted.TableQuery

class Tabs extends Controller {

  val tabs = TableQuery[TabTable]
  val categories = TableQuery[CategoryTable]

  def list = DBAction { implicit rs =>
    //    Logger.info(s"SHOW_ALL = ${cities.list}")
    val result = (for {
      (tab, category) <- tabs leftJoin categories on (_.categoryId === _.id)
    } yield (tab, category.name)).list
      .map { case (tab, categoryName) => TabForDisplay(tab, categoryName)}

    Ok(views.html.list(result,categories.list))
  }


  def showAddForm = DBAction { implicit rs =>
    Ok(views.html.addTab(categories.list))
  }

  def add = DBAction { implicit request =>
    val formParams = request.body.asFormUrlEncoded
    val name = formParams.get("name")(0)
    val address = formParams.get("address")(0)
    val categoryId = formParams.get("category")(0).toInt

    val tabId = (tabs returning tabs.map(_.id)) += Tab(None, name, address, categoryId)
    Logger.info(s"LastId = $tabId")
    Redirect(routes.Tabs.list())
  }


  def remove(id: Int) = DBAction { implicit request =>
    tabs.filter(_.id === id).delete;
    Redirect(routes.Tabs.list())
  }

  def update(id: Int) = DBAction { implicit rs =>
    val formParams = rs.body.asFormUrlEncoded
    val name = formParams.get("name")(0)
    val address = formParams.get("address")(0)
    val categoryId = formParams.get("category")(0).toInt

    val tab = Tab(Some(id), name, address, categoryId)
    tabs.filter(_.id === id).update(tab)

    Redirect(routes.Tabs.list())
  }

  def showEditForm(tabId: Int) = DBAction { implicit request =>
    val byId = tabs.findBy(_.id)
    val tab = byId(tabId).list.head

    Ok(views.html.edit(tab, categories.list))
  }

}