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

import com.dosmil_e.mall.browser.customconfigs.MallMallTreeConfigFactory;

import com.dosmil_e.browserbase.configs.EAIConfigIfc;
import com.dosmil_e.browserbase.tree.EAIRootNode;

import com.dosmil_e.modelbase.support.EAIException;


public class MallMallBrowserFrame extends EAIBrowserFrame {


  public static int     sBrowserFrameWidth     = 756;
  public static int     sBrowserFrameHeight    = 608;

  protected static String sNoMallRootName  = "?";


  protected JMenu           vMenuMall               = new JMenu();
  protected JMenuItem       vMenuItemMallSpawn     = new JMenuItem();
  protected JMenuItem       vMenuItemMallReplicate = new JMenuItem();
  protected JMenuItem       vMenuItemMallSave      = new JMenuItem();
  protected JMenuItem       vMenuItemMallSaveAs    = new JMenuItem();
  protected JMenuItem       vMenuItemMallClose     = new JMenuItem();
  protected JMenu           vMenuWindow               = new JMenu();
  protected JMenu           vMenuActions              = new JMenu();
  protected JMenuItem       vMenuItemActionsUndo     = new JMenuItem();
  protected JMenuItem       vMenuItemActionsRedo     = new JMenuItem();


  protected EAIPilotFrame     vPilotFrame;
  protected MallMallIfc   vMall;





  //Construct the frame
  public MallMallBrowserFrame(
    EAIMMCtxtIfc    theCtxt,
    EAIPilotFrame   thePilotFrame,
    EAIMMElementIfc theMall) {

    this( theCtxt, thePilotFrame, theMall, MallMallTreeConfigFactory.getConfig( theCtxt));

   }





