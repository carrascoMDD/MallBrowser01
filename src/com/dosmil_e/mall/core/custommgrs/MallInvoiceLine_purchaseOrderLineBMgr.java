package com.dosmil_e.mall.core.custommgrs;

// OnoToOneBMgr

import com.dosmil_e.modelbase.support.*;
import com.dosmil_e.modelbase.flattrx.*;

import com.dosmil_e.modelbase.ifc.*;


import com.dosmil_e.browserbase.mgrs.*;
import com.dosmil_e.browserbase.metamgrs.*;
import com.dosmil_e.browserbase.tree.*;
import com.dosmil_e.browserbase.shell.*;

import java.awt.event.ActionEvent;

import java.awt.Window;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.tree.TreeNode;

import java.util.Vector;


public class MallInvoiceLine_purchaseOrderLineBMgr extends EAIBranchMgr {


  public MallInvoiceLine_purchaseOrderLineBMgr() {
    super( );
  }


    protected EAIMMElementIfc[] getMMElements( EAITreeNode theNode) {
      EAIMMElementIfc aMMElement = getPurchaseOrderLine( theNode);
      if( aMMElement == null) { return null;}
      return new EAIMMElementIfc[] { aMMElement};
    }




    protected com.dosmil_e.mall.core.ifc.MallPurchaseOrderLineIfc getPurchaseOrderLine( EAITreeNode theNode) {

      if( theNode == null) { return null;}

      Object aUserObject = theNode.getUserObject();
      if( aUserObject == null) { return null;}

      com.dosmil_e.mall.core.ifc.MallInvoiceLineIfc aInvoiceLine = null;
      try { aInvoiceLine = (com.dosmil_e.mall.core.ifc.MallInvoiceLineIfc) aUserObject;} catch( ClassCastException anEx) {}
      if( aInvoiceLine == null) { return null;}

      EAIMMCtxtIfc aCtxt = theNode.getMMCtxt();
      if( aCtxt == null) { return null;}

      com.dosmil_e.mall.core.ifc.MallPurchaseOrderLineIfc aPurchaseOrderLine = null;
      try { aPurchaseOrderLine = aInvoiceLine.getPurchaseOrderLine( aCtxt);} catch( EAIException anEx) {}

	    return aPurchaseOrderLine;
    }




    protected void observePropertiesForChildren( EAITreeNode theNode) {
      if( theNode == null) { return;}
      theNode.observePropertiesForAspect( new String[] { "PurchaseOrderLine"}, gChildrenAspect, this);
    }


    public String composeLabelPrefix( EAITreeNode theNode, EAINodeMgrIfc theNodeMgr) {
      return "purchaseOrderLine: ";
    }



 public EAIActionsMgrIfc[] getBranchActionsMgrsForChild( ) {
    return new EAIActionsMgrIfc[] {
      new EAIGenericActionsMgr(
        new Class[] {
					MallInvoiceLine_purchaseOrderLine_setChosen_PurchaseOrderLine.class,

        },
        EAIActionsSetIfc.sMenuInliningModeInline, // setMenuInliningMode
        "purchaseOrderLine ? (1)" // setSubMenuLabel
      )
    };
  }






  public EAIActionsMgrIfc[] getBranchActionsMgrsForParent( ) {
    return new EAIActionsMgrIfc[] {
      new EAIGenericActionsMgr(
        new Class[] {
          MallInvoiceLine_purchaseOrderLine_remove.class
        }
      )
    };
  }


}


