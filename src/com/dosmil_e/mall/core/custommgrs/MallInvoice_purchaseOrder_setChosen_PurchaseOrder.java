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



public class MallInvoice_purchaseOrder_setChosen_PurchaseOrder extends
  com.dosmil_e.browserbase.metamgrs.EAISetChosenAction {


  public MallInvoice_purchaseOrder_setChosen_PurchaseOrder(
    com.dosmil_e.browserbase.tree.EAITreeNode theNode) {

    super( theNode,
      com.dosmil_e.mall.core.meta.MallInvoiceMeta.getStaticM3Type( theNode.getMMCtxt()),
      com.dosmil_e.mall.core.meta.MallPurchaseOrderMeta.getStaticM3Type( theNode.getMMCtxt()),
      com.dosmil_e.mall.core.meta.MallInvoiceMeta.getStaticM3Type( theNode.getMMCtxt()) == null
        ? null : com.dosmil_e.mall.core.meta.MallInvoiceMeta.vm3RelPurchaseOrder,
      com.dosmil_e.mall.core.customconfigs.MallPurchaseOrderChooserTreeConfigFactory.getConfig( theNode.getMMCtxt())
      );
  }



  public EAIActionIfc cloneBase() throws CloneNotSupportedException {
    MallInvoice_purchaseOrder_setChosen_PurchaseOrder anAction =
      new MallInvoice_purchaseOrder_setChosen_PurchaseOrder(
      getTargetNode());

    anAction.setIcon( getIcon());
    anAction.setName( getName());
    return anAction;
  }


  protected void initIcon() {
    vIcon = new ImageIcon("images/choosePurchaseOrder.gif");
  }






}




