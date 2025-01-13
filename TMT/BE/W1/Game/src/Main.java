public class Main {
    public static void main(String[] args) {
        Player player = new Player("Alpha", 100, 10, 5);
        Boss boss = new Boss("Dracula", 100, 10, 5, 1);

        BattleService battleService = new BattleService();
        boolean isPlayerTurn = true;
        int turnCount = 1;
        while (player.hp > 0 && boss.hp > 0) {
            System.out.print("Turn " + turnCount + ": ");
            if (isPlayerTurn) {
                battleService.playerAttack(player, boss);
            } else {
                battleService.bossAttack(boss, player);
            }

            if (player.hp == 0 || boss.hp == 0) {
                break;
            }

            isPlayerTurn = !isPlayerTurn;
            turnCount++;
        }

//        battleService.playerAttack(player, boss);
//        battleService.playerAttack(player, boss);
//        battleService.bossAttack(boss, player);
//        battleService.playerAttack(player, boss);
//        battleService.playerAttack(player, boss);
//        battleService.playerAttack(player, boss);
//        battleService.bossAttack(boss, player);
//        battleService.bossAttack(boss, player);
//        battleService.bossAttack(boss, player);
//        battleService.bossAttack(boss, player);
//        battleService.playerAttack(player, boss);
//        battleService.playerAttack(player, boss);
//        battleService.playerAttack(player, boss);
//        battleService.bossAttack(boss, player);
//        battleService.bossAttack(boss, player);
//        battleService.playerAttack(player, boss);
//        battleService.playerAttack(player, boss);
//        battleService.playerAttack(player, boss);
//        battleService.bossAttack(boss, player);
//        battleService.bossAttack(boss, player);
//        battleService.bossAttack(boss, player);
//        battleService.playerAttack(player, boss);
//        battleService.playerAttack(player, boss);
//        battleService.playerAttack(player, boss);
//        battleService.playerAttack(player, boss);
//        battleService.playerAttack(player, boss);
//        battleService.bossAttack(boss, player);

        if (player.hp == 0) {
            System.out.println(player.name + " kalah!");
        } else if (boss.hp == 0) {
            System.out.println(boss.name + " kalah!");
        }
    }
}