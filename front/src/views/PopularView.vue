<template>
  <v-container fluid grid-list-md>
    <v-layout row wrap>
      <v-flex
        mx-auto
        my-12
        v-for="product in popular_products"
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
    products.fetch().then(data => {
      this.popular_products = data.data;
    });
  },
  computed: {},
  data() {
    return {
      loading: false,
      popular_products: []
    };
  }
};
</script>
