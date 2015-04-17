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


case class Tab(id: Option[Int],
                name: String,
                address: String,
                categoryId: Int)


case class TabForDisplay(tab: Tab,
                          categoryName:String)

case class Category(id: Option[Int],
                     name: String
                     )

class UserTable(tag: Tag) extends  Table[user](tag, "Users"){

  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)

  def First_name = column[String]("FIRST_NAME", O.Default(""))

  def Last_name = column[String]("LAST_NAME", O.Default(""))

  def Mail_address = column[String]("MAIL_ADDRESS", O.Default(""))

  def Password = column[String]("PASSWORD", O.Default(""))

  def * = (id.?, First_name, Last_name, Mail_address, Password) <> (user.tupled, user.unapply _)

}

class TabTable(tag: Tag) extends Table[Tab](tag, "Tabs"){

  val categories = TableQuery[CategoryTable]

  def id=column[Int]("ID",O.PrimaryKey, O.AutoInc)

  def name = column[String]("NAME", O.Default(""))

  def address = column[String]("ADDRESS", O.Default(""))

  def categoryId = column[Int]("CATEGORY_ID", O.NotNull)

  def * = (id.?, name, address, categoryId) <> (Tab.tupled, Tab.unapply _)

  def category = foreignKey("CITY_FK_CATEGORY_ID", categoryId, categories)(_.id)

}

class CategoryTable(tag: Tag) extends Table[Category](tag, "CATEGORIES"){

  def id = column[Int]("ID",O.PrimaryKey, O.AutoInc)

  def name = column[String]("NAME", O.Default(""))

  def * = (id.?,name) <> (Category.tupled, Category.unapply _)

}

object for_number_user{

  var cnt=0
  def inc_num = {
    cnt+=1
    cnt
  }

  def inc_null = {
    cnt=0
  }

}