package org.grim3lt.FukkatsuNoJumonBuilder.services;

import org.grim3lt.FukkatsuNoJumonBuilder.models.HeroModel;
import org.grim3lt.FukkatsuNoJumonBuilder.values.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class JumonService {
    private final int[] data = new int[15];
    private final int[] encodedCodes = new int[20];

    public String encode(HeroModel heroModel, CryptoCode cryptoCode) {

        // 変換前データを作る
        // 名前の変換
        this.setName(heroModel.name());

        // 経験値の変換
        this.setExp(heroModel.experience());

        // 所持金の変換
        this.setGold(heroModel.gold());

        // 武器 盾 鎧三点セットの変換
        this.setEquip(heroModel.weapon(), heroModel.armor(), heroModel.shield());

        // 鍵 薬草の変換
        this.setKeyAndHerb(heroModel.magicKey(), heroModel.herb());

        // アイテムx8の変換
        this.setItem(heroModel.items());

        // 各種フラグの設定
        this.setEquippedItems(heroModel.isEquippedDragonScale(), heroModel.isEquippedSolderRing());
        this.setBeatBossMonster(heroModel.beatDragon(), heroModel.beatGolem());

        // 死の首飾りを入手したかどうか
        this.setCursedItemFlags(heroModel.hasDeathNecklace());

        // チェックコード（0-7）の設定
        this.setCryptoCode(cryptoCode);

        // マジックコートを計算
        this.setMagicNumber();

        // 変換後データを作る
        return this.encode();
    }

    // 名前の分解
    private void setName(Name name) {
        String nameString = name.toString();

        // 一文字ずつ切り出す
        // HashMapから文字コードを引き出す
        switch(nameString.length()) {
            case 4:
                data[7] = data[7] | (nameMap.get(nameString.substring(3, 4)));
            case 3:
                data[12] = data[12] | (nameMap.get(nameString.substring(2, 3)));
            case 2:
                data[1] = data[1] | (nameMap.get(nameString.substring(1, 2)) << 1);
            case 1:
                data[9] = data[9] | (nameMap.get(nameString.substring(0, 1)) << 2);
        }
    }

    // 経験値の展開
    private void setExp(Experience exp) {
        // 経験値の上位バイトを格納
        data[2] = (exp.value() >> 8) & 0xff;

        // 経験値の下位バイトを格納
        data[13]= exp.value() & 0xff;
    }

    // 所持金の展開
    private void setGold(Gold gold) {
        // Goldの上位バイトを格納
        data[5] = (gold.value() >> 8) & 0xff;

        // Goldの下位バイトを格納
        data[10] = gold.value() & 0xff;
    }

    // 装備の展開
    private void setEquip(Weapon weapon, Armor armor, Shield shield) {
        // 武器上位3ビット　鎧2-5ビット　盾下位2ビット
        data[6] = weapon.code() << 5 | armor.code() << 2 | shield.code();
    }

    // 薬草と魔法の鍵の展開
    private void setKeyAndHerb(MagicKey key, Herb herb) {
        data[4] = (key.value() << 4) | herb.value();
    }

    // どうぐの展開
    private void setItem(Item[] items) {
        // インベントリ1-2が0バイト目、3-4が11バイト目、 5-6が3バイト目、 7-8が8バイト目
        data[0] = (items[1].code() << 4) | items[0].code();
        data[11]= (items[3].code() << 4) | items[2].code();
        data[3] = (items[5].code() << 4) | items[4].code();
        data[8] = (items[7].code() << 4) | items[6].code();
    }

    // どうぐ系装備品の展開
    private void setEquippedItems(boolean isEquippedDragonScale, boolean isEquippedSolderRing) {
        // 竜の鱗装備
        if(isEquippedDragonScale) {
            data[1] = data[1] | 0x80;
        }
        // 戦士の指輪装備
        if(isEquippedSolderRing) {
            data[1] = data[1] | 0x01;
        }
    }

    // ボスモンスター討伐フラグの展開
    private void setBeatBossMonster(boolean beatDragon, boolean beatGolem) {
        // 見張りドラゴン退治
        if(beatDragon) {
            data[7] = data[7] | 0x40;
        }

        // メルキドのゴーレム退治
        if(beatGolem) {
            data[9] = data[9] | 0x02;
        }
    }

    // のろいのどうぐ装備系フラグ類の展開
    private void setCursedItemFlags(boolean hasDeathNecklace) {
        // 死の首飾り入手
        if(hasDeathNecklace) {
            data[12] = data[12] | 0x40;
        }
    }

    // ふっかつのじゅもんにランダム性をもたせるコード
    private void setCryptoCode(CryptoCode cryptoCode) {
        int code = cryptoCode.value();
        if((code & 0x01) == 0x01) {
            data[7] = data[7] | 0x80;
        }

        if((code & 0x02) == 0x02) {
            data[9] = data[9] | 0x01;
        }

        if((code & 0x04) == 0x04) {
            data[12] = data[12] |0x80;
        }
    }

    // マジックコードの埋め込み
    private void setMagicNumber() {
        for (int i = 0; i < 14; i ++) {
            for (int j = 0; j < 8; j ++ ) {
                if (0 != (data[i] & (0x80 >> j))) {
                    data[14] ^= magicNumber[i * 8 + j] ;
                }
            }
        }
    }

    // 15バイトのdataを6bitで分割して20文字分のデータにする
    private String encode() {
        // 8bitを3つ並べて24bitにしてから6bitコードに分割する。
        int j = 0;
        for(int i = 14; i >= 0; i -= 3) {
            int tmp = data[i - 2] << 16 | data[i - 1] << 8 | data[i];

            encodedCodes[j++] =  tmp        & 0x003f;
            encodedCodes[j++] = (tmp >> 6 ) & 0x003f;
            encodedCodes[j++] = (tmp >> 12) & 0x003f;
            encodedCodes[j++] = (tmp >> 18) & 0x003f;
        }

        int work = 0;
        for(int i = 0; i < encodedCodes.length; i ++) {
            work = (encodedCodes[i] + work + 4) & 0x3f;
            encodedCodes[i] = work;
        }

        // ひらがなの対比表に変換する。
        StringBuilder stringBuffer = new StringBuilder();
        for(int encodedCode : encodedCodes) {
            stringBuffer.append(jumonMap.get(encodedCode));
        }
        return stringBuffer.toString();
    }

    // password変換用のHashMap
    private final HashMap<Integer, String> jumonMap = new HashMap<>() {
        {
            put(0, "あ");
            put(1, "い");
            put(2, "う");
            put(3, "え");
            put(4, "お");
            put(5, "か");
            put(6, "き");
            put(7, "く");
            put(8, "け");
            put(9, "こ");
            put(10, "さ");
            put(11, "し");
            put(12, "す");
            put(13, "せ");
            put(14, "そ");
            put(15, "た");
            put(16, "ち");
            put(17, "つ");
            put(18, "て");
            put(19, "と");
            put(20, "な");
            put(21, "に");
            put(22, "ぬ");
            put(23, "ね");
            put(24, "の");
            put(25, "は");
            put(26, "ひ");
            put(27, "ふ");
            put(28, "へ");
            put(29, "ほ");
            put(30, "ま");
            put(31, "み");
            put(32, "む");
            put(33, "め");
            put(34, "も");
            put(35, "や");
            put(36, "ゆ");
            put(37, "よ");
            put(38, "ら");
            put(39, "り");
            put(40, "る");
            put(41, "れ");
            put(42, "ろ");
            put(43, "わ");
            put(44, "が");
            put(45, "ぎ");
            put(46, "ぐ");
            put(47, "げ");
            put(48, "ご");
            put(49, "ざ");
            put(50, "じ");
            put(51, "ず");
            put(52, "ぜ");
            put(53, "ぞ");
            put(54, "だ");
            put(55, "ぢ");
            put(56, "づ");
            put(57, "で");
            put(58, "ど");
            put(59, "ば");
            put(60, "び");
            put(61, "ぶ");
            put(62, "べ");
            put(63, "ぼ");
        }
    };

    // 名前変換用のHashMap
    private final HashMap<String, Integer> nameMap = new HashMap<>() {
        {
            put("０", 0);
            put("１", 1);
            put("２", 2);
            put("３", 3);
            put("４", 4);
            put("５", 5);
            put("６", 6);
            put("７", 7);
            put("８", 8);
            put("９", 9);
            put("あ", 10);
            put("い", 11);
            put("う", 12);
            put("え", 13);
            put("お", 14);
            put("か", 15);
            put("き", 16);
            put("く", 17);
            put("け", 18);
            put("こ", 19);
            put("さ", 20);
            put("し", 21);
            put("す", 22);
            put("せ", 23);
            put("そ", 24);
            put("た", 25);
            put("ち", 26);
            put("つ", 27);
            put("て", 28);
            put("と", 29);
            put("な", 30);
            put("に", 31);
            put("ぬ", 32);
            put("ね", 33);
            put("の", 34);
            put("は", 35);
            put("ひ", 36);
            put("ふ", 37);
            put("へ", 38);
            put("ほ", 39);
            put("ま", 40);
            put("み", 41);
            put("む", 42);
            put("め", 43);
            put("も", 44);
            put("や", 45);
            put("ゆ", 46);
            put("よ", 47);
            put("ら", 48);
            put("り", 49);
            put("る", 50);
            put("れ", 51);
            put("ろ", 52);
            put("わ", 53);
            put("を", 54);
            put("ん", 55);
            put("っ", 56);
            put("ゃ", 57);
            put("ゅ", 58);
            put("ょ", 59);
            put("゛", 60);
            put("゜", 61);
            put("ー", 62);
            put("　", 63);
        }
    };

    private final int[] magicNumber = {
            0x88, 0xc4, 0x62, 0x31, 0x08, 0x84, 0x42, 0x21,
            0x98, 0xcc, 0xe6, 0x73, 0xa9, 0xc4, 0x62, 0x31,
            0x5a, 0xad, 0xc6, 0x63, 0xa1, 0xc0, 0x60, 0x30,
            0x38, 0x9c, 0x4e, 0xa7, 0xc3, 0xf1, 0x68, 0xb4,
            0xd0, 0x68, 0xb4, 0x5a, 0x2d, 0x06, 0x83, 0x51,
            0x20, 0x10, 0x08, 0x84, 0x42, 0xa1, 0x40, 0xa0,
            0xf9, 0xec, 0xf6, 0x7b, 0xad, 0xc6, 0xe3, 0x61,
            0x81, 0xd0, 0x68, 0xb4, 0xda, 0x6d, 0xa6, 0xd3,
            0xb2, 0xd9, 0xfc, 0xfe, 0xff, 0xef, 0x67, 0x23,
            0x34, 0x1a, 0x0d, 0x96, 0x4b, 0x35, 0x8a, 0x45,
            0xaa, 0xd5, 0x7a, 0x3d, 0x8e, 0x47, 0xb3, 0x49,
            0xa1, 0x40, 0xa0, 0x50, 0xa8, 0xd4, 0xea, 0x75,
            0xa0, 0xd0, 0x68, 0xb4, 0x5a, 0xad, 0xc6, 0x63,
            0x7e, 0xbf, 0xcf, 0xf7, 0x6b, 0xa5, 0xc2, 0x61
    };
}
