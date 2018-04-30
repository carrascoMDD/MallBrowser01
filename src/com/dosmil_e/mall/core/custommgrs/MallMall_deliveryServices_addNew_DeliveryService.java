package com.dosmil_e.mall.core.custommgrs;

// AddNew

import com.dosmil_e.modelbase.support.*;
import com.dosmil_e.modelbase.flattrx.*;

import com.dosmil_e.modelbase.ifc.*;

import com.dosmil_e.browserbase.mgrs.*;
import com.dosmil_e.browserbase.tree.*;
import com.dosmil_e.browserbase.shell.*;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import java.util.Vector;



public class MallMall_deliveryServices_addNew_DeliveryService extends
  com.dosmil_e.browserbase.metamgrs.EAIAddNewAction {


  public MallMall_deliveryServices_addNew_DeliveryService(
    com.dosmil_e.browserbase.tree.EAITreeNode theNode) {

    super( theNode,
      com.dosmil_e.mall.core.meta.MallMallMeta.getStaticM3Type( theNode.getMMCtxt()),
      com.dosmil_e.mall.core.meta.MallDeliveryServiceMeta.getStaticM3Type( theNode.getMMCtxt()),
      com.dosmil_e.mall.core.meta.MallMallMeta.getStaticM3Type( theNode.getMMCtxt()) == null
        ? null : com.dosmil_e.mall.core.meta.MallMallMeta.vm3RelDeliveryServices
      );
  }



  public EAIActionIfc cloneBase() throws CloneNotSupportedException {
    MallMall_deliveryServices_addNew_DeliveryService anAction =
      new MallMall_deliveryServices_addNew_DeliveryService( 
        getTargetNode());

    anAction.setIcon( getIcon());
    anAction.setName( getName());
    return anAction;
  }




  protected void initIcon() {
    vIcon = new ImageIcon("images/createDeliveryService.gif");
  }






}







