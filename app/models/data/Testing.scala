package models.data

import java.awt.image.BufferedImage
import play.api.libs.json._
import play.api.libs.functional.syntax._


case class Testing(id: Long, eventImage: BufferedImage)

//object Testing{
//     val locationReads: Reads[Testing] = (
//      (JsPath \ "id").read[Long] and
//      (JsPath \ "eventImage").read[BufferedImage]
//    )(Testing.apply _)
//    
//    val locationWrites: Writes[Testing] = (
//      (JsPath \ "id").write[Long] and
//      (JsPath \ "eventImage").write[BufferedImage]
//    )(unlift(Testing.unapply))
//    
//    implicit val locationFormat: Format[Testing] =
//      Format(locationReads, locationWrites)
//}

 