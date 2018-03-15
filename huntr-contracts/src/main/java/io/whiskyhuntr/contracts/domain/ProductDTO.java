package io.whiskyhuntr.contracts.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	private int id;
	private int storeId;
	private String name;
	private String productPath;
	private String htmlTargetId;
	private String htmlTargetClass;

}
