package myapplication.jiyun.com.yue_kao;

import java.util.List;

/**
 * Created by Administrator on 2018/3/28 0028.
 */

public class Feng {

    /**
     * Students : {"Student":[{"name":"张三","content":"学生简介学生简介学生简介学生简介学生简介","img":"http:    "},{"name":"李四","content":"这是一个好学生，好好学习，特别努力","img":"http:    "},{"name":"王五","content":"喜欢读书，喜欢英语，认真学习的时候特别多","img":"http:    "},{"name":"赵六","content":"长的好看，个头大","img":"http:    "},{"name":"孙七","content":"努力学习，认真工作","img":"http:    "},{"name":"Alss","content":"学习好，是一个三好学生，班花","img":"http:    "},{"name":"哇哈哈","content":"学习好，是一个三好学生","img":"http:    "},{"name":"hander","content":"学习好，是一个三好学生","img":"http:    "},{"name":"EventBus","content":"学习好，是一个三好学生","img":"http:    "},{"name":"Android","content":"喜欢英语，擅长代码","img":"http:    "}]}
     */

    private StudentsBean Students;

    public StudentsBean getStudents() {
        return Students;
    }

    public void setStudents(StudentsBean Students) {
        this.Students = Students;
    }

    public static class StudentsBean {
        private List<StudentBean> Student;

        public List<StudentBean> getStudent() {
            return Student;
        }

        public void setStudent(List<StudentBean> Student) {
            this.Student = Student;
        }

        public static class StudentBean {
            /**
             * name : 张三
             * content : 学生简介学生简介学生简介学生简介学生简介
             * img : http:
             */

            private String name;
            private String content;
            private String img;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }
    }
}
