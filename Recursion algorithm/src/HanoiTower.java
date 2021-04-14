public class HanoiTower {
    int n;
    public HanoiTower(int n){
        this.n=n;
        hanoiTower(n,'s','e','b');
    }
    public void hanoiTower(int n,char start,char end,char between) {
        if (n == 1) {
            System.out.println("move disk 1 from " + start + " to " + end);
            return;
        }
        hanoiTower(n - 1, start, between, end);
        System.out.println("move disk " + n + " from " + start + " to " + end);
        hanoiTower(n - 1, between, end, start);
    }
}
