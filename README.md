FukkatuNoJumonBuilder
======================
ドラゴンクエスト（以下DQ1)のふっかつのじゅもんを作ります。
このプログラムはSATOH_Yoshiyuki氏が公開されている「復活の呪文」資料室の情報を元に作成されました。

ドラゴンクエストはスクエアエニックス社の登録商標です。

使い方
------
ここでは CLI での HTTP 通信は [HTTPie](https://httpie.io/) を使用しています。適宜読み替えてください。

- `./gradlew bootRun` してサーバーを起動します。
- `http GET localhost:8080/equipment/weapons` で武器の一覧が取得できます。
- `http GET localhost:8080/equipment/armors` で鎧の一覧が取得できます。
- `http GET localhost:8080/equipment/shields` で盾の一覧が取得できます。
- `http POST localhost:8080/hero name="お好きな名前" exp=経験値 gold=ゴールド` で勇者のパラメータを取得できます。
- `http POST localhost:8080/king` に ./hero で取得して適宜修正したパラメータを request body として渡すと `ふっかつのじゅもん` が帰ってきます。

### 便利な使い方 ###
```shell
$ http POST localhost:8080/hero name="おなまえ" exp=33440 gold=30000 > hero.json
# 適宜 hero.json の内容を書き換える
$ http POST localhost:8080/king < hero.json
```


パラメータの解説
----------------
実装例で使われているメソッドのパラメータを解説します。

### 勇者パラメータ
`POST localhost/hero` で取得できる勇者の全パラメータです。
これらに値を設定し、`POST localhost/king` することでふっかつのじゅもんが得られます。

```json
{
  "name": {
    "value": "おなまえ"
  },
  "weapon": "COPPER_SWORD",
  "armor": "FULL_PLATE",
  "shield": "IRON_SHIELD",
  "experience": {
    "value": 52310
  },
  "gold": {
    "value": 30000
  },
  "herb": {
    "value": 3
  },
  "magicKey": {
    "value": 6
  },
  "items": [
    "NOTHING",
    "NOTHING",
    "NOTHING",
    "NOTHING",
    "NOTHING",
    "NOTHING",
    "NOTHING",
    "NOTHING"
  ],
  "beat_dragon": false,
  "beat_golem": false,
  "equipped_cursed_belt": false,
  "equipped_death_necklace": false,
  "equipped_dragon_scale": false,
  "equipped_solder_ring": false
}
```


### 装備品

#### 武器
武器の表示名と設定名です。勇者パラメータには `name` の設定名を仕様してください。
```json
[
    {
        "display_name": "なし",
        "name": "NOTHING"
    },
    {
        "display_name": "たけざお",
        "name": "BAMBOO_LANCE"
    },
    {
        "display_name": "こんぼう",
        "name": "CLUB"
    },
    {
        "display_name": "どうのつるぎ",
        "name": "COPPER_SWORD"
    },
    {
        "display_name": "てつのおの",
        "name": "IRON_AXE"
    },
    {
        "display_name": "はがねのつるぎ",
        "name": "IRON_SWORD"
    },
    {
        "display_name": "ほのおのつるぎ",
        "name": "FIRE_SWORD"
    },
    {
        "display_name": "ロトのつるぎ",
        "name": "SWORD_OF_ROTO"
    }
]
```

#### 鎧
鎧の表示名と設定名です。勇者パラメータには `name` の設定名を仕様してください。
```json
[
    {
        "display_name": "なし",
        "name": "NOTHING"
    },
    {
        "display_name": "ぬののふく",
        "name": "CLOTHES"
    },
    {
        "display_name": "かわのふく",
        "name": "LEATHER_CLOTHES"
    },
    {
        "display_name": "くさりかたびら",
        "name": "CHAIN_MAIL"
    },
    {
        "display_name": "てつのよろい",
        "name": "IRON_ARMOR"
    },
    {
        "display_name": "はがねのよろい",
        "name": "FULL_PLATE"
    },
    {
        "display_name": "まほうのよろい",
        "name": "MAGICAL_ARMOR"
    },
    {
        "display_name": "ロトのよろい",
        "name": "ARMOR_OF_ROTO"
    }
]
```

#### 盾
盾の表示名と設定名です。勇者パラメータには `name` の設定名を仕様してください。
```json
[
    {
        "display_name": "なし",
        "name": "NOTHING"
    },
    {
        "display_name": "かわのたて",
        "name": "LEATHER_SHIELD"
    },
    {
        "display_name": "てつのたて",
        "name": "IRON_SHIELD"
    },
    {
        "display_name": "みかがみのたて",
        "name": "SILVER_SHIELD"
    }
]
```

#### どうぐ
どうぐの表示名と設定名です。勇者パラメータには `name` の設定名を仕様してください。
```json
[
    {
        "display_name": "なし",
        "name": "NOTHING"
    },
    {
        "display_name": "たいまつ",
        "name": "TOUCH"
    },
    {
        "display_name": "せいすい",
        "name": "HOLY_WATER"
    },
    {
        "display_name": "キメラのつばさ",
        "name": "WING"
    },
    {
        "display_name": "りゅうのうろこ",
        "name": "DRAGON_SCALE"
    },
    {
        "display_name": "ようせいのふえ",
        "name": "FAIRY_FLUTE"
    },
    {
        "display_name": "せんしのゆびわ",
        "name": "SOLDER_RING"
    },
    {
        "display_name": "ロトのしるし",
        "name": "ROTOS_TOKEN"
    },
    {
        "display_name": "おうじょのあい",
        "name": "PRINCESS_LOVE"
    },
    {
        "display_name": "のろいのベルト",
        "name": "CURSE_BELT"
    },
    {
        "display_name": "ぎんのたてごと",
        "name": "SILVER_HARP"
    },
    {
        "display_name": "しのくびかざり",
        "name": "DEATH_NECKLACE"
    },
    {
        "display_name": "たいようのいし",
        "name": "STONE_OF_SUNLIGHT"
    },
    {
        "display_name": "あまぐものつえ",
        "name": "STUFF_OF_THE_RAIN"
    },
    {
        "display_name": "にじのしずく",
        "name": "RAINBOW_DROP"
    },
    {
        "display_name": "（不明）",
        "name": "UNKNOWN"
    }
]
```

関連情報
--------
1. [SATOH_Yoshiyuki氏 「復活の呪文」資料室](http://www.imasy.or.jp/~yotti/dq-passwd.html "リンクのタイトル")

ライセンス
----------
Copyright &copy; 2021 grim3lt.org
