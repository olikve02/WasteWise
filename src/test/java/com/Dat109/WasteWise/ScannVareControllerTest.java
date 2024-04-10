package com.Dat109.WasteWise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;

import com.Dat109.WasteWise.Controllers.ScannVareController;
import com.Dat109.WasteWise.Services.VareService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;



@SpringBootTest
@AutoConfigureMockMvc // Ensure MockMvc is configured
public class ScannVareControllerTest {


	@Autowired
	private MockMvc mockMvc;
	@Mock
	private VareService vareService;

	@InjectMocks
	private ScannVareController controller;

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private RedirectAttributes redirectAttributes;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		redirectAttributes = new RedirectAttributes() {
			@Override
			public RedirectAttributes addAttribute(String attributeName, Object attributeValue) {
				return this;
			}

			@Override
			public RedirectAttributes addAttribute(Object attributeValue) {
				return this;
			}

			@Override
			public RedirectAttributes addAllAttributes(java.util.Collection<?> attributeValues) {
				return this;
			}

			@Override
			public Model addAllAttributes(java.util.Map<String, ?> attributes) {
				return null;
			}

			@Override
			public RedirectAttributes mergeAttributes(java.util.Map<String, ?> attributes) {
				return this;
			}

			@Override
			public boolean containsAttribute(String attributeName) {
				return false;
			}

			@Override
			public Object getAttribute(String attributeName) {
				return null;
			}

			@Override
			public java.util.Map<String, Object> asMap() {
				return null;
			}

			@Override
			public RedirectAttributes addFlashAttribute(String attributeName, Object attributeValue) {
				return null;
			}

			@Override
			public RedirectAttributes addFlashAttribute(Object attributeValue) {
				return null;
			}

			@Override
			public java.util.Map<String, Object> getFlashAttributes() {
				return Collections.emptyMap();
			}
		};
	}

	@Test
	public void testScannVarePage() throws Exception {
		mockMvc.perform(get("/scann-vare"))
				.andExpect(status().isOk())
				.andExpect(view().name("ScannVare"));
	}

	@Test
	public void testFinnVareWithValidBarcode() {
		String validBarcode = "123456789";
		String productName = "Test Product";
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("barcode", validBarcode);
		when(vareService.finnVareOgRedirect(params, redirectAttributes)).thenReturn(productName);

		String result = controller.finnVare(params, redirectAttributes);

		assertEquals(productName, result);
	}

	@Test
	public void testFinnVareWithInvalidBarcode() {
		String invalidBarcode = "invalidBarcode";
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("barcode", invalidBarcode);
		when(vareService.finnVareOgRedirect(params, redirectAttributes)).thenReturn(null);

		String result = controller.finnVare(params, redirectAttributes);

		assertEquals(null, result);
	}
}