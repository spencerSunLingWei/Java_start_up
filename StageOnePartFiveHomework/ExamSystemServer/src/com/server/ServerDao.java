package com.server;

import com.mode.Question;
import com.mode.User;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * 编程实现数据的存储
 */
public class ServerDao {

    /**
     * 编程实现管理员账号和密码的校验并将结果返回出去
     *
     * @param user
     * @return
     */
    public boolean serverManagerCheck(User user) {
        if ("admin".equalsIgnoreCase(user.getUsername()) &&
                "123456".equals(user.getPassword())) {
            return true;
        }
        return false;
    }

    /**
     * 编程实现学生账号和密码的校验并将结果返回出去
     */
    public boolean serverStudentCheck(User user) {
        Boolean to_return = false;
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/a.txt"));
            ArrayList<User> obj = (ArrayList<User>) ois.readObject();

            for (User us : obj) {
                if (user.getUsername().equals(us.getUsername()) && user.getPassword().equals(us.getPassword())) {
                    to_return = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null != ois) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return to_return;
    }

    /**
     * 编程实现学生密码的修改
     *
     * @param user
     * @return
     */
    public boolean serverStudentPassword(User user) {
        Boolean to_return = false;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois1 = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/a.txt"));
            ArrayList<User> obj = (ArrayList<User>) ois.readObject();

            for (User us : obj) {
                if (user.getUsername().equals(us.getUsername())) {
                    us.setPassword(user.getPassword());
                    to_return = true;
                    break;
                }
            }
            ois.close();

            File f = new File("/Users/spencersun/Desktop/a.txt");
            f.delete();

            oos = new ObjectOutputStream(new FileOutputStream("/Users/spencersun/Desktop/a.txt"));
            oos.writeObject(obj);
            oos.flush();

            ois1 = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/a.txt"));
            ArrayList<User> obj1 = (ArrayList<User>) ois1.readObject();

            System.out.println("目前列表中的学生信息有");
            for (User us : obj1) {
                System.out.println(us);
            }
            ois1.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return to_return;
    }

    /**
     * 编程实现manager的UserSearch
     * @param user
     * @return
     */
    public User serverManagerUserSearch(User user) {

        User to_return = null;
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/a.txt"));
            ArrayList<User> obj = (ArrayList<User>) ois.readObject();

            for (User us : obj) {
                if (user.getUsername().equals(us.getUsername())) {
                    to_return = us;
                    break;
                }
            }

            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return to_return;
    }

    /**
     * 编程实现manager的UserAddition
     * @param user
     * @return
     */
    public boolean serverManagerUserAddition(User user) {

        Boolean found = false;
        Boolean to_return = false;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois1 = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/a.txt"));
            ArrayList<User> obj = (ArrayList<User>) ois.readObject();

            for (User us : obj) {
                if (user.getUsername().equals(us.getUsername())) {
                    found = true;
                    break;
                }
            }
            ois.close();

            if(found){
                to_return = false;
            }
            else{

                File f = new File("/Users/spencersun/Desktop/a.txt");
                f.delete();

                oos = new ObjectOutputStream(new FileOutputStream("/Users/spencersun/Desktop/a.txt"));
                obj.add(user);
                oos.writeObject(obj);
                oos.flush();

                ois1 = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/a.txt"));
                ArrayList<User> obj1 = (ArrayList<User>) ois1.readObject();

                System.out.println("目前列表中的学生信息有");
                for (User us : obj1) {
                    System.out.println(us);
                }
                ois1.close();

                to_return = true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return to_return;
    }

    /**
     * 编程实现manager的UserDeletion
     * @param user
     * @return
     */
    public boolean serverManagerUserDeletion(User user) {

        Boolean found = false;
        Boolean to_return = false;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois1 = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/a.txt"));
            ArrayList<User> obj = (ArrayList<User>) ois.readObject();
            ArrayList<User> obj_new = new ArrayList<User>();

            for (User us : obj) {
                if (user.getUsername().equals(us.getUsername())) {
                    found = true;
                }
                else {
                    obj_new.add(us);
                }
            }
            ois.close();

            if(!found){
                to_return = false;
            }
            else{
                File f = new File("/Users/spencersun/Desktop/a.txt");
                f.delete();

                oos = new ObjectOutputStream(new FileOutputStream("/Users/spencersun/Desktop/a.txt"));
                oos.writeObject(obj_new);
                oos.flush();

                ois1 = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/a.txt"));
                ArrayList<User> obj1 = (ArrayList<User>) ois1.readObject();

                System.out.println("目前列表中的学生信息有");
                for (User us : obj1) {
                    System.out.println(us);
                }
                ois1.close();

                to_return = true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return to_return;

    }

    /**
     * 编程实现manager的UserUpdate
     * @return
     */
    public boolean serverManagerUserUpdate(User new_user, User original_user) {

        Boolean to_return = false;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois1 = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/a.txt"));
            ArrayList<User> obj = (ArrayList<User>) ois.readObject();

            for (User us : obj) {
                if (original_user.getUsername().equals(us.getUsername())) {
                    to_return = true;
                    us.setPassword(new_user.getPassword());
                    us.setUsername(new_user.getUsername());
                    break;
                }
            }
            ois.close();

            if(to_return){

                File f = new File("/Users/spencersun/Desktop/a.txt");
                f.delete();

                oos = new ObjectOutputStream(new FileOutputStream("/Users/spencersun/Desktop/a.txt"));
                oos.writeObject(obj);
                oos.flush();

                ois1 = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/a.txt"));
                ArrayList<User> obj1 = (ArrayList<User>) ois1.readObject();

                System.out.println("目前列表中的学生信息有");
                for (User us : obj1) {
                    System.out.println(us);
                }
                ois1.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return to_return;
    }

    /**
     * 编程实现manager的QuestionSearch
     * @param question
     * @return
     */
    public Question serverManagerQuestionSearch(Question question) {

        Question to_return = null;
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/b.txt"));
            HashMap<String, ArrayList<Question>> obj = (HashMap<String, ArrayList<Question>>) ois.readObject();

            Set<String> keys = obj.keySet();
            if(keys.contains(question.getProblemType())){
                ArrayList<Question> questionList = obj.get(question.getProblemType());
                int index = Integer.parseInt(question.getProblemDescription()) - 1;
                if(index < questionList.size()){
                    to_return = questionList.get(index);
                }
            }

            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return to_return;
    }

    /**
     * 编程实现manager的QuestionDeletion
     * @param question
     * @return
     */
    public boolean serverManagerQuestionDeletion(Question question) {

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        HashMap<String, ArrayList<Question>> new_obj = new HashMap<>();

        try {
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/b.txt"));
            HashMap<String, ArrayList<Question>> obj = (HashMap<String, ArrayList<Question>>) ois.readObject();

            Set<String> keys = obj.keySet();
            if(keys.contains(question.getProblemType())){
                int index = Integer.parseInt(question.getProblemDescription()) - 1;
                if(index >= obj.get(question.getProblemType()).size() || index < 0){
                    ois.close();
                    return false;
                }
            }
            else{
                ois.close();
                return false;
            }

            for(String ky:keys){
                ArrayList<Question> list = obj.get(ky);
                ArrayList<Question> new_list = new ArrayList<>();

                for(int i=0; i<list.size(); i++){
                    if(ky.equals(question.getProblemType())){
                        int index = Integer.parseInt(question.getProblemDescription()) - 1;
                        if(i != index){
                            new_list.add(list.get(i));
                        }
                    }
                    else{
                        new_list.add(list.get(i));
                    }
                }

                new_obj.put(ky,new_list);
            }

            ois.close();

            File f = new File("/Users/spencersun/Desktop/b.txt");
            f.delete();

            oos = new ObjectOutputStream(new FileOutputStream("/Users/spencersun/Desktop/b.txt"));
            oos.writeObject(new_obj);
            oos.flush();

            ObjectInputStream ois1 = null;
            try {
                ois1 = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/b.txt"));
                HashMap<String, ArrayList<Question>> obj1 = (HashMap<String, ArrayList<Question>>) ois1.readObject();

                Set<String> keys1 = obj1.keySet();
                for(String ky:keys1){
                    ArrayList<Question> questionList = obj1.get(ky);

                    System.out.println("\n----------------------------科目: " + ky + "----------------------------");
                    for(int i=0; i<questionList.size(); i++){
                        System.out.println("No." + (i+1) + ": " + questionList.get(i).getProblemDescription());
                    }
                    System.out.println("-----------------------------------------------------------------\n");
                }
                ois1.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return true;
    }

    /**
     * 编程实现manager的QuestionAddition
     * @param question
     * @return
     */
    public boolean serverManagerQuestionAddition(Question question) {

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        HashMap<String, ArrayList<Question>> new_obj = new HashMap<>();

        try {
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/b.txt"));
            HashMap<String, ArrayList<Question>> obj = (HashMap<String, ArrayList<Question>>) ois.readObject();

            Set<String> keys = obj.keySet();
            if(!keys.contains(question.getProblemType())){
                ArrayList<Question> new_list = new ArrayList<>();
                new_list.add(question);
                new_obj.put(question.getProblemType(), new_list);
                for(String ky:keys){
                    new_obj.put(ky, obj.get(ky));
                }
            }
            else{
                for(String ky:keys){
                    ArrayList<Question> list = obj.get(ky);
                    ArrayList<Question> new_list = new ArrayList<>();

                    if(!ky.equals(question.getProblemType())){
                        new_list = list;
                    }
                    else{
                        if(list.size()==0){
                            new_list.add(question);
                        }
                        else{
                            for (int i = 0; i < list.size(); i++) {
                                if (question.getProblemDescription().equals(list.get(i).getProblemDescription())) {
                                    ois.close();
                                    return false;
                                } else {
                                    new_list.add(list.get(i));
                                }
                            }
                            new_list.add(question);
                        }
                    }

                    new_obj.put(ky, new_list);
                }
            }

            ois.close();

            File f = new File("/Users/spencersun/Desktop/b.txt");
            f.delete();

            oos = new ObjectOutputStream(new FileOutputStream("/Users/spencersun/Desktop/b.txt"));
            oos.writeObject(new_obj);
            oos.flush();

            ObjectInputStream ois1 = null;
            try {
                ois1 = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/b.txt"));
                HashMap<String, ArrayList<Question>> obj1 = (HashMap<String, ArrayList<Question>>) ois1.readObject();

                Set<String> keys1 = obj1.keySet();
                for(String ky:keys1){
                    ArrayList<Question> questionList = obj1.get(ky);

                    System.out.println("\n----------------------------科目: " + ky + "----------------------------");
                    for(int i=0; i<questionList.size(); i++){
                        System.out.println("No." + (i+1) + ": " + questionList.get(i).getProblemDescription());
                    }
                    System.out.println("-----------------------------------------------------------------\n");
                }
                ois1.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return true;
    }

    /**
     * 编程实现manager的QuestionUpdate
     * @param new_q
     * @param prev_q
     * @return
     */
    public boolean serverManagerQuestionUpdate(Question new_q, Question prev_q) {

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        HashMap<String, ArrayList<Question>> new_obj = new HashMap<>();

        try {
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/b.txt"));
            HashMap<String, ArrayList<Question>> obj = (HashMap<String, ArrayList<Question>>) ois.readObject();

            Set<String> keys = obj.keySet();
            for(String ky:keys){
                if(!ky.equals(prev_q.getProblemType())){
                    new_obj.put(ky,obj.get(ky));
                }
                else{
                    ArrayList<Question> list = obj.get(ky);
                    ArrayList<Question> new_list = new ArrayList<>();

                    for(int i=0; i<list.size(); i++){
                        if (prev_q.getProblemDescription().equals(list.get(i).getProblemDescription())) {
                            new_list.add(new_q);
                        }
                        else {
                            new_list.add(list.get(i));
                        }
                    }

                    new_obj.put(ky,new_list);
                }
            }

            ois.close();

            File f = new File("/Users/spencersun/Desktop/b.txt");
            f.delete();

            oos = new ObjectOutputStream(new FileOutputStream("/Users/spencersun/Desktop/b.txt"));
            oos.writeObject(new_obj);
            oos.flush();

            ObjectInputStream ois1 = null;
            try {
                ois1 = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/b.txt"));
                HashMap<String, ArrayList<Question>> obj1 = (HashMap<String, ArrayList<Question>>) ois1.readObject();

                Set<String> keys1 = obj1.keySet();
                for(String ky:keys1){
                    ArrayList<Question> questionList = obj1.get(ky);

                    System.out.println("\n----------------------------科目: " + ky + "----------------------------");
                    for(int i=0; i<questionList.size(); i++){
                        System.out.println("No." + (i+1) + ": " + questionList.get(i).getProblemDescription());
                    }
                    System.out.println("-----------------------------------------------------------------\n");
                }
                ois1.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return true;

    }

    /**
     * 编程实现studentTesting的登分
     * @param user
     * @param problemType
     * @param score
     * @return
     */
    public boolean serverStudentQuestionStart(User user, String problemType, int score) {
        Boolean found = false;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois1 = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/a.txt"));
            ArrayList<User> obj = (ArrayList<User>) ois.readObject();
            User target_usr = null;

            for (User us : obj) {
                if (user.getUsername().equals(us.getUsername())) {
                    target_usr = us;
                    obj.remove(us);
                    break;
                }
            }
            ois.close();

            if(null == target_usr){
                return false;
            }
            else{
                HashMap<String, ArrayList<Integer>> totalScoreList = target_usr.getScore();
                if(null == totalScoreList){
                    ArrayList<Integer> singleScoreList = new ArrayList<>();
                    singleScoreList.add(score);
                    totalScoreList = new HashMap<>();
                    totalScoreList.put(problemType, singleScoreList);
                    target_usr.setScore(totalScoreList);
                }
                else {
                    if (!totalScoreList.containsKey(problemType)) {
                        ArrayList<Integer> singleScoreList = new ArrayList<>();
                        singleScoreList.add(score);
                        target_usr.getScore().put(problemType, singleScoreList);
                    } else {
                        ArrayList<Integer> singleScoreList = totalScoreList.get(problemType);
                        singleScoreList.add(score);
                        target_usr.getScore().replace(problemType, singleScoreList);
                    }
                }
            }

            File f = new File("/Users/spencersun/Desktop/a.txt");
            f.delete();

            oos = new ObjectOutputStream(new FileOutputStream("/Users/spencersun/Desktop/a.txt"));
            obj.add(target_usr);
            oos.writeObject(obj);
            oos.flush();

            System.out.println(target_usr.getScore());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return true;
    }


}