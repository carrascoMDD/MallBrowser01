package com.dosmil_e.mall.browser.customwindows;



import com.dosmil_e.modelbase.support.*;
import com.dosmil_e.modelbase.ifc.EAIMMElementIfc;

import com.dosmil_e.browserbase.shell.EAIPilotFrame;

import com.dosmil_e.browserbase.configs.*;

public class MallPilotFrame extends EAIPilotFrame {

  public static final String  sProMMCtxtClassName            = "com.dosmil_e.m3.support.MMCtxtWithM3";
  public static final String  sProBrowserFrameClassName      = "com.dosmil_e.mall.browser.customwindows.MallMallBrowserFrame";
  public static final String  sProMetaBrowserFrameClassName  = "com.dosmil_e.mall.browser.customwindows.MallMallMetaBrowserFrame";
  public static final String  sMallPilotFrameName            = "Mall Pilot";
  public static final String  sMallNameForNewRoot            = "new Mall";
  public static final String  sFactoryNameForNewRoot         = "Mall";


  public MallPilotFrame() {
    super();
  }


  protected void initVars() {
    super.initVars();
    
    vDefaultMMCtxtClassName             = sProMMCtxtClassName;
    vDefaultBrowserFrameClassName       = sProBrowserFrameClassName;
    vDefaultMetaBrowserFrameClassName   = sProMetaBrowserFrameClassName;
    vDefaultPilotFrameName              = sMallPilotFrameName;
    vDefaultNameForNewRoot              = sMallNameForNewRoot;
    vDefaultFactoryNameForNewRoot       = sFactoryNameForNewRoot;
  }



  protected void registerFactories( EAIMMCtxtIfc theCtxt) {
    super.registerFactories( theCtxt);

    com.dosmil_e.modelbase.support.EAIMMFactoryIfc aM3Factory =
      new com.dosmil_e.m3.support.M3MMFactoryStandAlone();
    theCtxt.registerFactory( aM3Factory);

    com.dosmil_e.modelbase.support.EAIMMFactoryIfc aMallFactory =
      new com.dosmil_e.mall.support.MallMMFactoryStandAlone();
    theCtxt.registerFactory( aMallFactory);

    com.dosmil_e.m3.support.MMCtxtWithM3Ifc aCtxt = null;
    try { aCtxt = (com.dosmil_e.m3.support.MMCtxtWithM3Ifc) theCtxt;} catch( ClassCastException anEx) {}
    if( aCtxt == null) { return;}

    com.dosmil_e.m3.core.ifc.M3ModelIfc aM3Model = com.dosmil_e.m3.meta.M3Dynamic02.getM3Model( aCtxt);
    if( aM3Model != null) {
      aCtxt.registerModel( aM3Model);
      aCtxt.registerFactoryForModel( aM3Model, aM3Factory);
    }

    com.dosmil_e.m3.core.ifc.M3ModelIfc aMallModel = com.dosmil_e.mall.meta.Mall01.getM3Model( aCtxt);
    if( aMallModel != null) {
      aCtxt.registerModel( aMallModel);
      aCtxt.registerFactoryForModel( aMallModel, aMallFactory);
    }
  }





