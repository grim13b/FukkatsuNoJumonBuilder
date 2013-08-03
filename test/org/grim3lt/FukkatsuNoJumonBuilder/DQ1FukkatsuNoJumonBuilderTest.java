package org.grim3lt.FukkatsuNoJumonBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class DQ1FukkatsuNoJumonBuilderTest
{

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public final void testGetJumon()
	{
		DQ1Character dc = DQ1Character.build("おから");

        dc.setEquip(0, 0, 0);
        dc.setHarbAndKey(0, 0);
        dc.setFlags(true, true, true, true, true);

        dc.addItem(0, 0, 0, 0, 0, 0, 0, 0);

		DQ1FukkatsuNoJumonBuilder builder = DQ1FukkatsuNoJumonBuilder.build(dc);

        String jumon = builder.getJumon();

		assertThat(jumon, is(not(nullValue())));
        System.out.print(jumon);
	}
}
