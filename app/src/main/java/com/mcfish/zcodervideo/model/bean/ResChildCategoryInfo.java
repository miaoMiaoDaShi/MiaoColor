package com.mcfish.zcodervideo.model.bean;

import com.mcfish.code.http.BaseResponse;

import java.util.List;

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/2
 * Description :
 */


public class ResChildCategoryInfo extends BaseResponse {
    /**
     * data : {"count":7,"list":[{"ads":{"imgAds":[{"ca_created":"2017-06-30 08:53:23","ca_img_url":"https://img.alicdn.com/imgextra/i2/3491683832/TB2bBP9jh6I8KJjy0FgXXXXzVXa_!!0-martrix_bbs.jpg","ca_title":"","ca_type":"0","ca_web_url":""}]},"child":[],"mc_created":"2017-12-04 17:25:26","mc_id":"8000207","mc_name":"小视频","mc_parentid":"79999"},{"ads":{"imgAds":[{"ca_created":"2017-06-30 08:53:23","ca_img_url":"https://img.alicdn.com/imgextra/i2/3491683832/TB2bBP9jh6I8KJjy0FgXXXXzVXa_!!0-martrix_bbs.jpg","ca_title":"","ca_type":"0","ca_web_url":""}]},"child":[],"mc_created":"2017-12-01 17:13:38","mc_id":"8000200","mc_name":"主播秀","mc_parentid":"79999"},{"ads":{"imgAds":[{"ca_created":"2017-06-30 08:53:23","ca_img_url":"https://img.alicdn.com/imgextra/i2/3491683832/TB2bBP9jh6I8KJjy0FgXXXXzVXa_!!0-martrix_bbs.jpg","ca_title":"","ca_type":"0","ca_web_url":""}]},"child":[],"mc_created":"2017-06-30 04:11:44","mc_id":"7999901","mc_name":"VIP无码","mc_parentid":"79999"},{"ads":{"imgAds":[{"ca_created":"2017-06-30 08:53:23","ca_img_url":"https://img.alicdn.com/imgextra/i2/3491683832/TB2bBP9jh6I8KJjy0FgXXXXzVXa_!!0-martrix_bbs.jpg","ca_title":"","ca_type":"0","ca_web_url":""}]},"child":[],"mc_created":"2017-12-16 00:54:26","mc_id":"8000232","mc_name":"VIP有码","mc_parentid":"79999"},{"ads":{"imgAds":[{"ca_created":"2017-06-30 08:53:23","ca_img_url":"https://img.alicdn.com/imgextra/i2/3491683832/TB2bBP9jh6I8KJjy0FgXXXXzVXa_!!0-martrix_bbs.jpg","ca_title":"","ca_type":"0","ca_web_url":""}]},"child":[],"mc_created":"2017-12-16 00:55:21","mc_id":"8000233","mc_name":"VIP中文","mc_parentid":"79999"},{"ads":{"imgAds":[{"ca_created":"2017-06-30 08:53:23","ca_img_url":"https://img.alicdn.com/imgextra/i2/3491683832/TB2bBP9jh6I8KJjy0FgXXXXzVXa_!!0-martrix_bbs.jpg","ca_title":"","ca_type":"0","ca_web_url":""}]},"child":[],"mc_created":"2017-11-17 05:27:47","mc_id":"8000170","mc_name":"VIP欧美","mc_parentid":"79999"},{"ads":{"imgAds":[{"ca_created":"2017-06-30 08:53:23","ca_img_url":"https://img.alicdn.com/imgextra/i2/3491683832/TB2bBP9jh6I8KJjy0FgXXXXzVXa_!!0-martrix_bbs.jpg","ca_title":"","ca_type":"0","ca_web_url":""}]},"child":[],"mc_created":"2017-11-17 05:38:06","mc_id":"8000171","mc_name":"VIP动漫","mc_parentid":"79999"}],"page":1,"pageCount":1}
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
         * count : 7
         * list : [{"ads":{"imgAds":[{"ca_created":"2017-06-30 08:53:23","ca_img_url":"https://img.alicdn.com/imgextra/i2/3491683832/TB2bBP9jh6I8KJjy0FgXXXXzVXa_!!0-martrix_bbs.jpg","ca_title":"","ca_type":"0","ca_web_url":""}]},"child":[],"mc_created":"2017-12-04 17:25:26","mc_id":"8000207","mc_name":"小视频","mc_parentid":"79999"},{"ads":{"imgAds":[{"ca_created":"2017-06-30 08:53:23","ca_img_url":"https://img.alicdn.com/imgextra/i2/3491683832/TB2bBP9jh6I8KJjy0FgXXXXzVXa_!!0-martrix_bbs.jpg","ca_title":"","ca_type":"0","ca_web_url":""}]},"child":[],"mc_created":"2017-12-01 17:13:38","mc_id":"8000200","mc_name":"主播秀","mc_parentid":"79999"},{"ads":{"imgAds":[{"ca_created":"2017-06-30 08:53:23","ca_img_url":"https://img.alicdn.com/imgextra/i2/3491683832/TB2bBP9jh6I8KJjy0FgXXXXzVXa_!!0-martrix_bbs.jpg","ca_title":"","ca_type":"0","ca_web_url":""}]},"child":[],"mc_created":"2017-06-30 04:11:44","mc_id":"7999901","mc_name":"VIP无码","mc_parentid":"79999"},{"ads":{"imgAds":[{"ca_created":"2017-06-30 08:53:23","ca_img_url":"https://img.alicdn.com/imgextra/i2/3491683832/TB2bBP9jh6I8KJjy0FgXXXXzVXa_!!0-martrix_bbs.jpg","ca_title":"","ca_type":"0","ca_web_url":""}]},"child":[],"mc_created":"2017-12-16 00:54:26","mc_id":"8000232","mc_name":"VIP有码","mc_parentid":"79999"},{"ads":{"imgAds":[{"ca_created":"2017-06-30 08:53:23","ca_img_url":"https://img.alicdn.com/imgextra/i2/3491683832/TB2bBP9jh6I8KJjy0FgXXXXzVXa_!!0-martrix_bbs.jpg","ca_title":"","ca_type":"0","ca_web_url":""}]},"child":[],"mc_created":"2017-12-16 00:55:21","mc_id":"8000233","mc_name":"VIP中文","mc_parentid":"79999"},{"ads":{"imgAds":[{"ca_created":"2017-06-30 08:53:23","ca_img_url":"https://img.alicdn.com/imgextra/i2/3491683832/TB2bBP9jh6I8KJjy0FgXXXXzVXa_!!0-martrix_bbs.jpg","ca_title":"","ca_type":"0","ca_web_url":""}]},"child":[],"mc_created":"2017-11-17 05:27:47","mc_id":"8000170","mc_name":"VIP欧美","mc_parentid":"79999"},{"ads":{"imgAds":[{"ca_created":"2017-06-30 08:53:23","ca_img_url":"https://img.alicdn.com/imgextra/i2/3491683832/TB2bBP9jh6I8KJjy0FgXXXXzVXa_!!0-martrix_bbs.jpg","ca_title":"","ca_type":"0","ca_web_url":""}]},"child":[],"mc_created":"2017-11-17 05:38:06","mc_id":"8000171","mc_name":"VIP动漫","mc_parentid":"79999"}]
         * page : 1
         * pageCount : 1
         */

