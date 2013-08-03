FukkatuNoJumonBuilder
======================
ドラゴンクエスト（以下DQ1)のふっかつのじゅもんを作ります。
このプログラムはSATOH_Yoshiyuki氏が公開されている「復活の呪文」資料室の情報を元に作成されました。

ドラゴンクエストはスクエアエニックス社の登録商標です。
メソッド名のセンスがないのは気にしないでください。

使い方
------
+ DQ1Characterをbuildします。
+ DQ1Characterに装備や薬草・魔法の鍵、ストーリー上のフラグ、もちものをセットします。
+ DQ1FukkatsuNoJumonBuilderにDQ1Characterを渡してbuildします。
+ DQ1FukkatsuNoJumonBuilderからgetJumonでふっかつのじゅもんを受け取ります。

------

### 実装例 ###
    public void hoge()
    {
        DQ1Character dc = DQ1Character.build("もょもと", 5000, 15000, 0);

        dc.setEquip(0, 0, 0);
        dc.setHarbAndKey(0, 0);
        dc.setFlags(true, true, true, true, true);

        dc.addItem(0, 0, 0, 0, 0, 0, 0, 0);

        DQ1FukkatsuNoJumonBuilder builder = DQ1FukkatsuNoJumonBuilder.build(dc);

        String jumon = builder.getJumon();

        System.out.print(jumon);
    }

パラメータの解説
----------------
実装例で使われているメソッドのパラメータを解説します。

    DQ1Character.build(name, exp, gold, cryptCode)
主人公を作成します。

+   `name` : 主人公の名前をセットします。濁点半濁点を含む場合は２文字としてカウントされます。

+   `exp` : 主人公の経験値をセットします。６５５３５までの数字で入力してください。

+   `gold` : 主人公の所持金をセットします。６５５３５までの数字で入力してください。

+   `cryptCode` : ふっかつのじゅもんに一様性を出さないために生成時にランダムな数字を用いていたようです。７までの数字を入力してください。

----
    dc.setEquip(weapon, armor, shield);
数字または名称で主人公に装備品をセットします。

+ `weapon` : 武器をセットします。次の何れかから選んでください。

  + 0 : なし

  + 1 : たけざお

  + 2 : こんぼう

  + 3 : どうのつるぎ

  + 4 : てつのつるぎ

  + 5 : はがねのつるぎ

  + 6 : ほのおのつるぎ

  + 7 : ロトのつるぎ

+ `armor` : よろいをセットします。次の何れかから選んでください。

  + 0 : なし

  + 1 : ぬののふく

  + 2 : かわのふく

  + 3 : くさりかたびら

  + 4 : てつのよろい

  + 5 : はがねのよろい

  + 6 : まほうのよろい

  + 7 : ロトのよろい

+ `shield` : 盾をセットします。次の何れかから選んでください。

  + 0 : なし

  + 1 : かわのたて

  + 2 : てつのたて

  + 3 : みかがみのたて

----
    dc.setHarbAndKey(harb, key);
やくそうとまほうのかぎをセットします。これらは固定で枠があり所有数だけを指定します。

+ `harb` : やくそうの所有数をセットします。

+ `key` : まほうのかぎの所有数をセットします。

----
    dc.setFlags(dragon, golem, senshinoyubiwa, shinokubikazari, ryuunouroko);
ストーリー上のフラグをセットします。trueが進行済み、falseが未進行です。

+ `dragon` : ドラゴンを倒したかどうかをセットします。

+ `golem` : ゴーレムを倒したかどうかをセットします。

+ `senshinoyubiwa` : せんしのゆびわを入手したかどうかをセットします。

+ `shinokubikazari` : しのくびかざりを入手したかどうかをセットします。

+ `ryuunouroko` : りゅうのうろこを装備したかどうかをセットします。

----
    dc.addItem(item0, item1, ... item7);
数字または名称で各スロットにどうぐをセットします。

+ `item0` ... `item7`

  + 0 : なし

  + 1 : たいまつ

  + 2 : せいすい

  + 3 : キメラのつばさ

  + 4 : りゅうのうろこ

  + 5 : ようせいのふえ

  + 6 : せんしのゆびわ

  + 7 : ロトのしるし

  + 8 : おうじょのあい

  + 9 : のろいのベルト

  + 10 : ぎんのたてごと

  + 11 : しのくびかざり

  + 12 : たいようのいし

  + 13 : あまぐものつえ

  + 14 : にじのしずく

  + 15 : （不明）


----
    DQ1FukkatsuNoJumonBuilder.build(dc);
主人公をセットしてふっかつのじゅもんを作ります。

+ `dc` : ふっかつのじゅもんを作りたい対象の主人公

----
    builder.getJumon();
ふっかつのじゅもんを受け取ります。戻り値はStringです。



関連情報
--------
###
1. [SATOH_Yoshiyuki氏 「復活の呪文」資料室](http://www.imasy.or.jp/~yotti/dq-passwd.html "リンクのタイトル")

ライセンス
----------
Copyright &copy; 2013 grim3lt.org
