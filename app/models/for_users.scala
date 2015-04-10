package models


/**
 * Created by Doston on 28.03.2015.
 */

import play.api.db.slick.Config.driver.simple._

case class user(id: Option[Int],
                 First_name: String,
                 Last_name: String,
                 Mail_address: String,
                 Password: String)


class UserTable(tag: Tag) extends  Table[user](tag, "Users"){

  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)

  def First_name = column[String]("FIRST_NAME", O.Default(""))

  def Last_name = column[String]("LAST_NAME", O.Default(""))

  def Mail_address = column[String]("MAIL_ADDRESS", O.Default(""))

  def Password = column[String]("PASSWORD", O.Default(""))

  def * = (id.?, First_name, Last_name, Mail_address, Password) <> (user.tupled, user.unapply _)

}
