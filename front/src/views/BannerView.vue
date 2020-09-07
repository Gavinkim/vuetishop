<!--<template>-->
<!--    <v-container fluid grid-list-md>-->
<!--        <v-carousel :show-arrows="false">-->
<!--            <v-carousel-item-->
<!--                    v-for="(item, i) in items"-->
<!--                    :key="i"-->
<!--                    :src="item.src"-->
<!--            ></v-carousel-item>-->
<!--        </v-carousel>-->
<!--    </v-container>-->
<!--</template>-->

<template>
  <v-carousel
    :show-arrows="true"
    cycle
    height="300"
    delimiter-icon="mdi-minus"
    hide-delimiter-background
  >
    <v-carousel-item
      v-for="(banner, i) in banners"
      :key="i"
      :src="banner.image"
    ></v-carousel-item>
  </v-carousel>
</template>

<script>
import { banners } from "../services";

export default {
  created() {
    banners.fetch().then(data => {
      this.banners = data.data;
    });
  },
  data() {
    return {
      banners: []
    };
  }
};
</script>
