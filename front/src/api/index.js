import axios from "axios";
//import router from "../router";

const DOMAIN = "https://banchango.herokuapp.com/api";
//const UNAUTHORIZED = 400;
const DEFAULT_TIMEOUT = 10000;

// function onUnauthorized() {
//   console.log("UNAUTHORIZED");
//   router.push("/login");
// }

export const request = (method, url, data) => {
  return axios({
    method,
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json"
    },
    withCredentials: false, // This is the default
    timeout: DEFAULT_TIMEOUT,
    url: DOMAIN + url,
    data
  })
    .then(result => result.data)
    .catch(result => {
      // todo: status undefined 라고 나옴, 해결후 onUnauthorized 사용
      // const { status } = result.response;
      // if (status === UNAUTHORIZED) return onUnauthorized();
      throw Error(result);
    });
};
