package com.dosmil_e.mall.browser.customwindows;

import com.dosmil_e.browserbase.shell.EAIRootChangeListenerIfc;
import com.dosmil_e.browserbase.shell.EAIBrowserRootHolder;
import com.dosmil_e.browserbase.shell.EAIRootChangeEvent;
import com.dosmil_e.browserbase.shell.EAIEditorPanel;

import com.dosmil_e.browserbase.tree.EAINodeObserverIfc;

import com.dosmil_e.modelbase.support.EAIMMCtxtIfc;
import com.dosmil_e.modelbase.support.EAIException;
import com.dosmil_e.modelbase.support.EAIMMNameIfc;
import com.dosmil_e.modelbase.support.EAIMMName;

import com.dosmil_e.modelbase.ifc.EAIMMElementIfc;

import com.dosmil_e.browserbase.configs.EAIConfigIfc;

import com.dosmil_e.browserbase.tree.EAITreeNode;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MallMMElementHorizontalEditorPanel extends EAIEditorPanel implements DocumentListener, EAIRootChangeListenerIfc {

  protected static final String gEmptyKind      = new String( " -- no Model element -- ");
  protected static final String gEmptyName      = new String( " -- no Model element -- " );

  protected static final String gUnknownKind    = new String( "Unknown kind");
  protected static final String gUnknownName    = new String( "Unknown name");

  protected boolean isInTransition = false;

  BorderLayout fullBorderLayout = new BorderLayout();
  Box fullBox;
  Box labelAndNameBox;
  Component topMargin;
  Component bottomMargin;
  Component leftMargin;
  Component rightMargin;
  Component kindToNameMargin;

  
  JPanel kindPanel = new JPanel();
  Box kindLabelAndFieldBox;
  Component kindRightMargin;
  Component kindLeftMargin;
  Component kindLabelAndFieldSeparator;
  BorderLayout kindPanelLayout = new BorderLayout();
  Box kindBox;
  JTextField kindField = new JTextField();
  JLabel kindLabel = new JLabel();

  JPanel namePanel = new JPanel();
  Box nameLabelAndFieldBox;
  Component nameRightMargin;
  Component nameLeftMargin;
  Component nameLabelAndFieldSeparator;
  BorderLayout namePanelLayout = new BorderLayout();
  Box nameBox;
  JTextField nameField = new JTextField();
  JLabel nameLabel = new JLabel();

 
  protected EAINodeObserverIfc  vFieldNameNodeObserver;
  protected EAIMMElementIfc     vFieldNameNodeObserved;


  public MallMMElementHorizontalEditorPanel() {
    try  {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
//    vRootHolder = new EAIBrowserRootHolder();
//    vRootHolder.addRootChangeListener( this);
  }



  private void jbInit() throws Exception {
    this.setLayout(fullBorderLayout);

    fullBox = Box.createVerticalBox();
    kindField.setToolTipText("Kind of Model Element");
    nameField.setToolTipText("Name of the Model Element");
    this.add(fullBox, BorderLayout.CENTER);

    topMargin = Box.createVerticalStrut(11);
    fullBox.add(topMargin, null);

    labelAndNameBox = Box.createHorizontalBox();
    fullBox.add(labelAndNameBox, null);

    leftMargin = Box.createHorizontalStrut(8);
    labelAndNameBox.add(leftMargin, null);


    kindLabelAndFieldSeparator = Box.createHorizontalStrut(8);
    kindToNameMargin = Box.createHorizontalStrut(8);
    kindLabelAndFieldBox = Box.createHorizontalBox();
    kindRightMargin = Box.createHorizontalStrut(8);
    kindLeftMargin = Box.createHorizontalStrut(8);
    kindBox = Box.createHorizontalBox();
    kindPanel.setMaximumSize(new Dimension(32767, 42));
    kindPanel.setMinimumSize(new Dimension(60, 22));
    kindPanel.setPreferredSize(new Dimension(96, 24));
    kindPanel.setLayout(kindPanelLayout);
    kindField.setEnabled(false);
    kindField.setFont(new java.awt.Font("Monospaced", 0, 12));
    kindField.setPreferredSize(new Dimension(95, 22));
    kindField.setEditable(false);
    kindField.setText("Kind");
    kindLabel.setEnabled(false);
    kindLabel.setText("Kind");
    kindPanel.add(kindLabelAndFieldBox, BorderLayout.CENTER);
    kindLabelAndFieldBox.add(kindLeftMargin, null);
    kindLabelAndFieldBox.add(kindBox, null);
    kindBox.add(kindLabel, null);
    kindBox.add(kindLabelAndFieldSeparator, null);
    kindBox.add(kindField, null);
    kindLabelAndFieldBox.add(kindRightMargin, null);
    labelAndNameBox.add(kindPanel, null);

    labelAndNameBox.add(kindToNameMargin, null);

    nameLabelAndFieldSeparator = Box.createHorizontalStrut(8);
    nameLabelAndFieldBox = Box.createHorizontalBox();
    nameRightMargin = Box.createHorizontalStrut(8);
    nameLeftMargin = Box.createHorizontalStrut(8);
    nameBox = Box.createHorizontalBox();
    namePanel.setMaximumSize(new Dimension(32767, 42));
    namePanel.setMinimumSize(new Dimension(60, 22));
    namePanel.setPreferredSize(new Dimension(96, 24));
    namePanel.setLayout(namePanelLayout);
    nameField.setEnabled(false);
    nameField.setFont(new java.awt.Font("Monospaced", 0, 12));
    nameField.setPreferredSize(new Dimension(95, 22));
    nameField.setEditable(false);
    nameField.setText("Name");
    nameLabel.setEnabled(false);
    nameLabel.setText("Name");
    namePanel.add(nameLabelAndFieldBox, BorderLayout.CENTER);
    nameLabelAndFieldBox.add(nameLeftMargin, null);
    nameLabelAndFieldBox.add(nameBox, null);
    nameBox.add(nameLabel, null);
    nameBox.add(nameLabelAndFieldSeparator, null);
    nameBox.add(nameField, null);
    nameLabelAndFieldBox.add(nameRightMargin, null);
    labelAndNameBox.add(namePanel, null);

    rightMargin = Box.createHorizontalStrut(8);
    labelAndNameBox.add(rightMargin, null);


    bottomMargin = Box.createVerticalStrut(8);
    fullBox.add(bottomMargin, null);


    nameField.addActionListener(
      new ActionListener() {
        public void actionPerformed( ActionEvent theEvent) {
          acceptName();
        }
      }
    );
  }



  public void acceptName() {
    if( nameField == null) { return;}

    if( vIsInTransition) { return;}

    String aFieldString = nameField.getText();
    if( aFieldString == null || aFieldString.length() < 1) { return;}
    if( aFieldString.equals( gEmptyName) || aFieldString.equals( gUnknownName)) { return;}

    String aNameString = getSubjectName();
    if( aNameString != null && aFieldString.equals( aNameString)) { return;}

    EAIMMCtxtIfc aCtxt = getMMCtxt();
    if( aCtxt == null) { return;}

    EAIMMElementIfc aMMElement = getSubject();
    if( aMMElement == null) { return;}
    try {  aMMElement.setName( aCtxt, new EAIMMName( aFieldString));} catch( EAIException anEx) {}
  }






  protected void resetKindFieldContents() {
    if( kindField != null) {
      kindField.setText( gEmptyKind);
    }
  }

  protected void resetNameFieldContents() {
    if( nameField != null) {
      if( !vIsInTransition) {
        try {
          vIsInTransition = true;
          nameField.setText( gEmptyName);
        }
        finally {
          vIsInTransition = false;
        }
      }
    }
    nameField.setEditable( false);
  }


  protected void resetWidgetContents() {
    resetKindFieldContents();
    resetNameFieldContents();
  }



  protected void setKindFieldContents() {
    if( kindField == null) { return;}

    String aKind = getSubjectKind();
    if( aKind == null) { aKind = gUnknownKind;}
    kindField.setText( aKind);
  }



  protected String getSubjectName() {
    EAIMMElementIfc aMMElement = getSubject();
    if( aMMElement == null) { return null;}

    EAIMMCtxtIfc aCtxt = getMMCtxt();
    if( aCtxt == null) { return null;}

    String aNameString = null;
    EAIMMNameIfc aName = null;
    try { aName = aMMElement.getName(); } catch( EAIException anEx) {}
    if( aName != null) {
      aNameString = aName.getString();
    }
    return aNameString;
  }


  protected String getSubjectKind() {
    EAIMMElementIfc aMMElement = getSubject();
    if( aMMElement == null) { return null;}

    EAIMMCtxtIfc aCtxt = getMMCtxt();
    if( aCtxt == null) { return null;}

    String aKind = null;
    try { aKind = aMMElement.getKind( aCtxt); } catch( EAIException anEx) {}
    return aKind;
  }


  protected void setNameFieldContents() {
    if( nameField == null) { return;}
    if( vIsInTransition)   { return;}

    EAIMMElementIfc aMMElement = getSubject();
    if( aMMElement == null) { return;}

    String aNameString = getSubjectName();
    if( aNameString == null) {
      aNameString = gUnknownName;
    }

    try {
      isInTransition = true;
      nameField.setText( aNameString);
    }
    finally {
      vIsInTransition = false;
    }

    boolean anIsEditable = isSubjectEditable();
    nameField.setEditable( anIsEditable);
  }



  protected void setWidgetContents() {
    setKindFieldContents();
    setNameFieldContents();
  }




  protected void widgetsEnablement( boolean theEnablement) {
    if( kindLabel != null) {
      kindLabel.setEnabled( theEnablement);
    }
    if( kindField != null) {
      kindField.setEnabled( theEnablement);
    }
    if( nameLabel != null) {
      nameLabel.setEnabled( theEnablement);
    }
    if( nameField != null) {
      nameField.setEnabled( theEnablement);
    }
  }




    /**
     * Gives notification that there was an insert into the document.  The
     * given range bounds the freshly inserted region.
     *
     * @param e the document event
     */
    public void insertUpdate(DocumentEvent theEvent) {
    }



    /**
     * Gives notification that a portion of the document has been
     * removed.  The range is given in terms of what the view last
     * saw (that is, before updating sticky positions).
     *
     * @param e the document event
     */
    public void removeUpdate(DocumentEvent theEvent) {
    }



    /**
     * Gives notification that an attribute or set of attributes changed.
     *
     * @param e the document event
     */
    public void changedUpdate(DocumentEvent theEvent) {
    }



  protected EAINodeObserverIfc getFieldNameObserver() {
    if( vFieldNameNodeObserver != null) { return vFieldNameNodeObserver;}

    vFieldNameNodeObserver = new EAINodeObserverIfc() {
      public void notifyAspectChange(
        EAITreeNode theNode,
        Object      theSource,
        String      thePropertyName,
        Object      theOldValue,
        Object      theNewValue,
        EAIConfigIfc theConfig) {

        setNameFieldContents();
        observePropertiesForName();
      }
    };
    return vFieldNameNodeObserver;
  }



  protected void observePropertiesForName() {
    EAITreeNode aTreeNode = getSubjectNode();
    if( aTreeNode == null) { return;}

    EAIMMElementIfc aMMElement = getSubject();
    if( aMMElement == null) { return;}
    vFieldNameNodeObserved = aMMElement;

    EAINodeObserverIfc aNodeObserver = getFieldNameObserver();
    if( aNodeObserver != null) {
      aTreeNode.observeOtherForAspect( aMMElement, new String[] { "Name"}, "Field_Name", aNodeObserver);
    }
  }

  protected void dropInterestsOnName() {
    if( vPreviousSubjectNode == null) { return;}
    if( vFieldNameNodeObserver == null) { return;}
    if( vFieldNameNodeObserved == null) { return;}

    vPreviousSubjectNode.dropOtherInterestOnAspect( vFieldNameNodeObserved, new String[] { "Name"}, "Field_Name", vFieldNameNodeObserver);
  }




  protected void dropInterestsOnPreviousSubject() {
    dropInterestsOnName();
  }



  protected void registerInterestsOnCurrentSubject() {
    observePropertiesForName();
  }


  protected boolean isSubjectEditable() {
    EAITreeNode aSubjectNode = getSubjectNode();
    if( aSubjectNode == null) { return false;}
    boolean anIsEditable = aSubjectNode.isEditable();
    return anIsEditable;
  }


}
