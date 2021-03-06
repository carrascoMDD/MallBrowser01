package com.dosmil_e.mall.core.custommgrs;

// SetChosen

import com.dosmil_e.modelbase.support.*;
import com.dosmil_e.modelbase.flattrx.*;

import com.dosmil_e.modelbase.ifc.*;

import com.dosmil_e.browserbase.mgrs.*;
import com.dosmil_e.browserbase.tree.*;
import com.dosmil_e.browserbase.shell.*;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import java.util.Vector;



public class MallShipping_contact_setChosen_Contact extends
  com.dosmil_e.browserbase.metamgrs.EAISetChosenAction {


  public MallShipping_contact_setChosen_Contact(
    com.dosmil_e.browserbase.tree.EAITreeNode theNode) {

    super( theNode,
      com.dosmil_e.mall.core.meta.MallShippingMeta.getStaticM3Type( theNode.getMMCtxt()),
      com.dosmil_e.mall.core.meta.MallContactMeta.getStaticM3Type( theNode.getMMCtxt()),
      com.dosmil_e.mall.core.meta.MallShippingMeta.getStaticM3Type( theNode.getMMCtxt()) == null
        ? null : com.dosmil_e.mall.core.meta.MallShippingMeta.vm3RelContact,
      com.dosmil_e.mall.core.customconfigs.MallContactChooserTreeConfigFactory.getConfig( theNode.getMMCtxt())
      );
  }



  public EAIActionIfc cloneBase() throws CloneNotSupportedException {
    MallShipping_contact_setChosen_Contact anAction =
      new MallShipping_contact_setChosen_Contact(
      getTargetNode());

    anAction.setIcon( getIcon());
    anAction.setName( getName());
    return anAction;
  }


  protected void initIcon() {
    vIcon = new ImageIcon("images/chooseContact.gif");
  }






}




