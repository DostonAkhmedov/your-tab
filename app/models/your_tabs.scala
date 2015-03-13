package models

/**
 * Created by Bunyod on 3/14/2015.
 */

case class tabs(id : Int, name : String, address : String, img_name : String)

object tabs {

  var table=List(
  tabs(1,"facebook","facebook.com","facebook.png"),
  tabs(2,"gmail","gmail.com","gmail.png"),
  tabs(3,"mail","mail.ru","mail.png"),
  tabs(4,"odnoklassniki","odnoklassniki.ru","odno.png"),
  tabs(5,"twitter","twitter.com","twitter.png"),
  tabs(6,"telegram","telegram.com","telegram.png"),
  tabs(7,"viber","viber.com","viber.png"),
  tabs(8,"instagram","instagram.com","instagram.png"),
  tabs(9,"whatsapp","whatsapp.com","whatsapp.png")
  )

}
