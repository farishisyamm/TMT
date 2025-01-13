public interface IBattleService {
    void playerAttack(Player player, Boss boss);
    void bossAttack(Boss boss, Player player);
}
