import Vue from "vue";
import Vuetify from "vuetify/lib";

Vue.use(Vuetify);

export default new Vuetify({
  theme: {
    //참고: https://vuetifyjs.com/ko/styles/colors/
    themes: {
      light: {
        primary: "#00B0FF", //light-blue accent-3
        secondary: "#b0bec5",
        accent: "#8c9eff",
        error: "#b71c1c"
      }
    }
  }
});
