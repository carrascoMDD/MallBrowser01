package com.dosmil_e.mall.browser.customapps;

import com.dosmil_e.browserbase.shell.EAIApplication;

import java.util.StringTokenizer;
import java.util.Properties;
import java.util.Enumeration;

import javax.swing.UIManager;
import java.awt.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class MallApplication extends EAIApplication {

  public static final String  sProPilotFrameClassName = "com.dosmil_e.mall.browser.customwindows.MallPilotFrame";


 //Construct the application
  public MallApplication( String[] theArgs) {
    super( theArgs);
  }


  protected void initVars() {
    super.initVars();
    vDefaultPilotFrameClassName = sProPilotFrameClassName;
  }


  //Main method
  public static void main(String[] theArgs) {
    try  {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
   }
    catch(Exception e) {
    }

    new MallApplication( theArgs);
  }





}


