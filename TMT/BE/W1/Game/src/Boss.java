public class Boss extends Player {
    protected int modifier;
    protected int attackedCount;

    public Boss(String name, int hp, int power, int defense, int modifier) {
        super(name, hp, power, defense);
        this.modifier = modifier;
        this.attackedCount = 0;
    }
}