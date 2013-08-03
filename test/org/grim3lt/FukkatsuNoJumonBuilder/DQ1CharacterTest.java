package org.grim3lt.FukkatsuNoJumonBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DQ1CharacterTest
{
	
	DQ1Character dqc = null;

	@Before
	public void setUp() throws Exception
	{
		dqc = DQ1Character.build("テスト");
	}

	@After
	public void tearDown() throws Exception
	{
		dqc = null;
	}

	@Test
	public final void testSetFlags()
	{
        this.dqc.setFlags(
                true, // ドラゴン討伐
                true, // ゴーレム討伐
                true, // せんしのゆびわ所有
                true, // しのくびかざり所有
                true  // りゅうのうろこ装備
        );

        assertThat(this.dqc.broughtDownDragon(), is(true));
        assertThat(this.dqc.broughtDownGolem(), is(true));
        assertThat(this.dqc.hasSenshiNoYubiwa(), is(true));
        assertThat(this.dqc.hasShiNoKubikazari(), is(true));
        assertThat(this.dqc.hasRyuNoUroko(), is(true));
	}

	@Test (expected = NullPointerException.class)
	public final void testItemNotFound()
	{
		this.dqc.getItem(0);
	}
	
	@Test
	public final void testAddItemSingleParam0to7()
	{
		this.dqc.addItem("なし"          );
		this.dqc.addItem("たいまつ"      );
		this.dqc.addItem("せいすい"      );
		this.dqc.addItem("キメラのつばさ");
		this.dqc.addItem("りゅうのうろこ");
		this.dqc.addItem("ようせいのふえ");
        this.dqc.addItem("せんしのゆびわ");
        this.dqc.addItem("ロトのしるし"  );

		assertThat(this.dqc.getItem(0), is(0));
		assertThat(this.dqc.getItem(1), is(1));
		assertThat(this.dqc.getItem(2), is(2));
		assertThat(this.dqc.getItem(3), is(3));
		assertThat(this.dqc.getItem(4), is(4));
		assertThat(this.dqc.getItem(5), is(5));
        assertThat(this.dqc.getItem(6), is(6));
        assertThat(this.dqc.getItem(7), is(7));
	}

	@Test
	public final void testAddItemSingleParam8to15()
	{
		this.dqc.addItem("おうじょのあい");
		this.dqc.addItem("のろいのベルト");
		this.dqc.addItem("ぎんのたてごと");
		this.dqc.addItem("しのくびかざり");
        this.dqc.addItem("たいようのいし");
        this.dqc.addItem("あまぐものつえ");
        this.dqc.addItem("にじのしずく"  );
        this.dqc.addItem("（不明）"      );

		assertThat(this.dqc.getItem(0), is(8));
		assertThat(this.dqc.getItem(1), is(9));
		assertThat(this.dqc.getItem(2), is(10));
		assertThat(this.dqc.getItem(3), is(11));
        assertThat(this.dqc.getItem(4), is(12));
        assertThat(this.dqc.getItem(5), is(13));
        assertThat(this.dqc.getItem(6), is(14));
        assertThat(this.dqc.getItem(7), is(15));
    }
	
    @Test  (expected = IndexOutOfBoundsException.class)
    public final void testAddItemMultiParamCode() {
        this.dqc.addItem(1, 3, 5, 7, 9, 11, 13, 15);

        assertThat(this.dqc.getItem(0), is(1));
        assertThat(this.dqc.getItem(1), is(3));
        assertThat(this.dqc.getItem(2), is(5));
        assertThat(this.dqc.getItem(3), is(7));
        assertThat(this.dqc.getItem(4), is(9));
        assertThat(this.dqc.getItem(5), is(11));
        assertThat(this.dqc.getItem(6), is(13));
        assertThat(this.dqc.getItem(7), is(15));

        this.dqc.addItem(0, 2, 4);
        assertThat(this.dqc.getItem(8), is(0));
        assertThat(this.dqc.getItem(9), is(2));
        assertThat(this.dqc.getItem(10), is(4));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public final void testAddItemMultiParamName() {
        this.dqc.addItem(
            "たいまつ",
            "せいすい",
            "キメラのつばさ",
            "ようせいのふえ",
            "ロトのしるし",
            "おうじょのあい",
            "ぎんのたてごと",
            "にじのしずく",
            "（不明）"
        );

        assertThat(this.dqc.getItem(0), is(1));
        assertThat(this.dqc.getItem(1), is(2));
        assertThat(this.dqc.getItem(2), is(3));
        assertThat(this.dqc.getItem(3), is(5));
        assertThat(this.dqc.getItem(4), is(7));
        assertThat(this.dqc.getItem(5), is(8));
        assertThat(this.dqc.getItem(6), is(10));
        assertThat(this.dqc.getItem(7), is(14));
        assertThat(this.dqc.getItem(8), is(15));
    }

	@Test
	public final void testGetItemLimitSize()
	{
		this.dqc.addItem("（不明）");
		this.dqc.addItem("（不明）");
		this.dqc.addItem("（不明）");
		this.dqc.addItem("（不明）");
		this.dqc.addItem("（不明）");
		this.dqc.addItem("（不明）");
		this.dqc.addItem("（不明）");
		this.dqc.addItem("（不明）");

		assertThat(this.dqc.getItem(0), is(15));
		assertThat(this.dqc.getItem(1), is(15));
		assertThat(this.dqc.getItem(2), is(15));
		assertThat(this.dqc.getItem(3), is(15));
		assertThat(this.dqc.getItem(4), is(15));
		assertThat(this.dqc.getItem(5), is(15));
		assertThat(this.dqc.getItem(6), is(15));
		assertThat(this.dqc.getItem(7), is(15));
	}
	
	
	@Test(expected = IndexOutOfBoundsException.class)
	public final void testGetItemIndexOutOfBounds()
	{
		this.dqc.addItem("なし"          );
		this.dqc.addItem("たいまつ"      );
		this.dqc.addItem("せいすい"      );
		this.dqc.addItem("キメラのつばさ");
		this.dqc.addItem("りゅうのうろこ");
		this.dqc.addItem("ようせいのふえ");
		this.dqc.addItem("せんしのゆびわ");
		this.dqc.addItem("ロトのしるし"  );
		this.dqc.addItem("おうじょのあい");
		this.dqc.addItem("のろいのベルト");
		this.dqc.addItem("ぎんのたてごと");
		this.dqc.addItem("しのくびかざり");
		this.dqc.addItem("たいようのいし");
		this.dqc.addItem("あまぐものつえ");
		this.dqc.addItem("にじのしずく"  );
		this.dqc.addItem("（不明）"      );
		
		assertThat(this.dqc.getItem(0), is(0));
		assertThat(this.dqc.getItem(1), is(1));
		assertThat(this.dqc.getItem(2), is(2));
		assertThat(this.dqc.getItem(3), is(3));
		assertThat(this.dqc.getItem(4), is(4));
		assertThat(this.dqc.getItem(5), is(5));
		assertThat(this.dqc.getItem(6), is(6));
		assertThat(this.dqc.getItem(7), is(7));
		assertThat(this.dqc.getItem(8), is(8));
		assertThat(this.dqc.getItem(9), is(9));
		assertThat(this.dqc.getItem(10), is(10));
		assertThat(this.dqc.getItem(11), is(11));
		assertThat(this.dqc.getItem(12), is(12));
		assertThat(this.dqc.getItem(13), is(13));
		assertThat(this.dqc.getItem(14), is(14));
		assertThat(this.dqc.getItem(15), is(15));
	}
	
	@Test
	public final void testGetItemNotFoundItemList()
	{
		this.dqc.addItem("ななし"        );
		this.dqc.addItem("おうごんすい"  );
		this.dqc.addItem("ザメラのつばさ");
		this.dqc.addItem("りょうのうろこ");
		this.dqc.addItem("ようせいのうえ");
		this.dqc.addItem("せんしのわわわ");
		this.dqc.addItem("トロのしるし"  );
		
		assertThat(this.dqc.getItem(0), is(15));
		assertThat(this.dqc.getItem(1), is(15));
		assertThat(this.dqc.getItem(2), is(15));
		assertThat(this.dqc.getItem(3), is(15));
		assertThat(this.dqc.getItem(4), is(15));
		assertThat(this.dqc.getItem(5), is(15));
		assertThat(this.dqc.getItem(6), is(15));
	}

	@Test
	public final void testGetName()
	{
        DQ1Character character;

        character = DQ1Character.build("もょもと");
		assertThat(character.getName(), is("もょもと"));

        character = DQ1Character.build("と");
		assertThat(character.getName(), is("と　　　"));

		character = DQ1Character.build("とん");
		assertThat(character.getName(), is("とん　　"));

        character = DQ1Character.build("とんぬ");
		assertThat(character.getName(), is("とんぬ　"));

        character = DQ1Character.build("とんぬら");
		assertThat(character.getName(), is("とんぬら"));

        character = DQ1Character.build("と　う　あ");
		assertThat(character.getName(), is("と　う　"));
}

	@Test
	public final void testGetNameDakuten()
	{
        DQ1Character character;

		character = DQ1Character.build("が");
		assertThat(character.getName(), is("か゛　　"));

		character = DQ1Character.build("ぎ");
		assertThat(character.getName(), is("き゛　　"));

		character = DQ1Character.build("ぐ");
		assertThat(character.getName(), is("く゛　　"));

		character = DQ1Character.build("げ");
		assertThat(character.getName(), is("け゛　　"));

		character = DQ1Character.build("ご");
		assertThat(character.getName(), is("こ゛　　"));

		character = DQ1Character.build("ざ");
		assertThat(character.getName(), is("さ゛　　"));

		character = DQ1Character.build("じ");
		assertThat(character.getName(), is("し゛　　"));

		character = DQ1Character.build("ず");
		assertThat(character.getName(), is("す゛　　"));

		character = DQ1Character.build("ぜ");
		assertThat(character.getName(), is("せ゛　　"));

		character = DQ1Character.build("ぞ");
		assertThat(character.getName(), is("そ゛　　"));

		character = DQ1Character.build("だ");
		assertThat(character.getName(), is("た゛　　"));

		character = DQ1Character.build("ぢ");
		assertThat(character.getName(), is("ち゛　　"));

		character = DQ1Character.build("づ");
		assertThat(character.getName(), is("つ゛　　"));

		character = DQ1Character.build("で");
		assertThat(character.getName(), is("て゛　　"));

		character = DQ1Character.build("ど");
		assertThat(character.getName(), is("と゛　　"));

		character = DQ1Character.build("ば");
		assertThat(character.getName(), is("は゛　　"));

		character = DQ1Character.build("び");
		assertThat(character.getName(), is("ひ゛　　"));

		character = DQ1Character.build("ぶ");
		assertThat(character.getName(), is("ふ゛　　"));

		character = DQ1Character.build("べ");
		assertThat(character.getName(), is("へ゛　　"));

		character = DQ1Character.build("ぼ");
		assertThat(character.getName(), is("ほ゛　　"));

		character = DQ1Character.build("ぱ");
		assertThat(character.getName(), is("は゜　　"));

		character = DQ1Character.build("ぴ");
		assertThat(character.getName(), is("ひ゜　　"));

		character = DQ1Character.build("ぷ");
		assertThat(character.getName(), is("ふ゜　　"));

		character = DQ1Character.build("ぺ");
		assertThat(character.getName(), is("へ゜　　"));

		character = DQ1Character.build("ぽ");
		assertThat(character.getName(), is("ほ゜　　"));
	}
	
	@Test
	public final void testGetNameDakutenLimit()
	{
        DQ1Character character;

		character = DQ1Character.build("がいる");
		assertThat(character.getName(), is("か゛いる"));

		character = DQ1Character.build("ぱぱ");
		assertThat(character.getName(), is("は゜は゜"));

		character = DQ1Character.build("がすとん");
		assertThat(character.getName(), is("か゛すと"));

		character = DQ1Character.build("じばぶぱ");
		assertThat(character.getName(), is("し゛は゛"));
	}

	@Test
	public final void testGetExp()
	{
		for(int i = -9999; i < 0x100000; i ++)
		{
			this.dqc.setExp(i);
			assertThat("Exp:" + i, this.dqc.getExp(), is((i & 0xffff)));
		}
	}

    @Test
    public final void testGetGold()
    {
        this.dqc.setGold(0);
        assertThat("in = 0 result = 0", this.dqc.getGold(), is(0));

        this.dqc.setGold(65535);
        assertThat("in = 65535 result = 65535", this.dqc.getGold(), is(65535));

        this.dqc.setGold(65536);
        assertThat("in = 65536 result = 0", this.dqc.getGold(), is(0));

        this.dqc.setGold(-1);
        assertThat("in = -1 result = 65535", this.dqc.getGold(), is(65535));

        this.dqc.setGold(12345);
        assertThat("in = 12345 result = 12345", this.dqc.getGold(), is(12345));
    }


	@Test
	public final void testGetWeapon()
	{
		assertThat(this.dqc.getWeapon(), is(0));
		
		for(int i = -256; i < 256; i ++)
		{
			this.dqc.setEquip(i, 0, 0);
			assertThat("Weapon:" + i, this.dqc.getWeapon(), is((i & 0x07)));
		}
	}

	@Test
	public final void testGetWeaponSetName()
	{
		this.dqc.setEquip("なし", "なし", "なし");
		assertThat(this.dqc.getWeapon(), is(0));

		this.dqc.setEquip("たけざお", "なし", "なし");
		assertThat(this.dqc.getWeapon(), is(1));

		this.dqc.setEquip("こんぼう", "なし", "なし");
		assertThat(this.dqc.getWeapon(), is(2));

		this.dqc.setEquip("どうのつるぎ", "なし", "なし");
		assertThat(this.dqc.getWeapon(), is(3));

		this.dqc.setEquip("てつのおの", "なし", "なし");
		assertThat(this.dqc.getWeapon(), is(4));

		this.dqc.setEquip("はがねのつるぎ", "なし", "なし");
		assertThat(this.dqc.getWeapon(), is(5));

		this.dqc.setEquip("ほのおのつるぎ", "なし", "なし");
		assertThat(this.dqc.getWeapon(), is(6));

		this.dqc.setEquip("ロトのつるぎ", "なし", "なし");
		assertThat(this.dqc.getWeapon(), is(7));
	}

	@Test
	public final void testGetWeaponSetNameTypo()
	{
		this.dqc.setEquip("トロのつるぎ", "なし", "なし");
		assertThat(this.dqc.getWeapon(), is(0));
	}
	
	
	@Test
	public final void testGetArmor()
	{
		assertThat(this.dqc.getArmor(), is(0));

		for(int i = -256; i < 256; i ++)
		{
			this.dqc.setEquip(0, i, 0);
			assertThat("Armor:" + i, this.dqc.getArmor(), is((i & 0x07)));
		}
	}

	@Test
	public final void testGetArmorSetName()
	{
		this.dqc.setEquip("なし", "なし", "なし");
		assertThat(this.dqc.getArmor(), is(0));

		this.dqc.setEquip("なし", "ぬののふく", "なし");
		assertThat(this.dqc.getArmor(), is(1));

		this.dqc.setEquip("なし", "かわのふく", "なし");
		assertThat(this.dqc.getArmor(), is(2));

		this.dqc.setEquip("なし", "くさりかたびら", "なし");
		assertThat(this.dqc.getArmor(), is(3));

		this.dqc.setEquip("なし", "てつのよろい", "なし");
		assertThat(this.dqc.getArmor(), is(4));

		this.dqc.setEquip("なし", "はがねのよろい", "なし");
		assertThat(this.dqc.getArmor(), is(5));

		this.dqc.setEquip("なし", "まほうのよろい", "なし");
		assertThat(this.dqc.getArmor(), is(6));

		this.dqc.setEquip("なし", "ロトのよろい", "なし");
		assertThat(this.dqc.getArmor(), is(7));
	}

	@Test
	public final void testGetArmorSetNameTypo()
	{
		this.dqc.setEquip("なし", "トロのよろい", "なし");
		assertThat(this.dqc.getArmor(), is(0));
	}	
	
	
	@Test
	public final void testGetShield()
	{
		assertThat(this.dqc.getShield(), is(0));

		for(int i = -16; i < 16; i ++)
		{
			this.dqc.setEquip(0, 0, i);
			assertThat("Shield:" + i, this.dqc.getShield(), is((i & 0x03)));
		}
	}

	@Test
	public final void testGetShieldSetName()
	{
		this.dqc.setEquip("なし", "なし", "なし");
		assertThat(this.dqc.getShield(), is(0));

		this.dqc.setEquip("なし", "なし", "かわのたて");
		assertThat(this.dqc.getShield(), is(1));

		this.dqc.setEquip("なし", "なし", "てつのたて");
		assertThat(this.dqc.getShield(), is(2));

		this.dqc.setEquip("なし", "なし", "みかがみのたて");
		assertThat(this.dqc.getShield(), is(3));
	}
	
	@Test
	public final void testGetShieldSetNameTypo()
	{
		this.dqc.setEquip("なし", "なし", "みかみのたて");
		assertThat(this.dqc.getShield(), is(0));
	}

	
	@Test
	public final void testGetYakusou()
	{
		assertThat(this.dqc.getYakusou(), is(0));

		for(int i = -16; i < 16; i ++)
		{
			this.dqc.setHarbAndKey(i, 0);
			assertThat("yakusou:" + i, this.dqc.getYakusou(), is(i));
		}
	}


	@Test
	public final void testGetMahonokagi()
	{
		assertThat(this.dqc.getMahonokagi(), is(0));

		for(int i = -16; i < 16; i ++)
		{
			this.dqc.setHarbAndKey(0, i);
			assertThat("mahonokagi:" + i, this.dqc.getMahonokagi(), is(i));
		}
	}

	@Test
	public final void testGetCryptCode()
	{
		for(int i = 0; i < 1000; i ++)
		{
			int result = (int)(Math.random() * 8192.0 % 8);

			this.dqc.setCryptCode(result);
			System.out.println(result);
			assertThat("in = " + i + " result = " + result, this.dqc.getCryptCode(), is(result));
			
		}
	}
}
