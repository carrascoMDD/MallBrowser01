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



public class MallPurchaseOrder_purchaseOrderLines_addNew_PurchaseOrderLine extends
  com.dosmil_e.browserbase.metamgrs.EAIAddNewAction {


  public MallPurchaseOrder_purchaseOrderLines_addNew_PurchaseOrderLine(
    com.dosmil_e.browserbase.tree.EAITreeNode theNode) {

    super( theNode,
      com.dosmil_e.mall.core.meta.MallPurchaseOrderMeta.getStaticM3Type( theNode.getMMCtxt()),
      com.dosmil_e.mall.core.meta.MallPurchaseOrderLineMeta.getStaticM3Type( theNode.getMMCtxt()),
      com.dosmil_e.mall.core.meta.MallPurchaseOrderMeta.getStaticM3Type( theNode.getMMCtxt()) == null
        ? null : com.dosmil_e.mall.core.meta.MallPurchaseOrderMeta.vm3RelPurchaseOrderLines
      );
  }



  public EAIActionIfc cloneBase() throws CloneNotSupportedException {
    MallPurchaseOrder_purchaseOrderLines_addNew_PurchaseOrderLine anAction =
      new MallPurchaseOrder_purchaseOrderLines_addNew_PurchaseOrderLine( 
        getTargetNode());

    anAction.setIcon( getIcon());
    anAction.setName( getName());
    return anAction;
  }




  protected void initIcon() {
    vIcon = new ImageIcon("images/createPurchaseOrderLine.gif");
  }






}







