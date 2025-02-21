package com.DatNguyen.ImageGenerator.Service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SubscriptionPlanService.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
class SubscriptionPlanServiceDiffblueTest {
    @Autowired
    private SubscriptionPlanService subscriptionPlanService;

    /**
     * Test {@link SubscriptionPlanService#getUUID(String)}.
     * <p>
     * Method under test: {@link SubscriptionPlanService#getUUID(String)}
     */
    @Test
    @DisplayName("Test getUUID(String)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testGetUUID() {
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
        subscriptionPlanService.getUUID("Role");
    }
}
