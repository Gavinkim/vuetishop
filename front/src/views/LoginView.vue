<template>
  <v-card width="400" class="mx-auto mt-5 ma-3">
    <v-card-title>
      <h1 class="headline primary--text">로그인</h1>
    </v-card-title>
    <v-card-text>
      <v-form>
        <v-text-field label="email" prepend-icon="mdi-email" />
        <v-text-field
          label="Password"
          :type="showPassword ? 'text' : 'password'"
          prepend-icon="mdi-lock"
          :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
          @click:append="showPassword = !showPassword"
        />
      </v-form>
    </v-card-text>
    <v-divider></v-divider>
    <v-card-actions>
      <v-btn color="#00B0FF" dark>로그인</v-btn>
      <v-spacer></v-spacer>
      <v-btn color="#00B0FF" dark link router :to="{ name: 'register' }"
        >회원가입</v-btn
      >
    </v-card-actions>
  </v-card>
</template>

<script>
export default {
  name: "login",
  data() {
    return {
      showPassword: false
    };
  }
};
</script>
