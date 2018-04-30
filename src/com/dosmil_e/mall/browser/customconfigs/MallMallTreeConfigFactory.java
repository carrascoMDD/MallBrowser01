package com.dosmil_e.mall.browser.customconfigs;

// WholeTreeConfigFactory

import com.dosmil_e.browserbase.shell.*;
import com.dosmil_e.browserbase.tree.EAITreeModel;
import com.dosmil_e.browserbase.tree.EAITreeCellRenderer;

import com.dosmil_e.modelbase.support.EAIMMCtxtIfc;

import com.dosmil_e.browserbase.configs.*;

import com.dosmil_e.modelbase.ifc.*;

import java.util.Hashtable;


public class MallMallTreeConfigFactory {

  public static EAIConfig     gConfig;
  public static Class         gCtxtClass;


  /*******************************************************
   *  Static members holding Node and Branch Managers
   *******************************************************/

	public static com.dosmil_e.mall.core.custommgrs.MallAddressNMgr aAddressNMgr  = new com.dosmil_e.mall.core.custommgrs.MallAddressNMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallAddress_shippingsBMgr aAddress_shippingsBMgr  = new com.dosmil_e.mall.core.custommgrs.MallAddress_shippingsBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallContactNMgr aContactNMgr  = new com.dosmil_e.mall.core.custommgrs.MallContactNMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallContact_shippingsBMgr aContact_shippingsBMgr  = new com.dosmil_e.mall.core.custommgrs.MallContact_shippingsBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallDeliveryServiceNMgr aDeliveryServiceNMgr  = new com.dosmil_e.mall.core.custommgrs.MallDeliveryServiceNMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallDeliveryService_shippingsBMgr aDeliveryService_shippingsBMgr  = new com.dosmil_e.mall.core.custommgrs.MallDeliveryService_shippingsBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallShippingNMgr aShippingNMgr  = new com.dosmil_e.mall.core.custommgrs.MallShippingNMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallShipping_deliveryServiceBMgr aShipping_deliveryServiceBMgr  = new com.dosmil_e.mall.core.custommgrs.MallShipping_deliveryServiceBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallShipping_contactBMgr aShipping_contactBMgr  = new com.dosmil_e.mall.core.custommgrs.MallShipping_contactBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallShipping_addressBMgr aShipping_addressBMgr  = new com.dosmil_e.mall.core.custommgrs.MallShipping_addressBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallMallNMgr aMallNMgr  = new com.dosmil_e.mall.core.custommgrs.MallMallNMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallMall_vendorsBMgr aMall_vendorsBMgr  = new com.dosmil_e.mall.core.custommgrs.MallMall_vendorsBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallMall_deliveryServicesBMgr aMall_deliveryServicesBMgr  = new com.dosmil_e.mall.core.custommgrs.MallMall_deliveryServicesBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallMall_partiesBMgr aMall_partiesBMgr  = new com.dosmil_e.mall.core.custommgrs.MallMall_partiesBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallPartyNMgr aPartyNMgr  = new com.dosmil_e.mall.core.custommgrs.MallPartyNMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallParty_customersBMgr aParty_customersBMgr  = new com.dosmil_e.mall.core.custommgrs.MallParty_customersBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallParty_contactsBMgr aParty_contactsBMgr  = new com.dosmil_e.mall.core.custommgrs.MallParty_contactsBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallParty_addressesBMgr aParty_addressesBMgr  = new com.dosmil_e.mall.core.custommgrs.MallParty_addressesBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallPaymentNMgr aPaymentNMgr  = new com.dosmil_e.mall.core.custommgrs.MallPaymentNMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallInvoiceLineNMgr aInvoiceLineNMgr  = new com.dosmil_e.mall.core.custommgrs.MallInvoiceLineNMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallInvoiceLine_purchaseOrderLineBMgr aInvoiceLine_purchaseOrderLineBMgr  = new com.dosmil_e.mall.core.custommgrs.MallInvoiceLine_purchaseOrderLineBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallPurchaseOrderLineNMgr aPurchaseOrderLineNMgr  = new com.dosmil_e.mall.core.custommgrs.MallPurchaseOrderLineNMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallPurchaseOrderLine_productBMgr aPurchaseOrderLine_productBMgr  = new com.dosmil_e.mall.core.custommgrs.MallPurchaseOrderLine_productBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallPurchaseOrderLine_invoiceLineBMgr aPurchaseOrderLine_invoiceLineBMgr  = new com.dosmil_e.mall.core.custommgrs.MallPurchaseOrderLine_invoiceLineBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallInvoiceNMgr aInvoiceNMgr  = new com.dosmil_e.mall.core.custommgrs.MallInvoiceNMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallInvoice_invoiceLinesBMgr aInvoice_invoiceLinesBMgr  = new com.dosmil_e.mall.core.custommgrs.MallInvoice_invoiceLinesBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallInvoice_purchaseOrderBMgr aInvoice_purchaseOrderBMgr  = new com.dosmil_e.mall.core.custommgrs.MallInvoice_purchaseOrderBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallInvoice_paymentBMgr aInvoice_paymentBMgr  = new com.dosmil_e.mall.core.custommgrs.MallInvoice_paymentBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallInvoice_shippingBMgr aInvoice_shippingBMgr  = new com.dosmil_e.mall.core.custommgrs.MallInvoice_shippingBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallPurchaseOrderNMgr aPurchaseOrderNMgr  = new com.dosmil_e.mall.core.custommgrs.MallPurchaseOrderNMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallPurchaseOrder_purchaseOrderLinesBMgr aPurchaseOrder_purchaseOrderLinesBMgr  = new com.dosmil_e.mall.core.custommgrs.MallPurchaseOrder_purchaseOrderLinesBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallPurchaseOrder_invoicesBMgr aPurchaseOrder_invoicesBMgr  = new com.dosmil_e.mall.core.custommgrs.MallPurchaseOrder_invoicesBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallProductNMgr aProductNMgr  = new com.dosmil_e.mall.core.custommgrs.MallProductNMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallProduct_purchaseOrderLinesBMgr aProduct_purchaseOrderLinesBMgr  = new com.dosmil_e.mall.core.custommgrs.MallProduct_purchaseOrderLinesBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallCustomerNMgr aCustomerNMgr  = new com.dosmil_e.mall.core.custommgrs.MallCustomerNMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallCustomer_purchaseOrdersBMgr aCustomer_purchaseOrdersBMgr  = new com.dosmil_e.mall.core.custommgrs.MallCustomer_purchaseOrdersBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallCustomer_partyBMgr aCustomer_partyBMgr  = new com.dosmil_e.mall.core.custommgrs.MallCustomer_partyBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallCustomer_invoicesBMgr aCustomer_invoicesBMgr  = new com.dosmil_e.mall.core.custommgrs.MallCustomer_invoicesBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallVendorNMgr aVendorNMgr  = new com.dosmil_e.mall.core.custommgrs.MallVendorNMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallVendor_productsBMgr aVendor_productsBMgr  = new com.dosmil_e.mall.core.custommgrs.MallVendor_productsBMgr();

