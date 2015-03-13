package controllers

/**
 * Created by Bunyod on 3/11/2015.
 */

import play.api.mvc._
import models.tabs

object admin extends Controller{

  def admin = Action {
    Ok(views.html.admin())
  }

  def your_tabs = Action {
    Ok(views.html.your_tabs(tabs.table))
  }

}
