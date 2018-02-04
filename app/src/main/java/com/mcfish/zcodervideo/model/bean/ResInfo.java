package com.mcfish.zcodervideo.model.bean;

import com.mcfish.code.http.BaseResponse;

import java.util.List;

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/2
 * Description :
 */


public class ResInfo extends BaseResponse{
    /**
     * data : {"ads":{"imgAds":[{"ca_created":"2017-12-19 00:37:02","ca_img_url":"https://img.alicdn.com/imgextra/i4/3491683832/TB2ugTni9fD8KJjSszhXXbIJFXa_!!0-martrix_bbs.jpg","ca_title":"","ca_type":"0","ca_web_url":"https://8dd.vip/qq_sb/"},{"ca_created":"2017-07-28 19:22:01","ca_img_url":"https://img.alicdn.com/imgextra/i4/3491683832/TB25W8vdfjM8KJjSZFsXXXdZpXa_!!0-martrix_bbs.jpg","ca_title":"","ca_type":"0","ca_web_url":"https://maomi999.info"},{"ca_created":"2017-09-24 23:11:11","ca_img_url":"https://img.alicdn.com/imgextra/i4/3491683832/TB2WRP7iS_I8KJjy0FoXXaFnVXa_!!0-martrix_bbs.jpg","ca_title":"","ca_type":"0","ca_web_url":"http://202.146.219.87/"},{"ca_created":"2017-07-07 09:41:41","ca_img_url":"http://wx4.sinaimg.cn/large/005StFp9gy1fl0mk27ntlj30k20a8gmb.jpg","ca_title":"","ca_type":"0","ca_web_url":"https://8dd.vip/vip/"}]},"list":[{"mc_created":"2017-06-27 04:39:01","mc_deleted":"2017-06-27 04:39:01","mc_id":"79999","mc_listorder":"10","mc_name":"VIP电影（超快速度观看体验）","mc_parentid":"0","mc_status":"0","mc_updated":"2017-06-27 04:39:01"},{"mc_created":"2017-06-30 23:53:46","mc_deleted":"2017-06-30 23:53:46","mc_id":"2099900","mc_listorder":"9","mc_name":"成人动漫","mc_parentid":"0","mc_status":"0","mc_updated":"2017-06-30 23:53:46"},{"mc_created":"2017-01-12 00:00:00","mc_deleted":"2017-01-12 00:00:00","mc_id":"9999","mc_listorder":"8","mc_name":"热门视频","mc_parentid":"0","mc_status":"0","mc_updated":"2017-01-12 00:00:00"},{"mc_created":"2017-06-27 20:35:07","mc_deleted":"2017-06-27 20:35:07","mc_id":"10003","mc_listorder":"7","mc_name":"迅雷下载","mc_parentid":"0","mc_status":"0","mc_updated":"2017-06-27 20:35:07"},{"mc_created":"2017-06-25 20:33:19","mc_deleted":"2017-06-25 20:33:19","mc_id":"98888","mc_listorder":"6","mc_name":"激情写真","mc_parentid":"0","mc_status":"0","mc_updated":"2017-06-25 20:33:19"},{"mc_created":"2016-12-06 10:54:06","mc_deleted":"2016-12-06 10:54:06","mc_id":"3","mc_listorder":"5","mc_name":"在线视频","mc_parentid":"0","mc_status":"0","mc_updated":"2016-12-06 10:54:06"},{"mc_created":"2016-12-05 08:24:59","mc_deleted":"2016-12-05 08:24:59","mc_id":"1","mc_listorder":"4","mc_name":"成人图片","mc_parentid":"0","mc_status":"0","mc_updated":"2016-12-05 08:24:59"},{"mc_created":"2016-12-06 10:54:15","mc_deleted":"2016-12-06 10:54:15","mc_id":"4","mc_listorder":"3","mc_name":"有声小说","mc_parentid":"0","mc_status":"0","mc_updated":"2016-12-06 10:54:15"},{"mc_created":"2016-12-06 10:53:45","mc_deleted":"2016-12-06 10:53:45","mc_id":"2","mc_listorder":"2","mc_name":"文字小说","mc_parentid":"0","mc_status":"0","mc_updated":"2016-12-06 10:53:45"}]}
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
         * ads : {"imgAds":[{"ca_created":"2017-12-19 00:37:02","ca_img_url":"https://img.alicdn.com/imgextra/i4/3491683832/TB2ugTni9fD8KJjSszhXXbIJFXa_!!0-martrix_bbs.jpg","ca_title":"","ca_type":"0","ca_web_url":"https://8dd.vip/qq_sb/"},{"ca_created":"2017-07-28 19:22:01","ca_img_url":"https://img.alicdn.com/imgextra/i4/3491683832/TB25W8vdfjM8KJjSZFsXXXdZpXa_!!0-martrix_bbs.jpg","ca_title":"","ca_type":"0","ca_web_url":"https://maomi999.info"},{"ca_created":"2017-09-24 23:11:11","ca_img_url":"https://img.alicdn.com/imgextra/i4/3491683832/TB2WRP7iS_I8KJjy0FoXXaFnVXa_!!0-martrix_bbs.jpg","ca_title":"","ca_type":"0","ca_web_url":"http://202.146.219.87/"},{"ca_created":"2017-07-07 09:41:41","ca_img_url":"http://wx4.sinaimg.cn/large/005StFp9gy1fl0mk27ntlj30k20a8gmb.jpg","ca_title":"","ca_type":"0","ca_web_url":"https://8dd.vip/vip/"}]}
         * list : [{"mc_created":"2017-06-27 04:39:01","mc_deleted":"2017-06-27 04:39:01","mc_id":"79999","mc_listorder":"10","mc_name":"VIP电影（超快速度观看体验）","mc_parentid":"0","mc_status":"0","mc_updated":"2017-06-27 04:39:01"},{"mc_created":"2017-06-30 23:53:46","mc_deleted":"2017-06-30 23:53:46","mc_id":"2099900","mc_listorder":"9","mc_name":"成人动漫","mc_parentid":"0","mc_status":"0","mc_updated":"2017-06-30 23:53:46"},{"mc_created":"2017-01-12 00:00:00","mc_deleted":"2017-01-12 00:00:00","mc_id":"9999","mc_listorder":"8","mc_name":"热门视频","mc_parentid":"0","mc_status":"0","mc_updated":"2017-01-12 00:00:00"},{"mc_created":"2017-06-27 20:35:07","mc_deleted":"2017-06-27 20:35:07","mc_id":"10003","mc_listorder":"7","mc_name":"迅雷下载","mc_parentid":"0","mc_status":"0","mc_updated":"2017-06-27 20:35:07"},{"mc_created":"2017-06-25 20:33:19","mc_deleted":"2017-06-25 20:33:19","mc_id":"98888","mc_listorder":"6","mc_name":"激情写真","mc_parentid":"0","mc_status":"0","mc_updated":"2017-06-25 20:33:19"},{"mc_created":"2016-12-06 10:54:06","mc_deleted":"2016-12-06 10:54:06","mc_id":"3","mc_listorder":"5","mc_name":"在线视频","mc_parentid":"0","mc_status":"0","mc_updated":"2016-12-06 10:54:06"},{"mc_created":"2016-12-05 08:24:59","mc_deleted":"2016-12-05 08:24:59","mc_id":"1","mc_listorder":"4","mc_name":"成人图片","mc_parentid":"0","mc_status":"0","mc_updated":"2016-12-05 08:24:59"},{"mc_created":"2016-12-06 10:54:15","mc_deleted":"2016-12-06 10:54:15","mc_id":"4","mc_listorder":"3","mc_name":"有声小说","mc_parentid":"0","mc_status":"0","mc_updated":"2016-12-06 10:54:15"},{"mc_created":"2016-12-06 10:53:45","mc_deleted":"2016-12-06 10:53:45","mc_id":"2","mc_listorder":"2","mc_name":"文字小说","mc_parentid":"0","mc_status":"0","mc_updated":"2016-12-06 10:53:45"}]
         */

