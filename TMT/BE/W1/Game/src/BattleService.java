public class BattleService implements IBattleService {

    @Override
    public void playerAttack(Player player, Boss boss) {
        if (player.hp > 0 && boss.hp > 0) {
            int damage = Math.max(0, player.power - boss.defense);
            boss.hp -= damage;
            boss.hp = Math.max(0, boss.hp);
            System.out.println(player.name + "(" + player.hp + ") hit " + boss.name + "(" + boss.hp + ")");
            boss.attackedCount += 1;
        }
    }

    @Override
    public void bossAttack(Boss boss, Player player) {
        if (player.hp > 0 && boss.hp > 0) {
            if (boss.attackedCount >= 5) {
                boss.modifier = 3;
                System.out.println(boss.name + " memiliki buff");
            }

            int damage = Math.max(0, (boss.power * boss.modifier) - player.defense);
            player.hp -= damage;
            player.hp = Math.max(0, player.hp);
            System.out.println(boss.name + "(" + boss.hp + ") hit " + player.name + "(" + player.hp + ")");

            if (boss.modifier == 3) {
                boss.modifier = 1;
                boss.attackedCount -= 5;
                System.out.println(boss.name + " telah menggunakan buff");
            }
        }
    }
}