	public static com.dosmil_e.mall.core.custommgrs.MallVendor_customersBMgr aVendor_customersBMgr  = new com.dosmil_e.mall.core.custommgrs.MallVendor_customersBMgr();



  public MallMallTreeConfigFactory() {
  }


  public static EAIConfig getConfig( EAIMMCtxtIfc theCtxt) {
    if( theCtxt == null) { return null;}
    if( gConfig == null) {
      initConfig( theCtxt);
    }
    Class aClass = theCtxt.getClass();
    if( gCtxtClass == null || aClass != gCtxtClass) {
      gConfig    = null;
      gCtxtClass = null;
      initConfig( theCtxt);
    }

    return gConfig;
  }






  public static EAIConfig initConfig( EAIMMCtxtIfc theCtxt) {

    gConfig     = new EAIConfig( "MallMallTreeConfigFactory");
    gCtxtClass  = theCtxt.getClass();

  /*******************************************************
   *  Root node configs
   *******************************************************/

		EAIClassRootNodeConfigIfc     aRootAddressRNC = new EAIClassRootNodeConfig( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Address", "core"), aAddressNMgr, null);
		gConfig.addClassRootNodeConfig( aRootAddressRNC);

		EAIClassRootNodeConfigIfc     aRootContactRNC = new EAIClassRootNodeConfig( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Contact", "core"), aContactNMgr, null);
		gConfig.addClassRootNodeConfig( aRootContactRNC);

		EAIClassRootNodeConfigIfc     aRootDeliveryServiceRNC = new EAIClassRootNodeConfig( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "DeliveryService", "core"), aDeliveryServiceNMgr, null);
		gConfig.addClassRootNodeConfig( aRootDeliveryServiceRNC);

		EAIClassRootNodeConfigIfc     aRootShippingRNC = new EAIClassRootNodeConfig( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Shipping", "core"), aShippingNMgr, null);
		gConfig.addClassRootNodeConfig( aRootShippingRNC);

		EAIClassRootNodeConfigIfc     aRootMallRNC = new EAIClassRootNodeConfig( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Mall", "core"), aMallNMgr, null);
		gConfig.addClassRootNodeConfig( aRootMallRNC);

		EAIClassRootNodeConfigIfc     aRootPartyRNC = new EAIClassRootNodeConfig( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Party", "core"), aPartyNMgr, null);
		gConfig.addClassRootNodeConfig( aRootPartyRNC);

		EAIClassRootNodeConfigIfc     aRootPaymentRNC = new EAIClassRootNodeConfig( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Payment", "core"), aPaymentNMgr, null);
		gConfig.addClassRootNodeConfig( aRootPaymentRNC);

		EAIClassRootNodeConfigIfc     aRootInvoiceLineRNC = new EAIClassRootNodeConfig( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "InvoiceLine", "core"), aInvoiceLineNMgr, null);
		gConfig.addClassRootNodeConfig( aRootInvoiceLineRNC);

		EAIClassRootNodeConfigIfc     aRootPurchaseOrderLineRNC = new EAIClassRootNodeConfig( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "PurchaseOrderLine", "core"), aPurchaseOrderLineNMgr, null);
		gConfig.addClassRootNodeConfig( aRootPurchaseOrderLineRNC);

		EAIClassRootNodeConfigIfc     aRootInvoiceRNC = new EAIClassRootNodeConfig( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Invoice", "core"), aInvoiceNMgr, null);
		gConfig.addClassRootNodeConfig( aRootInvoiceRNC);

		EAIClassRootNodeConfigIfc     aRootPurchaseOrderRNC = new EAIClassRootNodeConfig( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "PurchaseOrder", "core"), aPurchaseOrderNMgr, null);
		gConfig.addClassRootNodeConfig( aRootPurchaseOrderRNC);

		EAIClassRootNodeConfigIfc     aRootProductRNC = new EAIClassRootNodeConfig( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Product", "core"), aProductNMgr, null);
		gConfig.addClassRootNodeConfig( aRootProductRNC);

		EAIClassRootNodeConfigIfc     aRootCustomerRNC = new EAIClassRootNodeConfig( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Customer", "core"), aCustomerNMgr, null);
		gConfig.addClassRootNodeConfig( aRootCustomerRNC);

		EAIClassRootNodeConfigIfc     aRootVendorRNC = new EAIClassRootNodeConfig( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Vendor", "core"), aVendorNMgr, null);
		gConfig.addClassRootNodeConfig( aRootVendorRNC);




  /*******************************************************
   *  Node and Branch configs
   *******************************************************/

		EAINodeBranchesConfigIfc aAddressNBC  = new EAINodeBranchesConfig( aAddressNMgr);
		aAddressNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aAddress_shippingsBMgr, null));
		gConfig.addNodeBranchesConfig( aAddressNBC);

		EAIBranchClassNodesConfigIfc  aAddress_shippingsBCNC  = new EAIBranchClassNodesConfig( aAddress_shippingsBMgr);
		aAddress_shippingsBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Shipping","core"), aShippingNMgr, null ));
		gConfig.addBranchClassNodesConfig( aAddress_shippingsBCNC);

		EAINodeBranchesConfigIfc aContactNBC  = new EAINodeBranchesConfig( aContactNMgr);
		aContactNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aContact_shippingsBMgr, null));
		gConfig.addNodeBranchesConfig( aContactNBC);

		EAIBranchClassNodesConfigIfc  aContact_shippingsBCNC  = new EAIBranchClassNodesConfig( aContact_shippingsBMgr);
		aContact_shippingsBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Shipping","core"), aShippingNMgr, null ));
		gConfig.addBranchClassNodesConfig( aContact_shippingsBCNC);

		EAINodeBranchesConfigIfc aDeliveryServiceNBC  = new EAINodeBranchesConfig( aDeliveryServiceNMgr);
		aDeliveryServiceNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aDeliveryService_shippingsBMgr, null));
		gConfig.addNodeBranchesConfig( aDeliveryServiceNBC);

		EAIBranchClassNodesConfigIfc  aDeliveryService_shippingsBCNC  = new EAIBranchClassNodesConfig( aDeliveryService_shippingsBMgr);
		aDeliveryService_shippingsBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Shipping","core"), aShippingNMgr, null ));
		gConfig.addBranchClassNodesConfig( aDeliveryService_shippingsBCNC);

		EAINodeBranchesConfigIfc aShippingNBC  = new EAINodeBranchesConfig( aShippingNMgr);
		aShippingNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aShipping_addressBMgr, null));
		aShippingNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aShipping_contactBMgr, null));
		aShippingNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aShipping_deliveryServiceBMgr, null));
		gConfig.addNodeBranchesConfig( aShippingNBC);

		EAIBranchClassNodesConfigIfc  aShipping_deliveryServiceBCNC  = new EAIBranchClassNodesConfig( aShipping_deliveryServiceBMgr);
		aShipping_deliveryServiceBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "DeliveryService","core"), aDeliveryServiceNMgr, null ));
		gConfig.addBranchClassNodesConfig( aShipping_deliveryServiceBCNC);

		EAIBranchClassNodesConfigIfc  aShipping_contactBCNC  = new EAIBranchClassNodesConfig( aShipping_contactBMgr);
		aShipping_contactBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Contact","core"), aContactNMgr, null ));
		gConfig.addBranchClassNodesConfig( aShipping_contactBCNC);

		EAIBranchClassNodesConfigIfc  aShipping_addressBCNC  = new EAIBranchClassNodesConfig( aShipping_addressBMgr);
		aShipping_addressBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Address","core"), aAddressNMgr, null ));
		gConfig.addBranchClassNodesConfig( aShipping_addressBCNC);

		EAINodeBranchesConfigIfc aMallNBC  = new EAINodeBranchesConfig( aMallNMgr);
		aMallNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aMall_deliveryServicesBMgr, null));
		aMallNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aMall_partiesBMgr, null));
		aMallNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aMall_vendorsBMgr, null));
		gConfig.addNodeBranchesConfig( aMallNBC);

		EAIBranchClassNodesConfigIfc  aMall_vendorsBCNC  = new EAIBranchClassNodesConfig( aMall_vendorsBMgr);
		aMall_vendorsBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Vendor","core"), aVendorNMgr, null ));
		gConfig.addBranchClassNodesConfig( aMall_vendorsBCNC);

		EAIBranchClassNodesConfigIfc  aMall_deliveryServicesBCNC  = new EAIBranchClassNodesConfig( aMall_deliveryServicesBMgr);
		aMall_deliveryServicesBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "DeliveryService","core"), aDeliveryServiceNMgr, null ));
		gConfig.addBranchClassNodesConfig( aMall_deliveryServicesBCNC);

		EAIBranchClassNodesConfigIfc  aMall_partiesBCNC  = new EAIBranchClassNodesConfig( aMall_partiesBMgr);
		aMall_partiesBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Party","core"), aPartyNMgr, null ));
		gConfig.addBranchClassNodesConfig( aMall_partiesBCNC);

		EAINodeBranchesConfigIfc aPartyNBC  = new EAINodeBranchesConfig( aPartyNMgr);
		aPartyNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aParty_addressesBMgr, null));
		aPartyNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aParty_contactsBMgr, null));
		aPartyNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aParty_customersBMgr, null));
		gConfig.addNodeBranchesConfig( aPartyNBC);

		EAIBranchClassNodesConfigIfc  aParty_customersBCNC  = new EAIBranchClassNodesConfig( aParty_customersBMgr);
		aParty_customersBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Customer","core"), aCustomerNMgr, null ));
		gConfig.addBranchClassNodesConfig( aParty_customersBCNC);

		EAIBranchClassNodesConfigIfc  aParty_contactsBCNC  = new EAIBranchClassNodesConfig( aParty_contactsBMgr);
		aParty_contactsBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Contact","core"), aContactNMgr, null ));
		gConfig.addBranchClassNodesConfig( aParty_contactsBCNC);

		EAIBranchClassNodesConfigIfc  aParty_addressesBCNC  = new EAIBranchClassNodesConfig( aParty_addressesBMgr);
		aParty_addressesBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Address","core"), aAddressNMgr, null ));
		gConfig.addBranchClassNodesConfig( aParty_addressesBCNC);

		EAINodeBranchesConfigIfc aPaymentNBC  = new EAINodeBranchesConfig( aPaymentNMgr);
		gConfig.addNodeBranchesConfig( aPaymentNBC);

		EAINodeBranchesConfigIfc aInvoiceLineNBC  = new EAINodeBranchesConfig( aInvoiceLineNMgr);
		aInvoiceLineNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aInvoiceLine_purchaseOrderLineBMgr, null));
		gConfig.addNodeBranchesConfig( aInvoiceLineNBC);

		EAIBranchClassNodesConfigIfc  aInvoiceLine_purchaseOrderLineBCNC  = new EAIBranchClassNodesConfig( aInvoiceLine_purchaseOrderLineBMgr);
		aInvoiceLine_purchaseOrderLineBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "PurchaseOrderLine","core"), aPurchaseOrderLineNMgr, null ));
		gConfig.addBranchClassNodesConfig( aInvoiceLine_purchaseOrderLineBCNC);

		EAINodeBranchesConfigIfc aPurchaseOrderLineNBC  = new EAINodeBranchesConfig( aPurchaseOrderLineNMgr);
		aPurchaseOrderLineNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aPurchaseOrderLine_invoiceLineBMgr, null));
		aPurchaseOrderLineNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aPurchaseOrderLine_productBMgr, null));
		gConfig.addNodeBranchesConfig( aPurchaseOrderLineNBC);

		EAIBranchClassNodesConfigIfc  aPurchaseOrderLine_productBCNC  = new EAIBranchClassNodesConfig( aPurchaseOrderLine_productBMgr);
		aPurchaseOrderLine_productBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Product","core"), aProductNMgr, null ));
		gConfig.addBranchClassNodesConfig( aPurchaseOrderLine_productBCNC);

		EAIBranchClassNodesConfigIfc  aPurchaseOrderLine_invoiceLineBCNC  = new EAIBranchClassNodesConfig( aPurchaseOrderLine_invoiceLineBMgr);
		aPurchaseOrderLine_invoiceLineBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "InvoiceLine","core"), aInvoiceLineNMgr, null ));
		gConfig.addBranchClassNodesConfig( aPurchaseOrderLine_invoiceLineBCNC);

		EAINodeBranchesConfigIfc aInvoiceNBC  = new EAINodeBranchesConfig( aInvoiceNMgr);
		aInvoiceNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aInvoice_invoiceLinesBMgr, null));
		aInvoiceNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aInvoice_paymentBMgr, null));
		aInvoiceNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aInvoice_purchaseOrderBMgr, null));
		aInvoiceNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aInvoice_shippingBMgr, null));
		gConfig.addNodeBranchesConfig( aInvoiceNBC);

		EAIBranchClassNodesConfigIfc  aInvoice_invoiceLinesBCNC  = new EAIBranchClassNodesConfig( aInvoice_invoiceLinesBMgr);
		aInvoice_invoiceLinesBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "InvoiceLine","core"), aInvoiceLineNMgr, null ));
		gConfig.addBranchClassNodesConfig( aInvoice_invoiceLinesBCNC);

		EAIBranchClassNodesConfigIfc  aInvoice_purchaseOrderBCNC  = new EAIBranchClassNodesConfig( aInvoice_purchaseOrderBMgr);
		aInvoice_purchaseOrderBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "PurchaseOrder","core"), aPurchaseOrderNMgr, null ));
		gConfig.addBranchClassNodesConfig( aInvoice_purchaseOrderBCNC);

		EAIBranchClassNodesConfigIfc  aInvoice_paymentBCNC  = new EAIBranchClassNodesConfig( aInvoice_paymentBMgr);
		aInvoice_paymentBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Payment","core"), aPaymentNMgr, null ));
		gConfig.addBranchClassNodesConfig( aInvoice_paymentBCNC);

		EAIBranchClassNodesConfigIfc  aInvoice_shippingBCNC  = new EAIBranchClassNodesConfig( aInvoice_shippingBMgr);
		aInvoice_shippingBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Shipping","core"), aShippingNMgr, null ));
		gConfig.addBranchClassNodesConfig( aInvoice_shippingBCNC);

		EAINodeBranchesConfigIfc aPurchaseOrderNBC  = new EAINodeBranchesConfig( aPurchaseOrderNMgr);
		aPurchaseOrderNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aPurchaseOrder_invoicesBMgr, null));
		aPurchaseOrderNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aPurchaseOrder_purchaseOrderLinesBMgr, null));
		gConfig.addNodeBranchesConfig( aPurchaseOrderNBC);

		EAIBranchClassNodesConfigIfc  aPurchaseOrder_purchaseOrderLinesBCNC  = new EAIBranchClassNodesConfig( aPurchaseOrder_purchaseOrderLinesBMgr);
		aPurchaseOrder_purchaseOrderLinesBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "PurchaseOrderLine","core"), aPurchaseOrderLineNMgr, null ));
		gConfig.addBranchClassNodesConfig( aPurchaseOrder_purchaseOrderLinesBCNC);

		EAIBranchClassNodesConfigIfc  aPurchaseOrder_invoicesBCNC  = new EAIBranchClassNodesConfig( aPurchaseOrder_invoicesBMgr);
		aPurchaseOrder_invoicesBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Invoice","core"), aInvoiceNMgr, null ));
		gConfig.addBranchClassNodesConfig( aPurchaseOrder_invoicesBCNC);

		EAINodeBranchesConfigIfc aProductNBC  = new EAINodeBranchesConfig( aProductNMgr);
		aProductNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aProduct_purchaseOrderLinesBMgr, null));
		gConfig.addNodeBranchesConfig( aProductNBC);

		EAIBranchClassNodesConfigIfc  aProduct_purchaseOrderLinesBCNC  = new EAIBranchClassNodesConfig( aProduct_purchaseOrderLinesBMgr);
		aProduct_purchaseOrderLinesBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "PurchaseOrderLine","core"), aPurchaseOrderLineNMgr, null ));
		gConfig.addBranchClassNodesConfig( aProduct_purchaseOrderLinesBCNC);

		EAINodeBranchesConfigIfc aCustomerNBC  = new EAINodeBranchesConfig( aCustomerNMgr);
		aCustomerNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aCustomer_invoicesBMgr, null));
		aCustomerNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aCustomer_partyBMgr, null));
		aCustomerNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aCustomer_purchaseOrdersBMgr, null));
		gConfig.addNodeBranchesConfig( aCustomerNBC);

		EAIBranchClassNodesConfigIfc  aCustomer_purchaseOrdersBCNC  = new EAIBranchClassNodesConfig( aCustomer_purchaseOrdersBMgr);
		aCustomer_purchaseOrdersBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "PurchaseOrder","core"), aPurchaseOrderNMgr, null ));
		gConfig.addBranchClassNodesConfig( aCustomer_purchaseOrdersBCNC);

		EAIBranchClassNodesConfigIfc  aCustomer_partyBCNC  = new EAIBranchClassNodesConfig( aCustomer_partyBMgr);
		aCustomer_partyBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Party","core"), aPartyNMgr, null ));
		gConfig.addBranchClassNodesConfig( aCustomer_partyBCNC);

		EAIBranchClassNodesConfigIfc  aCustomer_invoicesBCNC  = new EAIBranchClassNodesConfig( aCustomer_invoicesBMgr);
		aCustomer_invoicesBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Invoice","core"), aInvoiceNMgr, null ));
		gConfig.addBranchClassNodesConfig( aCustomer_invoicesBCNC);

		EAINodeBranchesConfigIfc aVendorNBC  = new EAINodeBranchesConfig( aVendorNMgr);
		aVendorNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aVendor_customersBMgr, null));
		aVendorNBC.addBranchConfigOverride( new EAIBranchConfigOverride( aVendor_productsBMgr, null));
		gConfig.addNodeBranchesConfig( aVendorNBC);

		EAIBranchClassNodesConfigIfc  aVendor_productsBCNC  = new EAIBranchClassNodesConfig( aVendor_productsBMgr);
		aVendor_productsBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Product","core"), aProductNMgr, null ));
		gConfig.addBranchClassNodesConfig( aVendor_productsBCNC);

		EAIBranchClassNodesConfigIfc  aVendor_customersBCNC  = new EAIBranchClassNodesConfig( aVendor_customersBMgr);
		aVendor_customersBCNC.addClassNodeConfigOverride( new EAIClassNodeConfigOverride( theCtxt.getMMFactory("Mall").getClassForType( theCtxt, "Customer","core"), aCustomerNMgr, null ));
		gConfig.addBranchClassNodesConfig( aVendor_customersBCNC);





    return gConfig;
  }

}
