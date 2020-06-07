package com.server;

import com.mode.*;

import java.io.IOException;

/**
 * 编程实现服务器的主要功能
 */
public class ServerInterface {

    private ServerInitClose sic;
    private ServerDao sd;

    public ServerInterface(ServerInitClose sic, ServerDao sd){
        this.sic = sic;
        this.sd = sd;
    }

    /**
     * 自定义成员方法实现客户端发来消息的接受和处理
     */
    public void serverReceive() throws ClassNotFoundException, IOException {
        while(true) {
            UserMessage tum = (UserMessage) sic.getOis().readObject();
            System.out.println("接收到的消息时：" + tum);

            String checkType = tum.getType();
            if("managerCheck".equals(checkType)) {
                if (sd.serverManagerCheck(tum.getUser())) {
                    tum.setType("success");
                } else {
                    tum.setType("fail");
                }
            }
            else if("studentCheck".equals(checkType)){
                if (sd.serverStudentCheck(tum.getUser())) {
                    tum.setType("success");
                } else {
                    tum.setType("fail");
                }
            }
            else if("logOut".equals(checkType)){
                return;
            }
            else{
                tum.setType("fail");
            }

            sic.getOos().writeObject(tum);
            System.out.println("服务器发送校验结果成功");

            if("studentCheck".equals(checkType) && "success".equals(tum.getType())){
                while(true) {
                    Object value = sic.getOis().readObject();
                    if(value instanceof UserMessage){
                        UserMessage tum1 = (UserMessage) value;
                        System.out.println("接收到的消息时：" + tum1);

                        if ("passwordUpdate".equals(tum1.getType())) {
                            if (sd.serverStudentPassword(tum1.getUser())) {
                                tum1.setType("success");
                            }
                            else {
                                tum1.setType("fail");
                            }
                            sic.getOos().writeObject(tum1);
                            System.out.println("服务器发送校验结果成功");
                        }
                        else if("userLogOut".equals(tum1.getType())){
                            break;
                        }
                    }
                    else if(value instanceof UserExamMessage){
                        UserExamMessage tum1 = (UserExamMessage) value;
                        System.out.println("接收到的消息时：" + tum1);

                        if("questionStart".equals(tum1.getType())){
                            if(sd.serverStudentQuestionStart(tum1.getUser(), tum1.getProblemType(), tum1.getScore())){
                                tum1.setType("success");
                            }
                            else {
                                tum1.setType("fail");
                            }
                            sic.getOos().writeObject(tum1);
                            System.out.println("服务器发送校验结果成功");
                        }
                    }
                }
            }
            else if("managerCheck".equals(checkType) && "success".equals(tum.getType())){
                while(true){
                    Object value = sic.getOis().readObject();
                    if(value instanceof UserMessage) {
                        UserMessage tum1 = (UserMessage)value;
                        System.out.println("接收到的消息时：" + tum1);

                        if ("userSearch".equals(tum1.getType())) {
                            User result = sd.serverManagerUserSearch(tum1.getUser());
                            if (null != result) {
                                tum1.setType("success");
                                tum1.setUser(result);
                            } else {
                                tum1.setType("fail");
                            }

                            sic.getOos().writeObject(tum1);
                            System.out.println("服务器发送校验结果成功");
                        }
                        else if ("userDeletion".equals(tum1.getType())) {
                            if (sd.serverManagerUserDeletion(tum1.getUser())) {
                                tum1.setType("success");
                            } else {
                                tum1.setType("fail");
                            }

                            sic.getOos().writeObject(tum1);
                            System.out.println("服务器发送校验结果成功");
                        }
                        else if ("userUpdate".equals(tum1.getType())) {

                            User result = sd.serverManagerUserSearch(tum1.getUser());
                            if (null != result) {
                                tum1.setType("success");
                            } else {
                                tum1.setType("fail");
                            }
                            sic.getOos().writeObject(tum1);
                            System.out.println("服务器发送校验结果成功");

                            if ("success".equals(tum1.getType())) {
                                UserMessage tum2 = (UserMessage) sic.getOis().readObject();
                                System.out.println("接收到的消息时：" + tum2);

                                if (sd.serverManagerUserUpdate(tum2.getUser(), result)) {
                                    tum2.setType("success");
                                } else {
                                    tum2.setType("fail");
                                }

                                sic.getOos().writeObject(tum2);
                                System.out.println("服务器发送校验结果成功");
                            }
                        }
                        else if ("userAddition".equals(tum1.getType())) {
                            if (sd.serverManagerUserAddition(tum1.getUser())) {
                                tum1.setType("success");
                            } else {
                                tum1.setType("fail");
                            }

                            sic.getOos().writeObject(tum1);
                            System.out.println("服务器发送校验结果成功");
                        }
                        else if ("managerLogOut".equals((tum1.getType()))) {
                            break;
                        }
                    }
                    else if(value instanceof QuestionMessage){
                        QuestionMessage tum1 = (QuestionMessage)value;
                        System.out.println("接收到的消息时：" + tum1);

                        if ("questionSearch".equals((tum1.getType()))) {
                            Question result = sd.serverManagerQuestionSearch(tum1.getQuestion());
                            if (null != result){
                                tum1.setType("success");
                                tum1.setQuestion(result);
                            }
                            else {
                                tum1.setType("fail");
                            }
                            sic.getOos().writeObject(tum1);
                            System.out.println("服务器发送校验结果成功");
                        }
                        else if ("questionDeletion".equals((tum1.getType()))) {
                            if (sd.serverManagerQuestionDeletion(tum1.getQuestion())) {
                                tum1.setType("success");
                            }
                            else {
                                tum1.setType("fail");
                            }

                            sic.getOos().writeObject(tum1);
                            System.out.println("服务器发送校验结果成功");
                        }
                        else if ("questionUpdate".equals((tum1.getType()))) {
                            Question result = sd.serverManagerQuestionSearch(tum1.getQuestion());
                            if (null != result){
                                tum1.setType("success");
                            }
                            else {
                                tum1.setType("fail");
                            }

                            sic.getOos().writeObject(tum1);
                            System.out.println("服务器发送校验结果成功");

                            if ("success".equals(tum1.getType())) {
                                QuestionMessage tum2 = (QuestionMessage) sic.getOis().readObject();
                                System.out.println("接收到的消息时：" + tum2);

                                if (sd.serverManagerQuestionUpdate(tum2.getQuestion(), result)) {
                                    tum2.setType("success");
                                }
                                else {
                                    tum2.setType("fail");
                                }

                                sic.getOos().writeObject(tum2);
                                System.out.println("服务器发送校验结果成功");
                            }
                        }
                        else if ("questionAddition".equals((tum1.getType()))) {
                            if (sd.serverManagerQuestionAddition(tum1.getQuestion())) {
                                tum1.setType("success");
                            }
                            else {
                                tum1.setType("fail");
                            }

                            sic.getOos().writeObject(tum1);
                            System.out.println("服务器发送校验结果成功");
                        }
                    }
                }
            }
        }
    }
}
