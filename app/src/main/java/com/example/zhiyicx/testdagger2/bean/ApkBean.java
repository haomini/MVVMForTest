package com.example.zhiyicx.testdagger2.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/9
 * @Contact 605626708@qq.com
 */

@Entity
public class ApkBean implements Serializable{

    public static final long serialVersionUID = 536871008L;
    /**
     * id : 1
     * mode : 小米8
     * name : 汤姆猫跑酷-会说话
     * Introduction : 探索无穷无尽的跑酷世界
     * description : 2006年，跑酷运动进入中国，并开始在中国推广。跑酷不仅是门运动的艺术，它的热衷者更愿把它看成是一种青年亚文化所倡导生活方式，跑跳攀爬中的自由灵魂在运动中无限伸展。在中国，喜欢跑酷的人越来越多。据中国极限运动协会统计：全国共有150余家有组织的跑酷俱乐部，从事这项运动的民间运动员已达到10万多人，并保持着强劲的增长势头。“首届全国极限跑酷大赛”于2009年10月31日-11月1日，在北京蓝色港湾举行。它是结合运动、音乐、时尚为一体的时尚体育赛事。作为目前国内唯一官方认定的极限跑酷赛事，它将承载着更重大的意义：将民间的、自由的、无组织的极限跑酷运动，发展成为正规的、有组织的体育项目，并使之能够广泛传播，被社会大众所认可。同时，要通过举办体育赛事的平台，将跑酷运动中所蕴含的健康向上、充满信心、勇于挑战、克服困难的运动态度和生活理念传播开来，倡导自由、健康、积极的生活方式。

     跑酷运动在中国的发展很迅速，由于这项运动的性质和运动特点决定了它的练习者绝大部分是青少年，通过调查发现其中主要是自由工作者、公司白领和学生为主。主要有以社团、俱乐部等基本形式存在。活动形式分为两种，一种是自发组织的训练、表演、比赛等，实现的跑酷运动发展的多样性和持续性，另一种是由国家、商业、广告等组织的竞技比赛，这增大了跑酷运动影响，为跑酷运动注入了活力，为跑酷运动的发展起到了宣传作用。
     * download_url : http://111.178.233.108/file3.data.weipan.cn/60475765/8df0704e0f72ccc624b8ccfdcba559d612133112?ip=1512660646,118.113.45.117&ssig=1IufroStYV&Expires=1512661246&KID=sae,l30zoo1wmz&fn=%E9%92%A2%E9%93%81%E6%98%AF%E6%80%8E%E6%A0%B7%E7%82%BC%E6%88%90%E7%9A%84%20
     * version : v2.0.1
     * upload_time : 2038-01-19 11:07:14
     * developer : 新一百科技有限公司
     */
    @Index(unique = true)
    private int id;

    private String mode;
    private String name;
    private String Introduction;
    private String description;
    private String download_url;
    private String version;
    private String upload_time;
    private String developer;

    private long breakPosition;
    private long contentLength;

    @Generated(hash = 2094652060)
    public ApkBean(int id, String mode, String name, String Introduction, String description, String download_url, String version, String upload_time, String developer, long breakPosition, long contentLength) {
        this.id = id;
        this.mode = mode;
        this.name = name;
        this.Introduction = Introduction;
        this.description = description;
        this.download_url = download_url;
        this.version = version;
        this.upload_time = upload_time;
        this.developer = developer;
        this.breakPosition = breakPosition;
        this.contentLength = contentLength;
    }

    @Generated(hash = 2129966906)
    public ApkBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String Introduction) {
        this.Introduction = Introduction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDownload_url() {
        return download_url;
    }

    public void setDownload_url(String download_url) {
        this.download_url = download_url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(String upload_time) {
        this.upload_time = upload_time;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public long getBreakPosition() {
        return this.breakPosition;
    }

    public void setBreakPosition(long breakPosition) {
        this.breakPosition = breakPosition;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    @Override
    public String toString() {
        return "ApkBean{" +
                "id=" + id +
                ", mode='" + mode + '\'' +
                ", name='" + name + '\'' +
                ", Introduction='" + Introduction + '\'' +
                ", description='" + description + '\'' +
                ", download_url='" + download_url + '\'' +
                ", version='" + version + '\'' +
                ", upload_time='" + upload_time + '\'' +
                ", developer='" + developer + '\'' +
                ", breakPosition=" + breakPosition +
                ", contentLength=" + contentLength +
                '}';
    }
}
