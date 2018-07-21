package com.cjs.example;

import com.cjs.example.baidu.uid.impl.CachedUidGenerator;
import com.cjs.example.baidu.uid.impl.DefaultUidGenerator;
import com.cjs.example.meituan.idleaf.IdLeafService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UidGeneratorDemoApplicationTests {

	@Autowired
    @Qualifier("defaultUidGenerator")
	private DefaultUidGenerator defaultUidGenerator;

	@Autowired
    @Qualifier("cachedUidGenerator")
	private CachedUidGenerator cachedUidGenerator;

	@Autowired
	private IdLeafService idLeafService;

	@Test
	public void testSerialGenerate() {
		long uid = defaultUidGenerator.getUID();
		System.out.println(uid);
        System.out.println(defaultUidGenerator.parseUID(uid));
	}

    @Test
    public void testSerialGenerate2() {
        long uid = cachedUidGenerator.getUID();
        System.out.println(uid);
        System.out.println(cachedUidGenerator.parseUID(uid));
    }

    @Test
    public void testSerialGenerate3() {
        Long id = idLeafService.getId();
        System.out.println(id);

        String shopId = "10010";
        String date = "20180721";
        long ts = System.currentTimeMillis();
        String orderSN = shopId + date + ts + id;
        System.out.println(orderSN);
    }

}
