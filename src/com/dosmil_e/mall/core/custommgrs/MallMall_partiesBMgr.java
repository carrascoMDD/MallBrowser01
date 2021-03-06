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


public class MallMall_partiesBMgr extends EAIBranchMgr {


  public MallMall_partiesBMgr() {
    super( );
  }


    protected EAIMMElementIfc[] getMMElements( EAITreeNode theNode) {
      return getParties( theNode);
    }




    protected com.dosmil_e.mall.core.ifc.MallPartyIfc[] getParties( EAITreeNode theNode) {

      if( theNode == null) { return null;}

      Object aUserObject = theNode.getUserObject();
      if( aUserObject == null) { return null;}

      com.dosmil_e.mall.core.ifc.MallMallIfc aMall = null;
      try { aMall = (com.dosmil_e.mall.core.ifc.MallMallIfc) aUserObject;} catch( ClassCastException anEx) {}
      if( aMall == null) { return null;}

      EAIMMCtxtIfc aCtxt = theNode.getMMCtxt();
      if( aCtxt == null) { return null;}

      com.dosmil_e.mall.core.ifc.MallPartyIfc[] someParties = null;
      try { someParties = aMall.getParties( aCtxt);} catch( EAIException anEx) {}


	    return someParties;

    }




    protected void observePropertiesForChildren( EAITreeNode theNode) {
      if( theNode == null) { return;}
      theNode.observePropertiesForAspect( new String[] { "Parties"}, gChildrenAspect, this);
    }


    public String composeLabelPrefix( EAITreeNode theNode, EAINodeMgrIfc theNodeMgr) {
      return "parties: ";
    }






  public EAIActionsMgrIfc[] getBranchActionsMgrsForChild( ) {
    return new EAIActionsMgrIfc[] {
      new EAIGenericActionsMgr(
        new Class[] {
					MallMall_parties_addNew_Party.class,

        },
        EAIActionsSetIfc.sMenuInliningModeInline, // setMenuInliningMode
        "parties + (N)" // setSubMenuLabel
      )
    };
  }






  public EAIActionsMgrIfc[] getBranchActionsMgrsForParent( ) {
    return new EAIActionsMgrIfc[] {
      new EAIGenericActionsMgr(
        new Class[] {
          com.dosmil_e.mall.core.custommgrs.MallParty_delete.class
        }
      )
    };
  }






}


