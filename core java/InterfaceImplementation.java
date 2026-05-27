
interface Playable {
    void play();
}

class Guitar implements Playable {
    public void play() {
        System.out.println("Strumming the guitar!");
    }
}

class Piano implements Playable {
    public void play() {
        System.out.println("Playing a classical melody on the piano!");
    }
}

public class InterfaceImplementation {
    public static void main(String[] args) {
        Playable p1 = new Guitar();
        Playable p2 = new Piano();

        p1.play();
        p2.play();
    }
}
