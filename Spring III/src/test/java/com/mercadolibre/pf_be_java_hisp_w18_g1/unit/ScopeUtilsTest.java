package com.mercadolibre.pf_be_java_hisp_w18_g1.unit;

import com.mercadolibre.pf_be_java_hisp_w18_g1.util.ScopeUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.org.webcompere.systemstubs.environment.EnvironmentVariables;

class ScopeUtilsTest {

  private EnvironmentVariables env;

  @BeforeEach
  void startUp() throws Exception {
    env = new EnvironmentVariables();
    env.set(ScopeUtils.ENV_SCOPE, null);
    env.setup();
  }

  @AfterEach
  void stop() throws Exception {
    env.teardown();
  }

  @Test
  void testDefaultScope() {
    Assertions.assertTrue(ScopeUtils.isLocalScope());
  }

  @Test
  void testNonDefaultScope() {
    env.set(ScopeUtils.ENV_SCOPE, "PROD");
    Assertions.assertFalse(ScopeUtils.isLocalScope());
  }

  @Test
  void testCalculateScopeSuffix() {
    ScopeUtils.calculateScopeSuffix();
    Assertions.assertEquals(System.getProperty(ScopeUtils.SCOPE_SUFFIX), "local");
  }

  @Test
  void prodSuffix() {
    env.set(ScopeUtils.ENV_SCOPE, "write-prod");
    Assertions.assertTrue(ScopeUtils.isProdScope());
  }

  @Test
  void nonProdSuffix() {
    env.set(ScopeUtils.ENV_SCOPE, "test");
    Assertions.assertFalse(ScopeUtils.isProdScope());
  }

  @Test
  void testSuffix() {
    env.set(ScopeUtils.ENV_SCOPE, "test");
    Assertions.assertTrue(ScopeUtils.isTestScope());
  }

  @Test
  void nonTestSuffix() {
    env.set(ScopeUtils.ENV_SCOPE, "read-prod");
    Assertions.assertFalse(ScopeUtils.isTestScope());
  }

}
