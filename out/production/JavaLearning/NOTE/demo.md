## 案例分析
#### 斗地主发牌案例




-----
## 斗地主发牌案例
斗地主发牌，三个玩家参与游戏，每人17张牌，最后三张牌留作底牌

#### 花色和数字
梅花 方块 黑桃 红心
3 4 5 6 7 8 9 10 J Q K A 2
大王 小王

####  打乱牌的顺序
Collections.shuffle(cards);

#### 发牌
设定三个玩家，以及最后的剩余的三张牌


```
ArrayList<String> cards = new ArrayList<String>();
cards.add("大王");
cards.add("小王");
String[] types = {"梅花", "方块", "黑桃", "红心"};
String[] values = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
for (int i = 0; i < 4; i++) {
    String type = types[i];
    for (int j = 0; j < 13; j++) {
        String value = values[j];
        String card = type + value;
        cards.add(card);
    }
}
System.out.println(cards);

Collections.shuffle(cards);
System.out.println(cards);

ArrayList<String> player1 = new ArrayList<String>();
ArrayList<String> player2 = new ArrayList<String>();
ArrayList<String> player3 = new ArrayList<String>();
ArrayList<String> cardsRemind = new ArrayList<String>();
for (int i = 0; i < 54; i++) {
    String card = cards.get(i);
    if (i >= 51) {
        cardsRemind.add(card);
        continue;
    }
    if (i % 3 == 0) {
        player1.add(card);
    } else if (i % 3 == 1) {
        player2.add(card);
    } else {
        player3.add(card);
    }
}
System.out.println(player1);
System.out.println(player2);
System.out.println(player3);
System.out.println(cardsRemind);
```