package com.example.quizapp2.Model;

public class Questions {
    String answer,opt_A,opt_B,opt_C,opt_D,question;

    public Questions(String answer, String opt_A, String opt_B, String opt_C, String opt_D, String question) {
        this.answer = answer;
        this.opt_A = opt_A;
        this.opt_B = opt_B;
        this.opt_C = opt_C;
        this.opt_D = opt_D;
        this.question = question;
    }
    public Questions(){}

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getOpt_A() {
        return opt_A;
    }

    public void setOpt_A(String opt_A) {
        this.opt_A = opt_A;
    }

    public String getOpt_B() {
        return opt_B;
    }

    public void setOpt_B(String opt_B) {
        this.opt_B = opt_B;
    }

    public String getOpt_C() {
        return opt_C;
    }

    public void setOpt_C(String opt_C) {
        this.opt_C = opt_C;
    }

    public String getOpt_D() {
        return opt_D;
    }

    public void setOpt_D(String opt_D) {
        this.opt_D = opt_D;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
