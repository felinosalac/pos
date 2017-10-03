package com.fsalac.form.model.dto;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.fsalac.form.model.PosCustomer;
import com.fsalac.form.model.PosOrder;
import com.fsalac.form.model.PosProduct;

/**
 *
 * @author fsalac
 */
public class PosOrderDTO extends ModelObjectDTO {
	
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private Long productId;
    private String productName;
    private Long customerId;
    private String customerName;
	
	public static PosOrderDTO valueOf(PosOrder posOrder){
		
		PosOrderDTO posOrderDTO = new PosOrderDTO();
		posOrderDTO.setId(posOrder.getId());
		
		PosProduct product = posOrder.getProduct();
		posOrderDTO.setProductId(product.getId());
		posOrderDTO.setProductName(product.getProductName());
		
		PosCustomer customer = posOrder.getCustomer();
		posOrderDTO.setCustomerId(customer.getId());
		posOrderDTO.setCustomerName(customer.getFullName());
		
		return posOrderDTO;
	}
	
	public static List<PosOrderDTO> valueOf(List<PosOrder> posOrders){
		
		List<PosOrderDTO> posOrdersDTO = new LinkedList<PosOrderDTO>();
		
		for (PosOrder posOrder : posOrders) {
			posOrdersDTO.add(valueOf(posOrder));
		}
		return posOrdersDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}