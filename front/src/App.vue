<template>
  <v-app id="inspire">
    <NavBar />
    <v-main>
      <router-view />
    </v-main>
    <v-footer color="primary" app dark>
      <span class="white--text">
        {{ new Date().getFullYear() }} &copy; BanchanGo Copyright
      </span>
    </v-footer>
  </v-app>
</template>

<script>
import NavBar from "./views/NavBar";

export default {
  name: "App",
  components: {
    NavBar
  }
};
</script>

<style scoped></style>
