<template>
  <v-container fluid grid-list-md>
    <v-layout row wrap>
      <v-flex
        mx-auto
        my-12
        v-for="product in new_products"
        :key="product.productId"
      >
        <ProductComponent :product="product" :loading="loading" />
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
import ProductComponent from "../components/ProductComponent";
import { products } from "../services";

export default {
  components: {
    ProductComponent
  },
  created() {
    //todo: 신상품 일 경우 type 추가 요청
    products.fetch().then(data => {
      this.new_products = data.data;
    });
  },
  computed: {},
  data() {
    return {
      loading: false,
      new_products: []
    };
  }
};
</script>
