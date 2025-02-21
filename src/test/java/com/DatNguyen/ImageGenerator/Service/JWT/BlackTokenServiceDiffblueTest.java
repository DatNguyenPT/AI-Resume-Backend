package com.DatNguyen.ImageGenerator.Service.JWT;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BlackTokenService.class, RedisTemplate.class})
@ExtendWith(SpringExtension.class)
class BlackTokenServiceDiffblueTest {
    @Autowired
    private BlackTokenService blackTokenService;

    /**
     * Test {@link BlackTokenService#blacklistToken(String, long)}.
     * <p>
     * Method under test: {@link BlackTokenService#blacklistToken(String, long)}
     */
    @Test
    @DisplayName("Test blacklistToken(String, long)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testBlacklistToken() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.LibraryLinkageException: java.lang.NoClassDefFoundError: Could not initialize class org.mockito.internal.creation.cglib.ClassImposterizer$3
        //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
        //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
        //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
        //   java.lang.NoClassDefFoundError: Could not initialize class org.mockito.internal.creation.cglib.ClassImposterizer$3
        //       at org.mockito.internal.creation.cglib.ClassImposterizer.createProxyClass(ClassImposterizer.java:95)
        //       at org.mockito.internal.creation.cglib.ClassImposterizer.imposterise(ClassImposterizer.java:57)
        //       at org.mockito.internal.creation.cglib.ClassImposterizer.imposterise(ClassImposterizer.java:49)
        //       at org.mockito.internal.creation.cglib.CglibMockMaker.createMock(CglibMockMaker.java:24)
        //       at org.mockito.internal.util.MockUtil.createMock(MockUtil.java:33)
        //       at org.mockito.internal.MockitoCore.mock(MockitoCore.java:59)
        //       at org.mockito.Mockito.mock(Mockito.java:1285)
        //       at org.springframework.boot.test.mock.mockito.MockDefinition.createMock(MockDefinition.java:161)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.registerMock(MockitoPostProcessor.java:191)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.register(MockitoPostProcessor.java:173)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:147)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:135)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:363)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:197)
        //       at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:791)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:609)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:221)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:110)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:212)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:225)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:152)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
        //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
        //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
        //   java.lang.ExceptionInInitializerError: Exception java.lang.ExceptionInInitializerError [in thread "TimedExecutor-3"]
        //       at org.mockito.cglib.core.KeyFactory$Generator.generateClass(KeyFactory.java:167)
        //       at org.mockito.cglib.core.DefaultGeneratorStrategy.generate(DefaultGeneratorStrategy.java:25)
        //       at org.mockito.cglib.core.AbstractClassGenerator.create(AbstractClassGenerator.java:217)
        //       at org.mockito.cglib.core.KeyFactory$Generator.create(KeyFactory.java:145)
        //       at org.mockito.cglib.core.KeyFactory.create(KeyFactory.java:117)
        //       at org.mockito.cglib.core.KeyFactory.create(KeyFactory.java:109)
        //       at org.mockito.cglib.core.KeyFactory.create(KeyFactory.java:105)
        //       at org.mockito.cglib.proxy.Enhancer.<clinit>(Enhancer.java:70)
        //       at org.mockito.internal.creation.cglib.ClassImposterizer.createProxyClass(ClassImposterizer.java:95)
        //       at org.mockito.internal.creation.cglib.ClassImposterizer.imposterise(ClassImposterizer.java:57)
        //       at org.mockito.internal.creation.cglib.ClassImposterizer.imposterise(ClassImposterizer.java:49)
        //       at org.mockito.internal.creation.cglib.CglibMockMaker.createMock(CglibMockMaker.java:24)
        //       at org.mockito.internal.util.MockUtil.createMock(MockUtil.java:33)
        //       at org.mockito.internal.MockitoCore.mock(MockitoCore.java:59)
        //       at org.mockito.Mockito.mock(Mockito.java:1285)
        //       at org.mockito.Mockito.mock(Mockito.java:1163)
        //   To avoid this error, consider adding a custom base class to setup static
        //   mocking for org.mockito.cglib.core.AbstractClassGenerator.
        //   For details on how to set up a custom base class, please follow this link:
        //   https://docs.diffblue.com/features/cover-cli/writing-tests/custom-test-setup
        //   See https://diff.blue/R026 to resolve this issue.

        // Arrange and Act
        blackTokenService.blacklistToken("ABC123", 1L);
    }

    /**
     * Test {@link BlackTokenService#isTokenBlacklisted(String)}.
     * <p>
     * Method under test: {@link BlackTokenService#isTokenBlacklisted(String)}
     */
    @Test
    @DisplayName("Test isTokenBlacklisted(String)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testIsTokenBlacklisted() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@143e5fb6 testClass = com.DatNguyen.ImageGenerator.Service.JWT.DiffblueFakeClass2, locations = [], classes = [com.DatNguyen.ImageGenerator.Service.JWT.BlackTokenService, org.springframework.data.redis.core.RedisTemplate], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@19daba07, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@5634b1c6, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.web.reactor.netty.DisableReactorResourceFactoryGlobalResourcesContextCustomizerFactory$DisableReactorResourceFactoryGlobalResourcesContextCustomizerCustomizer@3d829d0c, org.springframework.boot.test.autoconfigure.OnFailureConditionReportContextCustomizerFactory$OnFailureConditionReportContextCustomizer@18338d42, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@39403504, org.springframework.test.context.support.DynamicPropertiesContextCustomizer@0], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
        //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
        //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
        //   To avoid this error, consider adding a custom base class to setup static
        //   mocking for org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.
        //   For details on how to set up a custom base class, please follow this link:
        //   https://docs.diffblue.com/features/cover-cli/writing-tests/custom-test-setup
        //   See https://diff.blue/R026 to resolve this issue.

        // Arrange and Act
        blackTokenService.isTokenBlacklisted("ABC123");
    }
}
