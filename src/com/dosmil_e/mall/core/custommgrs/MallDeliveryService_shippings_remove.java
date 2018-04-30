package com.dosmil_e.mall.core.custommgrs;

// Remove

import com.dosmil_e.modelbase.support.*;
import com.dosmil_e.modelbase.flattrx.*;

import com.dosmil_e.modelbase.ifc.*;

import com.dosmil_e.browserbase.mgrs.*;
import com.dosmil_e.browserbase.tree.*;
import com.dosmil_e.browserbase.shell.*;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import java.util.Vector;



public class MallDeliveryService_shippings_remove extends
  com.dosmil_e.browserbase.metamgrs.EAIRemoveAction {


  public MallDeliveryService_shippings_remove(
    com.dosmil_e.browserbase.tree.EAITreeNode theNode) {

    super( theNode,
      com.dosmil_e.mall.core.meta.MallDeliveryServiceMeta.getStaticM3Type( theNode.getMMCtxt()),
      com.dosmil_e.mall.core.meta.MallDeliveryServiceMeta.getStaticM3Type( theNode.getMMCtxt()) == null
        ? null : com.dosmil_e.mall.core.meta.MallDeliveryServiceMeta.vm3RelShippings
      );
  }



  public EAIActionIfc cloneBase() throws CloneNotSupportedException {
    MallDeliveryService_shippings_remove anAction =
      new MallDeliveryService_shippings_remove(
        getTargetNode());

    anAction.setIcon( getIcon());
    anAction.setName( getName());
    return anAction;
  }




  protected void initIcon() {
    vIcon = new ImageIcon("images/remove$RelatedConcreteTypeName$.gif");
  }






}