  //Construct the frame
  public MallMallBrowserFrame(
    EAIMMCtxtIfc    theCtxt,
    EAIPilotFrame   thePilotFrame,
    EAIMMElementIfc theMall,
    EAIConfigIfc    theConfig) {

    super( theCtxt, theConfig);

    vCtxt             = theCtxt;
    vPilotFrame       = thePilotFrame;
    try { vMall   = (MallMallIfc) theMall;} catch( ClassCastException anException) {}


    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try  {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    initVars();
    doMenuEnablement();

    if( theMall != null) {
      setRoot( theMall);
    }
  }










  protected String getMenuRootText() {
    return "Mall";
  }

  protected void initVars() {
  }

  protected int getFrameWidth() {
    return sBrowserFrameWidth;
  }

  protected int getFrameHeight() {
    return sBrowserFrameHeight;
  }

  //Component initialization
  private void jbInit() throws Exception  {

    this.getContentPane().setLayout(vBorderLayout1);
    this.setSize( new Dimension( sBrowserFrameWidth, sBrowserFrameHeight));

    vStatusBar.setText(" ");

    this.populateMenuBar2();
    this.setJMenuBar(vMenuBar1);
    this.getContentPane().add(vStatusBar, BorderLayout.SOUTH);
    this.getContentPane().add(vBrowserPanel, BorderLayout.CENTER);

    vBrowserPanel.setSuperBrowser( this);
  }


  //Help | About action performed
  public void menuItemHelpAbout_actionPerformed(ActionEvent e) {
    MallStudioAboutBox dlg = new MallStudioAboutBox(this);
    Dimension dlgSize = dlg.getPreferredSize();
    Dimension frmSize = getSize();
    Point loc = getLocation();
    dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
    dlg.setModal(true);
    dlg.show();
  }


  public void menuItemActionsUndo_actionPerformed(ActionEvent e) {
    undo();
  }


  public void undo() {
    if( vCtxt == null) { return;}
    EAIFlatTransactionMgrIfc aTrxMgr = vCtxt.getFlatTrxMgr();

    if( aTrxMgr == null) { return;}
    try { aTrxMgr.undoTransaction();} catch( EAIException anEx) {}
  }


  public void menuItemActionsRedo_actionPerformed(ActionEvent e) {
    redo();
  }


  public void redo() {
    if( vCtxt == null) { return;}
    EAIFlatTransactionMgrIfc aTrxMgr = vCtxt.getFlatTrxMgr();

    if( aTrxMgr == null) { return;}
    try { aTrxMgr.redoTransaction();} catch( EAIException anEx) {}
  }



  public void menuItemActionsCommit_actionPerformed(ActionEvent e) {

  }

  public void menuItemActionsRollback_actionPerformed(ActionEvent e) {

  }

  protected void populateMenuBar() {
  }

  protected void populateMenuBar2() {

    vMenuActions.setText("Control");
    vMenuActions.setToolTipText("Actions to control overall Mall edition");

    vMenuItemActionsUndo.setText("Undo");
    vMenuItemActionsUndo.setToolTipText("Undo effects of last action");
    vMenuItemActionsUndo.setEnabled(true);
    vMenuItemActionsUndo.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        menuItemActionsUndo_actionPerformed(e);
      }
    });
    vMenuActions.add(vMenuItemActionsUndo);

    vMenuItemActionsRedo.setText("Redo");
    vMenuItemActionsRedo.setToolTipText("Redo effects of last undone action");
    vMenuItemActionsRedo.setEnabled(true);
    vMenuItemActionsRedo.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        menuItemActionsRedo_actionPerformed(e);
      }
    });
    vMenuActions.add(vMenuItemActionsRedo);

    vMenuMall.setText("Mall");
    vMenuMall.setToolTipText("Mall operations");


    vMenuItemMallSpawn.setToolTipText("Spawn new window on current Mall");
    vMenuItemMallSpawn.setEnabled( true);
    vMenuItemMallSpawn.setText("Spawn");
    vMenuItemMallSpawn.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        menuItemMallSpawn_actionPerformed(e);
      }
    });
    vMenuMall.add(vMenuItemMallSpawn);

    vMenuItemMallReplicate.setToolTipText("Replicate new copy of current Mall");
    vMenuItemMallReplicate.setEnabled( true);
    vMenuItemMallReplicate.setText("Replicate");
    vMenuItemMallReplicate.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        menuItemMallReplicate_actionPerformed(e);
      }
    });
    vMenuMall.add(vMenuItemMallReplicate);

    vMenuMall.addSeparator();

    vMenuItemMallSave.setToolTipText("Save current Mall in file named as the Mall.");
    vMenuItemMallSave.setEnabled(false);
    vMenuItemMallSave.setText("Save");
    vMenuItemMallSave.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        menuItemMallSave_actionPerformed(e);
      }
    });
    vMenuMall.add(vMenuItemMallSave);
    vMenuItemMallSaveAs.setToolTipText("Save current Mall in a new File");
    vMenuItemMallSaveAs.setEnabled(true);
    vMenuItemMallSaveAs.setText("Save as ...");
    vMenuItemMallSaveAs.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        menuItemMallSaveAs_actionPerformed(e);
      }
    });
    vMenuMall.add(vMenuItemMallSaveAs);

    vMenuMall.addSeparator();

    vMenuItemMallClose.setText("Close");
    vMenuItemMallClose.addActionListener(new ActionListener()  {

      public void actionPerformed(ActionEvent e) {
        menuItemMallClose_actionPerformed(e);
      }
    });
    vMenuMall.add(vMenuItemMallClose);

    vMenuHelp.setText("Help");
    vMenuItemHelpAbout.setText("About");
    vMenuItemHelpAbout.addActionListener(new ActionListener()  {

      public void actionPerformed(ActionEvent e) {
        menuItemHelpAbout_actionPerformed(e);
      }
    });
    vMenuHelp.add(vMenuItemHelpAbout);

    vMenuHelp.setText("Help");
    vMenuItemHelpAbout.setText("About");
    vMenuItemHelpAbout.addActionListener(new ActionListener()  {

      public void actionPerformed(ActionEvent e) {
        menuItemHelpAbout_actionPerformed(e);
      }
    });
    vMenuWindow.setToolTipText("Manage Windows in the Mall");
    vMenuWindow.setText("Windows");

    JMenuItem aMenuItem = new JMenuItem();
    aMenuItem.setText( "Pilot");
    aMenuItem.setEnabled(true);
    aMenuItem.addActionListener(new ActionListener()  {
      public void actionPerformed(ActionEvent e) {
        if( vPilotFrame != null) {
          vPilotFrame.show();
        }
      }
    });
    vMenuWindow.add( aMenuItem);


    vMenuHelp.add(vMenuItemHelpAbout);

    vMenuSelection.setToolTipText("Operations on current selection");
    vMenuSelection.setText("Selection");


    vMenuBar1.add( vMenuMall);
    vMenuBar1.add(vMenuActions);
    vMenuBar1.add(vMenuSelection);
    vMenuBar1.add(vMenuWindow);
    vMenuBar1.add(vMenuHelp);
  }



  //Overridden so we can exit on System Close
  protected void processWindowEvent(WindowEvent e) {
    if(e.getID() == WindowEvent.WINDOW_CLOSING) {
      menuItemMallClose_actionPerformed(null);
    }
    else {
      super.processWindowEvent(e);
    }

  }








  



  public static String breakInLines( String theMsg, int theMaxLength) {
    java.util.StringTokenizer aTokenizer = new java.util.StringTokenizer( theMsg);

    String aNewMsg = new String();
    int aLineLength = 0;
    while( aTokenizer.hasMoreTokens()) {
      String aToken = aTokenizer.nextToken();
      if( aToken != null) {
        int aTokenLength = aToken.length();
        if( aLineLength + aTokenLength > theMaxLength) {

          if( aTokenLength > theMaxLength) {
            aToken = contractString( aToken, theMaxLength);
            aTokenLength = theMaxLength;
          }
          aNewMsg = aNewMsg + "\n" + aToken;
          aLineLength = aTokenLength;
        }
        else {
          aNewMsg = aNewMsg + " " + aToken;
          aLineLength = aLineLength + aTokenLength;
        }
      }
    }
    return aNewMsg;
  }


  public static String contractString( String theMsg, int theMaxLength) {
    if( theMsg == null) { return null;}
    if( theMaxLength < 1) { return new String();}

    int aLength = theMsg.length();
    if( aLength <= theMaxLength) { return theMsg;}


    int aHalfLength = (theMaxLength / 2) - 2;
    String aContracted = theMsg.substring( 0, aHalfLength - 1) +
      gContractedStringEllipsis +
      theMsg.substring( aLength - aHalfLength -1 , aLength );
    return aContracted;
  }


  void menuItemMallSave_actionPerformed(ActionEvent e) {
    save();
  }

  void menuItemMallSpawn_actionPerformed(ActionEvent e) {
    spawn();
  }

  public boolean spawn() {

    if( vMall == null) { return false;}

    showActionStatus("Spawn Mall : will open a new Browser on current Mall");

    EAIMMCtxtIfc aCtxt = getCtxt();
    if( aCtxt == null) { return false;}

    getPilotFrame().openRootBrowserFrameClassNamed( aCtxt, vMall, this.getClass().getName(), getConfig());
    return true;
  }




  void menuItemMallReplicate_actionPerformed(ActionEvent e) {
    replicate();
  }





  public boolean replicate() {

    if( vMall == null) { return false;}

    showActionStatus("Replicate Mall : will open a new Browser on replicated copy of current Mall");

    EAIMMCtxtIfc aCtxt = getCtxt();
    if( aCtxt == null) { return false;}

    try {
    com.dosmil_e.m3.core.ifc.M3ModelIfc aProM3Model = com.dosmil_e.mall.meta.Mall01.getM3Model( aCtxt);
    com.dosmil_e.m3.traversal.ifc.M3TraversalConfigIfc aProTravCfg =
      aProM3Model.findTraversalConfigsNamed( aCtxt, new EAIMMName(com.dosmil_e.mall.meta.MallReplicationConfig.gTraversalConfigName));

    com.dosmil_e.browserbase.configs.EAIConfigIfc aConfigForM3 = getConfig();

    com.dosmil_e.m3.visit.M3TraversalCtxtIfc aTravCtxt = new com.dosmil_e.m3.visit.M3TraversalCtxt();
    com.dosmil_e.m3.visit.M3TraversalVisitor aVisitor = new com.dosmil_e.m3.visit.M3TraversalVisitor( aCtxt);

    aVisitor.visit( aCtxt, aTravCtxt, aProTravCfg, vMall);

    java.util.Hashtable aReplicatedBySourceDict = aTravCtxt.getCommon( "ReplicatedBySource");
    if( aReplicatedBySourceDict != null) {
      Object aReplicatedSourceElementObject = aReplicatedBySourceDict.get( vMall);
      if( aReplicatedSourceElementObject != null) {
        com.dosmil_e.m3.withm3.ifc.MMElementWithM3Ifc aReplicatedSourceElement = null;
        try { aReplicatedSourceElement = (com.dosmil_e.m3.withm3.ifc.MMElementWithM3Ifc) aReplicatedSourceElementObject;} catch( ClassCastException anEx) {}
        if( aReplicatedSourceElement != null)     {
          getPilotFrame().openRootBrowserFrameClassNamed( aCtxt, aReplicatedSourceElement, this.getClass().getName(), getConfig());
        }
      }
    }

  } catch( EAIException anEx) {}

    return true;
  }






  public boolean save() {

    if( vMall == null) { return false;}

    showActionStatus("Save Mall as : Please choose destination Mall file");

    EAIMMCtxtIfc aCtxt = getCtxt();
    if( aCtxt == null) { return false;}

    EAIMMFactoryIfc aFactory = aCtxt.getMMFactory("Pro");
    if( aFactory == null) { return false;}

    boolean aSaveResult = false;
    try { aSaveResult = aFactory.persist( aCtxt, vMall, this);} catch( EAIException anEx) {}

    if( !aSaveResult) {
      String aMessage = "Error saving Mall";
      JOptionPane.showMessageDialog(
        this,
        nls("Pilot.Menu.File.Save.IO_Exception.SaveFailed_Error.message",
          "Error saving vMall file\n") + aMessage,
        nls("Pilot.Menu.File.Save.IO_Exception.SaveFailed_Error.title",
          "Save ERROR"),
        JOptionPane.ERROR_MESSAGE);
      return false;
    }

    if( !aSaveResult) {
      showActionStatus( "Mall File save FAILED");
      doMenuEnablement();
      return false;
    }

    EAIFlatTransactionMgrIfc aTrxMgr = vCtxt.getFlatTrxMgr();
    if( aTrxMgr != null) {
      try { aTrxMgr.justSaved();} catch( EAIException anException) {}
    }

    showActionStatus( "Mall File SUCCESSFULLY saved");
    doMenuEnablement();
    return true;
  }


  void menuItemMallSaveAs_actionPerformed(ActionEvent e) {
    saveAs();
  }


  public boolean saveAs() {

    if( vMall == null) { return false;}

    showActionStatus("Save Mall as : Please choose destination Mall file");

    EAIMMCtxtIfc aCtxt = getCtxt();
    if( aCtxt == null) { return false;}

    EAIMMFactoryIfc aFactory = aCtxt.getMMFactory( "Pro");
    if( aFactory == null) { return false;}

    boolean aSaveResult = false;
    try { aSaveResult = aFactory.persistAs( aCtxt, vMall, this);} catch( EAIException anEx) {}

    if( !aSaveResult) {
      String aMessage = "Error savingAs Mall";
      JOptionPane.showMessageDialog(
        this,
        nls("Pilot.Menu.File.SaveAs.IO_Exception.SaveFailed_Error.message",
          "Error saving vMall file\n") + aMessage,
        nls("Pilot.Menu.File.SaveAs.IO_Exception.SaveFailed_Error.title",
          "Save ERROR"),
        JOptionPane.ERROR_MESSAGE);
      return false;
    }

    if( !aSaveResult) {
      showActionStatus( "Mall File saveAs FAILED");
      doMenuEnablement();
      return false;
    }

    EAIFlatTransactionMgrIfc aTrxMgr = vCtxt.getFlatTrxMgr();
    if( aTrxMgr != null) {
      try { aTrxMgr.justSaved();} catch( EAIException anException) {}
    }

    showActionStatus( "Mall File SUCCESSFULLY saved");
    doMenuEnablement();
    return true;
  }








  public void menuItemMallClose_actionPerformed(ActionEvent e) {
    closeMall();
  }



  protected boolean closeMall() {
    EAIFlatTransactionMgrIfc aTrxMgr = null;
    boolean aCloseResult = false;

    if( vMall == null) {
      release();
      return true;
    }

    if( vCtxt == null) {
      vMall = null;
      release();
      return true;
    }

    aTrxMgr = vCtxt.getFlatTrxMgr();
    if( aTrxMgr == null) {
      vMall = null;
      release();
      return true;
    }

    boolean aHasUnsavedChanges = false;
    try { aHasUnsavedChanges = aTrxMgr.hasUnsavedChanges();} catch( EAIException anException) {}
    if( aHasUnsavedChanges) {
      int aConfirmResult = JOptionPane.showConfirmDialog(
        this,
        nls("MallBrowserFrame.MenuBar.FileMenu.CloseMenuItem.CancelClose_Exception.DiscardChanges_Confirmation.message",
          "Do you want to discard unsaved changes ?"),
        nls("MallBrowserFrame.MenuBar.FileMenu.CloseMenuItem.CancelClose_Exception.DiscardChanges_Confirmation.title",
          "Discard unsaved changes confirmation"),
        JOptionPane.YES_NO_CANCEL_OPTION);
      if( aConfirmResult != JOptionPane.YES_OPTION) { return false;}
    }

    aCloseResult = true;
    vMall = null;

   try {
    if( !aCloseResult) {
      showActionStatus( "Mall File close FAILED");
    }
    else {
      showActionStatus( "Mall File SUCCESSFULLY closed");
      try { aTrxMgr.reset();} catch( EAIException anException) {}

    }

    if( vPilotFrame != null) {
      vPilotFrame.browserFrameClosing( this);
    }
   }
   finally {
    release();
   }
    return aCloseResult;

  }


  public void release() {
    if( vPilotFrame != null) {
      vPilotFrame.browserFrameClosing( this);
    }
    if( vCtxt != null) {
//      vCtxt.release();
    }
    super.release();
  }




  public EAIPilotFrame getPilotFrame() {
    return vPilotFrame;
  }



  public void setCtxt( EAIMMCtxtIfc theCtxt) {
    vCtxt  = theCtxt;
  }


  public EAIMMCtxtIfc getCtxt() {
    return vCtxt;
  }



  public void setMall( MallMallIfc theMall) {
    vMall  = theMall;
    setRoot( vMall);
  }



  public MallMallIfc getMall() {
    return vMall;
  }



  public String getRootName() {
    MallMallIfc aMall = getMall();
    if( aMall == null) { return sNoMallRootName; }

    EAIMMCtxtIfc aCtxt = getCtxt();
    if( aCtxt == null) { return sNoMallRootName; }

    EAIMMNameIfc aName = null;
    try { aName = vMall.getName(); } catch( EAIException anEx) {}
    if( aName == null) { return "null Mall name";}

    String aString = aName.getString();
    if( aString == null) { return "null Mall name string";}
    if( aString.length() < 1) { return "empty Mall name";}

    return aString;
  }


  public String getRootKindName() {
    String aKind = "";
    return aKind + "Mall ";
  }




  protected void observePropertiesForTitle() {
    if( vMall == null)     { return;}

    EAIRootNode aRootNode = getRootNode();
    if( aRootNode == null)    { return;}

    aRootNode.observeOtherForAspect( vMall, new String[] { "Name"} , gFrameTitleAspect, getTitleObserver());
  }






  protected void showActionStatus( String theStatus) {
    if( vStatusBar == null) { return;}

    String aStatus = new String(" ");
    if( theStatus != null && theStatus.length() > 0) {
      aStatus = theStatus;
    }
    vStatusBar.setText( aStatus);
  }


  protected void doMenuEnablement() {
    boolean aHasUnsavedChanges = false;
    EAIFlatTransactionMgrIfc aTrxMgr = vCtxt.getFlatTrxMgr();
    try { aHasUnsavedChanges = aTrxMgr.hasUnsavedChanges();} catch( EAIException anException) {}

    vMenuItemMallSave.setEnabled( true /* aHasUnsavedChanges */);
  }


  class MallFileFilter extends javax.swing.filechooser.FileFilter {
    public boolean accept(File thePathname) {
      return( thePathname.getName().endsWith(".cxp") || thePathname.isDirectory());
    }
    public String getDescription() {
      return( "Pro Malls" );
    }
  } // end class MallFileFilter



  protected String nls( String theSymbol, String theDefault) {
    return theDefault;
  }



  public boolean exitRequest() {
    if( vCtxt == null) { return true;}

    return !hasUnsavedChanges();
  }


  public boolean hasUnsavedChanges() {
    if( vCtxt == null) { return false;}

    EAIFlatTransactionMgrIfc aTrxMgr = vCtxt.getFlatTrxMgr();
    if( aTrxMgr == null) { return false;}

    boolean aHasUnsavedChanges = false;
    try { aHasUnsavedChanges = aTrxMgr.hasUnsavedChanges();} catch( EAIException anException) {}
    return aHasUnsavedChanges;
  }







  protected void clearVars() {
    vMenuMall            = null;
    vMenuItemMallSave    = null;
    vMenuItemMallSaveAs  = null;
    vMenuItemMallClose   = null;
    vMenuWindow             = null;
    vMenuActions            = null;
    vMenuItemActionsUndo    = null;
    vMenuItemActionsRedo    = null;
    vPilotFrame             = null;
    vMall                = null;
    super.clearVars();
  }




}
