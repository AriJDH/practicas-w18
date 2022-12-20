package com.mercadolibre.bootcamp_demo_java_app.unit;

import com.mercadolibre.bootcamp_demo_java_app.util.ScopeUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;
import uk.org.webcompere.systemstubs.environment.EnvironmentVariables;
import uk.org.webcompere.systemstubs.jupiter.SystemStub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static uk.org.webcompere.systemstubs.SystemStubs.withEnvironmentVariable;

public class ScopeUtilTest {
	@Test
	public void testSuffix() throws Exception {
		withEnvironmentVariable("SCOPE","lalala-test").execute(() -> {
			// When
			ScopeUtils.calculateScopeSuffix();

			// Then
			assertEquals("test", System.getProperty(ScopeUtils.SCOPE_SUFFIX));
		});
	}
}