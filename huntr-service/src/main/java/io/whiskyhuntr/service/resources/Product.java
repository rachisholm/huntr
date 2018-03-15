package io.whiskyhuntr.service.resources;

import lombok.Data;

@Data

public class Product {
	private int id;
	private int storeId;
	private String name;
	private String productPath;
	private String htmlTargetId;
	private String htmlTargetClass;

}
