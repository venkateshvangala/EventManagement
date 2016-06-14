package service

import dao.EventTypeDAO
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import play.api.libs.json.Json
import models.data._
import dto.EventTypeDTO
import dto.EventTypeMapDTO


object EventTypeService {
    def getAllEventTypes = {
     EventTypeDAO.all
    }
    
    def addEventType(event: Seq[EventType]) = {
      EventTypeDAO.add(event)
    }
    
    def updateEventType(eventType: EventType) = {
      val eventtypeToUpdate: EventType = eventType.copy(eventType.id)
      EventTypeDAO.update(eventType.id, eventType)
    }
    
    def deleteEventType(id: Long) ={
      EventTypeDAO.delete(id).toString();
    }
    
}