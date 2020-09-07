<template>
  <v-container fluid>
    <BannerView />
    <HomeTabView />
  </v-container>
</template>

<script>
import BannerView from "@/views/BannerView";
import HomeTabView from "@/views/HomeTabView";

export default {
  name: "home",
  components: {
    BannerView,
    HomeTabView
  },
  data() {
    return {};
  }
};
</script>
