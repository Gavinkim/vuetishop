<template>
  <v-container fluid grid-list-md>
    <v-layout row wrap>
      <v-flex
        mx-auto
        my-12
        v-for="product in discount_products"
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
  computed: {},
  created() {
    products.fetch().then(data => {
      this.discount_products = data.data;
    });
  },
  data() {
    return {
      loading: false,
      discount_products: []
    };
  }
};
</script>
