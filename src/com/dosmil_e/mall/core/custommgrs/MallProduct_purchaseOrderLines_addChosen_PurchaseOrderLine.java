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



public class MallProduct_purchaseOrderLines_addChosen_PurchaseOrderLine extends
  com.dosmil_e.browserbase.metamgrs.EAIAddChosenAction {


  public MallProduct_purchaseOrderLines_addChosen_PurchaseOrderLine(
    com.dosmil_e.browserbase.tree.EAITreeNode theNode) {

    super( theNode,
      com.dosmil_e.mall.core.meta.MallProductMeta.getStaticM3Type( theNode.getMMCtxt()),
      com.dosmil_e.mall.core.meta.MallPurchaseOrderLineMeta.getStaticM3Type( theNode.getMMCtxt()),
      com.dosmil_e.mall.core.meta.MallProductMeta.getStaticM3Type( theNode.getMMCtxt()) == null
        ? null : com.dosmil_e.mall.core.meta.MallProductMeta.vm3RelPurchaseOrderLines,
      com.dosmil_e.mall.core.customconfigs.MallPurchaseOrderLineChooserTreeConfigFactory.getConfig( theNode.getMMCtxt())
      );
  }



  public EAIActionIfc cloneBase() throws CloneNotSupportedException {
    MallProduct_purchaseOrderLines_addChosen_PurchaseOrderLine anAction =
      new MallProduct_purchaseOrderLines_addChosen_PurchaseOrderLine(
      getTargetNode());

    anAction.setIcon( getIcon());
    anAction.setName( getName());
    return anAction;
  }


  protected void initIcon() {
    vIcon = new ImageIcon("images/choosePurchaseOrderLine.gif");
  }






}