  protected EAIMMElementIfc sampleRoot() throws EAIException {

    EAIMMCtxtIfc aCtxt = createMMCtxt();
    if( aCtxt == null) {
      String aMMCtxtClassName = getMMCtxtClassName();
      if( aMMCtxtClassName == null) {
        aMMCtxtClassName = "null MMCtxtClassName - check program arguments";
      }
      showActionStatus( "FAILURE null Ctxt : " + aMMCtxtClassName);
      return null;
    }

    boolean aMustVisit    = getArgumentProperty("visit")    != null;
    boolean aMustBrowseM3 = getArgumentProperty("browseM3") != null;
    boolean aMustEditView = getArgumentProperty("editView") != null;


    com.dosmil_e.m3.core.ifc.M3ModelIfc                   aM3M3Model  = null;
    com.dosmil_e.m3.traversal.ifc.M3TraversalConfigIfc    aM3TravCfg  = null;

    com.dosmil_e.m3.core.ifc.M3ModelIfc                   aMallM3Model = null;
    com.dosmil_e.m3.traversal.ifc.M3TraversalConfigIfc    aMallTravCfg = null;

    if( aMustVisit || aMustBrowseM3) {
      aM3M3Model = com.dosmil_e.m3.meta.M3Dynamic02.getM3Model( aCtxt);
      aM3TravCfg = aM3M3Model.findTraversalConfigsNamed( aCtxt,
        new EAIMMName(com.dosmil_e.m3.meta.M3ReplicationConfig.gTraversalConfigName));

      aMallM3Model = com.dosmil_e.mall.meta.Mall01.getM3Model( aCtxt);
      aMallTravCfg = aMallM3Model.findTraversalConfigsNamed( aCtxt,
        new EAIMMName(com.dosmil_e.mall.meta.MallReplicationConfig.gTraversalConfigName));
    }

    com.dosmil_e.m3.withm3.ifc.MMElementWithM3Ifc aRoot = null;
    try {
      aRoot = (com.dosmil_e.m3.withm3.ifc.MMElementWithM3Ifc) aCtxt.getMMFactory( getFactoryNameForNewRoot()).createRoot( aCtxt, new EAIMMName( getNameForNewRoot()));
    } catch( ClassCastException anEx) {}
    if( aRoot == null) {
      showActionStatus( "FAILURE creating Sample Root");
      return null;
    }

    showActionStatus( "New Root SUCCESSFULLY created");

    try { aCtxt.getFlatTrxMgr().justSaved();} catch( EAIException anException) {}


    com.dosmil_e.browserbase.configs.EAIConfigIfc aConfigForM3 = getTreeConfigForM3( aCtxt);


  if( aMustVisit) {

    com.dosmil_e.m3.visit.M3TraversalCtxtIfc aTravCtxt = new com.dosmil_e.m3.visit.M3TraversalCtxt();
    com.dosmil_e.m3.visit.M3TraversalVisitor aVisitor = new com.dosmil_e.m3.visit.M3TraversalVisitor( aCtxt);

    aVisitor.visit( aCtxt, aTravCtxt, aM3TravCfg, aM3M3Model);

    java.util.Hashtable aReplicatedBySourceDict = aTravCtxt.getCommon( "ReplicatedBySource");
    if( aReplicatedBySourceDict != null) {
      Object aReplicatedSourceElementObject = aReplicatedBySourceDict.get( aMallM3Model);
      if( aReplicatedSourceElementObject != null) {
        com.dosmil_e.m3.withm3.ifc.MMElementWithM3Ifc aReplicatedSourceElement = null;
        try { aReplicatedSourceElement = (com.dosmil_e.m3.withm3.ifc.MMElementWithM3Ifc) aReplicatedSourceElementObject;} catch( ClassCastException anEx) {}
        if( aReplicatedSourceElement != null)     {
          openRootBrowserFrameClassNamed( aCtxt, aReplicatedSourceElement,
            "com.dosmil_e.m3.browser.customwindows.M3ModelBrowserFrame", aConfigForM3);
        }
      }
    }

    aTravCtxt = new com.dosmil_e.m3.visit.M3TraversalCtxt();
    aVisitor = new com.dosmil_e.m3.visit.M3TraversalVisitor( aCtxt);

    aVisitor.visit( aCtxt, aTravCtxt, aM3TravCfg, aMallM3Model);

    aReplicatedBySourceDict = aTravCtxt.getCommon( "ReplicatedBySource");
    if( aReplicatedBySourceDict != null) {
      Object aReplicatedSourceElementObject = aReplicatedBySourceDict.get( aMallM3Model);
      if( aReplicatedSourceElementObject != null) {
        com.dosmil_e.m3.withm3.ifc.MMElementWithM3Ifc aReplicatedSourceElement = null;
        try { aReplicatedSourceElement = (com.dosmil_e.m3.withm3.ifc.MMElementWithM3Ifc) aReplicatedSourceElementObject;} catch( ClassCastException anEx) {}
        if( aReplicatedSourceElement != null)     {
          openRootBrowserFrameClassNamed( aCtxt, aReplicatedSourceElement,
            "com.dosmil_e.m3.browser.customwindows.M3ModelBrowserFrame", aConfigForM3);
        }
      }
    }
  }

    if( aMustBrowseM3) {

      openRootBrowserFrameClassNamed( aCtxt, aM3M3Model, "com.dosmil_e.m3.browser.customwindows.M3ModelBrowserFrame", aConfigForM3);
      openRootBrowserFrameClassNamed( aCtxt, aM3TravCfg, "com.dosmil_e.m3.browser.customwindows.M3ModelBrowserFrame", aConfigForM3);

      openRootBrowserFrameClassNamed( aCtxt, aMallM3Model, "com.dosmil_e.m3.browser.customwindows.M3ModelBrowserFrame", aConfigForM3);
      openRootBrowserFrameClassNamed( aCtxt, aMallTravCfg, "com.dosmil_e.m3.browser.customwindows.M3ModelBrowserFrame", aConfigForM3);
    }


    if( aMustEditView) {
      com.dosmil_e.m3.traversal.ifc.M3TraversalConfigIfc aNewTravCfg =
       (com.dosmil_e.m3.traversal.ifc.M3TraversalConfigIfc) aCtxt.getMMFactory("M3").createMMElementOfType( aCtxt, "TraversalConfig", "traversal",new EAIMMName("New View"));
	  	aMallM3Model.addTraversalConfigs( aCtxt, aNewTravCfg);

      com.dosmil_e.browserbase.configs.EAIConfigIfc aConfigForM3View =
        com.dosmil_e.m3.browser.customwindows.M3PilotFrame.getTreeConfigForModelViewM3( aCtxt);

      openRootBrowserFrameClassNamed( aCtxt, aNewTravCfg, "com.dosmil_e.m3.browser.customwindows.M3ModelBrowserFrame",
        aConfigForM3View);
    }



    openRootBrowserFrame( aCtxt, aRoot);


    return aRoot;
  }




