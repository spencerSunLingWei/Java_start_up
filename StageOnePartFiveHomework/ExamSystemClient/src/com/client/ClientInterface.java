package com.client;

import com.mode.*;

import java.io.*;
import java.util.*;

public class ClientInterface {
    /**
     * 为了可以使用输入输出流，采用合成复用原则实现
     */
    private ClientInitClose cic;

    /**
     * 通过构造方法实现成员变量的初始化
     */
    public ClientInterface(ClientInitClose cic){
        this.cic = cic;
    }

    /**
     * 自定义成员方法实现客户端主界面的绘制
     */
    public void clientMainPage() throws IOException, ClassNotFoundException {
        while(true) {
            System.out.println();
            System.out.println("    \t在线考试系统");
            System.out.println("--------------------------");
            System.out.print("    [1]学员系统");
            System.out.println("      [2]管理员系统");
            System.out.println("    [0]退出系统");
            System.out.println("--------------------------");
            System.out.print("请选择要进行的业务编号：");

            int choose = ClientScanner.getScanner().nextInt();
            switch (choose) {
                case 1:
                    System.out.println("正在进入学员系统");
                    clientStudentLogin();
                    break;
                case 2:
                    System.out.println("正在进入管理员系统");
                    clientManagerLogin();
                    break;
                case 0:
                    System.out.println("正在退出系统");
                    clientLogout();
                    return;
                default:
                    System.out.println("输入错误，请重新选择！");
            }
        }
    }

    /**
     * 自定义成员方法实现客户端退出程序
     */
    private void clientLogout() throws IOException {
        UserMessage tum = new UserMessage("logOut", new User("",""));

        cic.getOos().writeObject(tum);
        System.out.println("客户端发送退出程序指令成功");
    }











/*------------------------------------------------------------------------------------------------------------------------------*/

    /**
     * 自定义成员方法实现客户端管理员登陆
     * 登陆成功：在线考试系统 - 管理员系统
     * [1]学生管理模块
     * [2]考题管理模块
     * [0]退出管理员系统
     */
    private void clientManagerLogin() throws IOException, ClassNotFoundException {
        System.out.print("请输入管理员的账户信息：");
        String username = ClientScanner.getScanner().next();
        System.out.print("请输入管理员的密码信息：");
        String password = ClientScanner.getScanner().next();
        UserMessage tum = new UserMessage("managerCheck", new User(username,password));

        cic.getOos().writeObject(tum);
        System.out.println("客户端发送管理员账户信息成功");

        tum = (UserMessage) cic.getOis().readObject();
        if("success".equalsIgnoreCase(tum.getType())){
            System.out.println("登陆成功，欢迎进入管理员模式");

            while(true) {
                System.out.println();
                System.out.println("    \t在线考试系统 - 管理员系统");
                System.out.println("--------------------------");
                System.out.print("    [1]学生管理模块");
                System.out.println("      [2]考题管理模块");
                System.out.println("    [0]退出管理员系统");
                System.out.println("--------------------------");
                System.out.print("请选择要进行的业务编号：");

                int choose = ClientScanner.getScanner().nextInt();
                switch (choose) {
                    case 1:
                        System.out.println("正在进入管理员系统 - 学生管理模块");
                        clientManagerUser();
                        break;
                    case 2:
                        System.out.println("正在进入管理员系统 - 考题管理模块");
                        clientManagerQuestion();
                        break;
                    case 0:
                        System.out.println("正在退出管理员系统");
                        clientManagerLogOut();
                        return;
                    default:
                        System.out.println("输入错误，请重新选择！");
                }
            }
        }
        else{
            System.out.println("登陆失败，请重新尝试");
        }
    }

    /**
     * 在线考试系统 - 管理员系统 - 退出管理员系统
     */
    private void clientManagerLogOut() throws IOException {
        UserMessage tum1 = new UserMessage("managerLogOut", new User("",""));

        cic.getOos().writeObject(tum1);
        System.out.println("客户端发送退出管理员退出指令成功");
    }

