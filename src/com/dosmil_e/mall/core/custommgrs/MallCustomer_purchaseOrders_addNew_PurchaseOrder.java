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



public class MallCustomer_purchaseOrders_addNew_PurchaseOrder extends
  com.dosmil_e.browserbase.metamgrs.EAIAddNewAction {


  public MallCustomer_purchaseOrders_addNew_PurchaseOrder(
    com.dosmil_e.browserbase.tree.EAITreeNode theNode) {

    super( theNode,
      com.dosmil_e.mall.core.meta.MallCustomerMeta.getStaticM3Type( theNode.getMMCtxt()),
      com.dosmil_e.mall.core.meta.MallPurchaseOrderMeta.getStaticM3Type( theNode.getMMCtxt()),
      com.dosmil_e.mall.core.meta.MallCustomerMeta.getStaticM3Type( theNode.getMMCtxt()) == null
        ? null : com.dosmil_e.mall.core.meta.MallCustomerMeta.vm3RelPurchaseOrders
      );
  }



  public EAIActionIfc cloneBase() throws CloneNotSupportedException {
    MallCustomer_purchaseOrders_addNew_PurchaseOrder anAction =
      new MallCustomer_purchaseOrders_addNew_PurchaseOrder( 
        getTargetNode());

    anAction.setIcon( getIcon());
    anAction.setName( getName());
    return anAction;
  }




  protected void initIcon() {
    vIcon = new ImageIcon("images/createPurchaseOrder.gif");
  }






}







