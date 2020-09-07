<template>
  <div class="nav" id="nav">
    <v-navigation-drawer v-model="drawer" app color="primary" dark>
      <v-list dense>
        <v-list-item
          v-for="link in links"
          :key="`${link.url}-header-link`"
          :to="link.url"
        >
          <v-list-item-action>
            <v-icon>{{ link.icon }}</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>{{ link.label }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar app color="primary" dark>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-spacer></v-spacer>
      <v-btn v-show="drawer"
        v-for="link in links"
        :key="`${link.label}-header-link`"
        text
        rounded
        :to="link.url"
        >{{ link.label }}
      </v-btn>
    </v-app-bar>
  </div>
</template>

<script>
export default {
  name: "NavBar",
  data: () => ({
    drawer: false,
    links: [
      {
        label: "홈",
        icon: "mdi-home",
        url: "/"
      },
      {
        label: "신규",
        icon: "mdi-newspaper-plus",
        url: "/newproduct"
      },
      {
        label: "인기",
        icon: "mdi-fire",
        url: "/popular"
      },
      {
        label: "할인",
        icon: "mdi-sale",
        url: "/discount"
      },
      {
        label: "로그인",
        icon: "mdi-login",
        url: "/login"
      }
    ]
  })
};
</script>

<style scoped></style>