    /**
     * 在线考试系统 - 管理员系统 - 考题管理模块
     * [1]增加考题功能
     * [2]修改考题功能
     * [3]删除考题功能
     * [4]查询考题功能
     * [0]退出考题管理模块
     */
    private void clientManagerQuestion() {
        System.out.println();
        System.out.println("    \t在线考试系统 - 管理员系统 - 考题管理模块");
        System.out.println("--------------------------");
        System.out.print("    [1]增加考题功能");
        System.out.print("    [2]修改考题功能");
        System.out.print("    [3]删除考题功能");
        System.out.println("    [4]查询考题功能");
        System.out.println("    [0]退出考题管理模块");
        System.out.println("--------------------------");
        System.out.print("请选择要进行的业务编号：");

        int choose = ClientScanner.getScanner().nextInt();
        switch (choose) {
            case 1:
                System.out.println("正在进入管理员系统 - 考题管理模块 - 增加考题功能");
                clientManagerQuestionAddition();
                break;
            case 2:
                System.out.println("正在进入管理员系统 - 考题管理模块 - 修改考题功能");
                clientManagerQuestionUpdate();
                break;
            case 3:
                System.out.println("正在进入管理员系统 - 考题管理模块 - 删除考题功能");
                clientManagerQuestionDeletion();
                break;
            case 4:
                System.out.println("正在进入管理员系统 - 考题管理模块 - 查询考题功能");
                clientMangerQuestionSearch();
                break;
            case 0:
                System.out.println("正在退出考题管理模块");
                break;
            default:
                System.out.println("输入错误，请重新选择！");
        }
    }

    /**
     * 在线考试系统 - 管理员系统 - 考题管理模块 - 查询考题功能
     */
    private void clientMangerQuestionSearch() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/b.txt"));
            HashMap<String, ArrayList<Question>> obj = (HashMap<String, ArrayList<Question>>) ois.readObject();

