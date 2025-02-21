package com.DatNguyen.ImageGenerator.Service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.DatNguyen.ImageGenerator.Entity.Role;
import com.DatNguyen.ImageGenerator.Entity.SubscriptionPlans;
import com.DatNguyen.ImageGenerator.Entity.UserSubscriptions;
import com.DatNguyen.ImageGenerator.Entity.Users;
import com.DatNguyen.ImageGenerator.Repository.UserRepo;
import com.DatNguyen.ImageGenerator.Repository.UserSubscriptionRepo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.UUID;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserSubscriptionService.class, UserRepo.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class UserSubscriptionServiceDiffblueTest {
    @Autowired
    private UserSubscriptionService userSubscriptionService;

    @MockBean
    private UserRepo userRepo;

    @MockBean
    private UserSubscriptionRepo userSubscriptionRepo;

    /**
     * Test {@link UserSubscriptionService#createNewUserSubscription(UUID, String)}.
     * <p>
     * Method under test: {@link UserSubscriptionService#createNewUserSubscription(UUID, String)}
     */
    @Test
    @DisplayName("Test createNewUserSubscription(UUID, String)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testCreateNewUserSubscription() {
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
        userSubscriptionService.createNewUserSubscription(UUID.randomUUID(), "Payment Status");
    }

    /**
     * Test {@link UserSubscriptionService#createNewUserSubscription(UUID, String)}.
     * <p>
     * Method under test: {@link UserSubscriptionService#createNewUserSubscription(UUID, String)}
     */
    @Test
    @DisplayName("Test createNewUserSubscription(UUID, String)")
    @Tag("MaintainedByDiffblue")
    void testCreateNewUserSubscription2() {
        // Arrange
        SubscriptionPlans subscriptionPlan = new SubscriptionPlans();
        subscriptionPlan.setMaxImages(3);
        subscriptionPlan.setMaxResolution("Max Resolution");
        subscriptionPlan.setPlanID(UUID.randomUUID());
        subscriptionPlan.setPlanName("Plan Name");
        subscriptionPlan.setPrice(10.0f);

        SubscriptionPlans subscriptionPlan2 = new SubscriptionPlans();
        subscriptionPlan2.setMaxImages(3);
        subscriptionPlan2.setMaxResolution("Max Resolution");
        subscriptionPlan2.setPlanID(UUID.randomUUID());
        subscriptionPlan2.setPlanName("Plan Name");
        subscriptionPlan2.setPrice(10.0f);

        Users user = new Users();
        user.setCreatedAt(mock(Timestamp.class));
        user.setEmail("jane.doe@example.org");
        user.setGeneratedImages(new HashSet<>());
        user.setHashedPassword("iloveyou");
        user.setLastLogin(mock(Timestamp.class));
        user.setRole(Role.FREE);
        user.setSubscription(new UserSubscriptions());
        user.setUserID(UUID.randomUUID());
        user.setUsername("janedoe");
        user.setVerified(true);

        UserSubscriptions subscription = new UserSubscriptions();
        subscription.setEndDate(mock(Timestamp.class));
        subscription.setPaymentStatus("Payment Status");
        subscription.setStartDate(mock(Timestamp.class));
        subscription.setSubscriptionID(UUID.randomUUID());
        subscription.setSubscriptionPlan(subscriptionPlan2);
        subscription.setUser(user);

        Users user2 = new Users();
        user2.setCreatedAt(mock(Timestamp.class));
        user2.setEmail("jane.doe@example.org");
        user2.setGeneratedImages(new HashSet<>());
        user2.setHashedPassword("iloveyou");
        user2.setLastLogin(mock(Timestamp.class));
        user2.setRole(Role.FREE);
        user2.setSubscription(subscription);
        user2.setUserID(UUID.randomUUID());
        user2.setUsername("janedoe");
        user2.setVerified(true);

        UserSubscriptions subscription2 = new UserSubscriptions();
        subscription2.setEndDate(mock(Timestamp.class));
        subscription2.setPaymentStatus("Payment Status");
        subscription2.setStartDate(mock(Timestamp.class));
        subscription2.setSubscriptionID(UUID.randomUUID());
        subscription2.setSubscriptionPlan(subscriptionPlan);
        subscription2.setUser(user2);

        Users users = new Users();
        users.setCreatedAt(mock(Timestamp.class));
        users.setEmail("jane.doe@example.org");
        users.setGeneratedImages(new HashSet<>());
        users.setHashedPassword("iloveyou");
        users.setLastLogin(mock(Timestamp.class));
        users.setRole(Role.FREE);
        users.setSubscription(subscription2);
        users.setUserID(UUID.randomUUID());
        users.setUsername("janedoe");
        users.setVerified(true);
        when(userRepo.findByUserID(Mockito.<UUID>any())).thenReturn(users);
        when(userSubscriptionRepo.getPlanID(Mockito.<String>any())).thenReturn(UUID.randomUUID());
        doNothing().when(userSubscriptionRepo)
                .upsertSubscription(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Timestamp>any(),
                        Mockito.<Timestamp>any(), Mockito.<String>any());

        // Act
        boolean actualCreateNewUserSubscriptionResult = userSubscriptionService.createNewUserSubscription(UUID.randomUUID(),
                "Payment Status");

        // Assert
        verify(userRepo).findByUserID(isA(UUID.class));
        verify(userSubscriptionRepo).getPlanID(eq("FREE"));
        verify(userSubscriptionRepo).upsertSubscription(isA(UUID.class), isA(UUID.class), isA(UUID.class),
                isA(Timestamp.class), isA(Timestamp.class), eq("Payment Status"));
        assertTrue(actualCreateNewUserSubscriptionResult);
    }
}
