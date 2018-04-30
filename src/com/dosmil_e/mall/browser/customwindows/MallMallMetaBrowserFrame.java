package com.dosmil_e.mall.browser.customwindows;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;
import javax.swing.tree.*;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Properties;

import com.dosmil_e.modelbase.support.*;
import com.dosmil_e.modelbase.impl.*;
import com.dosmil_e.modelbase.trx.*;
import com.dosmil_e.modelbase.ifc.*;
import com.dosmil_e.modelbase.flattrx.*;

import com.dosmil_e.mall.core.ifc.MallMallIfc;
import com.dosmil_e.mall.core.impl.MallMallImpl;

import com.dosmil_e.browserbase.shell.EAIBrowserFrame;
import com.dosmil_e.browserbase.shell.EAIPilotFrame;

import com.dosmil_e.browserbase.metaconfigs.EAIMetaTreeConfigFactory;

import com.dosmil_e.browserbase.configs.EAIConfigIfc;
import com.dosmil_e.browserbase.tree.EAIRootNode;

import com.dosmil_e.modelbase.support.EAIException;


public class MallMallMetaBrowserFrame extends EAIBrowserFrame {


  //Construct the frame
  public MallMallMetaBrowserFrame(
    EAIMMCtxtIfc    theCtxt,
    EAIPilotFrame   thePilotFrame,
    MallMallIfc     theMall) {

    super( theCtxt, thePilotFrame, theMall, EAIMetaTreeConfigFactory.getConfig( theCtxt, theMall));
  }




}
