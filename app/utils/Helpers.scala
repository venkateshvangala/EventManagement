package utils

import java.util._

object Helpers {
  def getTimeStamp(currentDate: Date): java.sql.Timestamp = {
    implicit def date2timestamp(date: java.util.Date) =  new java.sql.Timestamp(currentDate.getTime)
    return currentDate
  }
}