  protected void printVisitHeader( String theHeader) {
    if( com.dosmil_e.m3.traversal.impl.M3NodeMgrImpl.sDumpVisitBoundaries) {
      System.out.println();
      System.out.println();
      System.out.println("****************  Visit dump : " + theHeader);
      System.out.println();
    }
  }







  public static com.dosmil_e.browserbase.configs.EAIConfigIfc getTreeConfigForM3( EAIMMCtxtIfc theCtxt) {

    com.dosmil_e.browserbase.configs.EAIConfigIfc aOverridenConfig =
      com.dosmil_e.m3.browser.customwindows.M3PilotFrame.getTreeConfigForM3( theCtxt);
    if( aOverridenConfig == null) { return null;}

    String aName = aOverridenConfig.getNameOrUnnamed();

    com.dosmil_e.browserbase.configs.EAIConfigIfc aOverrideConfig = new EAIConfig(aName + "_OVR_aliasClassesFor_MallTraversalConfig_&_MallReplicationConfig");

    aOverrideConfig.setClassAlias(
      com.dosmil_e.mall.meta.MallTraversalConfig.class,
      theCtxt.getMMFactory("M3").getClassForType( theCtxt, "TraversalConfig", "traversal"));

    aOverrideConfig.setClassAlias(
      com.dosmil_e.mall.meta.MallReplicationConfig.class,
      theCtxt.getMMFactory("M3").getClassForType( theCtxt, "TraversalConfig", "traversal"));

    aOverrideConfig.setOverridenConfig( aOverridenConfig);

    return aOverrideConfig;
  }



}
