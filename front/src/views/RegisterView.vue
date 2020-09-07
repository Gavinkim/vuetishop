<template>
  <v-container>
    <v-row>
      <v-col>
        <v-card width="500" class="mx-auto mt-5 ma-3">
          <v-card-title>
            <h1 class="headline primary--text">회원가입</h1>
          </v-card-title>
          <v-card-text>
            <v-form ref="registerForm" v-model="formValidity">
              <v-text-field
                prepend-icon="mdi-account"
                label="사용자이름"
                v-model="username"
                :rules="usernameRules"
                :counter="20"
                required
              />
              <v-text-field
                prepend-icon="mdi-email"
                label="이메일"
                type="email"
                v-model="email"
                :rules="emailRules"
                required
              />
              <v-text-field
                prepend-icon="mdi-cellphone"
                label="전화번호"
                type="tel"
                v-model="phone"
              />
              <v-text-field
                label="패스워드"
                :type="showPassword ? 'text' : 'password'"
                prepend-icon="mdi-lock"
                :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
                @click:append="showPassword = !showPassword"
                v-model="password"
              />
              <v-text-field
                label="패스워드 확인"
                :type="showPassword ? 'text' : 'password'"
                prepend-icon="mdi-lock"
                v-model="repassword"
              />
              <v-autocomplete
                label="좋아하는 반찬 종류 한가지를 선택 해주세요"
                :items="likes"
              />
              <v-file-input
                label="프로필 이미지를 선택해주세요."
              ></v-file-input>
              <v-checkbox
                label="회원가입 약관에 동의 합니다."
                v-model="agreeToTerms"
                :rules="agreeToTermsRules"
                required
              ></v-checkbox>
              <v-divider></v-divider>
              <v-card-actions>
                <v-btn
                  color="success"
                  type="submit"
                  class="mr-4"
                  :disabled="!formValidity"
                  @click="register"
                  >완료</v-btn
                >
                <v-spacer></v-spacer>
              </v-card-actions>
            </v-form>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    showPassword: false,
    agreeToTerms: false,
    phone: "",
    password: "",
    repassword: "",
    username: "",
    usernameRules: [
      v => !!v || "사용자 이름은 필수 입니다.",
      v => v.length <= 20 || "사용자 이름은 20 자 이내로 입력해주세요."
    ],
    agreeToTermsRules: [value => !!value || "회원정보 제공 동의"],
    likes: ["육류", "채소", "해산물"],
    email: "",
    emailRules: [
      value => !!value || "이메일은 필수 입니다.",
      value => value.indexOf("@") !== 0 || "옳바른 이메일 형식이 아닙니다.",
      value => value.includes("@") || "옳바른 이메일 형식이 아닙니다.",
      value =>
        value.indexOf(".") - value.indexOf("@") > 1 ||
        "옳바른 이메일 형식이 아닙니다.",
      value => value.includes(".") || "옳바른 이메일 형식이 아닙니다.",
      value =>
        value.indexOf(".") <= value.length - 3 ||
        "옳바른 이메일 형식이 아닙니다."
    ],
    formValidity: false
  }),
  methods: {
    register() {
      this.validateForm();
      this.$router.push("/login");
    },
    validateForm() {
      this.$refs.registerForm.validate();
    }
  }
};
</script>
