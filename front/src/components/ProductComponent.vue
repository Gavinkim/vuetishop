<template>
    <v-main>
        <v-card
                class="pa-2"
                max-width="450"
                :loading="loading"
        >
            <router-link :to="{ name: 'detail', params: { id: product.productId } }">
                <v-img
                        height="280"
                        :src="
            product.images && product.images.length > 0 ? product.images[0] : ''
          "
                ></v-img>
                <!-- 상품 이미지를 슬라이딩 하도록 한다. 혹은 상품 이미지 한개만.-->
            </router-link>
            <v-card-title>
                {{ product.name }}
            </v-card-title>
            <v-card-text>
                <v-row align="center" class="mx-0">
                    <v-rating
                            :value="product.ratings"
                            color="amber"
                            dense
                            half-increments
                            readonly
                            size="14"
                    ></v-rating>
                    <div class="white--text ml-4 font-weight-bold">
                        {{ product.ratings }}
                    </div>
                </v-row>
                <div class="my-4 subtitle-1">가격: {{ product.price }} 원(￦)</div>
            </v-card-text>
            <v-card-actions>
                <v-list-item class="grow">
                    <v-list-item-avatar color="grey darken-3">
                        <v-img class="elevation-6" :src="product.storeThumbnail"></v-img>
                    </v-list-item-avatar>
                    <v-list-item-content>
                        <v-list-item-title>{{ product.storeName }}</v-list-item-title>
                    </v-list-item-content>
                    <v-row align="center" justify="end">
                        <!--vuetify itemGroup 참고하여 current user 가 찜 혹은 comment 했을 경우 와 아닌 경우를 구분하여 icon 처리
                                                {{ active ? 'mdi-heart' : 'mdi-heart-outline' }}-->
                        <v-icon class="mr-1">mdi-heart-outline</v-icon>
                        <span class="subheading mr-2">{{ product.wishs }}</span>
                        <v-icon class="mr-1">mdi-comment-outline</v-icon>
                        <span class="subheading mr-2">{{ product.reviews }}</span>
                        <span class="mr-1">·</span>
                        <v-icon class="mr-1">mdi-share-variant</v-icon>
                    </v-row>
                </v-list-item>
            </v-card-actions>
        </v-card>
    </v-main>
</template>

<script>
    export default {
        props: {
            loading: {
                type: Boolean,
                default: false
            },
            product: {
                type: Object,
                default: () => {
                }
            }
        },
        data: () => ({})
    };
</script>
