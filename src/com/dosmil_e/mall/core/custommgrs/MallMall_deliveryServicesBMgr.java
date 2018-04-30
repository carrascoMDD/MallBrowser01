package com.dosmil_e.mall.core.custommgrs;

// OneToManyManyAggregationBMgr

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


public class MallMall_deliveryServicesBMgr extends EAIBranchMgr {


  public MallMall_deliveryServicesBMgr() {
    super( );
  }


    protected EAIMMElementIfc[] getMMElements( EAITreeNode theNode) {
      return getDeliveryServices( theNode);
    }




    protected com.dosmil_e.mall.core.ifc.MallDeliveryServiceIfc[] getDeliveryServices( EAITreeNode theNode) {

      if( theNode == null) { return null;}

      Object aUserObject = theNode.getUserObject();
      if( aUserObject == null) { return null;}

      com.dosmil_e.mall.core.ifc.MallMallIfc aMall = null;
      try { aMall = (com.dosmil_e.mall.core.ifc.MallMallIfc) aUserObject;} catch( ClassCastException anEx) {}
      if( aMall == null) { return null;}

      EAIMMCtxtIfc aCtxt = theNode.getMMCtxt();
      if( aCtxt == null) { return null;}

      com.dosmil_e.mall.core.ifc.MallDeliveryServiceIfc[] someDeliveryServices = null;
      try { someDeliveryServices = aMall.getDeliveryServices( aCtxt);} catch( EAIException anEx) {}


	    return someDeliveryServices;

    }




    protected void observePropertiesForChildren( EAITreeNode theNode) {
      if( theNode == null) { return;}
      theNode.observePropertiesForAspect( new String[] { "DeliveryServices"}, gChildrenAspect, this);
    }


    public String composeLabelPrefix( EAITreeNode theNode, EAINodeMgrIfc theNodeMgr) {
      return "deliveryServices: ";
    }






  public EAIActionsMgrIfc[] getBranchActionsMgrsForChild( ) {
    return new EAIActionsMgrIfc[] {
      new EAIGenericActionsMgr(
        new Class[] {
					MallMall_deliveryServices_addNew_DeliveryService.class,

        },
        EAIActionsSetIfc.sMenuInliningModeInline, // setMenuInliningMode
        "deliveryServices + (N)" // setSubMenuLabel
      )
    };
  }






  public EAIActionsMgrIfc[] getBranchActionsMgrsForParent( ) {
    return new EAIActionsMgrIfc[] {
      new EAIGenericActionsMgr(
        new Class[] {
          com.dosmil_e.mall.core.custommgrs.MallDeliveryService_delete.class
        }
      )
    };
  }






}


