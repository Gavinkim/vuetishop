import { request } from "../api";

export const products = {
  fetch() {
    return request("get", "/products");
  }
};

export const banners = {
  fetch() {
    return request("get", "/banners");
  }
};

export const product_detail = {
  fetch(id) {
    //todo: 상품 아이디를 넘겨주도록 한다.
    return request("get", "/products/detail/" + id);
  }
};
