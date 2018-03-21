package lecture.service;
import static org.hamcrest.core.Is.is;
import com.sun.istack.internal.NotNull;
import com.sun.javafx.collections.MappingChange;
import com.visma.lecture.common.domain.Item;
import com.visma.lecture.common.domain.support.ItemLocation;
import com.visma.lecture.common.domain.support.ItemType;
import com.visma.lecture.common.exception.InvalidCriteriaException;
import com.visma.lecture.repository.ShopRepository;
import com.visma.lecture.service.ShopService;
import lecture.util.ShopTestUtil;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShopServiceTest {
	
	@Rule
	public ExpectedException expected = ExpectedException.none();
	
	private ShopRepository shopRepository;
	private ShopService shopService;
	
	@Before
	public void setUp() throws Exception {
		shopRepository = new ShopRepository(new ShopTestUtil().getItems());
		shopService = new ShopService(shopRepository);
	}
	
	@Test
	public void shouldThrowExceptionOnMissingInput() throws Exception {
		expected.expect(InvalidCriteriaException.class);
		expected.expectMessage("Input was null, empty or lower than 0.");
	}
	@Test
	public void mapGetItemsPerLocation()throws Exception{
		assertThat(shopService.getMapPerLocation().size(), is(2));
		assertTrue(shopService.getMapPerLocation().containsKey(ItemLocation.OSLO));
		assertTrue(shopService.getMapPerLocation().containsValue(shopRepository.ItemFoundPerLocation(ItemLocation.OSLO)));
	}
	@Test
	public void mapGetItemsPerType()throws Exception{
		assertThat(shopService.getMapPerType().size(), is(3));
		assertTrue(shopService.getMapPerType().containsKey(ItemType.BEVERAGE));
		assertTrue(shopService.getMapPerType().containsValue(shopRepository.ItemFoundPerType(ItemType.BEVERAGE)));
	}
	@Test
	public void mapGetItemsXPerXAmount(){
		Map<Boolean, List<Item>> partisjonert = shopService.getMapItemPerUnderXAmount();
		assertEquals(partisjonert.get(true).size(), 0);
		assertEquals(partisjonert.get(false).size(), 6);
	}
	@Test
	public void stringGetProducersOnX(){
		assertEquals("Producer1 Test1|Producer2 Test2|Producer3 Test3|Producer4 Test4|Producer5 Test5|Producer6 Test7",
                shopService.producersSeperatedByX("|"));
	}

	@Test
	public void getSortAlphabetacllyByProducer(){
		List<Item> sort = new ArrayList<>();
		sort.add(shopRepository.findItemById(2001));
		sort.add(shopRepository.findItemById(2002));
		sort.add(shopRepository.findItemById(2003));
		sort.add(shopRepository.findItemById(2004));
		sort.add(shopRepository.findItemById(2005));
		sort.add(shopRepository.findItemById(2006));

		assertEquals(sort, shopService.sortAlphabetacllyByProducer());
	}

}