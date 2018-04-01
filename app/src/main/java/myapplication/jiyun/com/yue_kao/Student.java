package myapplication.jiyun.com.yue_kao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/28 0028.
 */
@Entity
public class Student implements Serializable{
    @Id
    private Long id;
    private String name;
    private String sex;
    private String Image;
    public String getImage() {
        return this.Image;
    }
    public void setImage(String Image) {
        this.Image = Image;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1687375209)
    public Student(Long id, String name, String sex, String Image) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.Image = Image;
    }

    public Student(String name, String sex, String image) {
        this.name = name;
        this.sex = sex;
        Image = image;
    }

    public Student(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public Student(Long id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    @Generated(hash = 1556870573)
    public Student() {
    }


}
