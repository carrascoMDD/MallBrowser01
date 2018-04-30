package com.dosmil_e.mall.core.custommgrs;

// SetNew

import com.dosmil_e.modelbase.support.*;
import com.dosmil_e.modelbase.flattrx.*;

import com.dosmil_e.modelbase.ifc.*;

import com.dosmil_e.browserbase.mgrs.*;
import com.dosmil_e.browserbase.tree.*;
import com.dosmil_e.browserbase.shell.*;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import java.util.Vector;



public class MallInvoice_payment_setNew_Payment extends
  com.dosmil_e.browserbase.metamgrs.EAISetNewAction {


  public MallInvoice_payment_setNew_Payment(
    com.dosmil_e.browserbase.tree.EAITreeNode theNode) {

    super( theNode,
      com.dosmil_e.mall.core.meta.MallInvoiceMeta.getStaticM3Type( theNode.getMMCtxt()),
      com.dosmil_e.mall.core.meta.MallPaymentMeta.getStaticM3Type( theNode.getMMCtxt()),
      com.dosmil_e.mall.core.meta.MallInvoiceMeta.getStaticM3Type( theNode.getMMCtxt()) == null
        ? null : com.dosmil_e.mall.core.meta.MallInvoiceMeta.vm3RelPayment
      );
  }



  public EAIActionIfc cloneBase() throws CloneNotSupportedException {
    MallInvoice_payment_setNew_Payment anAction =
      new MallInvoice_payment_setNew_Payment(
        getTargetNode());

    anAction.setIcon( getIcon());
    anAction.setName( getName());
    return anAction;
  }



  protected void initIcon() {
    vIcon = new ImageIcon("images/createPayment.gif");
  }






}







