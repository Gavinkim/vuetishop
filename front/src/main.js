import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import vuetify from "./plugins/vuetify";
import upperFirst from "lodash/upperFirst"; //vue ui -> install new dependency lodash
import camelCase from "lodash/camelCase";

Vue.config.productionTip = false;

//Global Configuration. vue.js 공식 문서에 global 설정 부분에서 가져온 것.(Todo: 현재 버전에서는 없어도 되는것 같은데... )
const requireComponent = require.context(
  "./components",
  false,
  /Base[A-Z]\w+\.(vue|js)$/
);

requireComponent.keys().forEach(fileName => {
  const componentConfig = requireComponent(fileName);

  const componentName = upperFirst(
    camelCase(fileName.replace(/^\.\/(.*)\.\w+$/, "$1"))
  );

  Vue.component(componentName, componentConfig.default || componentConfig);
});

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount("#app");
