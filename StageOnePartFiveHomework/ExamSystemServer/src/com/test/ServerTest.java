package com.test;

import com.mode.Question;
import com.mode.User;
import com.server.ServerDao;
import com.server.ServerInitClose;
import com.server.ServerInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ServerTest {

    public static void main(String[] args) {

        loadUserDatabase();
        loadQuestionDatabase();

        ServerInitClose sic = null;
        try {
            sic = new ServerInitClose();
            sic.serverInit();

            ServerDao sd = new ServerDao();
            ServerInterface sv = new ServerInterface(sic, sd);
            sv.serverReceive();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                sic.serverClose();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * load database to a file contain all subject's tests
     */
    private static void loadQuestionDatabase() {

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        HashMap<String, ArrayList<Question>> questionDatabase = new HashMap<>();

        String questionDescription = null;
        String correctAnswer = null;
        String answerA = null;
        String answerB = null;
        String answerC = null;
        String answerD = null;
        Question singleQuestion = new Question();

        try {

            /*
            oos = new ObjectOutputStream(new FileOutputStream("/Users/spencersun/Desktop/b.txt"));

            //语文
            ArrayList<Question> mandarinQuestionList = new ArrayList<Question>();

            questionDescription = "选出下列句子没有语病的一句: ";
            correctAnswer = "D";
            answerA = "为了防止学校安全问题不再发生，各个学校都加强了安全保卫工作。";
            answerB = "在\"亚运会\"的筹备会上，各相关部门交换了广泛的意见。";
            answerC = "我们的教育应该培养学生善于观察，善于思考，善于创造的水平。";
            answerD = "一本好书可以给你带来许多教义，甚至可以影响你的一生。";
            singleQuestion = new Question(questionDescription, correctAnswer, answerA, answerB, answerC, answerD,"语文");
            mandarinQuestionList.add(singleQuestion);

            questionDescription = "下列与课题对应的作者或朝代有误的一项是: ";
            correctAnswer = "B";
            answerA = "《五柳先生传》——陶渊明——东晋";
            answerB = "《山坡羊·潼关怀古》——张养浩——宋代";
            answerC = "《酬乐天扬州初逢席上见赠》——刘禹锡——唐代";
            answerD = "《送东阳马生序》——宋濂——明初";
            singleQuestion = new Question(questionDescription, correctAnswer, answerA, answerB, answerC, answerD,"语文");
            mandarinQuestionList.add(singleQuestion);

            questionDescription = "下列句子中加点的成语，使用恰当的一项是：";
            correctAnswer = "A";
            answerA = "当今世界散打擂台上，没有谁能和柳海龙分庭抗礼。";
            answerB = "听一则奇志、大兵的相声，可以使我们的烦恼涣然冰释。";
            answerC = "这种创造性的艺术作品充分反映了战国时期劳动人民炉火纯青的聪明智慧。";
            answerD = "我们班众多的莘莘学子经过高中三年刻苦学习，都取得了理想的成绩，其中有十多位同学考入了重点大学。";
            singleQuestion = new Question(questionDescription, correctAnswer, answerA, answerB, answerC, answerD,"语文");
            mandarinQuestionList.add(singleQuestion);

            questionDatabase.put("语文", mandarinQuestionList);

            //数学
            ArrayList<Question> mathQuestionList = new ArrayList<Question>();

            questionDescription = "如果一个圆锥体的底面半径扩大2倍，高缩小为原来的一半，它的体积是原来体积的（ ）。";
            correctAnswer = "A";
            answerA = "2倍";
            answerB = "一半";
            answerC = "不变";
            answerD = "无法确定";
            singleQuestion = new Question(questionDescription, correctAnswer, answerA, answerB, answerC, answerD,"数学");
            mathQuestionList.add(singleQuestion);

            questionDescription = "某村前年产苹果30万千克，去年增产20％，今年减产20％，今年产量为（ ）万千。";
            correctAnswer = "C";
            answerA = "29";
            answerB = "31";
            answerC = "28.8";
            answerD = "29.2";
            singleQuestion = new Question(questionDescription, correctAnswer, answerA, answerB, answerC, answerD,"数学");
            mathQuestionList.add(singleQuestion);

            questionDescription = "有5张卡片，上面的数字分别是0、4、5、6、7，从中抽出3张所组成的三位数中能被4整除的有（ ）个。";
            correctAnswer = "D";
            answerA = "11";
            answerB = "12";
            answerC = "10";
            answerD = "15";
            singleQuestion = new Question(questionDescription, correctAnswer, answerA, answerB, answerC, answerD,"数学");
            mathQuestionList.add(singleQuestion);

            questionDatabase.put("数学", mathQuestionList);

            //英语
            ArrayList<Question> englishQuestionList = new ArrayList<Question>();

            questionDescription = "You'll find this map of great _______ in helping you to get round London.";
            correctAnswer = "C";
            answerA = "price";
            answerB = "cost";
            answerC = "value";
            answerD = "usefulness";
            singleQuestion = new Question(questionDescription, correctAnswer, answerA, answerB, answerC, answerD,"英语");
            englishQuestionList.add(singleQuestion);

            questionDescription = "You can take as many as you like because they are free of _______.";
            correctAnswer = "B";
            answerA = "fare";
            answerB = "charge";
            answerC = "money";
            answerD = "pay";
            singleQuestion = new Question(questionDescription, correctAnswer, answerA, answerB, answerC, answerD,"英语");
            englishQuestionList.add(singleQuestion);

            questionDescription = "Some famous singers live on the _______ from their record sales.";
            correctAnswer = "D";
            answerA = "salary";
            answerB = "value";
            answerC = "bill";
            answerD = "income";
            singleQuestion = new Question(questionDescription, correctAnswer, answerA, answerB, answerC, answerD,"英语");
            englishQuestionList.add(singleQuestion);

            questionDatabase.put("英语", englishQuestionList);

            oos.writeObject(questionDatabase);
            oos.flush();
            */


            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/b.txt"));
            HashMap<String, ArrayList<Question>> obj = (HashMap<String, ArrayList<Question>>) ois.readObject();

            Set<String> keys = obj.keySet();
            for(String ky:keys){
                ArrayList<Question> questionList = obj.get(ky);

                System.out.println("\n----------------------------科目: " + ky + "----------------------------\n");
                for(Question qs:questionList){
                    System.out.println(qs);
                    System.out.println();
                }
                System.out.println("-----------------------------------------------------------------\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(null != ois) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * load database to a file contain all user information
     */
    private static void loadUserDatabase() {

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            /*
            oos = new ObjectOutputStream(new FileOutputStream("/Users/spencersun/Desktop/a.txt",false));
            ArrayList<User> studentList = new ArrayList<>();

            User user = new User("a","1");
            studentList.add(user);

            user = new User("b","1");
            studentList.add(user);

            user = new User("c","1");
            studentList.add(user);

            user = new User("d","1");
            studentList.add(user);

            user = new User("e","1");
            studentList.add(user);

            user = new User("f","1");
            studentList.add(user);

            user = new User("g","1");
            studentList.add(user);

            user = new User("h","1");
            studentList.add(user);

            user = new User("i","1");
            studentList.add(user);

            user = new User("g","1");
            studentList.add(user);

            oos.writeObject(studentList);
            oos.flush();
            */

            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/a.txt"));
            ArrayList<User> obj = (ArrayList<User>) ois.readObject();

            System.out.println("目前列表中的学生信息有");
            for(User us:obj){
                System.out.println(us);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(null != ois) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
