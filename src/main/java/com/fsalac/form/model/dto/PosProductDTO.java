package com.fsalac.form.model.dto;

import java.util.LinkedList;
import java.util.List;

import com.fsalac.form.model.PosProduct;

/**
 *
 * @author fsalac
 */
public class PosProductDTO extends ModelObjectDTO {
	
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String productName;
    private Double price;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	public static PosProductDTO valueOf(PosProduct posProduct){
		PosProductDTO posProductDTO = new PosProductDTO();
		posProductDTO.setId(posProduct.getId());
		posProductDTO.setProductName(posProduct.getProductName());
		posProductDTO.setPrice(posProduct.getCatalogPrice());
		return posProductDTO;
	}
	
	public static List<PosProductDTO> valueOf(List<PosProduct> posProducts){
		List<PosProductDTO> posProductsDTO = new LinkedList<PosProductDTO>();
		for (PosProduct posProduct : posProducts) {
			posProductsDTO.add(valueOf(posProduct));
		}
		return posProductsDTO;
	}
}