package com.fnfh.m.bean;

import java.util.List;

/**
 * 作用
 * 作者
 * 日期： 2017/1/12
 */
public class RiBao {

    /**
     * date : 20170112
     * stories : [{"images":["http://pic4.zhimg.com/79f34193449c31a90aeb8d45b8917e07.jpg"],"type":0,"id":9143456,"ga_prefix":"011213","title":"在用 95 号汽油，换成 98 号会更好吗？"},{"images":["http://pic4.zhimg.com/e1482752e34cf0a502353a63755fa71b.jpg"],"type":0,"id":9141097,"ga_prefix":"011212","title":"大误 · 我的故事只有一句话"},{"images":["http://pic2.zhimg.com/bd2883469dfae9fb122b7dc0339bb90d.jpg"],"type":0,"id":9140776,"ga_prefix":"011211","title":"身上接了一只橡皮手，自己居然真的感觉到疼"},{"images":["http://pic4.zhimg.com/982cd8da226662a58d1c5ee9e5d9c877.jpg"],"type":0,"id":9107180,"ga_prefix":"011210","title":"人的需求是无限的吗？"},{"images":["http://pic2.zhimg.com/5c0c3b9e334a8c86bc86e96171adccad.jpg"],"type":0,"id":9139504,"ga_prefix":"011209","title":"外星上没有海和「海拔」，怎么确定山的高度？"},{"images":["http://pic2.zhimg.com/c19d67af2ed62bfd6a49d72e0b4d0439.jpg"],"type":0,"id":9142150,"ga_prefix":"011208","title":"试用期里压力大，试试这 5 种应对策略"},{"images":["http://pic1.zhimg.com/9916a0bd7c8f2cf9a890fe05b7918aac.jpg"],"type":0,"id":9140873,"ga_prefix":"011207","title":"历史上唯一一个成功转型的大国抓住了什么诀窍？"},{"images":["http://pic1.zhimg.com/c17eab7aef852f1d71a6137b7743cf48.jpg"],"type":0,"id":9142074,"ga_prefix":"011207","title":"Super Mario Run 失败了？它也许是一次赌博式的市场调查"},{"images":["http://pic4.zhimg.com/9f6099345dece61a8413efc0a33041b7.jpg"],"type":0,"id":9141928,"ga_prefix":"011207","title":"大家都想过得好一点，于是方便面厂商的日子很难过"},{"images":["http://pic3.zhimg.com/efc875e626a34d6e918a71ae3667fe4a.jpg"],"type":0,"id":9139522,"ga_prefix":"011206","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic2.zhimg.com/c627316d9cdcafcfd941733571840681.jpg","type":0,"id":9142074,"ga_prefix":"011207","title":"Super Mario Run 失败了？它也许是一次赌博式的市场调查"},{"image":"http://pic2.zhimg.com/8d672656c5dc06e0ad2efde2bc4bad31.jpg","type":0,"id":9142091,"ga_prefix":"011117","title":"知乎好问题 · 怎么写出优秀的喜剧剧本？"},{"image":"http://pic2.zhimg.com/0cd5e23e4c556a3a7c25f401bacdf865.jpg","type":0,"id":9141928,"ga_prefix":"011207","title":"大家都想过得好一点，于是方便面厂商的日子很难过"},{"image":"http://pic3.zhimg.com/558e51fde7055950ec20300471ad2cca.jpg","type":0,"id":9139519,"ga_prefix":"011113","title":"奥巴马这 8 年：美国在种族、经济和同性婚姻浪潮中变动"},{"image":"http://pic4.zhimg.com/91e11355a8511923c6ee2e35b02535cb.jpg","type":0,"id":9138877,"ga_prefix":"011107","title":"《侠盗一号》中有哪些不易察觉的彩蛋或细节？（剧透）"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["http://pic4.zhimg.com/79f34193449c31a90aeb8d45b8917e07.jpg"]
         * type : 0
         * id : 9143456
         * ga_prefix : 011213
         * title : 在用 95 号汽油，换成 98 号会更好吗？
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : http://pic2.zhimg.com/c627316d9cdcafcfd941733571840681.jpg
         * type : 0
         * id : 9142074
         * ga_prefix : 011207
         * title : Super Mario Run 失败了？它也许是一次赌博式的市场调查
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
