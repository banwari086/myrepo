package com.sunilos.proj0.dto;

public class GenricDTO<T extends BaseDTO> {
T dto;
int pageNo;
int pageSize;
public T getDto() {
	return dto;
}
public void setDto(T dto) {
	this.dto = dto;
}
public int getPageNo() {
	return pageNo;
}
public void setPageNo(int pageNo) {
	this.pageNo = pageNo;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}

}
