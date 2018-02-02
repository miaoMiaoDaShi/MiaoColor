package com.mcfish.zcodervideo.model.bean;

import com.mcfish.code.http.BaseResponse;

import java.util.List;

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2017/12/26
 * Description :
 */


public class BannerInfo {
    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * data : 5555
         * id : 1
         * image : http://otvt0lhkm.bkt.clouddn.com/2017/09/08/10/56/41/u=298302414,240830751&fm=27&gp=0.jpg
         * title : 213321#@！！！@！@~@！
         * url : 555555555
         */

        private String data;
        private int id;
        private String image;
        private String title;
        private String url;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