        private int count;
        private int page;
        private int pageCount;
        private List<ListBean> list;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * ads : {"imgAds":[{"ca_created":"2017-06-30 08:53:23","ca_img_url":"https://img.alicdn.com/imgextra/i2/3491683832/TB2bBP9jh6I8KJjy0FgXXXXzVXa_!!0-martrix_bbs.jpg","ca_title":"","ca_type":"0","ca_web_url":""}]}
             * child : []
             * mc_created : 2017-12-04 17:25:26
             * mc_id : 8000207
             * mc_name : 小视频
             * mc_parentid : 79999
             */

            private AdsBean ads;
            private String mc_created;
            private String mc_id;
            private String mc_name;
            private String mc_parentid;
            private List<?> child;

            public AdsBean getAds() {
                return ads;
            }

            public void setAds(AdsBean ads) {
                this.ads = ads;
            }

            public String getMc_created() {
                return mc_created;
            }

            public void setMc_created(String mc_created) {
                this.mc_created = mc_created;
            }

            public String getMc_id() {
                return mc_id;
            }

            public void setMc_id(String mc_id) {
                this.mc_id = mc_id;
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

            public List<?> getChild() {
                return child;
            }

            public void setChild(List<?> child) {
                this.child = child;
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
                     * ca_created : 2017-06-30 08:53:23
                     * ca_img_url : https://img.alicdn.com/imgextra/i2/3491683832/TB2bBP9jh6I8KJjy0FgXXXXzVXa_!!0-martrix_bbs.jpg
                     * ca_title :
                     * ca_type : 0
                     * ca_web_url :
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
        }
    }
}
