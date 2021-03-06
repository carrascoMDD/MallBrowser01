package com.dosmil_e.mall.core.custommgrs;

// AddChosen

import com.dosmil_e.modelbase.support.*;
import com.dosmil_e.modelbase.flattrx.*;

import com.dosmil_e.modelbase.ifc.*;

import com.dosmil_e.browserbase.mgrs.*;
import com.dosmil_e.browserbase.tree.*;
import com.dosmil_e.browserbase.shell.*;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import java.util.Vector;



public class MallPurchaseOrder_invoices_addChosen_Invoice extends
  com.dosmil_e.browserbase.metamgrs.EAIAddChosenAction {


  public MallPurchaseOrder_invoices_addChosen_Invoice(
    com.dosmil_e.browserbase.tree.EAITreeNode theNode) {

    super( theNode,
      com.dosmil_e.mall.core.meta.MallPurchaseOrderMeta.getStaticM3Type( theNode.getMMCtxt()),
      com.dosmil_e.mall.core.meta.MallInvoiceMeta.getStaticM3Type( theNode.getMMCtxt()),
      com.dosmil_e.mall.core.meta.MallPurchaseOrderMeta.getStaticM3Type( theNode.getMMCtxt()) == null
        ? null : com.dosmil_e.mall.core.meta.MallPurchaseOrderMeta.vm3RelInvoices,
      com.dosmil_e.mall.core.customconfigs.MallInvoiceChooserTreeConfigFactory.getConfig( theNode.getMMCtxt())
      );
  }



  public EAIActionIfc cloneBase() throws CloneNotSupportedException {
    MallPurchaseOrder_invoices_addChosen_Invoice anAction =
      new MallPurchaseOrder_invoices_addChosen_Invoice(
      getTargetNode());

    anAction.setIcon( getIcon());
    anAction.setName( getName());
    return anAction;
  }


  protected void initIcon() {
    vIcon = new ImageIcon("images/chooseInvoice.gif");
  }






}







