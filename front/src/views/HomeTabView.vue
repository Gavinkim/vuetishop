<template>
  <v-card>
    <v-tabs
      background-color="primary accent-4"
      dark
      color="red accent-4"
      centered
      v-model="tab"
    >
      <v-tab v-for="item in items" :key="item.tab">
        <v-icon large>{{ item.icon }}</v-icon>
        <h4>{{ item.tab }}</h4>
      </v-tab>
    </v-tabs>
    <v-tabs-items v-model="tab">
      <v-tab-item v-for="item in items" :key="item.tab">
        <v-card flat>
          <v-card-text>
            <component v-bind:is="item.content"></component>
          </v-card-text>
        </v-card>
      </v-tab-item>
    </v-tabs-items>
  </v-card>
</template>

<script>
import NewView from "@/views/NewView";
import PopularView from "@/views/PopularView";
import DiscountView from "@/views/DiscountView";

export default {
  components: {
    NewView,
    PopularView,
    DiscountView
  },
  data() {
    return {
      tab: null,
      items: [
        { tab: "신규", icon: "mdi-newspaper-plus", content: NewView },
        { tab: "인기", icon: "mdi-fire", content: PopularView },
        { tab: "할인", icon: "mdi-sale", content: DiscountView }
      ]
    };
  }
};
</script>
