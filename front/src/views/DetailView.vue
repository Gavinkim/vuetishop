<template>
    <v-container fluid>
        <v-layout>
            <v-flex>
                <v-card class="mx-auto my-12" max-width="500">
                    <v-img height="400" src="https://cdn.vuetifyjs.com/images/cards/cooking.png"></v-img>
                    <v-card-title style="position: relative;">
                        {{ detail.name }}
                        <v-btn
                                :disabled="dialog"
                                :loading="dialog"
                                absolute color="green"
                                class="white--text" fab right top
                                @click="order"
                        >
                            <v-icon>mdi-cart</v-icon>
                        </v-btn>
                    </v-card-title>
                    <v-card-text>
                        <v-row align="center" class="mx-0">
                            <v-rating
                                    :value="detail.ratings"
                                    color="amber"
                                    dense
                                    half-increments
                                    readonly
                                    size="14"
                            ></v-rating>
                            <div class="grey--text ml-4">{{detail.ratings}}</div>
                        </v-row>
                        <div class="my-4 subtitle-1">
                            가격 • {{detail.price}} 원(￦)
                        </div>
                        <div>{{detail.description}}</div>
                    </v-card-text>
                    <v-divider class="mx-4"></v-divider>
                    <v-card-title>주문 방식을 선택 해주세요.</v-card-title>
                    <v-card-text>
                        <v-chip-group
                                v-model="selection"
                                active-class="deep-purple accent-4 white--text"
                                column
                        >
                            <v-chip>배송</v-chip>
                            <v-chip>방문</v-chip>
                            <v-chip>일간</v-chip>
                            <v-chip>주간</v-chip>
                            <v-chip>월간</v-chip>
                        </v-chip-group>
                    </v-card-text>
                    <v-card-actions>
                        <v-list-item class="grow">
                            <v-list-item-avatar color="grey darken-3">
                                <v-img class="elevation-6" :src="detail.storeThumbnail"></v-img>
                            </v-list-item-avatar>
                            <span class="subheading mr-5">{{ detail.storeName }}</span>
                            <v-spacer></v-spacer>
                            <v-btn icon @click="addWish">
                                <v-icon>mdi-heart-outline</v-icon>
                            </v-btn>
                            <span class="subheading mr-5">{{ detail.wishs }}</span>
                            <v-btn icon @click="addComment">
                                <v-icon>mdi-comment-outline</v-icon>
                            </v-btn>
                            <span class="subheading mr-2">{{ detail.reviews }}</span>
                            <v-btn icon @click="share">
                                <v-icon>mdi-share-variant</v-icon>
                            </v-btn>
                        </v-list-item>
                    </v-card-actions>
                </v-card>
                <!-- todo: dialog 를 글로벌 컴포넌트로 분리 -->
                <v-dialog
                        v-model="dialog"
                        hide-overlay
                        persistent
                        width="300"
                >
                    <v-card
                            color="green"
                            dark
                    >
                        <v-card-text>
                            장바구니에 추가 중 입니다.
                            <v-progress-linear
                                    indeterminate
                                    color="white"
                                    class="mb-0"
                            ></v-progress-linear>
                        </v-card-text>
                    </v-card>
                </v-dialog>
            </v-flex>
        </v-layout>
    </v-container>

</template>

<script>
    import {product_detail} from "../services";

    export default {
        data() {
            return {
                detail: Object,
                selection: 0,
                dialog: false,
            };
        },
        watch: {
            dialog(val) {
                if (!val) return
                setTimeout(() => (this.dialog = false), 1000)
            },
        },
        methods: {
            order() {
                this.loading = true
                this.dialog = true
            },
            addWish() {
                console.log('addwish')
            },
            addComment() {
                console.log('addcomment')
            },
            share() {
                console.log('share')
            }
        },
        props: {
            id: {
                type: Number
            }
        },
        created() {
            product_detail.fetch(this.id).then(data => {
                this.detail = data.data;
            });
        }
    };
</script>

<style>
    .custom-loader {
        animation: loader 1s infinite;
        display: flex;
    }
</style>
