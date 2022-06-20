package mylove.abstracts.abs004;

public abstract class Unit {
    abstract void move(int x, int y);

    abstract void stop();

}

class Marine extends Unit {
    int x, y;

    @Override
    void move(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("마린이 " + x + " " + y + " 움직인다");
    }

    @Override
    void stop() {
        System.out.println("마린이 멈춘다");
    }

    void stimPack() {
        System.out.println("스팀팩 사용");
    }
}

class Tank extends Unit {
    int x, y;

    @Override
    void move(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("탱크가 " + x + " " + y + " 움직인다");
    }

    @Override
    void stop() {
        System.out.println("탱크가 멈춘다");
    }

    void changeModel() {
        System.out.println("공격모드로 변환한다");
    }
}

class DropShip extends Unit {
    int x, y;

    @Override
    void move(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("수송선이 " + x + " " + y + " 움직인다");
    }

    @Override
    void stop() {
        System.out.println("수송선이 멈춘다");
    }

    void load() {
        System.out.println("선택된 대상을 태운다");
    }

    void unload() {
        System.out.println("선택된 대상을 내린다");
    }
}