        private AdsBean ads;
        private List<ListBean> list;

        public AdsBean getAds() {
            return ads;
        }

        public void setAds(AdsBean ads) {
            this.ads = ads;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class AdsBean {
            private List<ImgAdsBean> imgAds;

            public List<ImgAdsBean> getImgAds() {
                return imgAds;
            }

            public void setImgAds(List<ImgAdsBean> imgAds) {
                this.imgAds = imgAds;
            }

            public static class ImgAdsBean {
                /**
                 * ca_created : 2017-12-19 00:37:02
                 * ca_img_url : https://img.alicdn.com/imgextra/i4/3491683832/TB2ugTni9fD8KJjSszhXXbIJFXa_!!0-martrix_bbs.jpg
                 * ca_title :
                 * ca_type : 0
                 * ca_web_url : https://8dd.vip/qq_sb/
                 */

                private String ca_created;
                private String ca_img_url;
                private String ca_title;
                private String ca_type;
                private String ca_web_url;

                public String getCa_created() {
                    return ca_created;
                }

                public void setCa_created(String ca_created) {
                    this.ca_created = ca_created;
                }

                public String getCa_img_url() {
                    return ca_img_url;
                }

                public void setCa_img_url(String ca_img_url) {
                    this.ca_img_url = ca_img_url;
                }

                public String getCa_title() {
                    return ca_title;
                }

                public void setCa_title(String ca_title) {
                    this.ca_title = ca_title;
                }

                public String getCa_type() {
                    return ca_type;
                }

                public void setCa_type(String ca_type) {
                    this.ca_type = ca_type;
                }

                public String getCa_web_url() {
                    return ca_web_url;
                }

                public void setCa_web_url(String ca_web_url) {
                    this.ca_web_url = ca_web_url;
                }
            }
        }

        public static class ListBean {
            /**
             * mc_created : 2017-06-27 04:39:01
             * mc_deleted : 2017-06-27 04:39:01
             * mc_id : 79999
             * mc_listorder : 10
             * mc_name : VIP电影（超快速度观看体验）
             * mc_parentid : 0
             * mc_status : 0
             * mc_updated : 2017-06-27 04:39:01
             */

            private String mc_created;
            private String mc_deleted;
            private String mc_id;
            private String mc_listorder;
            private String mc_name;
            private String mc_parentid;
            private String mc_status;
            private String mc_updated;

            public String getMc_created() {
                return mc_created;
            }

            public void setMc_created(String mc_created) {
                this.mc_created = mc_created;
            }

            public String getMc_deleted() {
                return mc_deleted;
            }

            public void setMc_deleted(String mc_deleted) {
                this.mc_deleted = mc_deleted;
            }

            public String getMc_id() {
                return mc_id;
            }

            public void setMc_id(String mc_id) {
                this.mc_id = mc_id;
            }

            public String getMc_listorder() {
                return mc_listorder;
            }

            public void setMc_listorder(String mc_listorder) {
                this.mc_listorder = mc_listorder;
            }

            public String getMc_name() {
                return mc_name;
            }

            public void setMc_name(String mc_name) {
                this.mc_name = mc_name;
            }

            public String getMc_parentid() {
                return mc_parentid;
            }

            public void setMc_parentid(String mc_parentid) {
                this.mc_parentid = mc_parentid;
            }

            public String getMc_status() {
                return mc_status;
            }

            public void setMc_status(String mc_status) {
                this.mc_status = mc_status;
            }

            public String getMc_updated() {
                return mc_updated;
            }

            public void setMc_updated(String mc_updated) {
                this.mc_updated = mc_updated;
            }
        }
    }
}
