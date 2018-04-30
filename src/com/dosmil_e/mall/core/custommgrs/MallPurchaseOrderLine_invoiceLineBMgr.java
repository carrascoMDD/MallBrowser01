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


public class MallPurchaseOrderLine_invoiceLineBMgr extends EAIBranchMgr {


  public MallPurchaseOrderLine_invoiceLineBMgr() {
    super( );
  }


    protected EAIMMElementIfc[] getMMElements( EAITreeNode theNode) {
      EAIMMElementIfc aMMElement = getInvoiceLine( theNode);
      if( aMMElement == null) { return null;}
      return new EAIMMElementIfc[] { aMMElement};
    }




    protected com.dosmil_e.mall.core.ifc.MallInvoiceLineIfc getInvoiceLine( EAITreeNode theNode) {

      if( theNode == null) { return null;}

      Object aUserObject = theNode.getUserObject();
      if( aUserObject == null) { return null;}

      com.dosmil_e.mall.core.ifc.MallPurchaseOrderLineIfc aPurchaseOrderLine = null;
      try { aPurchaseOrderLine = (com.dosmil_e.mall.core.ifc.MallPurchaseOrderLineIfc) aUserObject;} catch( ClassCastException anEx) {}
      if( aPurchaseOrderLine == null) { return null;}

      EAIMMCtxtIfc aCtxt = theNode.getMMCtxt();
      if( aCtxt == null) { return null;}

      com.dosmil_e.mall.core.ifc.MallInvoiceLineIfc aInvoiceLine = null;
      try { aInvoiceLine = aPurchaseOrderLine.getInvoiceLine( aCtxt);} catch( EAIException anEx) {}

	    return aInvoiceLine;
    }




    protected void observePropertiesForChildren( EAITreeNode theNode) {
      if( theNode == null) { return;}
      theNode.observePropertiesForAspect( new String[] { "InvoiceLine"}, gChildrenAspect, this);
    }


    public String composeLabelPrefix( EAITreeNode theNode, EAINodeMgrIfc theNodeMgr) {
      return "invoiceLine: ";
    }



 public EAIActionsMgrIfc[] getBranchActionsMgrsForChild( ) {
    return new EAIActionsMgrIfc[] {
      new EAIGenericActionsMgr(
        new Class[] {
					MallPurchaseOrderLine_invoiceLine_setChosen_InvoiceLine.class,

        },
        EAIActionsSetIfc.sMenuInliningModeInline, // setMenuInliningMode
        "invoiceLine ? (1)" // setSubMenuLabel
      )
    };
  }






  public EAIActionsMgrIfc[] getBranchActionsMgrsForParent( ) {
    return new EAIActionsMgrIfc[] {
      new EAIGenericActionsMgr(
        new Class[] {
          MallPurchaseOrderLine_invoiceLine_remove.class
        }
      )
    };
  }


}


