package dao

import scala.concurrent.Future
import models.data.EventType

trait EventTypeDAO {
    def all(): Future[Seq[EventType]]
    def add(person: Seq[EventType]): Future[String]
}