package com.dosmil_e.mall.core.custommgrs;

// OneToManyManyBMgr

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


public class MallPurchaseOrder_invoicesBMgr extends EAIBranchMgr {


  public MallPurchaseOrder_invoicesBMgr() {
    super( );
  }


    protected EAIMMElementIfc[] getMMElements( EAITreeNode theNode) {
      return getInvoices( theNode);
    }




    protected com.dosmil_e.mall.core.ifc.MallInvoiceIfc[] getInvoices( EAITreeNode theNode) {

      if( theNode == null) { return null;}

      Object aUserObject = theNode.getUserObject();
      if( aUserObject == null) { return null;}

      com.dosmil_e.mall.core.ifc.MallPurchaseOrderIfc aPurchaseOrder = null;
      try { aPurchaseOrder = (com.dosmil_e.mall.core.ifc.MallPurchaseOrderIfc) aUserObject;} catch( ClassCastException anEx) {}
      if( aPurchaseOrder == null) { return null;}

      EAIMMCtxtIfc aCtxt = theNode.getMMCtxt();
      if( aCtxt == null) { return null;}

      com.dosmil_e.mall.core.ifc.MallInvoiceIfc[] someInvoices = null;
      try { someInvoices = aPurchaseOrder.getInvoices( aCtxt);} catch( EAIException anEx) {}


	    return someInvoices;

    }




    protected void observePropertiesForChildren( EAITreeNode theNode) {
      if( theNode == null) { return;}
      theNode.observePropertiesForAspect( new String[] { "Invoices"}, gChildrenAspect, this);
    }



    public String composeLabelPrefix( EAITreeNode theNode, EAINodeMgrIfc theNodeMgr) {
      return "invoices: ";
    }


  public EAIActionsMgrIfc[] getBranchActionsMgrsForChild( ) {
    return new EAIActionsMgrIfc[] {
      new EAIGenericActionsMgr(
        new Class[] {
					MallPurchaseOrder_invoices_addChosen_Invoice.class,

        },
        EAIActionsSetIfc.sMenuInliningModeInline, // setMenuInliningMode
        "invoices ? (N)" // setSubMenuLabel
      )
    };
  }






  public EAIActionsMgrIfc[] getBranchActionsMgrsForParent( ) {
    return new EAIActionsMgrIfc[] {
      new EAIGenericActionsMgr(
        new Class[] {
          MallPurchaseOrder_invoices_remove.class
        }
      )
    };
  }



}


