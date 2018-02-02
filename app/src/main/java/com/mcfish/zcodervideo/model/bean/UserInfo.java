package com.mcfish.zcodervideo.model.bean;

import com.mcfish.code.http.BaseResponse;

import java.util.List;


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/1
 * Description :
 */


public class UserInfo extends BaseResponse {
    /**
     * data : {"isSignin":0,"level":1,"levelName":"无证驾驶","mu_attention_me_count":"0","mu_avatar":"","mu_coins":"0","mu_device_pass":0,"mu_email":"1340751953@qq.com","mu_id":"7319024","mu_isgag":"0","mu_me_attention_count":"0","mu_name":"coder","mu_points":"0","mu_sex":"0","mu_sign":"","mu_sign_days":"0","mu_status":"0","mu_token":"343eeff3808edefb04013b7ac7d5ab31","mu_vip_date":"0000-00-00 00:00:00","mu_vip_type":"0"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * isSignin : 0
         * level : 1
         * levelName : 无证驾驶
         * mu_attention_me_count : 0
         * mu_avatar :
         * mu_coins : 0
         * mu_device_pass : 0
         * mu_email : 1340751953@qq.com
         * mu_id : 7319024
         * mu_isgag : 0
         * mu_me_attention_count : 0
         * mu_name : coder
         * mu_points : 0
         * mu_sex : 0
         * mu_sign :
         * mu_sign_days : 0
         * mu_status : 0
         * mu_token : 343eeff3808edefb04013b7ac7d5ab31
         * mu_vip_date : 0000-00-00 00:00:00
         * mu_vip_type : 0
         */

        private int isSignin;
        private int level;
        private String levelName;
        private String mu_attention_me_count;
        private String mu_avatar;
        private String mu_coins;
        private int mu_device_pass;
        private String mu_email;
        private String mu_id;
        private String mu_isgag;
        private String mu_me_attention_count;
        private String mu_name;
        private String mu_points;
        private String mu_sex;
        private String mu_sign;
        private String mu_sign_days;
        private String mu_status;
        private String mu_token;
        private String mu_vip_date;
        private String mu_vip_type;

        public int getIsSignin() {
            return isSignin;
        }

        public void setIsSignin(int isSignin) {
            this.isSignin = isSignin;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getLevelName() {
            return levelName;
        }

        public void setLevelName(String levelName) {
            this.levelName = levelName;
        }

        public String getMu_attention_me_count() {
            return mu_attention_me_count;
        }

        public void setMu_attention_me_count(String mu_attention_me_count) {
            this.mu_attention_me_count = mu_attention_me_count;
        }

        public String getMu_avatar() {
            return mu_avatar;
        }

        public void setMu_avatar(String mu_avatar) {
            this.mu_avatar = mu_avatar;
        }

        public String getMu_coins() {
            return mu_coins;
        }

        public void setMu_coins(String mu_coins) {
            this.mu_coins = mu_coins;
        }

        public int getMu_device_pass() {
            return mu_device_pass;
        }

        public void setMu_device_pass(int mu_device_pass) {
            this.mu_device_pass = mu_device_pass;
        }

        public String getMu_email() {
            return mu_email;
        }

        public void setMu_email(String mu_email) {
            this.mu_email = mu_email;
        }

        public String getMu_id() {
            return mu_id;
        }

        public void setMu_id(String mu_id) {
            this.mu_id = mu_id;
        }

        public String getMu_isgag() {
            return mu_isgag;
        }

        public void setMu_isgag(String mu_isgag) {
            this.mu_isgag = mu_isgag;
        }

        public String getMu_me_attention_count() {
            return mu_me_attention_count;
        }

        public void setMu_me_attention_count(String mu_me_attention_count) {
            this.mu_me_attention_count = mu_me_attention_count;
        }

        public String getMu_name() {
            return mu_name;
        }

        public void setMu_name(String mu_name) {
            this.mu_name = mu_name;
        }

        public String getMu_points() {
            return mu_points;
        }

        public void setMu_points(String mu_points) {
            this.mu_points = mu_points;
        }

        public String getMu_sex() {
            return mu_sex;
        }

        public void setMu_sex(String mu_sex) {
            this.mu_sex = mu_sex;
        }

        public String getMu_sign() {
            return mu_sign;
        }

        public void setMu_sign(String mu_sign) {
            this.mu_sign = mu_sign;
        }

        public String getMu_sign_days() {
            return mu_sign_days;
        }

        public void setMu_sign_days(String mu_sign_days) {
            this.mu_sign_days = mu_sign_days;
        }

        public String getMu_status() {
            return mu_status;
        }

        public void setMu_status(String mu_status) {
            this.mu_status = mu_status;
        }

        public String getMu_token() {
            return mu_token;
        }

        public void setMu_token(String mu_token) {
            this.mu_token = mu_token;
        }

        public String getMu_vip_date() {
            return mu_vip_date;
        }

        public void setMu_vip_date(String mu_vip_date) {
            this.mu_vip_date = mu_vip_date;
        }

        public String getMu_vip_type() {
            return mu_vip_type;
        }

        public void setMu_vip_type(String mu_vip_type) {
            this.mu_vip_type = mu_vip_type;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "isSignin=" + isSignin +
                    ", level=" + level +
                    ", levelName='" + levelName + '\'' +
                    ", mu_attention_me_count='" + mu_attention_me_count + '\'' +
                    ", mu_avatar='" + mu_avatar + '\'' +
                    ", mu_coins='" + mu_coins + '\'' +
                    ", mu_device_pass=" + mu_device_pass +
                    ", mu_email='" + mu_email + '\'' +
                    ", mu_id='" + mu_id + '\'' +
                    ", mu_isgag='" + mu_isgag + '\'' +
                    ", mu_me_attention_count='" + mu_me_attention_count + '\'' +
                    ", mu_name='" + mu_name + '\'' +
                    ", mu_points='" + mu_points + '\'' +
                    ", mu_sex='" + mu_sex + '\'' +
                    ", mu_sign='" + mu_sign + '\'' +
                    ", mu_sign_days='" + mu_sign_days + '\'' +
                    ", mu_status='" + mu_status + '\'' +
                    ", mu_token='" + mu_token + '\'' +
                    ", mu_vip_date='" + mu_vip_date + '\'' +
                    ", mu_vip_type='" + mu_vip_type + '\'' +
                    '}';
        }
    }
}
