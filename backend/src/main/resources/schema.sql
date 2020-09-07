DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `store`;
DROP TABLE IF EXISTS `product`;
DROP TABLE IF EXISTS `review`;
DROP TABLE IF EXISTS `product_image`;
DROP TABLE IF EXISTS `banner`;
DROP TABLE IF EXISTS `wish`;
DROP TABLE IF EXISTS `cart`;
DROP TABLE IF EXISTS `order`;

CREATE TABLE IF NOT EXISTS `user` (
    `user_id`         BIGINT  AUTO_INCREMENT COMMENT '사용자 아이디',
    `password`        VARCHAR(255) NOT NULL COMMENT '비밀번호(ENC)',
    `thumbnail`       VARCHAR(255) NOT NULL COMMENT '프로필 이미지 url',
    `name`            VARCHAR(100) NOT NULL comment '사용자 이름',
    `email`           VARCHAR(100) NULL comment '사용자 이메일',
    `phone`           VARCHAR(13)  NOT NULL UNIQUE comment '사용자 휴대폰',
    `status`          VARCHAR(100) NOT NULL DEFAULT 'DISABLE' comment '상태: enable / disable / block',
    `created_at`      TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    `updated_at`      TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    PRIMARY KEY (`user_id`),
    CONSTRAINT USER_UNIQUE_01 UNIQUE (email),
    CONSTRAINT USER_UNIQUE_02 UNIQUE (phone)
);


CREATE TABLE IF NOT EXISTS `store` (
    `store_id`         BIGINT AUTO_INCREMENT COMMENT '',
    `name`             VARCHAR(255) NOT NULL comment '가게명',
    `thumbnail`        VARCHAR(255)  NULL COMMENT '프로필 이미지 url',
    `tel`              VARCHAR(255) NOT NULL UNIQUE comment '전화 번호',
    `address`          VARCHAR(255) NOT NULL comment '가게 주소',
    `latitude`         VARCHAR(255)  NULL comment '',
    `longitude`        VARCHAR(255)  NULL comment '',
    `created_at`       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    `updated_at`       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    PRIMARY KEY (`store_id`)
);


CREATE TABLE IF NOT EXISTS `product` (
    `product_id`       BIGINT AUTO_INCREMENT,
    `name`             VARCHAR(255) NOT NULL comment '제품 명',
    `price`            BIGINT NOT NULL comment '가격',
    `description`      VARCHAR(255) NOT NULL comment '제품 설명',
    `status`           VARCHAR(100) NOT NULL comment '상태: enable , disable , sold_out',
    `created_at`       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    `updated_at`       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    PRIMARY KEY (`product_id`)
);

CREATE TABLE IF NOT EXISTS `product_image` (
    `product_image_id`        BIGINT AUTO_INCREMENT COMMENT '',
    `product_id`       BIGINT NOT NULL comment '제품 아아디',
    `display`          INT NULL comment '제품 이미지 표기 순위(순위가 없을 경우 이미지 업로드 순)',
    `status`           VARCHAR(100) NOT NULL DEFAULT 'DISABLE' comment '상태: enable , disable',
    `path`            VARCHAR(255)  NULL COMMENT '이미지 url',
    `created_at`       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    `updated_at`       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    PRIMARY KEY (`product_image_id`)
);

CREATE TABLE IF NOT EXISTS `review` (
    `review_id`        BIGINT AUTO_INCREMENT COMMENT '',
    `product_id`       BIGINT NOT NULL comment '제품 아아디',
    `user_id`          BIGINT NOT NULL comment '사용자 아아디',
    `rating`           INT NOT NULL comment '제품 평점 ',
    `content`      VARCHAR(255) NOT NULL comment '평가 내용 ',
    `status`           VARCHAR(100) NOT NULL DEFAULT 'DISABLE' comment '상태: enable , disable',
    `created_at`       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    `updated_at`       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    PRIMARY KEY (`review_id`),
    CONSTRAINT REVIEW_UNIQUE_01 UNIQUE(product_id,user_id)
);


CREATE TABLE IF NOT EXISTS `banner` (
    `banner_id`        BIGINT AUTO_INCREMENT COMMENT '',
    `type`             VARCHAR(100) NULL comment '타입: IN , OUT',
    `link`             VARCHAR(250) NULL comment 'link',
    `image`            VARCHAR(250) NULL comment 'image',
    `content`          VARCHAR(250) NULL comment '배너 설명',
    `created_at`       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    `updated_at`       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    PRIMARY KEY (`banner_id`)
);


CREATE TABLE IF NOT EXISTS `cart` (
    `cart_id`        BIGINT AUTO_INCREMENT COMMENT '',
    `product_id`      BIGINT NOT NULL comment '제품 아아디',
    `user_id`      BIGINT NOT NULL comment '사용자 아아디',
    `status`             VARCHAR(100) NULL DEFAULT 'IN' comment '상태: IN->담은상태 / OUT->제거, ORDER->주문,,, IN 상태만 노출 된다.',
    `created_at`       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    `updated_at`       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    PRIMARY KEY (`cart_id`)
);

CREATE TABLE IF NOT EXISTS `order` (
    `order_id`        BIGINT AUTO_INCREMENT COMMENT '',
    `status`             VARCHAR(100) NULL comment '상태: wait->주문중/cancel->취소/done->주문완료',
    `product_id`      BIGINT NOT NULL comment '제품 아아디',
    `user_id`      BIGINT NOT NULL comment '사용자 아아디',
    `created_at`       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    `updated_at`       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    PRIMARY KEY (`order_id`)
);


CREATE TABLE IF NOT EXISTS `wish` (
    `wish_id`        BIGINT AUTO_INCREMENT COMMENT '',
    `status`             VARCHAR(100) NULL comment '타입: IN / OUT',
    `product_id`      BIGINT NOT NULL comment '제품 아아디',
    `user_id`      BIGINT NOT NULL comment '제품 아아디',
    `created_at`       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    `updated_at`       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    PRIMARY KEY (`wish_id`)
);


