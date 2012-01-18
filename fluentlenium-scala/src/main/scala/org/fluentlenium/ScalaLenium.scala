package org.fluentlenium.scala

import org.fluentlenium.core._
import org.openqa.selenium.WebDriver

trait Script { 
  def run : String
}

object scripts { 

  def goTo(url : String)(implicit b : Browser) : Script = { 
    b add GoTo(url,b)
  }

  def submit(selector : String)(implicit b : Browser) : Script = { 
    b add Submit(selector,b)
  }

  def title(implicit b : Browser) : Script = { 
    b add Title(b)
  }

}


case class GoTo(url : String, browser : Browser) extends Script { 
  override def run = {  browser goTo url; ""}
  override def toString = "goTo " + url
}

case class Submit(selector : String, browser : Browser) extends Script { 
  override def run = { browser submit selector; "" }
  override def toString = "submit " + selector
}

case class Title(browser : Browser) extends Script { 
  override def run = browser.thetitle
  override def toString = "title"
}

class Browser(driver: WebDriver) extends Fluent with Script { 

  setDriver(driver)

  var scripts : List[Script] = Nil

  def add (script : Script) =  { 
    scripts = scripts :+ script
    this
  }

  def goTo(url : String)  = getDriver.get(url)

  def thetitle = title

  override def run = { 
    val ret = scripts.map(_.run).last; 
    driver.quit 
    ret
  }

  override def toString : String = scripts.toString
}

object browse { 

  def apply (script : => Script) = script

}