            Set<String> keys = obj.keySet();
            for(String ky:keys){
                ArrayList<Question> questionList = obj.get(ky);

                System.out.println("\n----------------------------科目: " + ky + "----------------------------");
                for(int i=0; i<questionList.size(); i++){
                    System.out.println("No." + (i+1) + ": " + questionList.get(i).getProblemDescription());
                }
                System.out.println("-----------------------------------------------------------------\n");
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.print("请输入您所想要查询的科目：");
        String input_problemType = ClientScanner.getScanner().next();
        System.out.print("请输入您所想要查询的问题题干序号：");
        String input_problemDescription = ClientScanner.getScanner().next();

        QuestionMessage tum = new QuestionMessage("questionSearch", new Question(input_problemDescription,"","","","","",input_problemType));

        try {
            cic.getOos().writeObject(tum);
            System.out.println("客户端发送查询考题的指令成功");

            tum = (QuestionMessage) cic.getOis().readObject();
            if("success".equalsIgnoreCase(tum.getType())){
                System.out.println("已查到该考题： ");
                Question result = tum.getQuestion();

                System.out.println("\n\tproblemDescription='" + result.getProblemDescription() +
                        "\n\t\t\tA: " + result.getAnswerA() +
                        "\n\t\t\tB: " + result.getAnswerB() +
                        "\n\t\t\tC: " + result.getAnswerC() +
                        "\n\t\t\tD: " + result.getAnswerD() +
                        "\n\t\t正确答案: " + result.getCorrectAnswer() +
                        "\n\t\t考查科目：" + result.getProblemType() +
                        "\n"
                );
            }
            else{
                System.out.println("未能查到该考题，请重新选择！");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在线考试系统 - 管理员系统 - 考题管理模块 - 删除考题功能
     */
    private void clientManagerQuestionDeletion() {

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/b.txt"));
            HashMap<String, ArrayList<Question>> obj = (HashMap<String, ArrayList<Question>>) ois.readObject();

            Set<String> keys = obj.keySet();
            for(String ky:keys){
                ArrayList<Question> questionList = obj.get(ky);

                System.out.println("\n----------------------------科目: " + ky + "----------------------------");
                for(int i=0; i<questionList.size(); i++){
                    System.out.println("No." + (i+1) + ": " + questionList.get(i).getProblemDescription());
                }
                System.out.println("-----------------------------------------------------------------\n");
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.print("请输入您所想要删除的科目：");
        String input_problemType = ClientScanner.getScanner().next();
        System.out.print("请输入您所想要删除的问题题干序号：");
        String input_problemDescription = ClientScanner.getScanner().next();

        QuestionMessage tum = new QuestionMessage("questionDeletion", new Question(input_problemDescription,"","","","","",input_problemType));

        try {
            cic.getOos().writeObject(tum);
            System.out.println("客户端发送删除考题的指令成功");

            tum = (QuestionMessage) cic.getOis().readObject();
            if("success".equalsIgnoreCase(tum.getType())){
                System.out.println("已删除该考题");
            }
            else{
                System.out.println("未能查到该考题，请重新选择！");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在线考试系统 - 管理员系统 - 考题管理模块 - 修改考题功能
     */
    private void clientManagerQuestionUpdate() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/b.txt"));
            HashMap<String, ArrayList<Question>> obj = (HashMap<String, ArrayList<Question>>) ois.readObject();

            Set<String> keys = obj.keySet();
            for(String ky:keys){
                ArrayList<Question> questionList = obj.get(ky);

                System.out.println("\n----------------------------科目: " + ky + "----------------------------");
                for(int i=0; i<questionList.size(); i++){
                    Question result = questionList.get(i);
                    System.out.println("No." + (i+1) +
                            "\tproblemDescription='" + result.getProblemDescription() +
                            "\n\t\t\tA: " + result.getAnswerA() +
                            "\n\t\t\tB: " + result.getAnswerB() +
                            "\n\t\t\tC: " + result.getAnswerC() +
                            "\n\t\t\tD: " + result.getAnswerD() +
                            "\n\t\t正确答案: " + result.getCorrectAnswer() +
                            "\n\t\t考查科目：" + result.getProblemType()
                    );
                }
                System.out.println("-----------------------------------------------------------------\n");
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.print("请输入您所想要修改的科目：");
        String input_problemType = ClientScanner.getScanner().next();
        System.out.print("请输入您所想要修改的问题题干序号：");
        String input_problemDescription = ClientScanner.getScanner().next();

        QuestionMessage tum = new QuestionMessage("questionUpdate", new Question(input_problemDescription,"","","","","",input_problemType));

        try {
            cic.getOos().writeObject(tum);
            System.out.println("客户端发送查询题目的指令成功");

            tum = (QuestionMessage) cic.getOis().readObject();
            if("success".equalsIgnoreCase(tum.getType())){
                System.out.println("已查到该考题");

                Scanner kk = new Scanner(System.in);

                System.out.print("请输入您所想要修改后的题目的题干：");
                String problemDescription = kk.nextLine();

                System.out.print("请输入您所想要修改后的题目的A选项内容：");
                String answerA = kk.nextLine();

                System.out.print("请输入您所想要修改后的题目的B选项内容：");
                String answerB = kk.nextLine();

                System.out.print("请输入您所想要修改后的题目的C选项内容：");
                String answerC = kk.nextLine();

                System.out.print("请输入您所想要修改后的题目的D选项内容：");
                String answerD = kk.nextLine();

                System.out.print("请输入您所想要修改后的题目的正确选项：");
                String correctAnswer = kk.nextLine();

                tum = new QuestionMessage("questionUpdateNext", new Question(problemDescription,correctAnswer,answerA,answerB,answerC,answerD,input_problemType));

                try {
                    cic.getOos().writeObject(tum);
                    System.out.println("客户端发送用户修改题目的指令成功");

                    tum = (QuestionMessage) cic.getOis().readObject();
                    if("success".equalsIgnoreCase(tum.getType())) {
                        System.out.println("题目内容修改成功");
                    }
                    else{
                        System.out.println("题目内容修改失败");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("未能查到该题目，请重新选择！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在线考试系统 - 管理员系统 - 考题管理模块 - 增加考题功能
     */
    private void clientManagerQuestionAddition() {

        Scanner spll = new Scanner(System.in);
        System.out.print("请输入您所想要添加题目的所在学科：");
        String problemType = spll.nextLine();

        System.out.print("请输入您所想要添加题目的题干：");
        String problemDescription = spll.nextLine();

        System.out.print("请输入您所想要添加题目的A选项内容：");
        String answerA = spll.nextLine();

        System.out.print("请输入您所想要添加题目的B选项内容：");
        String answerB = spll.nextLine();

        System.out.print("请输入您所想要添加题目的C选项内容：");
        String answerC = spll.nextLine();

        System.out.print("请输入您所想要添加题目的D选项内容：");
        String answerD = spll.nextLine();

        System.out.print("请输入您所想要添加题目的正确选项：");
        String correctAnswer = spll.nextLine();

        QuestionMessage tum = new QuestionMessage("questionAddition", new Question(problemDescription,correctAnswer,answerA,answerB,answerC,answerD,problemType));

        try {
            cic.getOos().writeObject(tum);
            System.out.println("客户端发送用户添加考题的指令成功");

            tum = (QuestionMessage) cic.getOis().readObject();
            if("success".equalsIgnoreCase(tum.getType())) {
                System.out.println("已成功添加该考题");

                ObjectInputStream ois = null;
                try {
                    ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/b.txt"));
                    HashMap<String, ArrayList<Question>> obj = (HashMap<String, ArrayList<Question>>) ois.readObject();

                    Set<String> keys = obj.keySet();
                    for(String ky:keys){
                        ArrayList<Question> questionList = obj.get(ky);

                        System.out.println("\n----------------------------科目: " + ky + "----------------------------");
                        for(int i=0; i<questionList.size(); i++){
                            System.out.println("No." + (i+1) + ": " + questionList.get(i).getProblemDescription());
                        }
                        System.out.println("-----------------------------------------------------------------\n");
                    }
                    ois.close();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("该考题已在考题题库中，请重新选择！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在线考试系统 - 管理员系统 - 学生管理模块
     * [1]添加学生功能
     * [2]修改学生功能
     * [3]删除学生功能
     * [4]查询学生功能
     * [0]退出学生管理模块
     */
    private void clientManagerUser() throws IOException {
        System.out.println();
        System.out.println("    \t在线考试系统 - 管理员系统 - 学生管理模块");
        System.out.println("--------------------------");
        System.out.print("    [1]添加学生功能");
        System.out.print("    [2]修改学生功能");
        System.out.print("    [3]删除学生功能");
        System.out.println("    [4]查询学生功能");
        System.out.println("    [0]退出学生管理模块");
        System.out.println("--------------------------");
        System.out.print("请选择要进行的业务编号：");

        int choose = ClientScanner.getScanner().nextInt();
        switch (choose) {
            case 1:
                System.out.println("正在进入管理员系统 - 学生管理模块 - 添加学生功能");
                clientManagerUserAddition();
                break;
            case 2:
                System.out.println("正在进入管理员系统 - 学生管理模块 - 修改学生功能");
                clientManagerUserUpdate();
                break;
            case 3:
                System.out.println("正在进入管理员系统 - 学生管理模块 - 删除学生功能");
                clientManagerUserDeletion();
                break;
            case 4:
                System.out.println("正在进入管理员系统 - 学生管理模块 - 查询学生功能");
                clientMangerUserSearch();
                break;
            case 0:
                System.out.println("正在退出学生管理模块");
                break;
            default:
                System.out.println("输入错误，请重新选择！");
        }
    }

    /**
     * 在线考试系统 - 管理员系统 - 学生管理模块 - 查询学生功能
     */
    private void clientMangerUserSearch() {

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/a.txt"));
            ArrayList<User> obj = (ArrayList<User>) ois.readObject();

            System.out.println("目前列表中的学生信息有");
            for(User us:obj){
                System.out.println("学生姓名：" + us.getUsername());
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.print("\n请输入您所想要查询的学生名字：");
        String input_name = ClientScanner.getScanner().next();

        UserMessage tum = new UserMessage("userSearch", new User(input_name,""));

        try {
            cic.getOos().writeObject(tum);
            System.out.println("客户端发送查询学生的指令成功");

            tum = (UserMessage) cic.getOis().readObject();
            if("success".equalsIgnoreCase(tum.getType())){
                System.out.println("已查到该学生： ");
                System.out.println("\t学生姓名： " + tum.getUser().getUsername());
                System.out.println("\t学生密码： " + tum.getUser().getPassword());
                System.out.println("\t学生成绩: ");

                Map<String, ArrayList<Integer>> scoreList = tum.getUser().getScore();
                if(null != scoreList){
                    Set<String> keySet = scoreList.keySet();

                    for(String key:keySet){
                        ArrayList<Integer> scoreOfKey = scoreList.get(key);
                        System.out.println("\t\t科目： " + key + " / " + "共做过该试卷" + scoreOfKey.size() + "次");

                        Integer average_score = 0;
                        for(int i=0; i<scoreOfKey.size(); i++){
                            System.out.println("\t\t\t尝试次数：" + (i+1) + " / " + "得分: " + scoreOfKey.get(i));
                            average_score += scoreOfKey.get(i);
                        }

                        System.out.println("\t\t平均分：" + average_score / scoreOfKey.size());
                    }
                }
                else{
                    System.out.println("\t\t该学生还没有完成任何考卷");
                }
            }
            else{
                System.out.println("未能查到该学生，请重新选择！");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在线考试系统 - 管理员系统 - 学生管理模块 - 删除学生功能
     */
    private void clientManagerUserDeletion() {

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/a.txt"));
            ArrayList<User> obj = (ArrayList<User>) ois.readObject();

            System.out.println("目前列表中的学生信息有");
            for(User us:obj){
                System.out.println("学生姓名：" + us.getUsername());
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.print("\n请输入您所想要删除的学生名字：");
        String input_name = ClientScanner.getScanner().next();

        UserMessage tum = new UserMessage("userDeletion", new User(input_name,""));
        try {
            cic.getOos().writeObject(tum);
            System.out.println("客户端发送用户删除学生的指令成功");

            tum = (UserMessage) cic.getOis().readObject();
            if("success".equalsIgnoreCase(tum.getType())) {
                System.out.println("已经成功删除该学生");
            }
            else{
                System.out.println("该学生不在学生名单中，请重新输入！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在线考试系统 - 管理员系统 - 学生管理模块 - 修改学生功能
     */
    private void clientManagerUserUpdate() {

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/a.txt"));
            ArrayList<User> obj = (ArrayList<User>) ois.readObject();

            System.out.println("目前列表中的学生信息有");
            for(User us:obj){
                System.out.println("学生姓名：" + us.getUsername() + " / 学生密码：" + us.getPassword());
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.print("请输入您想要修改的学生姓名：");
        String input_name = ClientScanner.getScanner().next();

        UserMessage tum = new UserMessage("userUpdate", new User(input_name,""));
        try {
            cic.getOos().writeObject(tum);
            System.out.println("客户端发送查询学生的指令成功");

            tum = (UserMessage) cic.getOis().readObject();
            if("success".equalsIgnoreCase(tum.getType())){
                System.out.println("已查到该学生");


                System.out.print("请输入修改后该学生的姓名：");
                String new_name = ClientScanner.getScanner().next();

                System.out.print("请输入修改后该学生的密码：");
                String new_password = ClientScanner.getScanner().next();

                tum = new UserMessage("userUpdateNext", new User(new_name,new_password));
                try {
                    cic.getOos().writeObject(tum);
                    System.out.println("客户端发送用户修改学生的指令成功");

                    tum = (UserMessage) cic.getOis().readObject();
                    if("success".equalsIgnoreCase(tum.getType())) {
                        System.out.println("学生信息修改成功");
                    }
                    else{
                        System.out.println("学生信息修改失败");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
            else{
                System.out.println("未能查到该学生，请重新选择！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在线考试系统 - 管理员系统 - 学生管理模块 - 添加学生功能
     */
    private void clientManagerUserAddition() {

        System.out.print("请输入您所想要添加的学生名字：");
        String input_name = ClientScanner.getScanner().next();
        System.out.print("请输入您所想要添加的学生初始默认密码：");
        String input_password = ClientScanner.getScanner().next();

        UserMessage tum = new UserMessage("userAddition", new User(input_name,input_password));
        try {
            cic.getOos().writeObject(tum);
            System.out.println("客户端发送用户添加学生的指令成功");

            tum = (UserMessage) cic.getOis().readObject();
            if("success".equalsIgnoreCase(tum.getType())) {
                System.out.println("已成功添加该学生");

                ObjectInputStream ois = null;
                try {
                    ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/a.txt"));
                    ArrayList<User> obj = (ArrayList<User>) ois.readObject();

                    System.out.println("目前列表中的学生信息有");
                    for(User us:obj){
                        System.out.println("学生姓名：" + us.getUsername());
                    }
                    ois.close();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("该学生已在学生名单中，请重新选择！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




















/*------------------------------------------------------------------------------------------------------------------------------*/

    /**
     * 自定义成员方法实现客户端学生登陆
     * 登陆成功：在线考试系统 - 学生系统
     * [1]用户模块
     * [2]考试模块
     * [0]退出学生系统
     */
    private void clientStudentLogin() throws IOException, ClassNotFoundException {
        System.out.print("请输入学生的账户信息：");
        String username = ClientScanner.getScanner().next();
        System.out.print("请输入学生的密码信息：");
        String password = ClientScanner.getScanner().next();
        UserMessage tum = new UserMessage("studentCheck", new User(username,password));

        cic.getOos().writeObject(tum);
        System.out.println("客户端发送学生账户信息成功");

        tum = (UserMessage) cic.getOis().readObject();
        if("success".equalsIgnoreCase(tum.getType())){
            System.out.println("登陆成功，欢迎" + tum.getUser().getUsername() + "进入学生模式");

            while(true) {
                System.out.println();
                System.out.println("    \t在线考试系统 - 学生系统");
                System.out.println("--------------------------");
                System.out.print("    [1]用户模块");
                System.out.println("      [2]考试模块");
                System.out.println("    [0]退出学生系统");
                System.out.println("--------------------------");
                System.out.print("请选择要进行的业务编号：");

                int choose = ClientScanner.getScanner().nextInt();
                switch (choose) {
                    case 1:
                        System.out.println("正在进入学生系统 - 用户模块");
                        clientStudentUser(tum.getUser());
                        break;
                    case 2:
                        System.out.println("正在进入学生系统 - 考试模块");
                        clientStudentQuestion(tum.getUser());
                        break;
                    case 0:
                        System.out.println("正在退出学生系统");
                        clientStudentUserLogOut();
                        return;
                    default:
                        System.out.println("输入错误，请重新选择！");
                }
            }
        }
        else{
            System.out.println("登陆失败，请重新尝试");
        }
    }

    /**
     * 在线考试系统 - 学生系统 - 考试模块
     * [1]开始考试功能
     * [2]导出成绩功能
     * [3]查询成绩功能
     * [0]退出考试模块
     */
    private void clientStudentQuestion(User user) {
        System.out.println();
        System.out.println("    \t在线考试系统 - 学生系统 - 考试模块");
        System.out.println("--------------------------");
        System.out.print("    [1]开始考试功能");
        System.out.print("    [2]导出成绩功能");
        System.out.println("    [3]查询成绩功能");
        System.out.println("    [0]退出考试模块");
        System.out.println("--------------------------");
        System.out.print("请选择要进行的业务编号：");

        int choose = ClientScanner.getScanner().nextInt();
        switch (choose) {
            case 1:
                System.out.println("正在进入学生系统 - 考试模块 - 开始考试功能");
                clientStudentQuestionStart(user);
                break;
            case 2:
                System.out.println("正在进入学生系统 - 考试模块 - 导出成绩功能");
                clientStudentQuestionLoad(user);
                break;
            case 3:
                System.out.println("正在进入学生系统 - 考试模块 - 查询成绩功能");
                clientStudentQuestionGet(user);
                break;
            case 0:
                System.out.println("正在退出考试模块");
                break;
            default:
                System.out.println("输入错误，请重新选择！");
        }
    }

    /**
     * 在线考试系统 - 学生系统 - 考试模块 - 开始考试功能
     */
    private void clientStudentQuestionStart(User user) {

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/b.txt"));
            HashMap<String, ArrayList<Question>> obj = (HashMap<String, ArrayList<Question>>) ois.readObject();

            System.out.println("此次考试包括的科目有：");
            Set<String> keys = obj.keySet();
            for(String ky:keys){
                System.out.println("\t" + ky);
            }
            ois.close();

            System.out.print("请选择您要考试的科目：");
            String input_problemType = ClientScanner.getScanner().next();

            if(keys.contains(input_problemType) && obj.get(input_problemType).size()!=0){

                System.out.println("\n-----------------------开始考试-----------------------\n");
                ArrayList<Question> questions = obj.get(input_problemType);
                ArrayList<String> choices = new ArrayList<>();
                ArrayList<String> correct_choices = new ArrayList<>();

                for(int i=0; i<questions.size(); i++){
                    Question result = questions.get(i);
                    System.out.println("No." + (i+1) +
                            "\tproblemDescription='" + result.getProblemDescription() +
                            "\n\t\t\tA: " + result.getAnswerA() +
                            "\n\t\t\tB: " + result.getAnswerB() +
                            "\n\t\t\tC: " + result.getAnswerC() +
                            "\n\t\t\tD: " + result.getAnswerD()
                    );
                    System.out.print("请输入您所选择的答案：");
                    String choice = ClientScanner.getScanner().next();
                    choices.add(choice);
                    correct_choices.add(result.getCorrectAnswer());
                    System.out.println();
                }

                System.out.println("-----------------------考试结束-----------------------\n");
                System.out.println("本次考试您的所有题目的选项汇总是： "+ choices + " / 已成功提交该考卷，请等待出分");

                int score = 0;
                for(int i=0; i< choices.size(); i++){
                    if(correct_choices.get(i).equalsIgnoreCase(choices.get(i))){
                        score++;
                    }
                }

                int final_score = (int) (((double)score / (double)choices.size()) * 100);

                UserExamMessage tum = new UserExamMessage("questionStart", user, input_problemType, final_score);

                cic.getOos().writeObject(tum);
                System.out.println("客户端发送考卷评分结果登记的指令成功");

                tum = (UserExamMessage) cic.getOis().readObject();
                if("success".equalsIgnoreCase(tum.getType())){
                    System.out.println("考卷批改成功，本张试卷您的得分是： " + final_score);
                }
                else{
                    System.out.println("考卷批改录入成绩失败");
                }
            }
            else{
                System.out.println("没有该项科目或该科目中暂时没有题目，请重新选择！");
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 在线考试系统 - 学生系统 - 考试模块 - 导出成绩功能
     */
    private void clientStudentQuestionLoad(User user) {
        Set<String> keys = null;
        try {
            ObjectInputStream ois = null;
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/b.txt"));
            HashMap<String, ArrayList<Question>> obj = (HashMap<String, ArrayList<Question>>) ois.readObject();

            keys = obj.keySet();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream ois = null;
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/a.txt"));
            ArrayList<User> obj = (ArrayList<User>) ois.readObject();

            for(User us:obj){
                if(us.getUsername().equals(user.getUsername())){
                    user = us;
                    break;
                }
            }
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {

            File file = new File("/Users/spencersun/Desktop/score.txt");
            FileWriter fr = new FileWriter(file);
            String data = null;

            data = "\n学生姓名：" + user.getUsername() + "\n";
            fr.write(data);

            for(String ky:keys) {
                ArrayList<Integer> scoreList = user.getScore().get(ky);
                if (null == scoreList) {
                    data = "\t您还没有参加科目为"+ky+"的考试" + "\n";
                    fr.write(data);
                } else {

                    data = "\t考试科目：" + ky + "\n";
                    fr.write(data);

                    int average = 0;
                    for (int i = 0; i < scoreList.size(); i++) {
                        data = "\t\t第" + (i + 1) + "次尝试 / 得分：" + scoreList.get(i) + "\n";
                        fr.write(data);

                        average += scoreList.get(i);
                    }
                    data = "\t科目均分：" + (average / scoreList.size()) + "\n";
                    fr.write(data);
                }
            }
            fr.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("您好您所有科目的成绩已下载到桌面名为score.txt的文件中了。");
    }

    /**
     * 在线考试系统 - 学生系统 - 考试模块 - 查询成绩功能
     */
    private void clientStudentQuestionGet(User user) {

        try {
            ObjectInputStream ois = null;
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/b.txt"));
            HashMap<String, ArrayList<Question>> obj = (HashMap<String, ArrayList<Question>>) ois.readObject();

            System.out.println("考试所包括的科目有：");
            Set<String> keys = obj.keySet();
            for(String ky:keys){
                System.out.println("\t" + ky);
            }
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.print("请输入您想查询的科目：");
        String input_problemType = ClientScanner.getScanner().next();

        try {
            ObjectInputStream ois = null;
            ois = new ObjectInputStream(new FileInputStream("/Users/spencersun/Desktop/a.txt"));
            ArrayList<User> obj = (ArrayList<User>) ois.readObject();

            for(User us:obj){
                if(us.getUsername().equals(user.getUsername())){
                    user = us;
                    break;
                }
            }
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(user.getScore().containsKey(input_problemType)){
            ArrayList<Integer> scoreList = user.getScore().get(input_problemType);
            if(null == scoreList){
                System.out.println("您还没有参加该科目的考试");
            }
            else{
                System.out.println("\n\t学生姓名：" + user.getUsername());
                System.out.println("\t考试科目："+ input_problemType);

                int average = 0;
                for(int i=0; i<scoreList.size(); i++){
                    System.out.println("\t\t第"+(i+1)+"次尝试 / 得分：" + scoreList.get(i));
                    average += scoreList.get(i);
                }
                System.out.println("\t科目均分：" + (average/scoreList.size()));
            }
        }
        else{
            System.out.println("该科目不存在或您还未参加该科目的考试，请重新选择！");
        }
    }

    /**
     * 在线考试系统 - 学生系统 - 退出学生系统
     */
    private void clientStudentUserLogOut() throws IOException {
        UserMessage tum1 = new UserMessage("userLogOut", new User("",""));

        cic.getOos().writeObject(tum1);
        System.out.println("客户端发送退出学生用户退出指令成功");
    }

    /**
     * 在线考试系统 - 学生系统 - 用户模块
     * [1]修改密码功能
     * [0]退出用户模块
     */
    private void clientStudentUser(User user) throws IOException {
        System.out.println();
        System.out.println("    \t在线考试系统 - 学生系统 - 用户模块");
        System.out.println("--------------------------");
        System.out.print("    [1]修改密码功能");
        System.out.println("    [0]退出用户模块");
        System.out.println("--------------------------");
        System.out.print("请选择要进行的业务编号：");

        int choose = ClientScanner.getScanner().nextInt();
        switch (choose) {
            case 1:
                System.out.println("正在进入学生系统 - 用户模块 - 修改密码功能");
                clientStudentUserPassword(user);
                break;
            case 0:
                System.out.println("正在退出用户模块");
                break;
            default:
                System.out.println("输入错误，请重新选择！");
        }
    }

    /**
     * 在线考试系统 - 学生系统 - 用户模块 - 修改密码功能
     */
    private void clientStudentUserPassword(User user) {

        String password0 = null;
        String password1 = null;
        String password2 = null;
        while(true) {
            System.out.print("请输入您的旧密码：");
            password0 = ClientScanner.getScanner().next();

            System.out.print("请输入您的新密码：");
            password1 = ClientScanner.getScanner().next();

            System.out.print("请再次输入您的新密码：");
            password2 = ClientScanner.getScanner().next();

            if(user.getPassword().equals(password0)){
                if (password1.equals(password2)) {
                    System.out.println("您的新密码是： " + password1);
                    break;
                } else {
                    System.out.println("两次密码输入不同，请重新尝试");
                }
            }
            else{
                System.out.println("您的旧密码输入不正确，请重新尝试");
            }
        }

        UserMessage tum = new UserMessage("passwordUpdate", new User(user.getUsername(), password1));

        try {
            cic.getOos().writeObject(tum);
            System.out.println("客户端发送用户更改密码的指令成功");

            tum = (UserMessage) cic.getOis().readObject();
            if("success".equalsIgnoreCase(tum.getType())){
                System.out.println("密码修改成功");
            }
            else{
                System.out.println("密码修改失败");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
