package mylove.poly2.poly18;

class Process18 {
    Process18[] datas;

    public Process18() {

    }

    public Process18(Process18[] datas) {
        this.datas = datas;
    }

    void run(Score_ver18[] std) {
        for (int i = 0; i < datas.length; i++) {
            datas[i].run(std);
        }
    }
}

/////////////////////////////////////////////////////////
class Total18 extends Process18 {
    public Total18() {
        super();
    }

    public Total18(Process18[] datas) {
        super(datas);
    }

    @Override
    void run(Score_ver18[] std) {
        for (Score_ver18 score_ver18 : std) {
            score_ver18.setTotal(score_ver18.getEng() + score_ver18.getKor() + score_ver18.getMath());
        }
    }
}

////////////////////////////////////////////////////
class Aver18 extends Process18 {
    @Override
    void run(Score_ver18[] std) {
        for (Score_ver18 score_ver18 : std) {
            score_ver18.setAver((double) score_ver18.getTotal() / 3);
        }
    }
}

class Pass18 extends Process18 {
    @Override
    void run(Score_ver18[] std) {
        for (Score_ver18 score_ver18 : std) {
            String s = "";
            if (score_ver18.getAver() >= 60) {
                s = "합격";
            } else {
                s = "불합격";
            }
            score_ver18.setP(s);
        }
    }
}

class Jang18 extends Process18 {
    @Override
    void run(Score_ver18[] std) {
        for (Score_ver18 score_ver18 : std) {
            String s = "";
            if (score_ver18.getAver() >= 95) {
                s = "장학생";
            } else {
                s = "";
            }
            score_ver18.setS(s);
        }
    }
}

class Star18 extends Process18 {
    @Override
    void run(Score_ver18[] std) {
        for (Score_ver18 score_ver18 : std) {
            int aver = (int) (score_ver18.getAver() / 10);
            String s = "";
            for (int i = 0; i < aver; i++) {
                s += "*";
            }
            score_ver18.setRank(s);
        }
    }
}


