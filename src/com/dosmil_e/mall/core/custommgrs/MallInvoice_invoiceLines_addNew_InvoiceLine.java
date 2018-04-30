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



public class MallInvoice_invoiceLines_addNew_InvoiceLine extends
  com.dosmil_e.browserbase.metamgrs.EAIAddNewAction {


  public MallInvoice_invoiceLines_addNew_InvoiceLine(
    com.dosmil_e.browserbase.tree.EAITreeNode theNode) {

    super( theNode,
      com.dosmil_e.mall.core.meta.MallInvoiceMeta.getStaticM3Type( theNode.getMMCtxt()),
      com.dosmil_e.mall.core.meta.MallInvoiceLineMeta.getStaticM3Type( theNode.getMMCtxt()),
      com.dosmil_e.mall.core.meta.MallInvoiceMeta.getStaticM3Type( theNode.getMMCtxt()) == null
        ? null : com.dosmil_e.mall.core.meta.MallInvoiceMeta.vm3RelInvoiceLines
      );
  }



  public EAIActionIfc cloneBase() throws CloneNotSupportedException {
    MallInvoice_invoiceLines_addNew_InvoiceLine anAction =
      new MallInvoice_invoiceLines_addNew_InvoiceLine( 
        getTargetNode());

    anAction.setIcon( getIcon());
    anAction.setName( getName());
    return anAction;
  }




  protected void initIcon() {
    vIcon = new ImageIcon("images/createInvoiceLine.gif");
  }






}







