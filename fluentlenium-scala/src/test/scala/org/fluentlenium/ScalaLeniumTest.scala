package org.fluentlenium.scala

import org.scalatest._
import org.scalatest.matchers._
import org.openqa.selenium.firefox.FirefoxDriver

import scripts._

class ScalaLeniumTest extends FunSuite with ShouldMatchers { 
  
  /*
   *
   *
    goTo("http://www.bing.com");
    fill("#sb_form_q").with("FluentLenium");
    submit("#sb_form_go");
    assertThat(title()).contains("FluentLenium");

   */ 

  test("can navigate to Bing") { 
    implicit val firefox = new Browser(new FirefoxDriver)

    val script = browse {
      goTo("http://www.bing.com")
      submit("#sb_form_go")
      title
    }

    script.run should be("Bing")
  }

}
