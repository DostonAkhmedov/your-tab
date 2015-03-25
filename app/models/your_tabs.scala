package models

/**
 * Created by Bunyod on 3/14/2015.
 */

import play.api.db.slick.Config.driver.simple._

case class tabs(id: Option[Int],
                name: String,
                address: String,
                img_name: String)

case class users(id: Option[Int],
                 First_name: String,
                 Last_name: String,
                 Mail_address: String,
                 Password: String)

//object tabs {
//
//  var table = List(
//    tabs(1, "facebook", "facebook.com", "facebook.png"),
//    tabs(2, "gmail", "gmail.com", "gmail.png"),
//    tabs(3, "mail", "mail.ru", "mail.png"),
//    tabs(4, "odnoklassniki", "odnoklassniki.ru", "odno.png"),
//    tabs(5, "twitter", "twitter.com", "twitter.png"),
//    tabs(6, "telegram", "telegram.com", "telegram.png"),
//    tabs(7, "viber", "viber.com", "viber.png"),
//    tabs(8, "instagram", "instagram.com", "instagram.png"),
//    tabs(9, "whatsapp", "whatsapp.com", "whatsapp.png")
//  )

class TabTable(tag: Tag) extends Table[tabs](tag, "Tabs"){

  def id=column[Int]("ID",O.PrimaryKey, O.AutoInc)

  def name = column[String]("NAME", O.Default(""))

  def address = column[String]("ADDRESS", O.Default(""))

  def img_name = column[String]("IMG_NAME", O.Default(""))

  def * = (id.?, name, address, img_name) <> (tabs.tupled, tabs.unapply _)

}
//
//class UserTable(tag: Tag) extends  Table[users](tag, "Users"){
//
//  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
//
//  def First_name = column[String]("FIRST_NAME", O.Default(""))
//
//  def Last_name = column[String]("LAST_NAME", O.Default(""))
//
//  def Mail_address = column[String]("MAIL-ADDRESS", O.Default(""))
//
//  def Password = column[String]("PASSWORD", O.Default(""))
//
//}
