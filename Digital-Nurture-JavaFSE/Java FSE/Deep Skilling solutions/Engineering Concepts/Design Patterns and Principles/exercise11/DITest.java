package exercise11;
interface Repo { String get(); }
class RepoImpl implements Repo { public String get() { return "data"; } }
class Service { Repo r; Service(Repo r){this.r=r;} void print(){System.out.println(r.get());} }
public class DITest {
    public static void main(String[] args) { new Service(new RepoImpl()).print(); }
}
