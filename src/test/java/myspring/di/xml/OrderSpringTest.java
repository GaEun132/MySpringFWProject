package myspring.di.xml;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mylab.order.di.xml.OrderService;
import mylab.order.di.xml.ShoppingCart;

//static import
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {
	@Autowired
	OrderService orderService;
	@Autowired 
	ShoppingCart shoppingCart;
	
	@Test
	void shoppingCartBeanTest() {
		//shoppingCart가 Null인지 검증
		assertNotNull(shoppingCart);
		//shoppingCart의 크기 검증
		assertEquals(2,shoppingCart.getProducts().size());
		//product1이 "노트북"인지 검증
		assertEquals("노트북",shoppingCart.getProducts().get(0).getName());
		//product2이 "스마트폰"인지 검증
		assertEquals("스마트폰",shoppingCart.getProducts().get(1).getName());
	}
	@Test
	void orderSerivceBeanTest() {
		//orderService를 주입받았는지 테스트
		assertNotNull(orderService);
		//shoppingCart를 주입받았는지 테스트
		assertEquals(shoppingCart,orderService.getShoppingCart());
		//shoppingCart의 총가격이 950000원인지 테스트
		assertEquals(950000,orderService.calculateOrderTotal());
		
	}
	
}
